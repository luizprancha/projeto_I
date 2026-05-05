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

import controller.CadastroConfeccaoController;
import controller.CadastroController;
import controller.CadastroLojaController;
import controller.CadastroMateriaController;
import controller.CadastroProdutosController;
import controller.ConfeccaoController;
import controller.LoginController;
import controller.LojasController;
import controller.Navegador;
import controller.PedidoLojasController;
import controller.PedidosLojasConfirmadosController;
import controller.ProdutosController;
import model.ConfeccoesDAO;
import model.MateriaPrimaDAO;
import model.PedidosLojasDAO;
import model.ProdutosDAO;
import model.UsuarioDAO;
import model.LojasDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

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
		ConfeccoesDAO confeccaoDAO = new ConfeccoesDAO();
		PedidosLojasDAO pedidolojaDAO = new PedidosLojasDAO();
		LojasDAO lojasDAO = new LojasDAO();
		MateriaPrimaDAO materiaDAO = new MateriaPrimaDAO();

		
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
		
		TelaCadastroConfeccao telaCadastroConfeccao = new TelaCadastroConfeccao ();
		adicionarTela("CADASTRO_CONFECCAO", telaCadastroConfeccao);
		
		TelaLojas telaLojas = new TelaLojas();
		adicionarTela("LOJAS", telaLojas);
		
		TelaPedidosLojas telapedidoloja= new TelaPedidosLojas();
		adicionarTela("PEDIDOS_LOJAS_VIZU", telapedidoloja);
		TelaCadastroLoja telacadastrolojas = new TelaCadastroLoja();
		adicionarTela("CADASTRO_LOJAS", telacadastrolojas);
		
		TelaPedidosLojasConfirmados telaPedidosLojas = new TelaPedidosLojasConfirmados();
		adicionarTela("PEDIDOS_LOJAS", telaPedidosLojas);

		TelaPedidosConfeccoesConfirmados telaPedidosConfeccoes = new TelaPedidosConfeccoesConfirmados();
		adicionarTela("PEDIDOS_CONFECCOES", telaPedidosConfeccoes);	
		
		TelaCadastroMateria telaCadastroMateria = new TelaCadastroMateria();
		adicionarTela("CADASTRO_MATERIA", telaCadastroMateria);	

       
		new LoginController(telaLogin, navegador);
		new CadastroController(telaCadastro, usuarioDAO, navegador);
		new ProdutosController(telaProduto, produtosDAO, navegador);
		new ConfeccaoController(telaConfeccoes, confeccaoDAO, navegador);
		new CadastroProdutosController(telaCadastroProduto, produtosDAO, navegador);
		new CadastroConfeccaoController(telaCadastroConfeccao,  confeccaoDAO, navegador );
		new PedidosLojasConfirmadosController(telaPedidosLojas ,pedidolojaDAO, navegador);
		new PedidoLojasController(telapedidoloja, pedidolojaDAO, navegador);
		new CadastroMateriaController(telaCadastroMateria, materiaDAO, navegador);
		new LojasController(telaLojas, lojasDAO, navegador);
		new CadastroLojaController(telacadastrolojas, lojasDAO, navegador);

		
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
		
		JMenu itemMateriaPrima = new JMenu("Matéria Prima");
		menuBar.add( itemMateriaPrima );
		
		JMenuItem itensMateriaPrima = new JMenuItem("Matéria Prima");
		 itensMateriaPrima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaLogin.limparCampos(); 
				navegador.navegarPara("LOGIN");
			}
		});
		 itemMateriaPrima.add(itensMateriaPrima);
		

		
		JMenu itemDeslogar = new JMenu("Deslogar");
		menuBar.add(itemDeslogar);
		
		JMenuItem ItemDeslogar = new JMenuItem("Deslogar");
		ItemDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaLogin.limparCampos(); 
				esconderMenu();
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
		menuBar.setVisible(true);
		

		
	}
	public void esconderMenu() {
		// TODO Auto-generated method stub
		if (menuBar != null ) {
			menuBar.setVisible(false);
		}
		

		
	}
}