package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.BancoDeDados;

public class CarrinhoDAO {

	public void adicionarItem(Carrinho item) {

		String sql =
		"INSERT INTO ItensCarrinho (id_carrinho, id_produto, quantidade, preco) VALUES (?, ?, ?, ?)";

		Connection conexao = null;
		PreparedStatement pstm = null;

		try {

			conexao = BancoDeDados.conectar();

			pstm = conexao.prepareStatement(sql);

			pstm.setInt(1, item.getIdCarrinho());

			pstm.setInt(2, item.getIdProduto());

			pstm.setInt(3, item.getQuantidade());

			pstm.setDouble(4, item.getPreco());

			pstm.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			BancoDeDados.desconectar(conexao);
		}
	}

	public List<Carrinho> listarItensCarrinho() {

		List<Carrinho> lista = new ArrayList<>();

		String sql = "SELECT * FROM ItensCarrinho";

		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conexao = BancoDeDados.conectar();

			pstm = conexao.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Carrinho item = new Carrinho();

				item.setIdCarrinho(
						rset.getInt("id_carrinho"));

				item.setIdProduto(
						rset.getInt("id_produto"));

				item.setQuantidade(
						rset.getInt("quantidade"));

				item.setPreco(
						rset.getDouble("preco"));

				lista.add(item);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			BancoDeDados.desconectar(conexao);
		}

		return lista;
	}

	public void limparCarrinho() {

		String sql = "DELETE FROM ItensCarrinho";

		Connection conexao = null;
		PreparedStatement pstm = null;

		try {

			conexao = BancoDeDados.conectar();

			pstm = conexao.prepareStatement(sql);

			pstm.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			BancoDeDados.desconectar(conexao);
		}
	}
}