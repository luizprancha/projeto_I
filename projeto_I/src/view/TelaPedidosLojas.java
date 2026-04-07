package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPedidosLojas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfLoja;
	private JTextField tfDataEntrega;
	private JTextField tfQuantidade;
	private JTextField tfTotal;
	private JButton btnFinalizar;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaPedidosLojas() throws FontFormatException, IOException {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
		).deriveFont(50f);
		
		JLabel lblNewLabel = new JLabel("Pedidos Lojas");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 3 1,alignx left,growy");
		lblNewLabel.setFont(fonte);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Loja");
		panel_1.add(lblNewLabel_1, "cell 1 1");
		
		tfLoja = new JTextField();
		panel_1.add(tfLoja, "cell 3 1,growx");
		tfLoja.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade de peças");
		panel_1.add(lblNewLabel_3, "cell 1 3");
		
		tfQuantidade = new JTextField();
		panel_1.add(tfQuantidade, "cell 3 3,growx");
		tfQuantidade.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data de Entrega");
		panel_1.add(lblNewLabel_2, "cell 1 5");
		
		tfDataEntrega = new JTextField();
		panel_1.add(tfDataEntrega, "cell 3 5,growx");
		tfDataEntrega.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Valor Total");
		panel_1.add(lblNewLabel_5, "cell 1 7");
		
		tfTotal = new JTextField();
		panel_1.add(tfTotal, "cell 3 7,growx");
		tfTotal.setColumns(10);
		
		btnFinalizar = new JButton("Finalizar pedido");
		btnFinalizar.setBackground(new Color(235, 219, 194)); 
		btnFinalizar.setContentAreaFilled(true);
		btnFinalizar.setOpaque(true);
		btnFinalizar.setBorderPainted(false);
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btnFinalizar, "cell 2 5,grow");

	}

}
