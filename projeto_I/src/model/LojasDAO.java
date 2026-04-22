package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LojasDAO {
	
	public void adicionarLojas(Lojas lojas) {
		String sql = "INSERT INTO Lojas(CNPJ, nome, responsavel, endereco, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conexao = null;
		PreparedStatement pstm = null;
		
		try {
			
			conexao = database.BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, lojas.getCnpj());
			pstm.setString(2, lojas.getNome());
			pstm.setString(3, lojas.getResponsavel());
			pstm.setString(4, lojas.getEndereco());
			pstm.setString(5, lojas.getTelefone());
			pstm.setString(6, lojas.getEmail());
			
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
	
			public List<Lojas> listarLojas(){
				String sql = "SELECT * FROM Lojas";
				List<Lojas> loja = new ArrayList<>();
				Connection conexao = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;
				
				try {
					conexao = database.BancoDeDados.conectar();
					pstm = conexao.prepareStatement(sql);
					rset = pstm.executeQuery();
					
					while(rset.next()) {
						Lojas lojas = new Lojas();
						lojas.setCnpj(rset.getString("CNPJ"));
						lojas.setNome(rset.getString("nome"));
						lojas.setResponsavel(rset.getString("responsavel"));
						lojas.setEndereco(rset.getString("endereco"));
						lojas.setTelefone(rset.getString("telefone"));
						lojas.setEmail(rset.getString("email"));
						loja.add(lojas);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					database.BancoDeDados.desconectar(conexao);
				}
				return loja;
			}
			

		    public void atualizarLojas(Lojas lojas) {
		        String sql = "UPDATE Lojas SET CNPJ = ?, nome = ?, responsavel = ?, endereco = ?, telefone = ?, email = ? WHERE id = ?";
		        Connection conexao = null;
		        PreparedStatement pstm = null;

		        try {
		            conexao = database.BancoDeDados.conectar();
		            pstm = conexao.prepareStatement(sql);
		            pstm.setString(1, lojas.getCnpj());
		            pstm.setString(2, lojas.getNome());
		            pstm.setString(3, lojas.getResponsavel());
		            pstm.setString(4, lojas.getEndereco());
		            pstm.setString(5, lojas.getTelefone());
		            pstm.setString(6, lojas.getEmail());
		            pstm.setInt(7, lojas.getIdLoja());
		            pstm.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		        	database.BancoDeDados.desconectar(conexao);
		        }
		    }
		    
		    public static void removerLojas(int id) {
		        String sql = "DELETE FROM Confeccoes WHERE id=?";

		        try (Connection conn = database.BancoDeDados.conectar();
		             PreparedStatement stmt = conn.prepareStatement(sql)) {

		            stmt.setInt(1, id);
		            stmt.executeUpdate();

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

}
