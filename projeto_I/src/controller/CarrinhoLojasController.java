package controller;

import java.awt.FontFormatException;
import java.io.IOException;
import java.util.List;
import model.Carrinho;
import model.CarrinhoDAO;
import view.Painel5;
import view.TelaCarrinhoLojas;


public class CarrinhoLojasController {
	
	private final TelaCarrinhoLojas view;
	private final  CarrinhoDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public CarrinhoLojasController(TelaCarrinhoLojas view, CarrinhoDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		


        List<Carrinho> lista = model.listarCarrinho();

        try {
            criarPaineis(lista);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

      

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
