package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.BancoDeDados;

public class CarrinhoDAO {

	public int criarCarrinho(Carrinho item) {

		String sql =
				"INSERT INTO Carrinho (id_usuario, idPedidosL) VALUES (?, ?)";

		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet generatedKeys = null;

		try {

			conexao = BancoDeDados.conectar();

			pstm = conexao.prepareStatement(
					sql,
					PreparedStatement.RETURN_GENERATED_KEYS
			);

			if (item.getIdUsuario() > 0) {
				pstm.setInt(1, item.getIdUsuario());
			} else {
				pstm.setNull(1, java.sql.Types.INTEGER);
			}

			if (item.getIdPedidosL() > 0) {
				pstm.setInt(2, item.getIdPedidosL());
			} else {
				pstm.setNull(2, java.sql.Types.INTEGER);
			}

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

	public void vincularPedidoAoCarrinho(int idCarrinho, int idPedido) {

		String sql = "UPDATE Carrinho SET idPedidosL = ? WHERE id_carrinho = ?";

		Connection conexao = null;
		PreparedStatement pstm = null;

		try {

			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idPedido);
			pstm.setInt(2, idCarrinho);
			pstm.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			BancoDeDados.desconectar(conexao);
		}
	}

	public List<Carrinho> listarCarrinho() {

		List<Carrinho> lista = new ArrayList<>();

		String sql = "SELECT * FROM Carrinho";

		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conexao = BancoDeDados.conectar();

			pstm = conexao.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

			    Carrinho item = new Carrinho();

			    item.setIdCarrinho(rset.getInt("id_carrinho"));
			    item.setIdUsuario(rset.getInt("id_usuario"));
			    item.setIdPedidosL( rset.getInt("idPedidosL"));

			    lista.add(item);

			

				lista.add(item);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			BancoDeDados.desconectar(conexao);
		}

		return lista;
	}
	  public void removerCarrinho(int idCarrinho) {

		  String sql =
		            "DELETE FROM Carrinho WHERE id_carrinho = ?";

		    Connection conexao = null;
		    PreparedStatement pstm = null;

		    try {

		        conexao = BancoDeDados.conectar();
		        
		        pstm = conexao.prepareStatement(sql);
		        pstm.setInt(1, idCarrinho);

	            pstm.executeUpdate();

	        } catch (Exception e) {

	            e.printStackTrace();

	        } finally {

	            BancoDeDados.desconectar(conexao);
	        }
	    }
}