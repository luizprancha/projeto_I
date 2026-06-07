package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NotificacaoDAO {

	    public List<Notificacao> buscarNotificacoes() {
	        garantirEstrutura();

	        List<Notificacao> notificacoes = new ArrayList<>();
	        notificacoes.addAll(buscarProdutosEMateriaPrima());
	        notificacoes.addAll(buscarPedidosFinalizados());
	        notificacoes.addAll(buscarPedidosEntregues());

	        notificacoes.sort(Comparator.comparing(Notificacao::getdataCadastro));
	        return notificacoes;
	    }

	    public void registrar(String tipo, String nome) {
	        garantirEstrutura();

	        String sql = """
	            INSERT INTO NotificacoesPedidos (tipo, nome)
	            VALUES (?, ?)
	            ON DUPLICATE KEY UPDATE nome = nome
	            """;

	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            conexao = database.BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            pstm.setString(1, tipo);
	            pstm.setString(2, nome);
	            pstm.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            database.BancoDeDados.desconectar(conexao);
	        }
	    }
	    
	    public void descartar(String tipo, String nome) {
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            String sql = """
	                INSERT INTO NotificacoesDescartadas (tipo, nome)
	                VALUES (?, ?)
	                ON DUPLICATE KEY UPDATE nome = nome
	                """;

	            conexao = database.BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            pstm.setString(1, tipo);
	            pstm.setString(2, nome);
	            pstm.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            database.BancoDeDados.desconectar(conexao);
	        }
	    }

	    private void garantirEstrutura() {
	        Connection conexao = null;
	        Statement stmt = null;

	        try {
	            conexao = database.BancoDeDados.conectar();
	            stmt = conexao.createStatement();
	            stmt.execute("""
	                CREATE TABLE IF NOT EXISTS NotificacoesPedidos (
	                    tipo VARCHAR(50) NOT NULL,
	                    nome VARCHAR(100) NOT NULL,
	                    dataCadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	                    PRIMARY KEY (tipo, nome)
	                )
	                """);
	            try {
	                stmt.execute("ALTER TABLE NotificacoesDescartadas MODIFY tipo VARCHAR(50) NOT NULL");
	            } catch (SQLException ignored) {
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            database.BancoDeDados.desconectar(conexao);
	        }
	    }

	    private List<Notificacao> buscarProdutosEMateriaPrima() {
	        List<Notificacao> notificacoes = new ArrayList<>();
	        Connection conexao = null;
	        PreparedStatement pstm = null;
	        ResultSet rset = null;

	        try {
	            String sql = """
	                SELECT 'MATERIA_PRIMA' AS tipo, nome, dataCadastro
	                FROM materiaprima
	                WHERE TIMESTAMPDIFF(SECOND, dataCadastro, NOW()) > 20
	                AND NOT EXISTS (
	                    SELECT 1 FROM NotificacoesDescartadas d
	                    WHERE d.tipo = 'MATERIA_PRIMA' AND d.nome = materiaprima.nome
	                )

	                UNION ALL

	                SELECT 'PRODUTO' AS tipo, nome, dataCadastro
	                FROM produtos
	                WHERE TIMESTAMPDIFF(SECOND, dataCadastro, NOW()) > 20
	                AND NOT EXISTS (
	                    SELECT 1 FROM NotificacoesDescartadas d
	                    WHERE d.tipo = 'PRODUTO' AND d.nome = produtos.nome
	                )
	                """;

	            conexao = database.BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            rset = pstm.executeQuery();
	            notificacoes.addAll(mapearResultado(rset));
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            database.BancoDeDados.desconectar(conexao);
	        }

	        return notificacoes;
	    }

	    private List<Notificacao> buscarPedidosFinalizados() {
	        List<Notificacao> notificacoes = new ArrayList<>();
	        Connection conexao = null;
	        PreparedStatement pstm = null;
	        ResultSet rset = null;

	        try {
	            String sql = """
	                SELECT np.tipo, np.nome, np.dataCadastro
	                FROM NotificacoesPedidos np
	                WHERE NOT EXISTS (
	                    SELECT 1 FROM NotificacoesDescartadas d
	                    WHERE d.tipo = np.tipo AND d.nome = np.nome
	                )
	                """;

	            conexao = database.BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            rset = pstm.executeQuery();
	            notificacoes.addAll(mapearResultado(rset));
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            database.BancoDeDados.desconectar(conexao);
	        }

	        return notificacoes;
	    }

	    private List<Notificacao> buscarPedidosEntregues() {
	        List<Notificacao> notificacoes = new ArrayList<>();
	        Connection conexao = null;
	        PreparedStatement pstm = null;
	        ResultSet rset = null;

	        try {
	            String sql = """
	                SELECT 'PEDIDO_LOJA_ENTREGUE' AS tipo,
	                       CONCAT('Pedido #', p.idPedidosL, ' - ', l.nome) AS nome,
	                       NOW() AS dataCadastro
	                FROM PedidosLojas p
	                JOIN Lojas l ON p.Lojas_CNPJ = l.CNPJ
	                WHERE p.data_entrega = CURDATE()
	                AND NOT EXISTS (
	                    SELECT 1 FROM NotificacoesDescartadas d
	                    WHERE d.tipo = 'PEDIDO_LOJA_ENTREGUE'
	                    AND d.nome = CONCAT('Pedido #', p.idPedidosL, ' - ', l.nome)
	                )

	                UNION ALL

	                SELECT 'PEDIDO_CONFECCAO_ENTREGUE' AS tipo,
	                       CONCAT('Pedido #', pc.idPedidoC, ' - ', c.nome) AS nome,
	                       NOW() AS dataCadastro
	                FROM PedidosConfeccoes pc
	                JOIN Confeccoes c ON pc.Confeccoes_CNPJ = c.CNPJ
	                WHERE pc.entrega = CURDATE()
	                AND NOT EXISTS (
	                    SELECT 1 FROM NotificacoesDescartadas d
	                    WHERE d.tipo = 'PEDIDO_CONFECCAO_ENTREGUE'
	                    AND d.nome = CONCAT('Pedido #', pc.idPedidoC, ' - ', c.nome)
	                )
	                """;

	            conexao = database.BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            rset = pstm.executeQuery();
	            notificacoes.addAll(mapearResultado(rset));
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            database.BancoDeDados.desconectar(conexao);
	        }

	        return notificacoes;
	    }

	    private List<Notificacao> mapearResultado(ResultSet rset) throws SQLException {
	        List<Notificacao> notificacoes = new ArrayList<>();

	        while (rset.next()) {
	            notificacoes.add(
	                new Notificacao(
	                    rset.getString("tipo"),
	                    rset.getString("nome"),
	                    rset.getTimestamp("dataCadastro").toLocalDateTime()
	                )
	            );
	        }

	        return notificacoes;
	    }
	}
