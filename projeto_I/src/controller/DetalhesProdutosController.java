package controller;

import model.Carrinho;
import model.CarrinhoDAO;
import model.Produtos;
import model.ProdutosDAO;
import view.TelaCarrinhoLojas;
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
        
        this.view.adicionarProduto(e -> {
        	
        	 Carrinho carrinho = new Carrinho();

        	    carrinho.setIdProduto(produto.getIdProduto());

        	    carrinho.setNomeProduto(produto.getNome());

        	    carrinho.setPreco(produto.getPreco());

        	    carrinho.setQuantidade(1);

        	    CarrinhoDAO carrinhoDAO = new CarrinhoDAO();

        	    carrinhoDAO.adicionarCarrinho(carrinho);
        	    
        	    try {

        	        TelaCarrinhoLojas telaCarrinho = new TelaCarrinhoLojas();

        	        CarrinhoLojasController controller =
        	            new CarrinhoLojasController(
        	                telaCarrinho,
        	                carrinhoDAO,
        	                navegador,
        	                carrinho
        	            
        	            );

        	        controller.recriarPaineis();

        	        navegador.adicionarPainel(
        	            "CARRINHO",
        	            telaCarrinho
        	        );

        	    } catch (Exception ex) {

        	        ex.printStackTrace();

        	    }

        	   

        	  navegador.navegarPara("CARRINHO");
        	
        });

    }
}