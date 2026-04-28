package controller;

import model.Produtos;

import model.ProdutosDAO;
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
		this.view.cadastrarProduto(e -> {
			String nomeProduto = view.getNomeProduto();
			String tipoProduto = view.getTipoProduto();
			double preco = view.getPreco();
			String tamanho = view.getTamanho();
			int quantidade = view.getQuantidade();
			String cor = view.getCor();

			if(!nomeProduto.equals("") &&
					!tipoProduto.equals("") &&
					preco>0 &&
			        !tamanho.equals("") &&
					quantidade>0 &&
					!cor.equals("")) {
				

				Produtos p= new Produtos(nomeProduto, tipoProduto, preco, tamanho, quantidade, cor);

				this.model.adicionarProduto(p);

				this.view.limparCampos();
				this.view.exibirMensagem("Sucesso", " Produto salvo!", 1);
			}
			
			else {
				this.view.exibirMensagem("Erro", "Preencha todos os campos!", 0);
			}
			
		});
	

	}

}

