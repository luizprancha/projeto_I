package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.BancoDeDados;

public class ProdutosDAO {
	
	public void adicionarProduto(Produtos produto) {
		String sql = "INSERT INTO Produtos(nome, tamanho, cor, qtde_estoque, preco) VALUES (?, ?, ?, ?, ?)";
		Connection conexao = null;
		PreparedStatement pstm = null;
		
		try {
			
			conexao = database.BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getTamanho());
			pstm.setString(3, produto.getCor());
			pstm.setInt(4, produto.getQuantidade());
			pstm.setDouble(5, produto.getPreco());
			
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
	
			public List<Produtos> listarProdutos(){
				String sql = "SELECT * FROM Produtos";
				List<Produtos> produtos = new ArrayList<>();
				Connection conexao = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;
				
				try {
					conexao = database.BancoDeDados.conectar();
					pstm = conexao.prepareStatement(sql);
					rset = pstm.executeQuery();
					
					while(rset.next()) {
						Produtos produto = new Produtos();
						produto.setNome(rset.getString("nome"));
						produto.setTamanho(rset.getString("tamanho"));
						produto.setCor(rset.getString("cor"));
						produto.setQuantidade(rset.getInt("qtde_estoque"));
						produto.setPreco(rset.getDouble("preco"));
						produto.setIdProduto(rset.getInt("idProdutos"));
						produtos.add(produto);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					database.BancoDeDados.desconectar(conexao);
				}
				return produtos;
			}
			

		    public void atualizarProdutos(Produtos produto) {
		        String sql = "UPDATE Produtos SET nome = ?, tamanho = ?, cor = ?, qtde_estoque = ?, preco = ? WHERE idProdutos = ?";
		        Connection conexao = null;
		        PreparedStatement pstm = null;

		        try {
		            conexao = database.BancoDeDados.conectar();
		            pstm = conexao.prepareStatement(sql);
		            pstm.setString(1, produto.getNome());
		            pstm.setString(2, produto.getTamanho());
		            pstm.setString(3, produto.getCor());
		            pstm.setInt(4, produto.getQuantidade());
		            pstm.setDouble(5, produto.getPreco());
		            pstm.setInt(6, produto.getIdProduto());
		            pstm.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		        	database.BancoDeDados.desconectar(conexao);
		        }
		    }
		    
		    public static void removerProdutos(int id) {

		        String sql = "DELETE FROM Produtos WHERE idProdutos = ?";

		        Connection conexao = null;
		        PreparedStatement pstm = null;

		        try {
		            conexao = database.BancoDeDados.conectar();
		            pstm = conexao.prepareStatement(sql);
		            pstm.setInt(1, id);
		            pstm.executeUpdate();

		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
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
		    
		    

		    public Produtos buscarPorId(int id) {

		    	String sql = "SELECT * FROM Produtos WHERE idProdutos = ?";

		    	Connection conexao = null;
		    	PreparedStatement pstm = null;
		    	ResultSet rset = null;

		    	Produtos produto = null;

		    	try {

		    		conexao = database.BancoDeDados.conectar();
		    		pstm = conexao.prepareStatement(sql);

		    		pstm.setInt(1, id);

		    		rset = pstm.executeQuery();

		    		if (rset.next()) {

		    			produto = new Produtos();

		    			produto.setIdProduto(rset.getInt("idProdutos"));
		    			produto.setNome(rset.getString("nome"));
		    			produto.setPreco(rset.getDouble("preco"));
		    			produto.setQuantidade(rset.getInt("qtde_estoque"));
		    			produto.setTamanho(rset.getString("tamanho"));
		    			produto.setCor(rset.getString("cor"));
		    		}

		    	} catch (SQLException e) {

		    		e.printStackTrace();

		    	} finally {

		    		database.BancoDeDados.desconectar(conexao);

		    	}

		    	return produto;
		    }
		    
		    public List<Produtos> buscarProdutos(String nomeBusca) {

		        String sql = "SELECT * FROM Produtos WHERE nome LIKE ?";

		        List<Produtos> produtos = new ArrayList<>();

		        Connection conexao = null;
		        PreparedStatement pstm = null;
		        ResultSet rset = null;

		        try {

		            conexao = database.BancoDeDados.conectar();
		            pstm = conexao.prepareStatement(sql);

		            pstm.setString(1, "%" + nomeBusca + "%");

		            rset = pstm.executeQuery();

		            while (rset.next()) {

		                Produtos produto = new Produtos();

		                produto.setNome(rset.getString("nome"));
		                produto.setTamanho(rset.getString("tamanho"));
		                produto.setCor(rset.getString("cor"));
		                produto.setQuantidade(rset.getInt("qtde_estoque"));
		                produto.setPreco(rset.getDouble("preco"));
		                produto.setIdProduto(rset.getInt("idProdutos"));

		                produtos.add(produto);
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            database.BancoDeDados.desconectar(conexao);
		        }

		        return produtos;
		    }
		    
		    public void atualizarEstoque(
		    		int idProduto,
		    		int quantidade) {

		    	String sql =
		    	"UPDATE Produtos " +
		    	"SET qtde_estoque = qtde_estoque - ? " +
		    	"WHERE idProdutos = ?";

		    	Connection conexao = null;
		    	PreparedStatement pstm = null;

		    	try {

		    		conexao = BancoDeDados.conectar();

		    		pstm = conexao.prepareStatement(sql);

		    		pstm.setInt(1, quantidade);

		    		pstm.setInt(2, idProduto);

		    		pstm.executeUpdate();

		    	} catch (Exception e) {

		    		e.printStackTrace();

		    	} finally {

		    		BancoDeDados.desconectar(conexao);
		    	}
		    }
			
		    
}
