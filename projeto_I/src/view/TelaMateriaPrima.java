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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaMateriaPrima extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaMateriaPrima() throws FontFormatException, IOException {
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
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow]", "[::10px][::90px,grow][::10px][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("../fontes/Abel-Regular.ttf")
		).deriveFont(80f);
		
		JLabel lbLojas = new JLabel("Matéria prima");
		lbLojas.setForeground(new Color(235, 219, 194));
		lbLojas.setFont(fonte);
		panel.add(lbLojas, "cell 1 1");
		
		JButton btCadastrarNovaLoja = new JButton("Nova matéria prima");
		btCadastrarNovaLoja.setBackground(new Color(235, 219, 194));
		btCadastrarNovaLoja.setBorderPainted(false);
		btCadastrarNovaLoja.setFocusPainted(false);
		btCadastrarNovaLoja.setContentAreaFilled(true);
		btCadastrarNovaLoja.setOpaque(true);
		btCadastrarNovaLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btCadastrarNovaLoja, "cell 3 1,growx,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 3 4 1,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(15, 57, 87));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_2.add(lblNewLabel, "cell 1 0");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_2.add(lblNewLabel_1, "cell 1 2");
		
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
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_7.add(lblNewLabel_2, "cell 1 0");
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_7.add(lblNewLabel_3, "cell 1 2");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_6, "cell 4 0,grow");
		panel_6.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panel_6.add(lblNewLabel_4, "cell 1 0");
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel_6.add(lblNewLabel_5, "cell 1 2");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_4, "cell 0 2,grow");
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		panel_4.add(lblNewLabel_6, "cell 1 0");
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		panel_4.add(lblNewLabel_8, "cell 1 2");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_5, "cell 2 2,grow");
		panel_5.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		panel_5.add(lblNewLabel_7, "cell 1 0");
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		panel_5.add(lblNewLabel_9, "cell 1 2");
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_8, "cell 4 2,grow");
		panel_8.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		panel_8.add(lblNewLabel_10, "cell 1 0");
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		panel_8.add(lblNewLabel_11, "cell 1 2");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_3, "cell 0 4,grow");
		panel_3.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		panel_3.add(lblNewLabel_12, "cell 1 0");
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		panel_3.add(lblNewLabel_13, "cell 1 2");
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_9, "cell 2 4,grow");
		panel_9.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		panel_9.add(lblNewLabel_14, "cell 1 0");
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		panel_9.add(lblNewLabel_15, "cell 1 2");
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_10, "cell 4 4,grow");
		panel_10.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		panel_10.add(lblNewLabel_16, "cell 1 0");
		
		JLabel lblNewLabel_17 = new JLabel("New label");
		panel_10.add(lblNewLabel_17, "cell 1 2");

	}

}
