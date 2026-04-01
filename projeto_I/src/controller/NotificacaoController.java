package controller;

import model.UsuarioDAO;
import view.TelaNotificacao;

public class NotificacaoController {
	
	private TelaNotificacao view;
	private UsuarioDAO model;
	private Navegador navegador;

	public NotificacaoController(TelaNotificacao view, UsuarioDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		view.mnProdutos(e -> {
			
			// String usuario= view.getUsuario();
				 
			// ação aqui
		});
	}
}


