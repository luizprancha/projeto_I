package controller;

import model.UsuarioDAO;
import view.TelaLogin;

public class LoginController {
	
	@SuppressWarnings("unused")
	private TelaLogin view;
	@SuppressWarnings("unused")
	private Navegador navegador;
	private final NotificacaoController notificacaoController;

	public LoginController(TelaLogin view, Navegador navegador, NotificacaoController notificacaoController) {
		this.view = view;
		this.navegador = navegador;
		this.notificacaoController = notificacaoController;

	
		view.entrar(e -> {
		    String user = view.getUsuario();
		    String senha = view.getSenha();

		    if(!user.equals("") && !senha.equals("")) {
		        UsuarioDAO usuarioDAO = new UsuarioDAO();
		        if(usuarioDAO.verificarUsuario(user, senha)) {
		            if (notificacaoController != null) {
		                notificacaoController.recriarPaineis();
		            }
		            navegador.navegarPara("NOTIFICACAO");
		            navegador.mostrarMenu();
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
