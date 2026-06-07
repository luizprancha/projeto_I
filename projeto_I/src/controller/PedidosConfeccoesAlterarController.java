package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import model.ConfeccoesDAO;
import model.PedidoConfeccao;
import model.PedidoConfeccaoDAO;
import view.TelaPedidosConfeccoesCadastrar;

public class PedidosConfeccoesAlterarController {

	private final TelaPedidosConfeccoesCadastrar view;
	private final PedidoConfeccaoDAO model;
	private final Navegador navegador;
	private PedidosConfeccoesConfirmadosController confirmadosController;
	private PedidoConfeccao pedidoAtual;

	public PedidosConfeccoesAlterarController(
			TelaPedidosConfeccoesCadastrar view,
			PedidoConfeccaoDAO model,
			Navegador navegador) {

		this.view = view;
		this.model = model;
		this.navegador = navegador;

		view.confirmarAlteracoes(e -> confirmarAlteracoes());
	}

	public void setConfirmadosController(PedidosConfeccoesConfirmadosController confirmadosController) {
		this.confirmadosController = confirmadosController;
	}

	public void abrirAlteracao(PedidoConfeccao pedido) {
		this.pedidoAtual = pedido;
		view.setPedido(pedido);
		navegador.navegarPara("PEDIDOS_CONFECCOES_ALTERAR");
	}

	private void confirmarAlteracoes() {
		if (pedidoAtual == null) {
			JOptionPane.showMessageDialog(null, "Nenhum pedido selecionado!");
			return;
		}

		try {
			String cnpj = view.getCNPJConfeccao().trim();
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

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate entrega = LocalDate.parse(view.getDataRetirada().trim(), formatter);
			int quantidade = Integer.parseInt(view.getQuantidadePecas().trim());
			double valor = Double.parseDouble(view.getValorTotal().trim());

			pedidoAtual.setConfeccoesCNPJ(cnpj);
			pedidoAtual.setEntrega(entrega);
			pedidoAtual.setQuantidade(quantidade);
			pedidoAtual.setValorPedido(valor);
			pedidoAtual.setForma_pgm(formaPgmt);
			pedidoAtual.setNomeConfeccao(confeccoesDAO.buscarNomePorCNPJ(cnpj));

			model.atualizarPedidoConfeccao(pedidoAtual);

			JOptionPane.showMessageDialog(null, "Pedido alterado com sucesso!");

			if (confirmadosController != null) {
				confirmadosController.recriarPaineis();
			}

			navegador.navegarPara("PEDIDOS_CONFECCOES");

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Quantidade ou valor total inválidos!");
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao alterar pedido! Verifique a data (dd/MM/yyyy).");
		}
	}
}
