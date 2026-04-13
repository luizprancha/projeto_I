package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CadastroController;
import controller.LoginController;
import controller.Navegador;
import model.UsuarioDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	protected JMenuBar menuBar;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				JFrame frame = new JFrame();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public JFrame() throws FontFormatException, IOException {
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 675);

		
		this.cardLayout = new CardLayout();

		this.contentPane = new JPanel(this.cardLayout);
		this.contentPane.setPreferredSize(new Dimension(600, 675));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);

		
		Navegador navegador = new Navegador(this);
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		
		TelaLogin telaLogin = new TelaLogin();
		adicionarTela("LOGIN", telaLogin);

		TelaCadastro telaCadastro = new TelaCadastro();
		adicionarTela("CADASTRO", telaCadastro);
		
		TelaNotificacao telaNotificacao = new TelaNotificacao();
		adicionarTela("NOTIFICACAO", telaNotificacao);

       
		new LoginController(telaLogin, navegador);
		new CadastroController(telaCadastro, usuarioDAO, navegador);

		
		mostrarTela("LOGIN");
		
		menuBar = new JMenuBar();

		JMenu mnNewMenu = new JMenu("Notificações");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Produtos");
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_2 = new JMenu("Confecções");
		menuBar.add(mnNewMenu_2);

		JMenu mnNewMenu_3 = new JMenu("Lojas");
		menuBar.add(mnNewMenu_3);

		JMenu mnNewMenu_4 = new JMenu("Pedidos");
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem = new JMenuItem("Confecções");
		mnNewMenu_4.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Lojas");
		mnNewMenu_4.add(mntmNewMenuItem_1);

		
		setJMenuBar(menuBar);
	}

	public void adicionarTela(String nome, JPanel tela) {
		this.contentPane.add(tela, nome);
	}

	public void mostrarTela(String nome) {
		this.cardLayout.show(this.contentPane, nome);
		this.pack();
	}
}