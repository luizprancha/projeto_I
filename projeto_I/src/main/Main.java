package main;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import controller.CadastroController; 
import controller.LoginController;
import controller.Navegador;
import model.UsuarioDAO;
import view.JFrame;
import view.TelaCadastro;
import view.TelaLogin;

/**
 * Classe responsável por inicializar os elementos das camadas: model, view e controller.
 * A execução do programa começa por aqui.
 */
public class Main {
	public static void main(String[] args) throws Exception, IOException {
	
	
		JFrame janela = new JFrame();
		Navegador navegador = new Navegador(janela);
		UsuarioDAO usuarioDAO = new UsuarioDAO();


		TelaCadastro telaCadastro = new TelaCadastro();
		CadastroController cadastroController = new CadastroController(telaCadastro, usuarioDAO, navegador);
//		telaCadastro.cadastrar(cadastroController);
		
		TelaLogin telaLogin = new TelaLogin();
//		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador);
		
		
//		telaLogin.entrar(loginController);
//		telaLogin.irParaCadastro(loginController);
//		telaCadastro.cadastrar(cadastroController);
//		telaCadastro.irParaLogin(cadastroController);

		navegador.adicionarPainel("CADASTRO", telaCadastro);
		navegador.adicionarPainel("LOGIN", telaLogin);

		
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		navegador.navegarPara("LOGIN"); 
	}
}