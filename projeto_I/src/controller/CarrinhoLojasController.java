package controller;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Carrinho;

import model.ItensCarrinhoDAO;
import model.ItensCarrinho;
import model.Produtos;
import model.ProdutosDAO;

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
        
        recarregarItens();

        this.view.getTfBuscar().getDocument().addDocumentListener(
            new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    filtrar();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    filtrar();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    filtrar();
                }

                private void filtrar() {

                    String texto = view.getTfBuscar()
                            .getText()
                            .trim()
                            .toLowerCase();

                    if (texto.isEmpty()) {
                        try {
                            criarPaineis(lista);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        return;
                    }

                    List<ItensCarrinho> filtrados = new ArrayList<>();

                    for (ItensCarrinho item : lista) {

                        if (item.getNomeProduto()
                                .toLowerCase()
                                .contains(texto)) {

                            filtrados.add(item);
                        }
                    }

                    try {
                        criarPaineis(filtrados);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        );
        
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

        	String erroEstoque = validarEstoqueItens(itens);
        	if (erroEstoque != null) {
        		view.exibirMensagem(
        				"Erro",
        				"Estoque insuficiente:\n" + erroEstoque,
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

    private String validarEstoqueItens(List<ItensCarrinho> itens) {
        ProdutosDAO produtosDAO = new ProdutosDAO();
        StringBuilder erros = new StringBuilder();

        for (ItensCarrinho item : itens) {
            Produtos produto = produtosDAO.buscarPorId(item.getIdProduto());
            int disponivel = produto != null ? produto.getQuantidade() : 0;

            if (disponivel < item.getQuantidade()) {
                erros.append(item.getNomeProduto())
                        .append(": disponível ")
                        .append(disponivel)
                        .append(", solicitado ")
                        .append(item.getQuantidade())
                        .append("\n");
            }
        }

        return erros.length() > 0 ? erros.toString().trim() : null;
    }
    
	
}
