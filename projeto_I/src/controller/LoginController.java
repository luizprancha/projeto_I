package controller;

import view.TelaLogin;


public class LoginController {
	
	private TelaLogin view;
	private Navegador navegador;

	public LoginController(TelaLogin view, Navegador navegador) {
		this.view = view;
		this.navegador = navegador;

	
		view.entrar(e -> {
			String user = view.getUsuario();
			String senha = view.getSenha();

			if(!user.equals("") && !senha.equals("")) {
				navegador.navegarPara("NOTIFICACAO"); 
			} else {
				view.exibirMensagem("Erro", "Preencha os campos!", 0);
			}
		});

		
		view.irParaCadastro(e -> {
			navegador.navegarPara("CADASTRO");
		});

	}
}
