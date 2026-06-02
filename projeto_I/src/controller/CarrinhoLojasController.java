package controller;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import model.Carrinho;

import model.ItensCarrinhoDAO;
import model.ItensCarrinho;

import view.Painel5;
import view.TelaCarrinhoLojas;

public class CarrinhoLojasController {
	
	private final TelaCarrinhoLojas view;
	//private final  CarrinhoDAO model;
	private final ItensCarrinhoDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;
	private final Carrinho carrinho;
	private ArrayList<Painel5> listaPaineis = new ArrayList<Painel5>();
	private List<ItensCarrinho> lista;
	private int itemSelecionado;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public CarrinhoLojasController(TelaCarrinhoLojas view, ItensCarrinhoDAO model, Navegador navegador,  Carrinho carrinho) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.carrinho =carrinho;
		this.itemSelecionado = -1;
		
		


        lista = model.listarItensCarrinho();

        try {
            criarPaineis(lista);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        
        this.view.excluir(e -> {

            try {
            	  if (itemSelecionado == -1) {
                      view.exibirMensagem(
                          "Erro",
                          "Selecione um produto para excluir",
                          0
                      );
                      return;
                  }

            	ItensCarrinho item = lista.get(itemSelecionado);
            	int id = item.getIdItem();

            	ItensCarrinhoDAO.removerItensCarrinho(id);

                view.exibirMensagem(
                    "Sucesso",
                    "Produto excluído!",
                    1
                );

                TelaCarrinhoLojas telaCarrinhoLojas = new TelaCarrinhoLojas();
                lista.remove(itemSelecionado);
                itemSelecionado=-1;
               recriarPaineis();

               // navegador.adicionarPainel("PRODUTO", view);

              //  navegador.navegarPara("PRODUTO");

                
            } catch (Exception ex) {

                ex.printStackTrace();

            }

        });
        
        this.view.continuarCompra(e ->{ 
      
        	navegador.navegarPara("PRODUTO");
        	
        });
        
       
        

    
        
        this.view.finalizarPedido(e ->{ 
        	
        	navegador.navegarPara("PEDIDOS_LOJAS_VIZU");
        });

      

    }

    public void criarPaineis(List<ItensCarrinho> lista)
            throws FontFormatException, IOException {

        this.view.limparPaineis();

        int linha = 0;
        int coluna = 0;

        for (int i = 0; i < lista.size(); i++) {

            ItensCarrinho car= lista.get(i); 
          
            Painel5 p5 = new Painel5(i, car);
            listaPaineis.add(p5);
            p5.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
            
            p5.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	for (int j = 0; j < listaPaineis.size(); j++) {
                		if(listaPaineis.get(j).selected == 1) {
                			listaPaineis.get(j).setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
                		}
                	}
                	p5.selected = 1;
                	p5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                	itemSelecionado =p5.i;

                }
            });


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
    		List<ItensCarrinho> lista = model.listarItensCarrinho();
    		criarPaineis(lista);
    	}
    
	
}
