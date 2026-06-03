package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotificacaoDAO {

	    public List<Notificacao> buscarNotificacoes() {

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

	            	ORDER BY dataCadastro ASC;
	            	""";

	            conexao = database.BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);

	            rset = pstm.executeQuery();

	            while(rset.next()) {

	            	notificacoes.add(
	                        new Notificacao(
	                            rset.getString("tipo"),
	                            rset.getString("nome"),
	                            rset.getTimestamp("dataCadastro")
	                              .toLocalDateTime()
	                        )
	                    );
	            }

	        } catch(Exception e) {
	            e.printStackTrace();
	        }

	        return notificacoes;
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
	        }
	    }
	}
