package controller;

import model.UsuarioDAO;
import view.TelaLogin;


public class LoginController {
	
	@SuppressWarnings("unused")
	private TelaLogin view;
	@SuppressWarnings("unused")
	private Navegador navegador;

	public LoginController(TelaLogin view, Navegador navegador) {
		this.view = view;
		this.navegador = navegador;

	
		view.entrar(e -> {
		    String user = view.getUsuario();
		    String senha = view.getSenha();

		    if(!user.equals("") && !senha.equals("")) {
		        UsuarioDAO usuarioDAO = new UsuarioDAO();
		        if(usuarioDAO.verificarUsuario(user, senha)) {
		            navegador.navegarPara("NOTIFICACAO");
		        } else {
		            view.exibirMensagem("Erro", "Usuário ou senha inválidos!", 0);
		        }
		    } else {
		        view.exibirMensagem("Erro", "Preencha os campos!", 0);
		    }
		});


		
		view.irParaCadastro(e -> {
			navegador.navegarPara("CADASTRO");
		});

	}
}
