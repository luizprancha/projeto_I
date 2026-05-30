package controller;

import java.time.LocalDate;

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
	private final ProdutosController produtoscontroller;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public CadastroProdutosController(TelaCadastroProduto view, ProdutosDAO model, Navegador navegador, ProdutosController produtoscontroller) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.produtoscontroller = produtoscontroller;

		//Define o que será executado quando o botão 'Cadastrar' da TelaCadastroProdutos for clicado.
		
		view.cadastrarProduto(e -> {
			String nomeProduto = view.getNomeProduto().trim();
			double preco = view.getPreco();
			String tamanho = view.getTamanho().trim();
			int quantidade = view.getQuantidade();
			String cor = view.getCor().trim();

			StringBuilder erros = new StringBuilder();

			if (nomeProduto.isEmpty()) {
			    erros.append("Nome é obrigatório\n");
			} else if (nomeProduto.length() < 3) {
			    erros.append("Nome muito curto\n");
			}
			
			if (preco <= 0) {
			    erros.append("Preço inválido\n");
			}

			if (tamanho.isEmpty()) {
			    erros.append("Tamanho é obrigatório\n");
			} else if (!tamanho.matches("[a-zA-ZÀ-ÿ ]+")) {
			    erros.append("Tamanho inválido\n");
			}

			if (quantidade <= 0) {
			    erros.append("Quantidade inválida\n");
			}

			if (cor.isEmpty()) {
			    erros.append("Cor é obrigatória\n");
			} else if (cor.length() < 2) {
			    erros.append("Cor inválida\n");
			}

			if (erros.length() > 0) {
			    view.exibirMensagem("Erro", erros.toString(), 0);
			} else {
			    Produtos p = new Produtos(nomeProduto, preco, tamanho, quantidade, cor, LocalDate.now());
			    model.adicionarProduto(p);
			    view.limparCampos();
			    view.exibirMensagem("Sucesso", "Produto salvo!", 1);
			    try {

			    	produtoscontroller.recriarPaineis();

				    navegador.navegarPara("PRODUTO");

				} catch (Exception ex) {

				    view.exibirMensagem(
				            "Erro",
				            "Erro ao atualizar a tela",
				            0
				    );

				    ex.printStackTrace();
				}
			}
			});

				
			

			
	

	}

}

