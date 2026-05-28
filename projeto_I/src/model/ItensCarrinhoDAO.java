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


public class ItensCarrinhoDAO {
	
	public void adicionarItensCarrinho(ItensCarrinho itenscarrinho)
	        throws SQLException {

	    String verificar = "SELECT * FROM ItensCarrinho " +"WHERE id_carrinho = ? AND id_produto = ?";

	    String sql ="INSERT INTO ItensCarrinho " +"(id_carrinho, id_produto, quantidade, nome_produtos, preco) " +"VALUES (?, ?, ?, ?, ?)";

	    Connection conexao = null;
	    PreparedStatement pstmVerificar = null;
	    PreparedStatement pstm = null;
	    ResultSet rset = null;

	    try {

	        conexao = BancoDeDados.conectar();


	        pstmVerificar =conexao.prepareStatement(verificar);
	        pstmVerificar.setInt( 1, itenscarrinho.getIdCarrinho());
	        pstmVerificar.setInt( 2, itenscarrinho.getIdProduto()  );
	        rset = pstmVerificar.executeQuery();

	        // já existe
	        if (rset.next()) { throw new SQLException("Produto já existe no carrinho!" );
	        }

	        // insert
	        pstm = conexao.prepareStatement(sql);

	        pstm.setInt(1,itenscarrinho.getIdCarrinho());
	        pstm.setInt(2,itenscarrinho.getIdProduto());
	        pstm.setInt( 3, itenscarrinho.getQuantidade() );
	        pstm.setString( 4,itenscarrinho.getNomeProduto() );
	        pstm.setDouble(5,itenscarrinho.getPreco());

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
				String sql = "SELECT * FROM ItensCarrinho";
				List<ItensCarrinho> itenscarrinho = new ArrayList<>();
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
						
						itenscarrinho.add(itenscarrinhos);

					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					database.BancoDeDados.desconectar(conexao);
				}
				return itenscarrinho;
			}
			

		    public void atualizarItensCarrinho(ItensCarrinho itenscarrinho) {
		        String sql = "UPDATE ItensCarrinho SET id_carrinho = ?, id_produto = ?, quantidade = ?, nome_produto = ?, preco = ? WHERE  id_item = ?";
		        Connection conexao = null;
		        PreparedStatement pstm = null;

		        try {
		        	  conexao = database.BancoDeDados.conectar();
			            pstm = conexao.prepareStatement(sql);
			            pstm.setInt(1, itenscarrinho.getIdCarrinho());
			            pstm.setInt(2, itenscarrinho.getIdProduto());
			            pstm.setInt(3, itenscarrinho.getQuantidade());
			            pstm.setString(4, itenscarrinho.getNomeProduto());
			            pstm.setDouble(5, itenscarrinho.getPreco());
			            pstm.setInt(6, itenscarrinho.getIdItem());

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

		          
		            String sqlPedidos = "DELETE FROM ItensCarrinho WHERE id_item = ?";

		            pstm = conexao.prepareStatement(sqlPedidos);
		            pstm.setInt(1, id);
		            pstm.executeUpdate();

		        } catch (Exception e) {

		            e.printStackTrace();

		        }
		    }

}
