package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidosLojasDAO {
	
	public void adicionarPedidosLojas(PedidosLojas pedidoslojas) {
		String sql = "INSERT INTO PedidosLojas(data_entrega, valor_total, Lojas_CNPJ, endereco) VALUES (?, ?, ?, ?)";
		Connection conexao = null;
		PreparedStatement pstm = null;
		
		try {
			
			conexao = database.BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, pedidoslojas.getEntrega());
			pstm.setDouble(2, pedidoslojas.getValorTotal());
			pstm.setString(3, pedidoslojas.getLojas_CNPJ());
			pstm.setString(4, pedidoslojas.getEndereco());
			
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
	
			public List<PedidosLojas> listarPedidosLojas(){
				String sql = "SELECT * FROM PedidosLojas";
				List<PedidosLojas> pedidolojas = new ArrayList<>();
				Connection conexao = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;
				
				try {
					conexao = database.BancoDeDados.conectar();
					pstm = conexao.prepareStatement(sql);
					rset = pstm.executeQuery();
					
					while(rset.next()) {
						PedidosLojas pedidoslojas = new PedidosLojas();
						pedidoslojas.setEntrega(rset.getString("data_entrega"));
						pedidoslojas.setValorTotal(rset.getDouble("valor_total"));
						pedidoslojas.setLojas_CNPJ(rset.getString("Lojas_CNPJ"));
						pedidoslojas.setEndereco(rset.getString("endereco"));
						pedidolojas.add(pedidoslojas);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					database.BancoDeDados.desconectar(conexao);
				}
				return pedidolojas;
			}
			

		    public void atualizarPedidosLojas(PedidosLojas pedidoslojas) {
		        String sql = "UPDATE PedidosLojas SET data_entrega = ?, valor_total = ?, Lojas_CNPJ = ?, endereco = ? WHERE id = ?";
		        Connection conexao = null;
		        PreparedStatement pstm = null;

		        try {
		            conexao = database.BancoDeDados.conectar();
		            pstm = conexao.prepareStatement(sql);
		            pstm.setString(1, pedidoslojas.getEntrega());
		            pstm.setDouble(2, pedidoslojas.getValorTotal());
		            pstm.setString(3, pedidoslojas.getLojas_CNPJ());
		            pstm.setString(4, pedidoslojas.getEndereco());
		            pstm.setInt(5, pedidoslojas.getIdPedidoL());
		            pstm.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		        	database.BancoDeDados.desconectar(conexao);
		        }
		    }
		    
		    public static void removerPedidosLojas(int id) {
		        String sql = "DELETE FROM PedidosLojas WHERE id=?";

		        try (Connection conn = database.BancoDeDados.conectar();
		             PreparedStatement stmt = conn.prepareStatement(sql)) {

		            stmt.setInt(1, id);
		            stmt.executeUpdate();

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

}
