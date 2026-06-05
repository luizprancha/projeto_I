package controller;

import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import model.ConfeccoesDAO;
import model.PedidoConfeccao;
import model.PedidoConfeccaoDAO;
import view.Painel8;
import view.TelaPedidosConfeccoesConfirmados;

public class PedidosConfeccoesConfirmadosController {

	private final TelaPedidosConfeccoesConfirmados view;
	private final PedidoConfeccaoDAO model;
	private final Navegador navegador;
	private final ConfeccoesDAO confeccoesDAO;
	private PedidosConfeccoesAlterarController alterarController;

	public PedidosConfeccoesConfirmadosController(
			TelaPedidosConfeccoesConfirmados view,
			PedidoConfeccaoDAO model,
			Navegador navegador,
			ConfeccoesDAO confeccoesDAO) {

		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.confeccoesDAO = confeccoesDAO;

		this.view.realizarPedido(e -> navegador.navegarPara("PEDIDOS_CONFECCOES_VIZU"));

		try {
			criarPaineis(model.listarPedidosConfeccoes());
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public void setAlterarController(PedidosConfeccoesAlterarController alterarController) {
		this.alterarController = alterarController;
	}

	public void criarPaineis(List<PedidoConfeccao> lista) throws FontFormatException, IOException {
		view.limparPaineis();

		int linha = 0;
		int coluna = 0;

		for (PedidoConfeccao pedido : lista) {
			if (pedido.getNomeConfeccao() == null || pedido.getNomeConfeccao().isEmpty()) {
				pedido.setNomeConfeccao(confeccoesDAO.buscarNomePorCNPJ(pedido.getConfeccoesCNPJ()));
			}

			Painel8 p = new Painel8(pedido);

			if (coluna > 4) {
				coluna = 0;
				linha = linha + 2;
			}

			p.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (alterarController != null) {
						alterarController.abrirAlteracao(pedido);
					}
				}
			});

			view.addPanel(p, "cell " + coluna + " " + linha + ",grow");
			coluna = coluna + 2;
		}

		view.revalidatePanel();
	}

	public void recriarPaineis() {
		try {
			criarPaineis(model.listarPedidosConfeccoes());
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
