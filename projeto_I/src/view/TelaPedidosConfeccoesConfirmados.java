package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.JButton;

public class TelaPedidosConfeccoesConfirmados extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbNomeConfeccao2;
	private JLabel lbNomeConfeccao3;
	private JLabel lbNomeConfeccao5;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaPedidosConfeccoesConfirmados() throws FontFormatException, IOException {
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Lojas");
		mnNewMenu_4.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Confecções");
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
		).deriveFont(40f);
		
//		Font fonte1 = Font.createFont(
//		        Font.TRUETYPE_FONT,
//		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
//		).deriveFont(20f);
		
		JLabel lblNewLabel = new JLabel("Pedidos Confecções");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		lblNewLabel.setBackground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1,grow");
		lblNewLabel.setFont(fonte);
		
		JButton btnRealizarNovo = new JButton("Realizar novo pedido");
		btnRealizarNovo.setBackground(new Color(235, 219, 194)); 
		btnRealizarNovo.setContentAreaFilled(true);
		btnRealizarNovo.setOpaque(true);
		btnRealizarNovo.setBorderPainted(false);
		btnRealizarNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btnRealizarNovo, "cell 3 1,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Confirmados:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel_1, "cell 1 3");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 4 3 1,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(15, 57, 87));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow]"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JLabel lbNomeConfeccao1 = new JLabel("Nome confecção");
		panel_2.add(lbNomeConfeccao1, "cell 0 1");
		
		JLabel lbDataEntrega1 = new JLabel("Data de entrega");
		panel_2.add(lbDataEntrega1, "cell 0 3");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_4, "cell 2 0,grow");
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		lbNomeConfeccao2 = new JLabel("Nome confecção");
		panel_4.add(lbNomeConfeccao2, "cell 0 1");
		
		JLabel lbDataEntrega2 = new JLabel("Data de entrega");
		panel_4.add(lbDataEntrega2, "cell 0 3");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_6, "cell 4 0,grow");
		panel_6.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][][grow][grow][][grow]"));
		
		lbNomeConfeccao3 = new JLabel("Nome confecção");
		panel_6.add(lbNomeConfeccao3, "cell 0 1");
		
		JLabel lbDataEntrega3 = new JLabel("Data de entrega");
		panel_6.add(lbDataEntrega3, "cell 0 4");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_3, "cell 0 2,grow");
		panel_3.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JLabel lbNomeConfeccao4 = new JLabel("Nome confecção");
		panel_3.add(lbNomeConfeccao4, "cell 0 1");
		
		JLabel lbDataEntrega4 = new JLabel("Data de entrega");
		panel_3.add(lbDataEntrega4, "cell 0 3");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_5, "cell 2 2,grow");
		panel_5.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		lbNomeConfeccao5 = new JLabel("Nome confecção");
		panel_5.add(lbNomeConfeccao5, "cell 0 1");
		
		JLabel lbDataEntrega5 = new JLabel("Data de entrega");
		panel_5.add(lbDataEntrega5, "cell 0 3");
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_7, "cell 4 2,grow");
		panel_7.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JLabel lbNomeConfeccao6 = new JLabel("Nome confecção");
		panel_7.add(lbNomeConfeccao6, "cell 0 1");
		
		JLabel lbDataEntrega6 = new JLabel("Data de entrega");
		panel_7.add(lbDataEntrega6, "cell 0 3");

	}

}
