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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLojas extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaLojas() throws FontFormatException, IOException {
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
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[::10px][::90px,grow][::10px][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
		).deriveFont(80f);
		
		JLabel lbLojas = new JLabel("Lojas");
		lbLojas.setForeground(new Color(235, 219, 194));
		lbLojas.setFont(fonte);
		panel.add(lbLojas, "cell 1 1");
		
		JButton btnCadastrarLoja = new JButton("Cadastrar Loja");
		btnCadastrarLoja.setBackground(new Color(235, 219, 194)); 
		btnCadastrarLoja.setContentAreaFilled(true);
		btnCadastrarLoja.setOpaque(true);
		btnCadastrarLoja.setBorderPainted(false);
		btnCadastrarLoja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnCadastrarLoja, "cell 3 1,growx,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 3 3 1,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(15, 57, 87));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNomeLoja1 = new JLabel("Nome da loja");
		panel_2.add(lbNomeLoja1, "cell 1 0");
		
		JLabel lbCNPJ1 = new JLabel("CNPJ");
		panel_2.add(lbCNPJ1, "cell 1 2,alignx center");
		
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
		
		JLabel lbNomeLoja2 = new JLabel("Nome da loja");
		panel_7.add(lbNomeLoja2, "cell 1 0");
		
		JLabel lbCNPJ2 = new JLabel("CNPJ");
		panel_7.add(lbCNPJ2, "cell 1 2,alignx center");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_6, "cell 4 0,grow");
		panel_6.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNomeLoja3 = new JLabel("Nome da loja");
		panel_6.add(lbNomeLoja3, "cell 1 0");
		
		JLabel lbCNPJ3 = new JLabel("CNPJ");
		panel_6.add(lbCNPJ3, "cell 1 2,alignx center");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_4, "cell 0 2,grow");
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNomeLoja4 = new JLabel("Nome da loja");
		panel_4.add(lbNomeLoja4, "cell 1 0");
		
		JLabel lbCNPJ4 = new JLabel("CNPJ");
		panel_4.add(lbCNPJ4, "cell 1 2,alignx center");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_5, "cell 2 2,grow");
		panel_5.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNomeLoja5 = new JLabel("Nome da loja");
		panel_5.add(lbNomeLoja5, "cell 1 0");
		
		JLabel lbCNPJ5 = new JLabel("CNPJ");
		panel_5.add(lbCNPJ5, "cell 1 2,alignx center");
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_8, "cell 4 2,grow");
		panel_8.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNomeLoja6 = new JLabel("Nome da loja");
		panel_8.add(lbNomeLoja6, "cell 1 0");
		
		JLabel lbCNPJ6 = new JLabel("CNPJ");
		panel_8.add(lbCNPJ6, "cell 1 2,alignx center");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_3, "cell 0 4,grow");
		panel_3.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNomeLoja7 = new JLabel("Nome da loja");
		panel_3.add(lbNomeLoja7, "cell 1 0");
		
		JLabel lbCNPJ7 = new JLabel("CNPJ");
		panel_3.add(lbCNPJ7, "cell 1 2,alignx center");
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_9, "cell 2 4,grow");
		panel_9.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNomeLoja8 = new JLabel("Nome da loja");
		panel_9.add(lbNomeLoja8, "cell 1 0");
		
		JLabel lbCNPJ8 = new JLabel("CNPJ");
		panel_9.add(lbCNPJ8, "cell 1 2,alignx center");
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_10, "cell 4 4,grow");
		panel_10.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNomeLoja9 = new JLabel("Nome da loja");
		panel_10.add(lbNomeLoja9, "cell 1 0");
		
		JLabel lbCNPJ9 = new JLabel("CNPJ");
		panel_10.add(lbCNPJ9, "cell 1 2,alignx center");

	}

}
