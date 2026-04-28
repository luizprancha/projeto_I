package view;

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
import controller.CadastroProdutosController;
import controller.LoginController;
import controller.Navegador;
import controller.ProdutosController;
import model.ProdutosDAO;
import model.UsuarioDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	protected JMenuBar menuBar;
	
	public JMenuItem itemNotificacao;

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
		ProdutosDAO produtosDAO = new ProdutosDAO();

		
		TelaLogin telaLogin = new TelaLogin();
		adicionarTela("LOGIN", telaLogin);

		TelaCadastro telaCadastro = new TelaCadastro();
		adicionarTela("CADASTRO", telaCadastro);
		
		TelaNotificacao telaNotificacao = new TelaNotificacao();
		adicionarTela("NOTIFICACAO", telaNotificacao);
		
		TelaProdutos telaProduto = new TelaProdutos();
		adicionarTela("PRODUTO", telaProduto);
		
		
		TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto ();
		adicionarTela("CADASTRO_PRODUTO", telaCadastroProduto);
		
		TelaConfeccoes telaConfeccoes = new TelaConfeccoes();
		adicionarTela("CONFECCAO", telaConfeccoes);
		
		TelaLojas telaLojas = new TelaLojas();
		adicionarTela("LOJAS", telaLojas);
		
		
		TelaPedidosLojasConfirmados telaPedidosLojas = new TelaPedidosLojasConfirmados();
		adicionarTela("PEDIDOS_LOJAS", telaPedidosLojas);

		TelaPedidosConfeccoesConfirmados telaPedidosConfeccoes = new TelaPedidosConfeccoesConfirmados();
		adicionarTela("PEDIDOS_CONFECCOES", telaPedidosConfeccoes);	

       
		new LoginController(telaLogin, navegador);
		new CadastroController(telaCadastro, usuarioDAO, navegador);
		new ProdutosController(telaProduto, produtosDAO, navegador);
		new CadastroProdutosController(telaCadastroProduto, produtosDAO, navegador);

		
		mostrarTela("LOGIN");
		
		menuBar = new JMenuBar();

		JMenu itemNotificacao = new JMenu("Notificações");
		menuBar.add(itemNotificacao);
		
		JMenuItem ItemNotificacao = new JMenuItem("Notificação");
		ItemNotificacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegador.navegarPara("NOTIFICACAO");
			}
		});
		itemNotificacao.add(ItemNotificacao);

		JMenu mnNewMenu_1 = new JMenu("Produtos");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem itemProdutos = new JMenuItem("Produtos");
		itemProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegador.navegarPara("PRODUTO");
			}
		});
		mnNewMenu_1.add(itemProdutos);

		JMenu itemConfeccoes = new JMenu("Confecções");
		menuBar.add(itemConfeccoes);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Confecções");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegador.navegarPara("CONFECCAO");
				
			}
		});
		itemConfeccoes.add(mntmNewMenuItem_3);

		JMenu itemLojas = new JMenu("Lojas");
		menuBar.add(itemLojas);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Lojas");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegador.navegarPara("PEDIDOS_LOJAS");
			}
		});
		itemLojas.add(mntmNewMenuItem_4);

		JMenu itemPedidos = new JMenu("Pedidos");
		menuBar.add(itemPedidos);

		JMenuItem itemLojasPedidos = new JMenuItem("Lojas");
		itemLojasPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegador.navegarPara("PEDIDOS_LOJAS");
			}
		});
		itemPedidos.add(itemLojasPedidos);
		
		JMenuItem itemConfeccao = new JMenuItem("Confeccoes");
		itemConfeccao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegador.navegarPara("PEDIDOS_CONFECCOES");
			}
		});
		itemPedidos.add(itemConfeccao);
		
		JMenu itemDeslogar = new JMenu("Deslogar");
		menuBar.add(itemDeslogar);
		
		JMenuItem ItemDeslogar = new JMenuItem("Deslogar");
		ItemDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaLogin.limparCampos(); 
				navegador.navegarPara("LOGIN");
			}
		});
		itemDeslogar.add(ItemDeslogar);

		
		//setJMenuBar(menuBar);
	}

	public void adicionarTela(String nome, JPanel tela) {
		this.contentPane.add(tela, nome);
	}

	public void mostrarTela(String nome) {
		this.cardLayout.show(this.contentPane, nome);
		this.pack();
	}

	public void mostrarMenu() {
		// TODO Auto-generated method stub
		setJMenuBar(menuBar);
		validate();
		repaint();
		this.pack();
		

		
	}
}