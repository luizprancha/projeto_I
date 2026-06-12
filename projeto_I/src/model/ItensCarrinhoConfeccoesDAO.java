package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.BancoDeDados;

public class ItensCarrinhoConfeccoesDAO {

	public void adicionarItem(ItensCarrinhoConfeccoes item) throws SQLException {

		String sql = "INSERT INTO ItensCarrinhoConfeccoes "
				+ "(id_carrinho, id_materia_prima, quantidade, nome_materia) "
				+ "VALUES (?, ?, ?, ?)";

		Connection conexao = null;
		PreparedStatement pstm = null;

		try {

			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, item.getIdCarrinho());
			pstm.setInt(2, item.getIdMateriaPrima());
			pstm.setInt(3, item.getQuantidade());
			pstm.setString(4, item.getNomeMateria());
			pstm.executeUpdate();

		} catch (SQLException e) {

			throw e;

		} finally {

			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			BancoDeDados.desconectar(conexao);
		}
	}

	public List<ItensCarrinhoConfeccoes> listarItensPorCarrinho(int idCarrinho) {

		String sql = "SELECT * FROM ItensCarrinhoConfeccoes WHERE id_carrinho = ?";
		List<ItensCarrinhoConfeccoes> itens = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idCarrinho);
			rset = pstm.executeQuery();

			while (rset.next()) {

				ItensCarrinhoConfeccoes item = new ItensCarrinhoConfeccoes();
				item.setIdItem(rset.getInt("id_item"));
				item.setIdCarrinho(rset.getInt("id_carrinho"));
				item.setIdMateriaPrima(rset.getInt("id_materia_prima"));
				item.setQuantidade(rset.getInt("quantidade"));
				item.setNomeMateria(rset.getString("nome_materia"));
				itens.add(item);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			BancoDeDados.desconectar(conexao);
		}

		return itens;
	}

	public void atualizarItem(ItensCarrinhoConfeccoes item) {

		String sql = "UPDATE ItensCarrinhoConfeccoes SET id_carrinho = ?, id_materia_prima = ?, "
				+ "quantidade = ?, nome_materia = ? WHERE id_item = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {

			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, item.getIdCarrinho());
			pstm.setInt(2, item.getIdMateriaPrima());
			pstm.setInt(3, item.getQuantidade());
			pstm.setString(4, item.getNomeMateria());
			pstm.setInt(5, item.getIdItem());
			pstm.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			BancoDeDados.desconectar(conexao);
		}
	}

	public static void removerItem(int id) {

		Connection conexao = null;
		PreparedStatement pstm = null;

		try {

			conexao = BancoDeDados.conectar();
			String sql = "DELETE FROM ItensCarrinhoConfeccoes WHERE id_item = ?";
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public static void removerItensPorMateria(int idMateriaPrima) {

		Connection conexao = null;
		PreparedStatement pstm = null;

		try {

			conexao = BancoDeDados.conectar();
			String sql = "DELETE FROM ItensCarrinhoConfeccoes WHERE id_materia_prima = ?";
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idMateriaPrima);
			pstm.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			BancoDeDados.desconectar(conexao);
		}
	}
}
