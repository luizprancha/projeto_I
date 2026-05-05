package controller;

import model.MateriaPrima;
import model.MateriaPrimaDAO;
import model.ProdutosDAO;
import view.TelaMateriaPrima;
import view.TelaProdutos;


/**
 * Classe responsável pela comunicação entre a view (TelaCadastro) e o model (candidatoDAO).
 */
public class MateriaPrimaController {
	private final TelaMateriaPrima view;
	private final MateriaPrimaDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public MateriaPrimaController(TelaMateriaPrima view, MateriaPrimaDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		//Define o que será executado quando o botão 'Cadastrar Produto' da TelaProdutos for clicado.
		this.view.novaMateria(e -> {
			
			this.navegador.navegarPara("CADASTRO_MATERIA");
			
		});
	

	}

}

