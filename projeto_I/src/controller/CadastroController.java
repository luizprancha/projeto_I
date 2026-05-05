package controller;

import model.Usuario;

import model.UsuarioDAO;
import view.TelaCadastro;


/**
 * Classe responsável pela comunicação entre a view (TelaCadastro) e o model (candidatoDAO).
 */
public class CadastroController {
	private final TelaCadastro view;
	private final UsuarioDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastro).
	 * @param model Referência ao modelo de dados (CandidatoDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public CadastroController(TelaCadastro view, UsuarioDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		//Define o que será executado quando o botão 'Cadastrar' da TelaCadastro for clicado.
		this.view.cadastrar(e -> {
			String nome = view.getNome().trim();
			String usuario = view.getUsuario().trim();
			String cargo = view.getCargo().trim();
			String senha = view.getSenha().trim();

			if (nome.isEmpty() || usuario.isEmpty() || cargo.isEmpty() || senha.isEmpty()) {
				this.view.exibirMensagem("Erro", "Preencha todos os campos!", 0);
			}
			else if (nome.length() < 3) {
				this.view.exibirMensagem("Erro", "Nome muito curto!", 0);
			}
			else if (usuario.length() < 3) {
				this.view.exibirMensagem("Erro", "Usuário muito curto!", 0);
			}
			else if (senha.length() < 4) {
				this.view.exibirMensagem("Erro", "Senha muito curta!", 0);
			}
			else if (!nome.matches("[a-zA-ZÀ-ÿ ]+")) {
				this.view.exibirMensagem("Erro", "Nome inválido!", 0);
			}
			else {
				Usuario u = new Usuario(usuario, senha, cargo, nome);
				this.model.adicionarUsuario(u);
				this.view.limparFormulario();
				this.view.exibirMensagem("Sucesso", "Usuario salvo!", 1);
			}
		});

		view.irParaLogin(e -> {
			navegador.navegarPara("LOGIN");
		});
	}
}