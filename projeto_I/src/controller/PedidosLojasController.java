package controller;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import model.Carrinho;
import model.CarrinhoDAO;
import model.LojasDAO;
import model.PedidosLojas;
import model.PedidosLojasDAO;
import model.PedidosLojasProdutos;
import model.PedidosLojasProdutosDAO;
import model.ProdutosDAO;
import view.TelaPedidosLojas;

public class PedidosLojasController {

	private final TelaPedidosLojas view;
	private final PedidosLojasDAO model;
	private final Navegador navegador;

	public PedidosLojasController(
			TelaPedidosLojas view,
			PedidosLojasDAO model,
			Navegador navegador) {

		this.view = view;
		this.model = model;
		this.navegador = navegador;

		view.finalizarPedido(e -> {

			try {

				// VALIDAR CNPJ
				String cnpj = view.getCNPJLoja();

				LojasDAO lojasDAO = new LojasDAO();

				boolean existe =
						lojasDAO.existeCNPJ(cnpj);

				if (!existe) {

					JOptionPane.showMessageDialog(
							null,
							"CNPJ não encontrado!"
					);

					return;
				}

				// PEGAR ITENS DO CARRINHO
				CarrinhoDAO carrinhoDAO =
						new CarrinhoDAO();

				List<Carrinho> carrinho =
						carrinhoDAO.listarItensCarrinho();

				if (carrinho.isEmpty()) {

					JOptionPane.showMessageDialog(
							null,
							"Carrinho vazio!"
					);

					return;
				}

				// CALCULAR VALOR TOTAL
				double valorTotal = 0;

				for (Carrinho item : carrinho) {

					valorTotal +=
							item.getPreco()
							* item.getQuantidade();
				}

				// CRIAR PEDIDO
				PedidosLojas pedido =
						new PedidosLojas();

				pedido.setLojas_CNPJ(cnpj);

				pedido.setEntrega(
						LocalDate.parse(
								view.getEntrega()
						)
				);

				pedido.setEndereco(
						view.getEndereco()
				);

				pedido.setValorTotal(valorTotal);

				// SALVAR PEDIDO
				int idPedido =
						model.adicionarPedidosLojas(
								pedido
						);

				// DAO DOS ITENS
				PedidosLojasProdutosDAO itensDAO =
						new PedidosLojasProdutosDAO();

				// DAO PRODUTOS
				ProdutosDAO produtosDAO =
						new ProdutosDAO();

				// PERCORRER CARRINHO
				for (Carrinho item : carrinho) {

					// SALVAR ITEM DO PEDIDO
					PedidosLojasProdutos itemPedido =
							new PedidosLojasProdutos();

					itemPedido.setIdPedido(idPedido);

					itemPedido.setIdProduto(
							item.getIdProduto()
					);

					itemPedido.setQuantidade(
							item.getQuantidade()
					);

					itemPedido.setPreco(
							item.getPreco()
					);

					itensDAO.salvar(itemPedido);


					produtosDAO.atualizarEstoque(
							item.getIdProduto(),
							item.getQuantidade()
					);
				}

				// LIMPAR CARRINHO
				carrinhoDAO.limparCarrinho();

				// LIMPAR CAMPOS
				view.limparCampos();

				JOptionPane.showMessageDialog(
						null,
						"Pedido realizado com sucesso!"
				);

			} catch (Exception ex) {

				ex.printStackTrace();

				JOptionPane.showMessageDialog(
						null,
						"Erro ao finalizar pedido!"
				);
			}
		});
	}
}