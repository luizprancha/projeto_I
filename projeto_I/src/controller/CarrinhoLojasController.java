package controller;

import model.PedidoConfeccaoDAO;
import model.PedidosLojasDAO;
import view.TelaCarrinhoLojas;
import view.TelaPedidosConfeccoesCadastrar;
import view.TelaPedidosConfeccoesConfirmados;
import view.TelaPedidosLojasAlterar;
import view.TelaPedidosLojasConfirmados;

public class CarrinhoLojasController {
	
	private final TelaCarrinhoLojas view;
	private final PedidoConfeccaoDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public CarrinhoLojasController(TelaCarrinhoLojas view, PedidoConfeccaoDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		//Define o que será executado quando o botão 'Cadastrar' da TelaCadastroProdutos for clicado.
		this.view.finalizarPedido(e -> {
				
				this.navegador.navegarPara("");
				
		});
		
		this.view.alterarPedido(e -> {
			
			this.navegador.navegarPara("");
	
		});
		
		this.view.excluir(e -> {
			
			this.navegador.navegarPara("");
			
			
		});


	}

}
