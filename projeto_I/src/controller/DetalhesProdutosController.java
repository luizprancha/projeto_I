package controller;

import model.Produtos;
import model.ProdutosDAO;
import view.TelaDetalheProduto;

public class DetalhesProdutosController {

    private final TelaDetalheProduto view;
    private final ProdutosDAO model;
    private final Navegador navegador;

    private Produtos produto;

    public DetalhesProdutosController(
            TelaDetalheProduto view,
            ProdutosDAO model,
            Navegador navegador,
            Produtos produto) {

        this.view = view;
        this.model = model;
        this.navegador = navegador;
        this.produto = produto;

        carregarDados();

        configurarEventos();
    }

    private void carregarDados() {
    	
        view.setProduto(produto);

    }

    private void configurarEventos() {

        this.view.excluirProduto(e -> {

            int id = produto.getIdProduto();

            ProdutosDAO.removerProdutos(id);

            view.exibirMensagem(
                "Sucesso",
                "Produto excluído!",
                1
            );

            navegador.navegarPara("PRODUTOS");

        });

        this.view.editarProduto(e -> {

            navegador.navegarPara("CADASTRO_PRODUTO");

        });

    }
}