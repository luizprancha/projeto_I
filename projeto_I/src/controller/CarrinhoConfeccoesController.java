package controller;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.CarrinhoConfeccoes;
import model.ItensCarrinhoConfeccoes;
import model.ItensCarrinhoConfeccoesDAO;
import view.PainelCarrinhoMateria;
import view.TelaCarrinhoConfeccoes;

public class CarrinhoConfeccoesController {

	private final TelaCarrinhoConfeccoes view;
	private final ItensCarrinhoConfeccoesDAO model;
	private final Navegador navegador;
	private final CarrinhoConfeccoes carrinho;
	private final PedidosConfeccoesController pedidosController;
	private ArrayList<PainelCarrinhoMateria> listaPaineis = new ArrayList<>();
	private List<ItensCarrinhoConfeccoes> lista;
	private int itemSelecionado;

	public CarrinhoConfeccoesController(
			TelaCarrinhoConfeccoes view,
			ItensCarrinhoConfeccoesDAO model,
			Navegador navegador,
			CarrinhoConfeccoes carrinho,
			PedidosConfeccoesController pedidosController) {

		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.carrinho = carrinho;
		this.pedidosController = pedidosController;
		this.itemSelecionado = -1;

		recarregarItens();

		this.view.getTfBuscar().getDocument().addDocumentListener(
				new DocumentListener() {

					@Override
					public void insertUpdate(DocumentEvent e) {
						filtrar();
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						filtrar();
					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						filtrar();
					}

					private void filtrar() {

						String texto = view.getTfBuscar()
								.getText()
								.trim()
								.toLowerCase();

						if (texto.isEmpty()) {
							try {
								criarPaineis(lista);
							} catch (Exception ex) {
								ex.printStackTrace();
							}
							return;
						}

						List<ItensCarrinhoConfeccoes> filtrados = new ArrayList<>();

						for (ItensCarrinhoConfeccoes item : lista) {
							if (item.getNomeMateria()
									.toLowerCase()
									.contains(texto)) {
								filtrados.add(item);
							}
						}

						try {
							criarPaineis(filtrados);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});

		this.view.excluir(e -> {

			try {
				if (itemSelecionado == -1) {
					view.exibirMensagem(
							"Erro",
							"Selecione uma matéria-prima para excluir",
							0);
					return;
				}

				ItensCarrinhoConfeccoes item = lista.get(itemSelecionado);
				int id = item.getIdItem();

				ItensCarrinhoConfeccoesDAO.removerItem(id);

				view.exibirMensagem(
						"Sucesso",
						"Matéria-prima excluída!",
						1);

				lista.remove(itemSelecionado);
				itemSelecionado = -1;
				recarregarItens();

			} catch (Exception ex) {

				ex.printStackTrace();

			}

		});

		this.view.continuarCompra(e -> {
			navegador.navegarPara("MATERIA_PRIMA");
		});

		this.view.finalizarPedido(e -> {

			List<ItensCarrinhoConfeccoes> itens =
					model.listarItensPorCarrinho(carrinho.getIdCarrinho());

			if (itens.isEmpty()) {
				view.exibirMensagem(
						"Erro",
						"O carrinho está vazio!",
						0);
				return;
			}

			int quantidadeTotal = 0;

			for (ItensCarrinhoConfeccoes item : itens) {
				quantidadeTotal += item.getQuantidade();
			}

			pedidosController.receberDadosDoCarrinho(itens, quantidadeTotal);
			navegador.navegarPara("PEDIDOS_CONFECCOES_VIZU");
		});
	}

	public void recarregarItens() {
		listaPaineis.clear();
		lista = model.listarItensPorCarrinho(carrinho.getIdCarrinho());
		try {
			criarPaineis(lista);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public void criarPaineis(List<ItensCarrinhoConfeccoes> lista)
			throws FontFormatException, IOException {

		this.view.limparPaineis();

		int linha = 0;
		int coluna = 0;

		for (int i = 0; i < lista.size(); i++) {

			ItensCarrinhoConfeccoes item = lista.get(i);

			PainelCarrinhoMateria painel = new PainelCarrinhoMateria(i, item);
			listaPaineis.add(painel);
			painel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

			painel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for (int j = 0; j < listaPaineis.size(); j++) {
						if (listaPaineis.get(j).selected == 1) {
							listaPaineis.get(j).setBorder(
									BorderFactory.createEmptyBorder(1, 1, 1, 1));
						}
					}
					painel.selected = 1;
					painel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					itemSelecionado = painel.i;
				}
			});

			if (coluna > 4) {
				coluna = 0;
				linha = linha + 2;
			}

			this.view.addPanel(painel, "cell " + coluna + " " + linha + ",grow");

			coluna = coluna + 2;
		}

		this.view.revalidate();
		this.view.repaint();
	}
}
