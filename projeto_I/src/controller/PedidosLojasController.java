package controller;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import model.Carrinho;
import model.CarrinhoDAO;
import model.ItensCarrinho;
import model.ItensCarrinhoDAO;
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

	public PedidosLojasController(TelaPedidosLojas view,PedidosLojasDAO model,Navegador navegador) {

		this.view = view;
		this.model = model;
		this.navegador = navegador;

		view.finalizarPedido(e -> {

			try {

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

			
				ItensCarrinhoDAO itensCarrinhoDAO =
				        new ItensCarrinhoDAO();

				List<ItensCarrinho> carrinho =
				        itensCarrinhoDAO.listarItensCarrinho();

				if (carrinho.isEmpty()) {

				    JOptionPane.showMessageDialog(
				            null,
				            "Carrinho vazio!"
				    );

				    return;
				}

			
				double valorTotal = 0;

				for (ItensCarrinho item : carrinho) {
				    valorTotal += item.getPreco();
				}

				
				PedidosLojas pedido =
				        new PedidosLojas();

				pedido.setLojas_CNPJ(cnpj);

				pedido.setEntrega(
				        LocalDate.parse(
				                view.getEntrega()
				        )
				);


				pedido.setValorTotal(valorTotal);

				
				int idPedido =
				        model.adicionarPedidosLojas(
				                pedido
				        );

			
				PedidosLojasProdutosDAO itensDAO =
				        new PedidosLojasProdutosDAO();

		
				ProdutosDAO produtosDAO =
				        new ProdutosDAO();

				
				for (ItensCarrinho item : carrinho) {

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
				
				//CarrinhoDAO carrinhoDAO = new CarrinhoDAO();


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