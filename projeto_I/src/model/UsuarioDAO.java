package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	// CREATE - Adiciona um novo usuário
	public void adicionarUsuario(Usuario usuario) {
		String sql = "INSERT INTO Usuarios(nome, usuario, cargo, senha) VALUES (?, ?, ?, ?)";
		Connection conexao = null;
		PreparedStatement pstm = null;
		
		try {
			
			conexao = database.BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getUser());
			pstm.setString(3, usuario.getCargo());
			pstm.setString(4, usuario.getSenha());
			
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
	
	// READ - Lista de todos os Usuários
			public List<Usuario> listarUsuarios(){
				String sql = "SELECT * FROM Usuarios";
				List<Usuario> usuarios = new ArrayList<>();
				Connection conexao = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;
				
				try {
					conexao = database.BancoDeDados.conectar();
					pstm = conexao.prepareStatement(sql);
					rset = pstm.executeQuery();
					
					while(rset.next()) {
						Usuario usuario = new Usuario();
						usuario.setNome(rset.getString("nome"));
						usuario.setSenha(rset.getString("senha"));
						usuario.setCargo(rset.getString("cargo"));
						usuario.setUser(rset.getString("user"));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					database.BancoDeDados.desconectar(conexao);
				}
				return usuarios;
			}
			
			// UPDATE - Atualizar um usuário existente
		    public void atualizarUsuario(Usuario usuario) {
		        String sql = "UPDATE usuarios SET nome = ?, senha = ?, cargo = ?, user = ? WHERE id = ?";
		        Connection conexao = null;
		        PreparedStatement pstm = null;

		        try {
		            conexao = database.BancoDeDados.conectar();
		            pstm = conexao.prepareStatement(sql);
		            pstm.setString(1, usuario.getNome());
		            pstm.setString(2, usuario.getSenha());
		            pstm.setString(3, usuario.getCargo());
		            pstm.setString(4, usuario.getUser());
		            pstm.setInt(3, usuario.getId());
		            pstm.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		        	database.BancoDeDados.desconectar(conexao);
		        }
		    }
	
}
