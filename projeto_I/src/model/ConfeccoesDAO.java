package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.BancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class ConfeccoesDAO {
	
	public void adicionarConfeccoes(Confeccoes confeccao) {
		String sql = "INSERT INTO Confeccoes(CNPJ, nome, responsavel, endereco, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conexao = null;
		PreparedStatement pstm = null;
		
		try {
			
			conexao = database.BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, confeccao.getCnpj());
			pstm.setString(2, confeccao.getNome());
			pstm.setString(3, confeccao.getResponsavel());
			pstm.setString(4, confeccao.getEndereco());
			pstm.setString(5, confeccao.getTelefone());
			pstm.setString(6, confeccao.getEmail());
			
			pstm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			database.BancoDeDados.desconectar(conexao);
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
			public List<Confeccoes> listarConfeccoes(){
				String sql = "SELECT * FROM Confeccoes";
				List<Confeccoes> confeccoes = new ArrayList<>();
				Connection conexao = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;
				
				try {
					conexao = database.BancoDeDados.conectar();
					pstm = conexao.prepareStatement(sql);
					rset = pstm.executeQuery();
					
					while(rset.next()) {
						Confeccoes confeccao = new Confeccoes();
						confeccao.setCnpj(rset.getString("CNPJ"));
						confeccao.setNome(rset.getString("nome"));
						confeccao.setResponsavel(rset.getString("responsavel"));
						confeccao.setEndereco(rset.getString("endereco"));
						confeccao.setTelefone(rset.getString("telefone"));
						confeccao.setEmail(rset.getString("email"));
						confeccao.setIdConfeccoes(rset.getInt("idConfeccoes"));
						confeccoes.add(confeccao);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					database.BancoDeDados.desconectar(conexao);
				}
				return confeccoes;
			}
			

		    public void atualizarConfeccoes(Confeccoes confeccao) {
		        String sql = "UPDATE Confeccoes SET CNPJ = ?, nome = ?, responsavel = ?, endereco = ?, telefone = ?, email = ? WHERE idConfeccoes = ?";
		        Connection conexao = null;
		        PreparedStatement pstm = null;

		        try {
		            conexao = database.BancoDeDados.conectar();
		            pstm = conexao.prepareStatement(sql);
		            pstm.setString(1, confeccao.getCnpj());
		            pstm.setString(2, confeccao.getNome());
		            pstm.setString(3, confeccao.getResponsavel());
		            pstm.setString(4, confeccao.getEndereco());
		            pstm.setString(5, confeccao.getTelefone());
		            pstm.setString(6, confeccao.getEmail());
		            pstm.setInt(7, confeccao.getIdConfeccoes());
		            pstm.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		        	database.BancoDeDados.desconectar(conexao);
		        }
		    }
		    
		    public static void removerConfeccoes(int id) {

		        Connection conexao = null;
		        PreparedStatement pstm = null;

		        try {

		            conexao = database.BancoDeDados.conectar();

		            // remove pedidos ligados à confecção
		            String sqlPedidos = "DELETE FROM PedidosConfeccoes WHERE idPedidoC = ?";

		            pstm = conexao.prepareStatement(sqlPedidos);
		            pstm.setInt(1, id);
		            pstm.executeUpdate();

		            // remove a confecção
		            String sqlConfeccao = "DELETE FROM Confeccoes WHERE idConfeccoes = ?";

		            pstm = conexao.prepareStatement(sqlConfeccao);
		            pstm.setInt(1, id);
		            pstm.executeUpdate();

		        } catch (Exception e) {

		            e.printStackTrace();

		        }
		    }
		    
		    public boolean existeCNPJ(String cnpj) {

		    	String sql = "SELECT * FROM Confeccoes WHERE CNPJ = ?";

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
		    
		    public List<Confeccoes> buscarConfeccoes(String nomeBusca) {

		        String sql = "SELECT * FROM Confeccoes WHERE nome LIKE ?";

		        List<Confeccoes> confeccoes = new ArrayList<>();

		        Connection conexao = null;
		        PreparedStatement pstm = null;
		        ResultSet rset = null;

		        try {

		            conexao = database.BancoDeDados.conectar();

		            pstm = conexao.prepareStatement(sql);

		            pstm.setString(1, "%" + nomeBusca + "%");

		            rset = pstm.executeQuery();

		            while (rset.next()) {

		            	Confeccoes confeccao = new Confeccoes();

		            	confeccao.setCnpj(rset.getString("CNPJ"));
						confeccao.setNome(rset.getString("nome"));
						confeccao.setResponsavel(rset.getString("responsavel"));
						confeccao.setEndereco(rset.getString("endereco"));
						confeccao.setTelefone(rset.getString("telefone"));
						confeccao.setEmail(rset.getString("email"));
						confeccao.setIdConfeccoes(rset.getInt("idConfeccoes"));

		                confeccoes.add(confeccao);
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            database.BancoDeDados.desconectar(conexao);
		        }

		        return confeccoes;
		    }

		    public String buscarNomePorCNPJ(String cnpj) {
		    	String sql = "SELECT nome FROM Confeccoes WHERE CNPJ = ?";
		    	Connection conexao = null;
		    	PreparedStatement pstm = null;
		    	ResultSet rset = null;

		    	try {
		    		conexao = BancoDeDados.conectar();
		    		pstm = conexao.prepareStatement(sql);
		    		pstm.setString(1, cnpj);
		    		rset = pstm.executeQuery();

		    		if (rset.next()) {
		    			return rset.getString("nome");
		    		}
		    	} catch (SQLException e) {
		    		e.printStackTrace();
		    	} finally {
		    		BancoDeDados.desconectar(conexao);
		    	}
		    	return "";
		    }

}
