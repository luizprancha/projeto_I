package controller;

import java.awt.FontFormatException;
import java.io.IOException;

import model.Confeccoes;
import model.ConfeccoesDAO;
import model.PedidosLojas;
import model.PedidosLojasDAO;
import view.TelaAlterarLoja;
import view.TelaDetalhePedidosLojas;
import view.TelaDetalhesConfeccoes;
import view.TelaPedidosLojasAlterar;

public class DetalhesPedidosLojasController {
	
	  private final TelaDetalhePedidosLojas view;
	   private final PedidosLojasDAO model;
	    private final Navegador navegador;
	    private final PedidosLojasConfirmadosController pedidoslojasconfirmadosController;
	    private PedidosLojas pedidosLojas;

	    public DetalhesPedidosLojasController(TelaDetalhePedidosLojas view,PedidosLojasDAO model,Navegador navegador, PedidosLojas pedidosLojas,PedidosLojasConfirmadosController pedidoslojasconfirmadosController) {

	        this.view = view;
	        this.model = model;
	        this.navegador = navegador;
	        this.pedidosLojas = pedidosLojas;
	        this.pedidoslojasconfirmadosController = pedidoslojasconfirmadosController;

	        carregarDados();

	        configurarEventos();
	    }
	    
	    private void carregarDados() {
	    	
	        view.setPedidosLojas(pedidosLojas);

	    }

	    private void configurarEventos() {

	        this.view.excluirPedidoLojas(e -> {

	            int id = pedidosLojas.getIdPedidoL();

	            PedidosLojasDAO.removerPedidosLojas(id);

	            view.exibirMensagem(
	                "Sucesso",
	                "Pedido excluído!",
	                1
	            );

	            navegador.navegarPara("PEDIDOS_LOJAS");
	            try {
	            	pedidoslojasconfirmadosController.recriarPaineis();
				} catch (FontFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

	        });


	        this.view. editarPedidoLoja(e -> { //parei aqui 

	        	try {

	        	    TelaPedidosLojasAlterar telapedidos = new TelaPedidosLojasAlterar();

	        	    new PedidosLojasAlterarController(
	        	            telapedidos,
	        	            model,
	        	            navegador,
	        	            pedidosLojas,
	        	            pedidoslojasconfirmadosController
	        	    );

	        	    navegador.adicionarPainel("ALTERAR_PEDIDO_LOJA", telapedidos);
	        	    navegador.navegarPara("ALTERAR_PEDIDO_LOJA");

	        	} catch (Exception ex) {
	        	    ex.printStackTrace();
	        	}

	        });

	    }
	}
