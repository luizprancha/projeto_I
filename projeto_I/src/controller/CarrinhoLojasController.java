package controller;

import java.awt.FontFormatException;
import java.io.IOException;
import java.util.List;
import model.Carrinho;
import model.CarrinhoDAO;
import model.ProdutosDAO;
import view.Painel5;
import view.TelaCarrinhoLojas;
import view.TelaProdutos;


public class CarrinhoLojasController {
	
	private final TelaCarrinhoLojas view;
	private final  CarrinhoDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;
	
	private final Carrinho carrinho;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public CarrinhoLojasController(TelaCarrinhoLojas view, CarrinhoDAO model, Navegador navegador, Carrinho carrinho) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.carrinho = carrinho;
		


        List<Carrinho> lista = model.listarCarrinho();

        try {
            criarPaineis(lista);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        
        this.view.excluir(e -> {

            try {

                int id = carrinho.getIdCarrinho();

                ProdutosDAO.removerProdutos(id);

                view.exibirMensagem(
                    "Sucesso",
                    "Produto excluído!",
                    1
                );

                TelaCarrinhoLojas telaCarrinhoLojas = new TelaCarrinhoLojas();

                CarrinhoLojasController controller = new CarrinhoLojasController(
                    telaCarrinhoLojas,
                    model,
                    navegador, 
                    carrinho
                );

                controller.recriarPaineis();

                navegador.adicionarPainel("PRODUTO", view);

                navegador.navegarPara("PRODUTO");

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        });

      

      

    }

    public void criarPaineis(List<Carrinho> lista)
            throws FontFormatException, IOException {

        this.view.limparPaineis();

        int linha = 0;
        int coluna = 0;

        for (int i = 0; i < lista.size(); i++) {

            Carrinho car= lista.get(i);

            Painel5 p5 = new Painel5(car);

            if (coluna > 4) {
                coluna = 0;
                linha = linha + 2;
            }

        

            this.view.addPanel5(
                    p5,
                    "cell " + coluna + " " + linha + ",grow"
            );

            coluna = coluna + 2;
        }

        this.view.revalidate();
        this.view.repaint();
    }

    public void recriarPaineis() throws FontFormatException, IOException {
    		List<Carrinho> lista = model.listarCarrinho();
    		criarPaineis(lista);
    	}
    
	
}
