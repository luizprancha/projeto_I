package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.BancoDeDados;

public class CarrinhoDAO {

    /**
     * Adiciona um novo item ao carrinho no banco de dados.
     * @param carrinho Objeto contendo os dados do produto.
     */
    public void adicionarCarrinho(Carrinho carrinho) throws SQLException  {
        String sql = "INSERT INTO Carrinho( id_carrinho) VALUES ( ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(2, carrinho.getIdCarrinho());
           
            pstm.execute();

        } finally {

            if (pstm != null) {
                pstm.close();
            }

            BancoDeDados.desconectar(conexao);
        }
    }

    /**
     * Lista todos os itens presentes na tabela Carrinho.
     * @return Uma lista de objetos Carrinho.
     */
    public List<Carrinho> listarCarrinho() {
        String sql = "SELECT * FROM Carrinho";
        List<Carrinho> itensCarrinho = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Carrinho carrinho = new Carrinho();
                carrinho.setIdCarrinho(rset.getInt("id_carrinho"));
                itensCarrinho.add(carrinho);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return itensCarrinho;
    }

    /**
     * Atualiza os dados de um item já existente no carrinho.
     * @param carrinho Objeto com os dados atualizados e o id_carrinho preenchido.
     */
    public void atualizarCarrinho(Carrinho carrinho) {
        String sql = "UPDATE Carrinho SET  id_carrinho = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(5, carrinho.getIdCarrinho());

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Remove um item do carrinho pelo seu ID.
     * @param id O id_carrinho do item a ser removido.
     */
    public void removerCarrinho(int id) {
        String sql = "DELETE FROM Carrinho WHERE id_carrinho = ?";

        try (Connection conn = BancoDeDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}