package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.BancoDeDados;

public class PedidosLojasDAO {
	
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
						pedidoslojas.setEntrega(
						rset.getDate("data_entrega").toLocalDate());
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
		        String sql = "UPDATE PedidosLojas SET data_entrega = ?, valor_total = ?, Lojas_CNPJ = ?, endereco = ? WHERE idPedidosL = ?";
		        Connection conexao = null;
		        PreparedStatement pstm = null;

		        try {
		            conexao = database.BancoDeDados.conectar();
		            pstm = conexao.prepareStatement(sql);
		            pstm.setDate(1, java.sql.Date.valueOf(pedidoslojas.getEntrega()));
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
		        String sql = "DELETE FROM PedidosLojas WHERE idPedidosL=?";

		        try (Connection conn = database.BancoDeDados.conectar();
		             PreparedStatement stmt = conn.prepareStatement(sql)) {

		            stmt.setInt(1, id);
		            stmt.executeUpdate();

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		    
		    public int adicionarPedidosLojas(PedidosLojas pedido) {

		    	String sql =
		    	"INSERT INTO PedidosLojas(data_entrega, valor_total, endereco, Lojas_CNPJ) VALUES (?, ?, ?, ?)";

		    	Connection conexao = null;
		    	PreparedStatement pstm = null;
		    	ResultSet generatedKeys = null;

		    	try {

		    		conexao = BancoDeDados.conectar();

		    		pstm = conexao.prepareStatement(
		    				sql,
		    				PreparedStatement.RETURN_GENERATED_KEYS
		    		);

		    		pstm.setDate(1, java.sql.Date.valueOf(pedido.getEntrega()));

		    		pstm.setDouble(2, pedido.getValorTotal());

		    		pstm.setString(3, pedido.getEndereco());

		    		pstm.setString(4, pedido.getLojas_CNPJ());

		    		pstm.executeUpdate();

		    		generatedKeys = pstm.getGeneratedKeys();

		    		if (generatedKeys.next()) {

		    			return generatedKeys.getInt(1);
		    		}

		    	} catch (Exception e) {

		    		e.printStackTrace();

		    	} finally {

		    		BancoDeDados.desconectar(conexao);
		    	}

		    	return -1;
		    }

}
