package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.BancoDeDados;

public class PedidoConfeccaoDAO {

	public int adicionarPedidosConfeccoes(PedidoConfeccao pedidoconfeccao) {
		String sql = "INSERT INTO PedidosConfeccoes(entrega, valor, Confeccoes_CNPJ, forma_pgmt, quantidade) VALUES (?, ?, ?, ?, ?)";
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet generatedKeys = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setDate(1, java.sql.Date.valueOf(pedidoconfeccao.getEntrega()));
			pstm.setDouble(2, pedidoconfeccao.getValorPedido());
			pstm.setString(3, pedidoconfeccao.getConfeccoesCNPJ());
			pstm.setString(4, pedidoconfeccao.getForma_pgm());
			pstm.setInt(5, pedidoconfeccao.getQuantidade());

			pstm.executeUpdate();

			generatedKeys = pstm.getGeneratedKeys();
			if (generatedKeys.next()) {
				return generatedKeys.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
		return -1;
	}

	public List<PedidoConfeccao> listarPedidosConfeccoes() {
		String sql = "SELECT * FROM PedidosConfeccoes";
		List<PedidoConfeccao> pedidos = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				PedidoConfeccao pedido = new PedidoConfeccao();
				pedido.setIdPedidoC(rset.getInt("idPedidoC"));
				java.sql.Date data = rset.getDate("entrega");
				if (data != null) {
					pedido.setEntrega(data.toLocalDate());
				}
				pedido.setValorPedido(rset.getDouble("valor"));
				pedido.setConfeccoesCNPJ(rset.getString("Confeccoes_CNPJ"));
				pedido.setForma_pgm(rset.getString("forma_pgmt"));
				pedido.setQuantidade(rset.getInt("quantidade"));
				pedidos.add(pedido);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
		return pedidos;
	}

	public void atualizarPedidoConfeccao(PedidoConfeccao pedidoconfeccao) {
		String sql = "UPDATE PedidosConfeccoes SET entrega = ?, valor = ?, Confeccoes_CNPJ = ?, forma_pgmt = ?, quantidade = ? WHERE idPedidoC = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setDate(1, java.sql.Date.valueOf(pedidoconfeccao.getEntrega()));
			pstm.setDouble(2, pedidoconfeccao.getValorPedido());
			pstm.setString(3, pedidoconfeccao.getConfeccoesCNPJ());
			pstm.setString(4, pedidoconfeccao.getForma_pgm());
			pstm.setInt(5, pedidoconfeccao.getQuantidade());
			pstm.setInt(6, pedidoconfeccao.getIdPedidoC());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
	}

	public void removerPedidoConfeccao(int id) {
		String sql = "DELETE FROM PedidosConfeccoes WHERE idPedidoC = ?";

		try (Connection conn = BancoDeDados.conectar();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, id);
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
