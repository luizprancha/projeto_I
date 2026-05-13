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
import view.Painel2;
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
	


}

