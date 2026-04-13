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
import javax.swing.JRadioButton;

public class TelaEditarUsuarios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaEditarUsuarios() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
//		Font fonte1 = Font.createFont(
//		        Font.TRUETYPE_FONT,
//		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
//		).deriveFont(50f);
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(70f);
		
		
		JLabel lblNewLabel = new JLabel("Editar Usuários");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 2 1");
		lblNewLabel.setFont(fonte);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel_1.setForeground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
		).deriveFont(14f);
		
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1, "cell 1 1");
		lblNewLabel_1.setFont(fonte2);
		
		
		textField = new JTextField();
		panel_1.add(textField, "cell 2 1 2 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuário");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2, "cell 1 3");
		lblNewLabel_2.setFont(fonte2);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 2 3 2 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cargo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_3, "cell 1 5");
		lblNewLabel_3.setFont(fonte2);
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 2 5 2 1,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Permissão");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_4, "cell 1 7");
		lblNewLabel_4.setFont(fonte2);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Usuário");
		rdbtnNewRadioButton.setBackground(new Color(235, 219, 194));
		panel_1.add(rdbtnNewRadioButton, "cell 2 7");
		rdbtnNewRadioButton.setFont(fonte2);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Administrador");
		rdbtnNewRadioButton_1.setBackground(new Color(235, 219, 194));
		panel_1.add(rdbtnNewRadioButton_1, "cell 3 7");
		rdbtnNewRadioButton_1.setFont(fonte2);
		
		JButton btnNewButton = new JButton("Remover Usuário");
		btnNewButton.setFont(fonte2);
		
		btnNewButton.setBackground(new Color(235, 219, 194));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
          
		btnNewButton.setContentAreaFilled(true);
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);

		btnNewButton.setBackground(new Color(235, 219, 194 ));
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton, "cell 1 5,growx");
		
		JButton btnNewButton_1 = new JButton("Confirmar Alterações");
		btnNewButton_1.setFont(fonte2);
		

		btnNewButton_1.setBackground(new Color(235, 219, 194));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBorderPainted(false);
          
		btnNewButton_1.setContentAreaFilled(true);
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBorderPainted(false);

		btnNewButton_1.setBackground(new Color(235, 219, 194 ));
		
		panel.add(btnNewButton_1, "cell 3 5,growx");

	}

}
