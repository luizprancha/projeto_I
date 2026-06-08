package controller;

import javax.swing.JOptionPane;

import model.ConfeccoesDAO;
import model.PedidoConfeccao;
import model.PedidoConfeccaoDAO;
import view.TelaPedidosConfeccoes;

public class PedidosConfeccoesController {

	private final TelaPedidosConfeccoes view;
	private final PedidoConfeccaoDAO model;
	private final Navegador navegador;
	private final NotificacaoController notificacaoController;
	private PedidosConfeccoesConfirmadosController confirmadosController;

	public PedidosConfeccoesController(
			TelaPedidosConfeccoes view,
			PedidoConfeccaoDAO model,
			Navegador navegador,
			NotificacaoController notificacaoController) {

		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.notificacaoController = notificacaoController;

		view.finalizarPedido(e -> finalizarPedido());
	}

	public void setConfirmadosController(PedidosConfeccoesConfirmadosController confirmadosController) {
		this.confirmadosController = confirmadosController;
	}

	private void finalizarPedido() {
		try {
			String cnpj = view.getCNPJ().trim();
			if (cnpj.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Informe o CNPJ da confecção!");
				return;
			}

			ConfeccoesDAO confeccoesDAO = new ConfeccoesDAO();
			if (!confeccoesDAO.existeCNPJ(cnpj)) {
				JOptionPane.showMessageDialog(null, "CNPJ não encontrado!");
				return;
			}

			String formaPgmt = view.getFormaPgmt().trim();
			if (formaPgmt.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Selecione a forma de pagamento!");
				return;
			}

			int quantidade = view.getQtdePecas();
			double valorTotal = view.getValorTotal();

			PedidoConfeccao pedido = new PedidoConfeccao();
			pedido.setConfeccoesCNPJ(cnpj);
			pedido.setEntrega(view.getDataEntrega());
			pedido.setValorPedido(valorTotal);
			pedido.setForma_pgm(formaPgmt);
			pedido.setQuantidade(quantidade);
			pedido.setNomeConfeccao(confeccoesDAO.buscarNomePorCNPJ(cnpj));

			int idPedido = model.adicionarPedidosConfeccoes(pedido);
			if (idPedido <= 0) {
				JOptionPane.showMessageDialog(null, "Erro ao registrar o pedido!");
				return;
			}

			view.limparCampos();
			JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!");

			if (confirmadosController != null) {
				confirmadosController.recriarPaineis();
			}

			if (notificacaoController != null) {
				notificacaoController.registrarNotificacao(
				        "PEDIDO_CONFECCAO_FINALIZADO",
				        pedido.getNomeConfeccao());
			}

			navegador.navegarPara("NOTIFICACAO");

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Quantidade ou valor total inválidos!");
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao finalizar pedido! Verifique a data (dd/MM/yyyy).");
		}
	}
}
