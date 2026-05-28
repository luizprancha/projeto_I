package controller;

import java.awt.FontFormatException;
import java.sql.SQLException;
import java.io.IOException;
import model.Carrinho;
import model.CarrinhoDAO;
import model.ItensCarrinho;
import model.ItensCarrinhoDAO;
import model.Produtos;
import model.ProdutosDAO;
import view.TelaAlterarProdutos;
import view.TelaCarrinhoLojas;
import view.TelaDetalheProduto;
import view.TelaProdutos;

public class DetalhesProdutosController {

    private final TelaDetalheProduto view;
    private final ProdutosDAO model;
    private final Navegador navegador;
    private final ProdutosController produtosController;

    private Produtos produto;
    private Carrinho carrinho;

    public DetalhesProdutosController(
            TelaDetalheProduto view,
            ProdutosDAO model,
            Navegador navegador,
            Produtos produto,
            ProdutosController produtosController,
            Carrinho carrinho) {

        this.view = view;
        this.model = model;
        this.navegador = navegador;
        this.produto = produto;
		this.produtosController = produtosController;
        this.carrinho = carrinho;

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

            	model.removerProdutos(id);

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

            int id = produto.getIdProduto();
            Produtos produto = model.buscarPorId(id);

            try {

                TelaAlterarProdutos telaAlterar = new TelaAlterarProdutos();

        		telaAlterar.setProdutos(produto);

        		navegador.adicionarPainel("ALTERAR_PRODUTOS", telaAlterar);

                navegador.navegarPara("ALTERAR_PRODUTOS");

            } catch (FontFormatException erro) {

                erro.printStackTrace();

            } catch (IOException erro) {

                erro.printStackTrace();

            }

        });

        this.view.adicionarProduto(e -> {

            try {

             
                ItensCarrinho item = new ItensCarrinho();

                item.setIdCarrinho(carrinho.getIdCarrinho());
                item.setIdProduto(produto.getIdProduto());
                item.setNomeProduto(produto.getNome());
                item.setPreco(produto.getPreco());
                item.setQuantidade(1);

               
                ItensCarrinhoDAO itensDAO = new ItensCarrinhoDAO();

                itensDAO.adicionarItensCarrinho(item);

                view.exibirMensagem(
                    "Sucesso",
                    "Produto adicionado ao carrinho!",
                    1
                );

                TelaCarrinhoLojas telaCarrinho =
                    new TelaCarrinhoLojas();

                CarrinhoDAO carrinhoDAO = new CarrinhoDAO();

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

                navegador.navegarPara("CARRINHO");

            } catch (SQLException ex) {

                view.exibirMensagem(
                    "Erro",
                    "Produto já existe no carrinho!",
                    0
                );

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        });

    }
}