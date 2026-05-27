package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.BancoDeDados;


public class ItensCarrinhoDAO {
	public void adicionarItensCarrinho(
	        ItensCarrinho itensCarrinho)
	        throws SQLException {

	    String verificar =
	        "SELECT * FROM ItensCarrinho " +
	        "WHERE id_carrinho = ? AND id_produto = ?";

	    String sql =
	        "INSERT INTO ItensCarrinho " +
	        "(id_carrinho, id_produto, quantidade, nome_produto, preco) " +
	        "VALUES (?, ?, ?, ?, ?)";

	    Connection conexao = null;

	    PreparedStatement pstmVerificar = null;
	    PreparedStatement pstm = null;

	    ResultSet rset = null;

	    try {

	        conexao = BancoDeDados.conectar();

	        // verifica se o produto já existe no carrinho
	        pstmVerificar =
	            conexao.prepareStatement(verificar);

	        pstmVerificar.setInt(
	            1,
	            itensCarrinho.getIdCarrinho()
	        );

	        pstmVerificar.setInt(
	            2,
	            itensCarrinho.getIdProduto()
	        );

	        rset = pstmVerificar.executeQuery();

	        if (rset.next()) {

	            throw new SQLException(
	                "Produto já existe no carrinho!"
	            );

	        }

	        // insert
	        pstm = conexao.prepareStatement(sql);

	        pstm.setInt( 1,itensCarrinho.getIdCarrinho());
	        pstm.setInt(2,itensCarrinho.getIdProduto());
	        pstm.setInt(3, itensCarrinho.getQuantidade());
	        pstm.setString(4,itensCarrinho.getNomeProduto() );
	        pstm.setDouble( 5, itensCarrinho.getPreco() );
	        pstm.execute();

	    } finally {

	        if (rset != null) {
	            rset.close();
	        }

	        if (pstmVerificar != null) {

	            pstmVerificar.close();
	        }
	        
	        if (pstm != null) {
	            pstm.close();
	        }

	        BancoDeDados.desconectar(conexao);
	    }
	}
	
			public List<ItensCarrinho> listarItensCarrinho(){
				String sql = "SELECT * FROM Confeccoes";
				List<ItensCarrinho> itensCarrinho = new ArrayList<>();
				Connection conexao = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;
				
				try {
					conexao = database.BancoDeDados.conectar();
					pstm = conexao.prepareStatement(sql);
					rset = pstm.executeQuery();
					
					while(rset.next()) {
						ItensCarrinho itenscarrinhos = new ItensCarrinho();
						itenscarrinhos.setIdItem(rset.getInt("id_item"));
						itenscarrinhos.setIdCarrinho(rset.getInt("id_carrinho"));
						itenscarrinhos.setIdProduto(rset.getInt("id_produto"));
						itenscarrinhos.setQuantidade(rset.getInt("quantidade"));
						itenscarrinhos.setNomeProduto(rset.getString("nome_produto"));
						itenscarrinhos.setPreco(rset.getDouble("preco"));
						
						itensCarrinho.add(itenscarrinhos);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					database.BancoDeDados.desconectar(conexao);
				}
				return itensCarrinho;
			}
			

		    public void atualizarItensCarrinho(ItensCarrinho itensCarrinho) {
		        String sql = "UPDATE Confeccoes SET  id_carrinho = ?, id_produto = ?, quantidade = ? WHERE id_item = ?";
		        Connection conexao = null;
		        PreparedStatement pstm = null;

		        try {
		            conexao = database.BancoDeDados.conectar();
		            pstm = conexao.prepareStatement(sql);
		            pstm.setInt(1, itensCarrinho.getIdItem());
		            pstm.setInt(2, itensCarrinho.getIdCarrinho());
		            pstm.setInt(3, itensCarrinho.getIdProduto());
		            pstm.setInt(4, itensCarrinho.getQuantidade());
		            pstm.setString(5, itensCarrinho.getNomeProduto());
		            pstm.setDouble(6, itensCarrinho.getPreco());
		            
		           
		            pstm.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		        	database.BancoDeDados.desconectar(conexao);
		        }
		    }
		    
		    
		    
		    public static void removerItensCarrinho(int id) {

		        Connection conexao = null;
		        PreparedStatement pstm = null;

		        try {

		            conexao = database.BancoDeDados.conectar();

		            // remove pedidos ligados à confecção
		            String sqlPedidos = "DELETE FROM ItensCarrinho WHERE id_item = ?";

		            pstm = conexao.prepareStatement(sqlPedidos);
		            pstm.setInt(1, id);
		            pstm.executeUpdate();

		        } catch (Exception e) {

		            e.printStackTrace();

		        }
		    }

}
