package controller;

import model.PedidoConfeccaoDAO;
import model.PedidosLojasDAO;
import view.TelaPedidosConfeccoesConfirmados;
import view.TelaPedidosLojasConfirmados;

public class PedidosConfeccoesConfirmadosController {
	
	private final TelaPedidosConfeccoesConfirmados view;
	private final PedidoConfeccaoDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public PedidosConfeccoesConfirmadosController(TelaPedidosConfeccoesConfirmados view, PedidoConfeccaoDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		//Define o que será executado quando o botão 'Cadastrar' da TelaCadastroProdutos for clicado.
		this.view.realizarPedido(e -> {
				
				this.navegador.navegarPara("PEDIDOS_CONFECCOES_VIZU");
				
			});


	}

}
