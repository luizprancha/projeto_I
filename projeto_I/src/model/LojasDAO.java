package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.BancoDeDados;

public class LojasDAO {

    public void adicionarLojas(Lojas loja) {

        String sql = "INSERT INTO Lojas(CNPJ, nome, responsavel, endereco, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conexao = null;
        PreparedStatement pstm = null;

        try {

            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);

            pstm.setString(1, loja.getCnpj());
            pstm.setString(2, loja.getNome());
            pstm.setString(3, loja.getResponsavel());
            pstm.setString(4, loja.getEndereco());
            pstm.setString(5, loja.getTelefone());
            pstm.setString(6, loja.getEmail());

            pstm.execute();

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


    public List<Lojas> listarLojas(){

        String sql = "SELECT * FROM Lojas";

        List<Lojas> lojas = new ArrayList<>();

        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {

            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()) {

                Lojas loja = new Lojas();

                loja.setCnpj(rset.getString("CNPJ"));
                loja.setNome(rset.getString("nome"));
                loja.setResponsavel(rset.getString("responsavel"));
                loja.setEndereco(rset.getString("endereco"));
                loja.setTelefone(rset.getString("telefone"));
                loja.setEmail(rset.getString("email"));
                loja.setIdLoja(rset.getInt("idLoja"));

                lojas.add(loja);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            BancoDeDados.desconectar(conexao);

        }

        return lojas;
    }


    public void atualizarLojas(Lojas loja) {

        String sql = "UPDATE Lojas SET CNPJ = ?, nome = ?, responsavel = ?, endereco = ?, telefone = ?, email = ? WHERE idLoja = ?";

        Connection conexao = null;
        PreparedStatement pstm = null;

        try {

            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);

            pstm.setString(1, loja.getCnpj());
            pstm.setString(2, loja.getNome());
            pstm.setString(3, loja.getResponsavel());
            pstm.setString(4, loja.getEndereco());
            pstm.setString(5, loja.getTelefone());
            pstm.setString(6, loja.getEmail());
            pstm.setInt(7, loja.getIdLoja());

            pstm.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            BancoDeDados.desconectar(conexao);

        }
    }


    public static void removerLojas(int id) {

        Connection conexao = null;
        PreparedStatement pstm = null;

        try {

            conexao = BancoDeDados.conectar();

            // remove pedidos ligados à loja
            String sqlPedidos = "DELETE FROM PedidosLojas WHERE idPedidosL = ?";

            pstm = conexao.prepareStatement(sqlPedidos);
            pstm.setInt(1, id);
            pstm.executeUpdate();

            // remove a loja
            String sqlLoja = "DELETE FROM Lojas WHERE idLoja = ?";

            pstm = conexao.prepareStatement(sqlLoja);
            pstm.setInt(1, id);
            pstm.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    
    public boolean existeCNPJ(String cnpj) {

    	String sql = "SELECT * FROM Lojas WHERE cnpj = ?";

    	Connection conexao = null;
    	PreparedStatement pstm = null;
    	ResultSet rset = null;

    	try {

    		conexao = database.BancoDeDados.conectar();

    		pstm = conexao.prepareStatement(sql);

    		pstm.setString(1, cnpj);

    		rset = pstm.executeQuery();

    		return rset.next();

    	} catch (SQLException e) {

    		e.printStackTrace();

    		return false;

    	} finally {

    		database.BancoDeDados.desconectar(conexao);

    	}
    }
    
    
    
    public List<Lojas> buscarLojas(String nomeBusca) {

        String sql = "SELECT * FROM Lojas WHERE nome LIKE ?";

        List<Lojas> lojas = new ArrayList<>();

        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {

            conexao = database.BancoDeDados.conectar();

            pstm = conexao.prepareStatement(sql);

            pstm.setString(1, "%" + nomeBusca + "%");

            rset = pstm.executeQuery();

            while (rset.next()) {

                Lojas loja = new Lojas();

                loja.setCnpj(rset.getString("CNPJ"));
                loja.setNome(rset.getString("nome"));
                loja.setResponsavel(rset.getString("responsavel"));
                loja.setEndereco(rset.getString("endereco"));
                loja.setTelefone(rset.getString("telefone"));
                loja.setEmail(rset.getString("email"));
                loja.setIdLoja(rset.getInt("idLoja"));

                lojas.add(loja);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.BancoDeDados.desconectar(conexao);
        }

        return lojas;
    }

}