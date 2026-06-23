package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import database.BancoDeDados;

public class PedidosLojasDAO {

	private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public List<PedidosLojas> listarPedidosLojas() {

	    String sql =
	        "SELECT p.idPedidosL, p.data_entrega, p.valor_total, p.Lojas_CNPJ, p.endereco, " +
	        "l.nome, COALESCE(SUM(plp.quantidade), 0) AS quantidade_total " +
	        "FROM PedidosLojas p " +
	        "JOIN Lojas l ON p.Lojas_CNPJ = l.CNPJ " +
	        "LEFT JOIN PedidosLojas_Produtos plp ON plp.PedidosLojas_idPedidosL = p.idPedidosL " +
	        "GROUP BY p.idPedidosL, p.data_entrega, p.valor_total, p.Lojas_CNPJ, p.endereco, l.nome";

	    List<PedidosLojas> pedidolojas = new ArrayList<>();
	    Connection conexao = null;
	    PreparedStatement pstm = null;
	    ResultSet rset = null;

	    try {

	        conexao = BancoDeDados.conectar();
	        pstm = conexao.prepareStatement(sql);
	        rset = pstm.executeQuery();

	        while (rset.next()) {

	            PedidosLojas pedidoslojas = new PedidosLojas();

	            java.sql.Date data = rset.getDate("data_entrega");

	            pedidoslojas.setIdPedidoL(rset.getInt("idPedidosL"));
	            pedidoslojas.setEntrega(
	                data != null ? data.toLocalDate().format(FORMATO_DATA) : null
	            );

	            pedidoslojas.setValorTotal(rset.getDouble("valor_total"));
	            pedidoslojas.setQuantidadeTotal(rset.getInt("quantidade_total"));
	            pedidoslojas.setLojas_CNPJ(rset.getString("Lojas_CNPJ"));
	            pedidoslojas.setEndereco(rset.getString("endereco"));

	            // nome vindo da tabela Lojas
	            pedidoslojas.setNomeLoja(rset.getString("nome"));

	            pedidolojas.add(pedidoslojas);
	        }

	    } catch (SQLException e) {

	        e.printStackTrace();

	    } finally {

	        BancoDeDados.desconectar(conexao);
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
		            pstm.setDate(1, java.sql.Date.valueOf(parseDataEntrega(pedidoslojas.getEntrega())));
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
		        Connection conn = null;

		        try {
		            conn = database.BancoDeDados.conectar();

		            String sqlCarrinho = "UPDATE Carrinho SET idPedidosL = NULL WHERE idPedidosL = ?";
		            PreparedStatement stmtCarrinho = conn.prepareStatement(sqlCarrinho);
		            stmtCarrinho.setInt(1, id);
		            stmtCarrinho.executeUpdate();

		            String sqlProdutos = "DELETE FROM PedidosLojas_Produtos WHERE PedidosLojas_idPedidosL = ?";
		            PreparedStatement stmtProdutos = conn.prepareStatement(sqlProdutos);
		            stmtProdutos.setInt(1, id);
		            stmtProdutos.executeUpdate();

		            String sqlPedido = "DELETE FROM PedidosLojas WHERE idPedidosL = ?";
		            PreparedStatement stmtPedido = conn.prepareStatement(sqlPedido);
		            stmtPedido.setInt(1, id);
		            stmtPedido.executeUpdate();

		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            database.BancoDeDados.desconectar(conn);
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

		    		pstm.setDate(1, java.sql.Date.valueOf(parseDataEntrega(pedido.getEntrega())));

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

		    private LocalDate parseDataEntrega(String data) {
		    	String trimmed = data.trim();
		    	if (trimmed.contains("/")) {
		    		return LocalDate.parse(trimmed, FORMATO_DATA);
		    	}
		    	return LocalDate.parse(trimmed);
		    }

}
