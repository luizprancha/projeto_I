package controller;

import model.MateriaPrima;
import model.MateriaPrimaDAO;
import model.ProdutosDAO;
import view.TelaCadastroMateria;
import view.TelaProdutos;


/**
 * Classe responsável pela comunicação entre a view (TelaCadastro) e o model (candidatoDAO).
 */
public class CadastroMateriaController {
	private final TelaCadastroMateria view;
	private final MateriaPrimaDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public CadastroMateriaController(TelaCadastroMateria view, MateriaPrimaDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		//Define o que será executado quando o botão 'Cadastrar Produto' da TelaProdutos for clicado.
		this.view.cadastro(e -> {

			String nome = view.getNome();
			String tipo = view.getTipo();
			int quantidade = view.getQuantidade();
			String cor = view.getCor();	
			if (nome.isEmpty() || tipo.isEmpty() || quantidade<=0 || cor.isEmpty()) {
				this.view.exibirMensagem("Erro", "Preencha todos os campos corretamente!", 0);
			}
			else {
				MateriaPrima m = new MateriaPrima(nome, quantidade, cor, tipo);
			}
			
		});
	

	}

}

