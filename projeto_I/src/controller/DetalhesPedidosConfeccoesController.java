package controller;

import model.PedidoConfeccao;
import model.PedidoConfeccaoDAO;
import view.TelaDetalhePedidosConfeccoes;

public class DetalhesPedidosConfeccoesController {

	private final TelaDetalhePedidosConfeccoes view;
	private final PedidoConfeccaoDAO model;
	private final Navegador navegador;
	private final PedidoConfeccao pedido;
	private final PedidosConfeccoesConfirmadosController confirmadosController;
	private final PedidosConfeccoesAlterarController alterarController;

	public DetalhesPedidosConfeccoesController(
			TelaDetalhePedidosConfeccoes view,
			PedidoConfeccaoDAO model,
			Navegador navegador,
			PedidoConfeccao pedido,
			PedidosConfeccoesConfirmadosController confirmadosController,
			PedidosConfeccoesAlterarController alterarController) {

		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.pedido = pedido;
		this.confirmadosController = confirmadosController;
		this.alterarController = alterarController;

		carregarDados();
		configurarEventos();
	}

	private void carregarDados() {
		view.setPedidoConfeccao(pedido);
	}

	private void configurarEventos() {
		view.excluirPedidoConfeccao(e -> {
			model.removerPedidoConfeccao(pedido.getIdPedidoC());

			view.exibirMensagem(
					"Sucesso",
					"Pedido excluído!",
					1);

			if (confirmadosController != null) {
				confirmadosController.recriarPaineis();
			}

			navegador.navegarPara("PEDIDOS_CONFECCOES");
		});

		view.editarPedidoConfeccao(e -> {
			if (alterarController != null) {
				alterarController.abrirAlteracao(pedido);
			}
		});
	}
}
