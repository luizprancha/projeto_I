package controller;

import java.awt.FontFormatException;
import java.io.IOException;

import model.Produtos;
import model.ProdutosDAO;
import view.TelaAlterarProdutos;
import view.TelaProdutos;

public class AlterarProdutosController {

	private final TelaAlterarProdutos view;
	private final ProdutosDAO model;
	private final Navegador navegador;
	private final Produtos produtos;
	private final TelaProdutos telaP;
	private final ProdutosController produtosController;

	public AlterarProdutosController(
			TelaAlterarProdutos view,
			ProdutosDAO model,
			Navegador navegador,
			Produtos produtos,
			TelaProdutos telaP,
			ProdutosController produtosController) throws FontFormatException, IOException {

		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.produtos = produtos;
		this.telaP = new TelaProdutos();
		this.produtosController = produtosController;

		carregarDados();

		view.alterarProduto(e -> {

			String nome = view.getNomeProduto().trim();
			double preco = Double.parseDouble(view.getPreco().trim());
			int quantidade = Integer.parseInt(view.getQuantidade().trim());
			String tamanho = view.getTamanho().trim();
			String cor = view.getCor().trim();

			StringBuilder erros = new StringBuilder();

			if (nome.isEmpty()) {
				erros.append("Nome é obrigatório\n");
			} else if (nome.length() < 3) {
				erros.append("Nome muito curto\n");
			}

			if (String.valueOf(preco).isEmpty()) {
				erros.append("Preço é obrigatório\n");
			}

			if (String.valueOf(quantidade).isEmpty()) {
				erros.append("Quantidade é obrigatória\n");
			}

			if (cor.isEmpty()) {
				erros.append("Cor é obrigatória\n");
			}

			if (erros.length() > 0) {

				view.exibirMensagem("Erro", erros.toString(), 0);

			} else {

				Produtos p = new Produtos(
						nome,
						preco,
						tamanho,
						quantidade,
						cor
				);

				p.setIdProduto(produtos.getIdProduto());

				model.atualizarProdutos(p);

				view.exibirMensagem(
						"Sucesso",
						"Produto alterado com sucesso",
						1
				);
				
				
				
				navegador.navegarPara("PRODUTO");

				try {
					produtosController.recriarPaineis();
				} catch (FontFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void carregarDados() {

		view.setProdutos(produtos);

	}
}