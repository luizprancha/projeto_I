package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.BancoDeDados;

public class PedidosLojasProdutosDAO {

	public void salvar(PedidosLojasProdutos item) {

		String sql =
		"INSERT INTO PedidosLojas_Produtos (PedidosLojas_idPedidosL, Produtos_idProdutos, preco, quantidade) VALUES (?, ?, ?, ?)";

		Connection conexao = null;
		PreparedStatement pstm = null;

		try {

			conexao = BancoDeDados.conectar();

			pstm = conexao.prepareStatement(sql);

			pstm.setInt(1, item.getIdPedido());
			pstm.setInt(2, item.getIdProduto());
			pstm.setDouble(3, item.getPreco());
			pstm.setInt(4, item.getQuantidade());

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			BancoDeDados.desconectar(conexao);
		}
	}
}