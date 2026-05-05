package controller;

import model.ConfeccoesDAO;
import model.LojasDAO;
import model.ProdutosDAO;
import view.TelaConfeccoes;
import view.TelaLojas;
import view.TelaProdutos;

public class LojasController {
	
	private final TelaLojas view;
	private final LojasDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public LojasController(TelaLojas view, LojasDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		//Define o que será executado quando o botão 'Cadastrar Produto' da TelaProdutos for clicado.
		this.view.novaLoja(e -> {
			
			this.navegador.navegarPara("CADASTRO_LOJAS");
			
		});
	

	}

}


