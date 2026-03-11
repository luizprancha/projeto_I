package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class TelaCadastroMateria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public TelaCadastroMateria() {
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
		
		JMenu mnNewMenu_5 = new JMenu("Permissões");
		menuBar.add(mnNewMenu_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Cadastro Matéria Prima");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		panel.add(lblNewLabel, "cell 1 1 5 1,alignx center");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 2 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[][][][grow][]", "[][][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_1.add(lblNewLabel_1, "cell 1 1");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 3 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_1.add(lblNewLabel_2, "cell 1 3");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 3 3,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_1.add(lblNewLabel_3, "cell 1 5");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 3 5,growx");
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		panel.add(btnNewButton, "cell 3 5,growx");

	}

}
