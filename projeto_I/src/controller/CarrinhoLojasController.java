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
	private final ItensCarrinhoDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;
	private final Carrinho carrinho;
	private final PedidosLojasController pedidosController;
	private ArrayList<Painel5> listaPaineis = new ArrayList<Painel5>();
	private List<ItensCarrinho> lista;
	private int itemSelecionado;

	public CarrinhoLojasController(
			TelaCarrinhoLojas view,
			ItensCarrinhoDAO model,
			Navegador navegador,
			Carrinho carrinho,
			PedidosLojasController pedidosController) {

		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.carrinho = carrinho;
		this.pedidosController = pedidosController;
		this.itemSelecionado = -1;

        recarregarItens();
        
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

                lista.remove(itemSelecionado);
                itemSelecionado = -1;
               recarregarItens();
                
            } catch (Exception ex) {

                ex.printStackTrace();

            }

        });
        
        this.view.continuarCompra(e ->{ 
      
        	navegador.navegarPara("PRODUTO");
        	
        });
        
        this.view.finalizarPedido(e ->{ 

        	List<ItensCarrinho> itens = model.listarItensPorCarrinho(carrinho.getIdCarrinho());

        	if (itens.isEmpty()) {
        		view.exibirMensagem(
        				"Erro",
        				"O carrinho está vazio!",
        				0
        		);
        		return;
        	}

        	int quantidadeTotal = 0;
        	double valorTotal = 0;

        	for (ItensCarrinho item : itens) {
        		quantidadeTotal += item.getQuantidade();
        		valorTotal += item.getPreco() * item.getQuantidade();
        	}

        	pedidosController.receberDadosDoCarrinho(itens, quantidadeTotal, valorTotal);
        	navegador.navegarPara("PEDIDOS_LOJAS_VIZU");
        });

    }

	public void recarregarItens() {
		listaPaineis.clear();
		lista = model.listarItensPorCarrinho(carrinho.getIdCarrinho());
		try {
			criarPaineis(lista);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
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
    
	
}
