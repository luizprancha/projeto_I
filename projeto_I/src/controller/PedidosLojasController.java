package controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import model.PedidosLojas;
import model.PedidosLojasDAO;
import view.TelaPedidosLojas;

public class PedidosLojasController {

	private final TelaPedidosLojas view;
	private final PedidosLojasDAO model;
	private final Navegador navegador;
	
	public PedidosLojasController(TelaPedidosLojas view, PedidosLojasDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		
		view.finalizarPedido(e ->{

			
			
			});
	}
	
	

}
