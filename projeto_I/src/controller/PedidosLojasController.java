package controller;

import java.util.ArrayList;
import java.util.List;

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
import view.TelaMensagem;
import view.TelaPedidosLojas;

public class PedidosLojasController {

private final TelaPedidosLojas view;
private final PedidosLojasDAO model;
private final Navegador navegador;
private final Carrinho carrinhoAtual;
private final CarrinhoDAO carrinhoDAO;
private final ItensCarrinhoDAO itensCarrinhoDAO;
private final NotificacaoController notificacaoController;
private CarrinhoLojasController carrinhoController;

private List<ItensCarrinho> itensDoPedido = new ArrayList<>();
private double valorTotalPedido;
private int quantidadeTotalPedido;

public PedidosLojasController(
		TelaPedidosLojas view,
		PedidosLojasDAO model,
		Navegador navegador,
		Carrinho carrinhoAtual,
		CarrinhoDAO carrinhoDAO,
		ItensCarrinhoDAO itensCarrinhoDAO,
		NotificacaoController notificacaoController) {

	this.view = view;
	this.model = model;
	this.navegador = navegador;
	this.carrinhoAtual = carrinhoAtual;
	this.carrinhoDAO = carrinhoDAO;
	this.itensCarrinhoDAO = itensCarrinhoDAO;
	this.notificacaoController = notificacaoController;

	view.finalizarPedido(e -> finalizarPedido());
}

public void setCarrinhoController(CarrinhoLojasController carrinhoController) {
	this.carrinhoController = carrinhoController;
}

public void receberDadosDoCarrinho(List<ItensCarrinho> itens, int quantidadeTotal, double valorTotal) {

	this.itensDoPedido = new ArrayList<>(itens);
	this.quantidadeTotalPedido = quantidadeTotal;
	this.valorTotalPedido = valorTotal;
	view.setQuantidade(quantidadeTotal);
	view.setValorTotal(valorTotal);
}

private void finalizarPedido() {

	try {

		if (itensDoPedido.isEmpty()) {
			TelaMensagem.mostrar("Aviso", "Nenhum item no carrinho para finalizar!");
			return;
		}

		String cnpj = view.getCNPJLoja();
		LojasDAO lojasDAO = new LojasDAO();

		if (!lojasDAO.existeCNPJ(cnpj)) {
			TelaMensagem.mostrar("Erro", "CNPJ não encontrado!");
			return;
		}

		PedidosLojas pedido = new PedidosLojas();
		pedido.setLojas_CNPJ(cnpj);
		pedido.setEntrega(view.getEntrega());
		pedido.setEndereco(lojasDAO.buscarEnderecoPorCNPJ(cnpj));
		pedido.setValorTotal(valorTotalPedido);

		int idCarrinhoAntigo = carrinhoAtual.getIdCarrinho();

		int idPedido = model.adicionarPedidosLojas(pedido);

		if (idPedido <= 0) {
			TelaMensagem.mostrar("Erro", "Erro ao registrar o pedido!");
			return;
		}

		PedidosLojasProdutosDAO itensDAO = new PedidosLojasProdutosDAO();
		ProdutosDAO produtosDAO = new ProdutosDAO();

		for (ItensCarrinho item : itensDoPedido) {

			PedidosLojasProdutos itemPedido = new PedidosLojasProdutos();
			itemPedido.setIdPedido(idPedido);
			itemPedido.setIdProduto(item.getIdProduto());
			itemPedido.setQuantidade(item.getQuantidade());
			itemPedido.setPreco(item.getPreco());

			itensDAO.salvar(itemPedido);

			produtosDAO.atualizarEstoque(item.getIdProduto(), item.getQuantidade());
		}

		carrinhoDAO.vincularPedidoAoCarrinho(idCarrinhoAntigo, idPedido);
		criarNovoCarrinho();

		itensDoPedido.clear();
		view.limparCampos();

		TelaMensagem.mostrar("Sucesso", "Pedido realizado com sucesso!");

		if (carrinhoController != null) {
			carrinhoController.recarregarItens();
		}

		if (notificacaoController != null) {
			String nomeLoja = lojasDAO.buscarNomePorCNPJ(cnpj);

			notificacaoController.registrarNotificacao(
					"PEDIDO_LOJA_FINALIZADO",
					nomeLoja);
		}

		navegador.navegarPara("NOTIFICACAO");

	} catch (Exception ex) {

		ex.printStackTrace();
		TelaMensagem.mostrar("Erro", "Erro ao finalizar pedido!");
	}
}

private void criarNovoCarrinho() {

	Carrinho novo = new Carrinho();
	if (carrinhoAtual.getIdUsuario() > 0) {
		novo.setIdUsuario(carrinhoAtual.getIdUsuario());
	}

	int novoId = carrinhoDAO.criarCarrinho(novo);
	if (novoId > 0) {
		carrinhoAtual.setIdCarrinho(novoId);
		carrinhoAtual.setIdPedidosL(0);
	}
}


}
