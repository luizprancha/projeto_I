package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.CarrinhoConfeccoes;
import model.CarrinhoConfeccoesDAO;
import model.ConfeccoesDAO;
import model.ItensCarrinhoConfeccoes;
import model.MateriaPrimaDAO;
import model.PedidoConfeccao;
import model.PedidoConfeccaoDAO;
import view.TelaPedidosConfeccoes;

public class PedidosConfeccoesController {

	private final TelaPedidosConfeccoes view;
	private final PedidoConfeccaoDAO model;
	private final Navegador navegador;
	private final NotificacaoController notificacaoController;
	private final CarrinhoConfeccoes carrinhoAtual;
	private final CarrinhoConfeccoesDAO carrinhoDAO;
	private final MateriaPrimaDAO materiaPrimaDAO;
	private PedidosConfeccoesConfirmadosController confirmadosController;
	private CarrinhoConfeccoesController carrinhoController;

	private List<ItensCarrinhoConfeccoes> itensDoPedido = new ArrayList<>();
	private int quantidadeTotalPedido;

	public PedidosConfeccoesController(
			TelaPedidosConfeccoes view,
			PedidoConfeccaoDAO model,
			Navegador navegador,
			NotificacaoController notificacaoController,
			CarrinhoConfeccoes carrinhoAtual,
			CarrinhoConfeccoesDAO carrinhoDAO,
			MateriaPrimaDAO materiaPrimaDAO) {

		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.notificacaoController = notificacaoController;
		this.carrinhoAtual = carrinhoAtual;
		this.carrinhoDAO = carrinhoDAO;
		this.materiaPrimaDAO = materiaPrimaDAO;

		view.finalizarPedido(e -> finalizarPedido());
	}

	public void setConfirmadosController(PedidosConfeccoesConfirmadosController confirmadosController) {
		this.confirmadosController = confirmadosController;
	}

	public void setCarrinhoController(CarrinhoConfeccoesController carrinhoController) {
		this.carrinhoController = carrinhoController;
	}

	public void receberDadosDoCarrinho(List<ItensCarrinhoConfeccoes> itens, int quantidadeTotal) {
		this.itensDoPedido = new ArrayList<>(itens);
		this.quantidadeTotalPedido = quantidadeTotal;
		view.setQuantidade(quantidadeTotal);
	}

	private void finalizarPedido() {
		try {
			if (itensDoPedido.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Nenhum item no carrinho para finalizar!");
				return;
			}

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

			double valorTotal = view.getValorTotal();

			PedidoConfeccao pedido = new PedidoConfeccao();
			pedido.setConfeccoesCNPJ(cnpj);
			pedido.setEntrega(view.getDataEntrega());
			pedido.setValorPedido(valorTotal);
			pedido.setForma_pgm(formaPgmt);
			pedido.setQuantidade(quantidadeTotalPedido);
			pedido.setNomeConfeccao(confeccoesDAO.buscarNomePorCNPJ(cnpj));

			int idCarrinhoAntigo = carrinhoAtual.getIdCarrinho();

			int idPedido = model.adicionarPedidosConfeccoes(pedido);
			if (idPedido <= 0) {
				JOptionPane.showMessageDialog(null, "Erro ao registrar o pedido!");
				return;
			}

			for (ItensCarrinhoConfeccoes item : itensDoPedido) {
				materiaPrimaDAO.atualizarEstoque(
						item.getIdMateriaPrima(),
						item.getQuantidade());
			}

			carrinhoDAO.vincularPedidoAoCarrinho(idCarrinhoAntigo, idPedido);
			criarNovoCarrinho();

			itensDoPedido.clear();
			view.limparCampos();

			JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!");

			if (carrinhoController != null) {
				carrinhoController.recarregarItens();
			}

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

	private void criarNovoCarrinho() {

		CarrinhoConfeccoes novo = new CarrinhoConfeccoes();
		if (carrinhoAtual.getIdUsuario() > 0) {
			novo.setIdUsuario(carrinhoAtual.getIdUsuario());
		}

		int novoId = carrinhoDAO.criarCarrinho(novo);
		if (novoId > 0) {
			carrinhoAtual.setIdCarrinho(novoId);
			carrinhoAtual.setIdPedidoC(0);
		}
	}
}
