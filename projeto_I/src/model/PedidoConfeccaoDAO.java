package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PedidoConfeccao;

public class PedidoConfeccaoDAO {
		
		public void adicionarPedidosConfeccoes(PedidoConfeccao pedidoconfeccao) {
			String sql = "INSERT INTO PedidosConfeccoes(entrega, valor, Confeccoes_CNPJ, forma_pgmt) VALUES (?, ?, ?, ?)";
			Connection conexao = null;
			PreparedStatement pstm = null;
			
			try {
				
				conexao = database.BancoDeDados.conectar();
				pstm = conexao.prepareStatement(sql);
				pstm.setString(1, pedidoconfeccao.getEntrega());
				pstm.setDouble(2, pedidoconfeccao.getValorPedido());
				pstm.setString(3, pedidoconfeccao.getConfeccoesCNPJ());
				pstm.setString(4, pedidoconfeccao.getForma_pgm());
				
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
		
				public List<PedidoConfeccao> listarPedidosConfeccoes(){
					String sql = "SELECT * FROM PedidosConfeccoes";
					List<PedidoConfeccao> PedidosConfeccao = new ArrayList<>();
					Connection conexao = null;
					PreparedStatement pstm = null;
					ResultSet rset = null;
					
					try {
						conexao = database.BancoDeDados.conectar();
						pstm = conexao.prepareStatement(sql);
						rset = pstm.executeQuery();
						
						while(rset.next()) {
							PedidoConfeccao pedidoconfeccao = new PedidoConfeccao();
							pedidoconfeccao.setEntrega(rset.getString("entrega"));
							pedidoconfeccao.setValorPedido(rset.getDouble("valor"));
							pedidoconfeccao.setConfeccoesCNPJ(rset.getString("Confeccoes_CNPJ"));
							pedidoconfeccao.setForma_pgm(rset.getString("forma_pgmt"));
							PedidosConfeccao.add(pedidoconfeccao);
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						database.BancoDeDados.desconectar(conexao);
					}
					return PedidosConfeccao;
				}
				

			    public void atualizarPedidoConfeccao(PedidoConfeccao pedidoconfeccao) {
			        String sql = "UPDATE PedidosConfeccoes SET entrega = ?, valor = ?, Confeccoes_CNPJ = ?, forma_pgmt = ? WHERE id = ?";
			        Connection conexao = null;
			        PreparedStatement pstm = null;

			        try {
			            conexao = database.BancoDeDados.conectar();
			            pstm = conexao.prepareStatement(sql);
			            pstm.setString(1, pedidoconfeccao.getEntrega());
			            pstm.setDouble(2, pedidoconfeccao.getValorPedido());
			            pstm.setString(3, pedidoconfeccao.getConfeccoesCNPJ());
			            pstm.setString(4, pedidoconfeccao.getForma_pgm());
			            pstm.setInt(5, pedidoconfeccao.getIdPedidoC());
			            pstm.executeUpdate();
			        } catch (SQLException e) {
			            e.printStackTrace();
			        } finally {
			        	database.BancoDeDados.desconectar(conexao);
			        }
			    }
			    
			    public static void removerPedidoConfeccao(int id) {
			        String sql = "DELETE FROM PedidosConfeccoes WHERE id=?";

			        try (Connection conn = database.BancoDeDados.conectar();
			             PreparedStatement stmt = conn.prepareStatement(sql)) {

			            stmt.setInt(1, id);
			            stmt.executeUpdate();

			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			    }

	}
