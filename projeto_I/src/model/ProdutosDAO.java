package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {
	
	public void adicionarProduto(Produtos produto) {
		String sql = "INSERT INTO Produtos(nome, tamanho, cor, qtde_estoque, preco, tipo_produto) VALUES (?, ?, ?, ?, ?, ?)";
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
			pstm.setString(6, produto.getTipoProduto());
			
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
						produto.setTipoProduto(rset.getString("tipo_produto"));
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
		        String sql = "UPDATE Produtos SET nome = ?, tamanho = ?, cor = ?, qtde_estoque = ?, preco = ?, tipo_produto = ? WHERE id = ?";
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
		            pstm.setString(6, produto.getTipoProduto());
		            pstm.setInt(7, produto.getIdProduto());
		            pstm.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		        	database.BancoDeDados.desconectar(conexao);
		        }
		    }
		    
		    public static void remover(int id) {
		        String sql = "DELETE FROM Produtos WHERE id=?";

		        try (Connection conn = database.BancoDeDados.conectar();
		             PreparedStatement stmt = conn.prepareStatement(sql)) {

		            stmt.setInt(1, id);
		            stmt.executeUpdate();

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		    
}
