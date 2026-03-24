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
			String nome = view.getNome();
			String usuario = view.getUsuario();
			String cargo = view.getCargo();
			String senha = view.getSenha();

			if(!nome.equals("") &&
					!cargo.equals("") &&
					!senha.equals("") &&
			        !usuario.equals("")){
				

				Usuario u= new Usuario(usuario, senha, cargo, nome);
				
				this.model.adicionarUsuario(u);

				this.view.limparFormulario();
				this.view.exibirMensagem("Sucesso", " Usuario Salvo", 1);
			}
			else {
				this.view.exibirMensagem("Erro", "Preencha todos os campos!", 0);
			}
		});

	

	}

}

