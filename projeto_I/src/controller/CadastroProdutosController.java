package controller;

import model.Produtos;

import model.ProdutosDAO;
import model.Usuario;
import view.TelaCadastroProduto;


/**
 * Classe responsável pela comunicação entre a view (TelaCadastro) e o model (candidatoDAO).
 */
public class CadastroProdutosController {
	private final TelaCadastroProduto view;
	private final ProdutosDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public CadastroProdutosController(TelaCadastroProduto view, ProdutosDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		//Define o que será executado quando o botão 'Cadastrar' da TelaCadastroProdutos for clicado.
		view.cadastrarProduto(e -> {
			String nomeProduto = view.getNomeProduto().trim();
			String tipoProduto = view.getTipoProduto().trim();
			double preco = view.getPreco();
			String tamanho = view.getTamanho().trim();
			int quantidade = view.getQuantidade();
			String cor = view.getCor().trim();


				if (nomeProduto.isEmpty() || tipoProduto.isEmpty() ||  preco <= 0 || tamanho.isEmpty() || quantidade <=0 || cor.isEmpty() ) {
					this.view.exibirMensagem("Erro", "Preencha todos os campos!", 0);
				}
				else if (nomeProduto.length() < 3) {
					this.view.exibirMensagem("Erro", "Nome muito curto!", 0);
				}
				else if (tipoProduto.length() < 3) {
					this.view.exibirMensagem("Erro", "Este Produto não é valido", 0);
				}
				else if ( preco <= 0) {
					this.view.exibirMensagem("Erro", "Senha muito curta!", 0);
				}
				else if (!tamanho.matches("[a-zA-ZÀ-ÿ ]+")) {
					this.view.exibirMensagem("Erro", "Tamanho não é válido", 0);
				}
				else if (quantidade <=0 ) {
					this.view.exibirMensagem("Erro", "Quantidade não é válida", 0);
				}
				else if (cor.length() < 2 ) {
					this.view.exibirMensagem("Erro", "Essa cor não é válida", 0);
				}
				
				else {
					Produtos p= new Produtos(nomeProduto, tipoProduto, preco, tamanho, quantidade, cor);
					
					this.model.adicionarProduto(p);
					view.limparCampos();
					this.view.exibirMensagem("Sucesso", " Produto salvo!", 1);
				}
			});

				
			

			
	

	}

}

