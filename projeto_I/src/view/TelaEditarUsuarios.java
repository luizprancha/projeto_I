package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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
	private JTextField tfNome;
	private JTextField tfUsuario;
	private JTextField tfCargo;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaEditarUsuarios() throws FontFormatException, IOException {
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
		
		
		tfNome = new JTextField();
		panel_1.add(tfNome, "cell 2 1 2 1,growx");
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuário");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2, "cell 1 3");
		lblNewLabel_2.setFont(fonte2);
		
		tfUsuario = new JTextField();
		panel_1.add(tfUsuario, "cell 2 3 2 1,growx");
		tfUsuario.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cargo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_3, "cell 1 5");
		lblNewLabel_3.setFont(fonte2);
		
		tfCargo = new JTextField();
		panel_1.add(tfCargo, "cell 2 5 2 1,growx");
		tfCargo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Permissão");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_4, "cell 1 7");
		lblNewLabel_4.setFont(fonte2);
		
		
		JRadioButton rdbUsuario = new JRadioButton("Usuário");
		rdbUsuario.setBackground(new Color(235, 219, 194));
		panel_1.add(rdbUsuario, "cell 2 7");
		rdbUsuario.setFont(fonte2);
		
		JRadioButton rdbAdministrador = new JRadioButton("Administrador");
		rdbAdministrador.setBackground(new Color(235, 219, 194));
		panel_1.add(rdbAdministrador, "cell 3 7");
		rdbAdministrador.setFont(fonte2);
		
		JButton btnRemover = new JButton("Remover Usuário");
		btnRemover.setBackground(new Color(235, 219, 194)); 
		btnRemover.setContentAreaFilled(true);
		btnRemover.setOpaque(true);
		btnRemover.setBorderPainted(false);
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnRemover, "cell 1 5,growx");
		
		JButton btnConfirmar = new JButton("Confirmar Alterações");
		btnConfirmar.setBackground(new Color(235, 219, 194)); 
		btnConfirmar.setContentAreaFilled(true);
		btnConfirmar.setOpaque(true);
		btnConfirmar.setBorderPainted(false);
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnConfirmar, "cell 3 5,growx");

	}

}
