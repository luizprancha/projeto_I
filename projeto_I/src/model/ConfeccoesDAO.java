package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConfeccoesDAO {
	
	public void adicionarConfeccoes(Confeccoes confeccao) {
		String sql = "INSERT INTO Confeccoes(CNPJ, nome, responsavel, endereco, telefone, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
		        String sql = "UPDATE Confeccoes SET CNPJ = ?, nome = ?, responsavel = ?, endereco = ?, telefone = ?, email = ? WHERE id = ?";
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
		    
		    public static void remover(int id) {
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
