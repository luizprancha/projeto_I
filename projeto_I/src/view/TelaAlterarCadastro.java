package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.JTextField;

public class TelaAlterarCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtSofiaMartinsPascoalini;
	private JTextField txtSomapa;
	private JTextField txtVendedora;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaAlterarCadastro() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("Notificações");
		menuBar.add(mnNewMenu);
		
		JMenu menu = new JMenu("New menu");
		mnNewMenu.add(menu);
		
		JMenu mnNewMenu_1 = new JMenu("Produto");
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
		panel.setLayout(new MigLayout("", "[grow][grow 60][grow][grow]", "[grow 10][grow][grow 10][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("../fontes/Jomhuria-Regular.ttf")
		).deriveFont(100f);
		
		
		JLabel lblNewLabel = new JLabel("Alterar Cadastro");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1,alignx left");
		lblNewLabel.setFont(fonte);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 2 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow 70][grow 50][grow][grow 30][grow 30][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1, "cell 1 1");
		
		txtSofiaMartinsPascoalini = new JTextField();
		txtSofiaMartinsPascoalini.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSofiaMartinsPascoalini.setText("Sofia Martins Pascoalini");
		panel_1.add(txtSofiaMartinsPascoalini, "cell 2 1 3 1,growx");
		txtSofiaMartinsPascoalini.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuário");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2, "cell 1 3");
		
		txtSomapa = new JTextField();
		txtSomapa.setText("somapa");
		txtSomapa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(txtSomapa, "cell 2 3 3 1,growx");
		txtSomapa.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cargo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_3, "cell 1 5");
		
		txtVendedora = new JTextField();
		txtVendedora.setText("Vendedor(a)");
		txtVendedora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(txtVendedora, "cell 2 5 3 1,growx");
		txtVendedora.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Permissão");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_5, "cell 1 7");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Usuário");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(rdbtnNewRadioButton, "cell 2 7,alignx left");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Administrador");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(rdbtnNewRadioButton_1, "cell 4 7 2 1,alignx left");
		
		JButton btnNewButton = new JButton("Remover usuário");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnNewButton, "cell 1 9 2 1,grow");
		
		JButton btnNewButton_1 = new JButton("Confirmar Alterações");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnNewButton_1, "cell 4 9 2 1,grow");

	}

}
