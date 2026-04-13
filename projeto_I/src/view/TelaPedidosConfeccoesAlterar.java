package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPedidosConfeccoesAlterar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaPedidosConfeccoesAlterar() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte1 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
		).deriveFont(50f);
		
		JLabel lblNewLabel = new JLabel("Pedidos Confecções");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 3 1");
		lblNewLabel.setFont(fonte1);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel_1.setForeground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Confecção");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1, "cell 1 1");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 3 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade de peças");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2, "cell 1 3");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 3 3,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data de entrega");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_3, "cell 1 5");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 3 5,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Valor total");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_4, "cell 1 7");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "cell 3 7,growx");
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar Alterações");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton, "cell 2 5,growx");

	}

}
