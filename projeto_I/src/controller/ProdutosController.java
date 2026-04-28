package controller;

import model.Produtos;

import model.ProdutosDAO;
import view.TelaProdutos;


/**
 * Classe responsável pela comunicação entre a view (TelaCadastro) e o model (candidatoDAO).
 */
public class ProdutosController {
	private final TelaProdutos view;
	private final ProdutosDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public ProdutosController(TelaProdutos view, ProdutosDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		//Define o que será executado quando o botão 'Cadastrar Produto' da TelaProdutos for clicado.
		this.view.cadastrarProduto(e -> {
			
			this.navegador.navegarPara("PRODUTO");
			
		});
	

	}

}

