package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfBuscar;
	private JLabel lbNome9;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaProdutos() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("Notificações");
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
		
		JMenu mnNewMenu_5 = new JMenu("Permissões");
		menuBar.add(mnNewMenu_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow]", "[::10px][::50px,grow][::20px,grow][::10px][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
		).deriveFont(80f);
		
		JLabel lbLojas = new JLabel("Produtos");
		lbLojas.setForeground(new Color(235, 219, 194));
		lbLojas.setFont(fonte);
		panel.add(lbLojas, "cell 1 0 1 3");
		
		JButton btnCadastrarProduto = new JButton("Cadastrar produto");
		btnCadastrarProduto.setBackground(new Color(235, 219, 194)); 
		btnCadastrarProduto.setContentAreaFilled(true);
		btnCadastrarProduto.setOpaque(true);
		btnCadastrarProduto.setBorderPainted(false);
		btnCadastrarProduto.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel.add(btnCadastrarProduto, "cell 3 1,growx,aligny center");
		
		tfBuscar = new JTextField();
		panel.add(tfBuscar, "cell 3 2,growx,aligny center");
		tfBuscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 4 4 1,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(15, 57, 87));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNome1 = new JLabel("Nome da peça");
		panel_2.add(lbNome1, "cell 1 0");
		
		JLabel lbPreco1 = new JLabel("Preço R$");
		panel_2.add(lbPreco1, "cell 1 2");
		
		JPanel panel_7 = new JPanel();
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e);
			}
		});
		panel_7.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_7, "cell 2 0,grow");
		panel_7.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNome2 = new JLabel("Nome da peça");
		panel_7.add(lbNome2, "cell 1 0");
		
		JLabel lbPreco2 = new JLabel("Preço R$");
		panel_7.add(lbPreco2, "cell 1 2");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_6, "cell 4 0,grow");
		panel_6.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNome3 = new JLabel("Nome da peça");
		panel_6.add(lbNome3, "cell 1 0");
		
		JLabel lbPreco3 = new JLabel("Preço R$");
		panel_6.add(lbPreco3, "cell 1 2");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_4, "cell 0 2,grow");
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNome4 = new JLabel("Nome da peça");
		panel_4.add(lbNome4, "cell 1 0");
		
		JLabel lbPreco4 = new JLabel("Preço R$");
		lbPreco4.setToolTipText("");
		panel_4.add(lbPreco4, "cell 1 2");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_5, "cell 2 2,grow");
		panel_5.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNome5 = new JLabel("Nome da peça");
		panel_5.add(lbNome5, "cell 1 0");
		
		JLabel lbPreco5 = new JLabel("Preço R$");
		panel_5.add(lbPreco5, "cell 1 2");
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_8, "cell 4 2,grow");
		panel_8.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNome6 = new JLabel("Nome da peça");
		panel_8.add(lbNome6, "cell 1 0");
		
		JLabel lbPreco6 = new JLabel("Preço R$");
		panel_8.add(lbPreco6, "cell 1 2");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_3, "cell 0 4,grow");
		panel_3.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNome7 = new JLabel("Nome da peça");
		panel_3.add(lbNome7, "cell 1 0");
		
		JLabel lbPreco7 = new JLabel("Preço R$");
		panel_3.add(lbPreco7, "cell 1 2");
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_9, "cell 2 4,grow");
		panel_9.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNome8 = new JLabel("Nome da peça");
		panel_9.add(lbNome8, "cell 1 0");
		
		JLabel lbPreco8 = new JLabel("Preço R$");
		panel_9.add(lbPreco8, "cell 1 2");
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_10, "cell 4 4,grow");
		panel_10.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		lbNome9 = new JLabel("Nome da peça");
		panel_10.add(lbNome9, "cell 1 0");
		
		JLabel lbPreco9 = new JLabel("Preço R$");
		panel_10.add(lbPreco9, "cell 1 2");

	}

}
