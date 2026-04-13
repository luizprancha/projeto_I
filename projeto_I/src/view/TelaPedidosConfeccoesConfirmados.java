package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.JButton;

public class TelaPedidosConfeccoesConfirmados extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaPedidosConfeccoesConfirmados() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
	
		
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
		
		JButton btnNewButton = new JButton("Realizar novo pedido");
		panel.add(btnNewButton, "cell 3 1,growx");
		
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
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_2.add(lblNewLabel_2, "cell 0 1");
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_2.add(lblNewLabel_3, "cell 0 3");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_4, "cell 2 0,grow");
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panel_4.add(lblNewLabel_4, "cell 0 1");
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel_4.add(lblNewLabel_5, "cell 0 3");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_6, "cell 4 0,grow");
		panel_6.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][][grow][grow][][grow]"));
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		panel_6.add(lblNewLabel_6, "cell 0 1");
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		panel_6.add(lblNewLabel_7, "cell 0 4");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_3, "cell 0 2,grow");
		panel_3.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		panel_3.add(lblNewLabel_8, "cell 0 1");
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		panel_3.add(lblNewLabel_9, "cell 0 3");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_5, "cell 2 2,grow");
		panel_5.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		panel_5.add(lblNewLabel_10, "cell 0 1");
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		panel_5.add(lblNewLabel_11, "cell 0 3");
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_7, "cell 4 2,grow");
		panel_7.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		panel_7.add(lblNewLabel_12, "cell 0 1");
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		panel_7.add(lblNewLabel_13, "cell 0 3");

	}

}
