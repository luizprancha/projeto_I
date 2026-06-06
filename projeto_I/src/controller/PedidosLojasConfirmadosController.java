package controller;


import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import model.Confeccoes;
import model.PedidoConfeccao;
import model.PedidosLojas;
import model.PedidosLojasDAO;
import view.Painel;
import view.Painel2;
import view.Painel7;
import view.TelaDetalhePedidosLojas;
import view.TelaDetalhesConfeccoes;
import view.TelaPedidosLojasConfirmados;

public class PedidosLojasConfirmadosController {
	private final TelaPedidosLojasConfirmados view;
	private final PedidosLojasDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public PedidosLojasConfirmadosController(TelaPedidosLojasConfirmados view, PedidosLojasDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		
	

		//Define o que será executado quando o botão 'Cadastrar' da TelaCadastroProdutos for clicado.
		this.view.realizarPedido(e -> {
				
				this.navegador.navegarPara("PEDIDOS_LOJAS_VIZU");
				
			});
	}
		
	    public void criarPaineis(List<PedidosLojas> lista)  throws FontFormatException, IOException {

	        this.view.limparPaineis();

	        int linha = 0;
	        int coluna = 0;

	        for (int i = 0; i < lista.size(); i++) {

	            PedidosLojas ped = lista.get(i);

	            Painel7 p7 = new Painel7(ped);

	            if (coluna > 4) {
	                coluna = 0;
	                linha = linha + 2;
	            }

	            p7.addMouseListener(new MouseAdapter() {

	                @Override
	                public void mouseClicked(MouseEvent e) {

	                    try {

	                        TelaDetalhePedidosLojas telaDetalhePedidosLojas =
	                                new TelaDetalhePedidosLojas();

	                        new DetalhesPedidosLojasController(
	                        		telaDetalhePedidosLojas,
	                                model,
	                                navegador,
	                                ped,
	                                PedidosLojasConfirmadosController.this
	                        );

	                       PedidosLojasConfirmadosController.this.navegador.adicionarPainel(
	                                "DETALHES_CONFECCAO",
	                                telaDetalhePedidosLojas
	                        );

	                       PedidosLojasConfirmadosController.this.navegador.navegarPara(
	                                "DETALHES_CONFECCAO"
	                        );

	                    } catch (FontFormatException | IOException ex) {
	                        ex.printStackTrace();
	                    }

	                }
	            });

	            this.view.addPanel7(
	                    p7,
	                    "cell " + coluna + " " + linha + ",grow"
	            );

	            coluna = coluna + 2;

	            this.view.revalidate();
	            this.view.repaint();
	        }
	    }
	        
	        public void recriarPaineis() throws FontFormatException, IOException {

	                List<PedidosLojas > lista = model.listarPedidosLojas();

	                criarPaineis(lista);
	            }

	    }



	




