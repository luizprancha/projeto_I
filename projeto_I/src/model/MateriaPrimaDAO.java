package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import database.BancoDeDados;
import model.MateriaPrima;

public class MateriaPrimaDAO {
		
		public void adicionarMateriaPrima(MateriaPrima materiaPrima) {
			String sql = "INSERT INTO MateriaPrima(nome, cor, quantidade, tipo, dataCadastro) VALUES (?, ?, ?, ?, ?)";
			Connection conexao = null;
			PreparedStatement pstm = null;
			
			try {
				
				conexao = database.BancoDeDados.conectar();
				pstm = conexao.prepareStatement(sql);
				pstm.setString(1, materiaPrima.getNome());
				pstm.setString(2, materiaPrima.getCor());
				pstm.setInt(3, materiaPrima.getQuantidade());
				pstm.setString(4, materiaPrima.getTipo());
				pstm.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
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
		
				public List<MateriaPrima> listarMateriasPrimas(){
					String sql = "SELECT * FROM MateriaPrima";
					List<MateriaPrima> MateriaPrima = new ArrayList<>();
					Connection conexao = null;
					PreparedStatement pstm = null;
					ResultSet rset = null;
					
					try {
						conexao = database.BancoDeDados.conectar();
						pstm = conexao.prepareStatement(sql);
						rset = pstm.executeQuery();
						
						while(rset.next()) {
							MateriaPrima materiaPrima = new MateriaPrima();
							materiaPrima.setNome(rset.getString("nome"));
							materiaPrima.setCor(rset.getString("cor"));
							materiaPrima.setQuantidade(rset.getInt("quantidade"));
							materiaPrima.setTipo(rset.getString("tipo"));
							materiaPrima.setIdMateriaPrima(rset.getInt("idMateriaPrima"));
							materiaPrima.setDataCadastro(rset.getDate("dataCadastro").toLocalDate()
								);
							MateriaPrima.add(materiaPrima);
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						database.BancoDeDados.desconectar(conexao);
					}
					return MateriaPrima;
				}
				

			    public void atualizarMateriaPrima(MateriaPrima materiaPrima) {
			        String sql = "UPDATE MateriaPrima SET nome = ?, cor = ?, quantidade = ?, tipo = ? WHERE idMateriaPrima = ?";
			        Connection conexao = null;
			        PreparedStatement pstm = null;

			        try {
			            conexao = database.BancoDeDados.conectar();
			            pstm = conexao.prepareStatement(sql);
			            pstm.setString(1, materiaPrima.getNome());
			            pstm.setString(2, materiaPrima.getCor());
			            pstm.setInt(3, materiaPrima.getQuantidade());
			            pstm.setString(4, materiaPrima.getTipo());
			            pstm.setInt(5, materiaPrima.getIdMateriaPrima());

			            pstm.executeUpdate();
			        } catch (SQLException e) {
			            e.printStackTrace();
			        } finally {
			        	database.BancoDeDados.desconectar(conexao);
			        }
			    }
			    
			    public static void removerMateria(int id) {
			        String sql = "DELETE FROM MateriaPrima WHERE idMateriaPrima=?";

			        try (Connection conn = database.BancoDeDados.conectar();
			             PreparedStatement stmt = conn.prepareStatement(sql)) {

			            stmt.setInt(1, id);
			            stmt.executeUpdate();

			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			    }
			    
			    
			    public List<MateriaPrima> buscarMateria(String nomeBusca) {

			        String sql = "SELECT * FROM MateriaPrima WHERE nome LIKE ?";

			        List<MateriaPrima> materiaprima = new ArrayList<>();

			        Connection conexao = null;
			        PreparedStatement pstm = null;
			        ResultSet rset = null;

			        try {

			            conexao = database.BancoDeDados.conectar();

			            pstm = conexao.prepareStatement(sql);

			            pstm.setString(1, "%" + nomeBusca + "%");

			            rset = pstm.executeQuery();

			            while (rset.next()) {

			                MateriaPrima materia = new MateriaPrima();

			                materia.setNome(rset.getString("nome"));
							materia.setCor(rset.getString("cor"));
							materia.setQuantidade(rset.getInt("quantidade"));
							materia.setTipo(rset.getString("tipo"));
							materia.setIdMateriaPrima(rset.getInt("idMateriaPrima"));

			                materiaprima.add(materia);
			            }

			        } catch (SQLException e) {
			            e.printStackTrace();
			        } finally {
			            database.BancoDeDados.desconectar(conexao);
			        }

			        return materiaprima;
			    }
			    
			    public List<MateriaPrima> buscarMateriasParadas() {

			        List<MateriaPrima> lista = new ArrayList<>();

			        String sql =
			            "SELECT * FROM MateriaPrima " +
			            "WHERE UNIX_TIMESTAMP(dataCadastro) <= UNIX_TIMESTAMP(NOW()) - (10)";

			        try {
			            Connection con = database.BancoDeDados.conectar();
			            PreparedStatement stmt = con.prepareStatement(sql);
			            ResultSet rs = stmt.executeQuery();

			            while (rs.next()) {
			                MateriaPrima mp = new MateriaPrima();

			                mp.setIdMateriaPrima(rs.getInt("idMateriaPrima"));
			                mp.setNome(rs.getString("nome"));

			                lista.add(mp);
			            }

			            rs.close();
			            stmt.close();
			            con.close();

			        } catch (Exception e) {
			            e.printStackTrace();
			        }

			        return lista;
			    }

	}
