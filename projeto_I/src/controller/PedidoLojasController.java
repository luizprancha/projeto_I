package controller;

import model.PedidosLojasDAO;
import view.TelaPedidosLojas;

public class PedidoLojasController {
	
	private final TelaPedidosLojas view;
	private final PedidosLojasDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public PedidoLojasController(TelaPedidosLojas view, PedidosLojasDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		//Define o que será executado quando o botão 'Cadastrar' da TelaCadastroProdutos for clicado.
		this.view.finalizarPedido(e -> {
				
				this.navegador.navegarPara("PEDIDOS_LOJAS_VIZU");
				
			});

	}
}
