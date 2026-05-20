package controller;

import model.Produtos;
import model.ProdutosDAO;
import view.TelaDetalheProduto;
import view.TelaProdutos;

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

            try {

                int id = produto.getIdProduto();

                ProdutosDAO.removerProdutos(id);

                view.exibirMensagem(
                    "Sucesso",
                    "Produto excluído!",
                    1
                );

                TelaProdutos telaProdutos = new TelaProdutos();

                ProdutosController controller = new ProdutosController(
                    telaProdutos,
                    model,
                    navegador
                );

                controller.recriarPaineis();

                navegador.adicionarPainel("PRODUTO", telaProdutos);

                navegador.navegarPara("PRODUTO");

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        });

        this.view.editarProduto(e -> {

            navegador.navegarPara("CADASTRO_PRODUTO");

        });

    }
}