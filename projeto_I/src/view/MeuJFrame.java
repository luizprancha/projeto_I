package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.AlterarLojaController;
import controller.CadastroConfeccaoController;
import controller.CadastroController;
import controller.CadastroLojaController;
import controller.CadastroMateriaController;
import controller.CadastroProdutosController;
import controller.CarrinhoLojasController;
import controller.ConfeccaoController;
import controller.LoginController;
import controller.LojasController;
import controller.MateriaPrimaController;
import controller.Navegador;
import controller.PedidosConfeccoesConfirmadosController;
import controller.PedidosLojasConfirmadosController;
import controller.ProdutosController;
import model.Carrinho;
import model.CarrinhoDAO;
import model.ConfeccoesDAO;
import model.MateriaPrimaDAO;
import model.PedidoConfeccaoDAO;
import model.PedidosLojasDAO;
import model.ProdutosDAO;
import model.UsuarioDAO;
import model.LojasDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MeuJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	protected JMenuBar menuBar;
	private CarrinhoLojasController carrinhocont;
	private Carrinho carrinho;
	
	public JMenuItem itemNotificacao;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MeuJFrame frame = new MeuJFrame();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public MeuJFrame() throws FontFormatException, IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MeuJFrame.class.getResource("/imagem/logo.png")));
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 675);
		setTitle("Nó de Estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setMinimumSize(new Dimension(600, 500));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		setLocationRelativeTo(null);
		 
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
		PedidoConfeccaoDAO pedidoconfeccaoDAO = new PedidoConfeccaoDAO();
		CarrinhoDAO carrinhoDAO = new CarrinhoDAO();

		
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
	     
		TelaDetalhesConfeccoes telaDetalheaConf = new 	TelaDetalhesConfeccoes();
		adicionarTela("DETALHES_CONFECCOES", telaDetalheaConf);
		
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

		TelaPedidosConfeccoesConfirmados telaPedidosConfeccoesconfirmados = new TelaPedidosConfeccoesConfirmados();
		adicionarTela("PEDIDOS_CONFECCOES", telaPedidosConfeccoesconfirmados);	
		
		TelaCadastroMateria telaCadastroMateria = new TelaCadastroMateria();
		adicionarTela("CADASTRO_MATERIA", telaCadastroMateria);	
		
		TelaMateriaPrima telaMateriaPrima = new TelaMateriaPrima();
		adicionarTela("MATERIA_PRIMA", telaMateriaPrima);
		
		TelaDetalheMateria teladetalhemateria = new TelaDetalheMateria();
		adicionarTela("DETALHE_MATERIA", teladetalhemateria);
		
		TelaDetalheProduto telaDetalhesProdutos = new TelaDetalheProduto();
		adicionarTela("DETALHES_PRODUTOS", telaDetalhesProdutos);
		
		TelaPedidosConfeccoes telapedidosconfeccoes = new TelaPedidosConfeccoes();
		adicionarTela("PEDIDOS_CONFECCOES_VIZU", telapedidosconfeccoes);
		
		TelaDetalhesLojas telaDetalhesLojas = new TelaDetalhesLojas();
		adicionarTela("DETALHES_LOJAS", telaDetalhesLojas);
		
		TelaAlterarLoja telaAlterarLoja = new TelaAlterarLoja();
		adicionarTela("ALTERAR_LOJA", telaAlterarLoja);
		
		TelaCarrinhoLojas telaCarrinho = new TelaCarrinhoLojas();
		adicionarTela("CARRINHO", telaCarrinho);
		
		TelaAlterarProdutos telaAlterarProdutos = new TelaAlterarProdutos();
		adicionarTela("ALTERAR_PRODUTOS", telaAlterarProdutos);
		
		TelaAlterarConfeccao telaalterarconfeccao = new TelaAlterarConfeccao();
		adicionarTela("ALTERAR_CONFECCAO", telaalterarconfeccao);
		
		TelaAlterarMateria telaalterarmateria = new TelaAlterarMateria();
		adicionarTela("ALTERAR_MATERIA", telaalterarmateria);
       
		new LoginController(telaLogin, navegador);
		new CadastroController(telaCadastro, usuarioDAO, navegador);
		
		ProdutosController prodCont = new ProdutosController(telaProduto, produtosDAO, navegador);
		new CadastroProdutosController(telaCadastroProduto, produtosDAO, navegador, prodCont);
		
		ConfeccaoController confCont = new ConfeccaoController(telaConfeccoes, confeccaoDAO, navegador);
		new CadastroConfeccaoController(telaCadastroConfeccao,  confeccaoDAO, navegador, confCont);
		
		new PedidosLojasConfirmadosController(telaPedidosLojas ,pedidolojaDAO, navegador);
		
		LojasController lojaCont = new LojasController(telaLojas, lojasDAO, navegador);		
		new CadastroLojaController(telacadastrolojas, lojasDAO, navegador, lojaCont);
		
		MateriaPrimaController materiaConf = new MateriaPrimaController (telaMateriaPrima , materiaDAO ,  navegador);
		new CadastroMateriaController(telaCadastroMateria, materiaDAO, navegador, materiaConf);
		
		new PedidosConfeccoesConfirmadosController(telaPedidosConfeccoesconfirmados, pedidoconfeccaoDAO, navegador);
	    carrinhocont = new CarrinhoLojasController ( telaCarrinho, carrinhoDAO, navegador, carrinho );
		
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
				try {
					prodCont.recriarPaineis();
				} catch (FontFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_1.add(itemProdutos);

		JMenu itemConfeccoes = new JMenu("Confecções");
		menuBar.add(itemConfeccoes);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Confecções");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegador.navegarPara("CONFECCAO");
				try {
					confCont.recriarPaineis();
				} catch (FontFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		itemConfeccoes.add(mntmNewMenuItem_3);
		


		JMenu itemLojas = new JMenu("Lojas");
		menuBar.add(itemLojas);
		

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Lojas");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegador.navegarPara("LOJAS");
				try {
					lojaCont.recriarPaineis();
				} catch (FontFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		itemLojas.add( mntmNewMenuItem_4);

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
				navegador.navegarPara("MATERIA_PRIMA");
				try {
					materiaConf.recriarPaineis();
				} catch (FontFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
	}


	public void mostrarMenu() {
		// TODO Auto-generated method stub
		setJMenuBar(menuBar);
		validate();
		repaint();
		menuBar.setVisible(true);
	}
	
	public void esconderMenu() {
		// TODO Auto-generated method stub
		if (menuBar != null ) {
			menuBar.setVisible(false);
		}
		

		
	}
}