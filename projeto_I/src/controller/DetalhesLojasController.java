package controller;

import model.ConfeccoesDAO;
import model.Lojas;
import model.LojasDAO;
import model.ProdutosDAO;
import view.TelaConfeccoes;
import view.TelaDetalhesLojas;
import view.TelaProdutos;

public class DetalhesLojasController {
	
	private final TelaDetalhesLojas view;
	private final LojasDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;
	
	Lojas loja = new Lojas();

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public DetalhesLojasController(TelaDetalhesLojas view, LojasDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		//Define o que será executado quando o botão 'Cadastrar Produto' da TelaProdutos for clicado.
		view.setId(loja.getIdLoja());
		this.view.excluir(e -> {
		    int id = view.getId();

		    model.removerLojas(id);

		    view.exibirMensagem("Sucesso", "Loja excluída!", 1);
		    navegador.navegarPara("LOJAS");
		});
		
		this.view.editar(e -> {
			
			this.navegador.navegarPara("CADASTRO_CONFECCAO");
			
		});
	
	

	}

}


