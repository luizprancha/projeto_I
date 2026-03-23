package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TelaVisualizarUsuarios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome1;
	private JTextField tfNome2;
	private JTextField tfNome3;
	private JTextField tfUsuario1;
	private JTextField tfUsuario2;
	private JTextField tfUsuario3;
	private JTextField tfCargo1;
	private JTextField tfCargo2;
	private JTextField tfCargo3;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaVisualizarUsuarios() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(235, 219, 194));
		add(menuBar, BorderLayout.NORTH);

		
		JMenu mnNewMenu = new JMenu("Notificações");
		mnNewMenu.setBackground(new Color(235, 219, 194));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
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
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("../fontes/Jomhuria-Regular.ttf")
		).deriveFont(70f);
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("../fontes/Abel-Regular.ttf")
		).deriveFont(14f);
		
		
		JLabel lblNewLabel = new JLabel("Usuários");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1,grow");
		lblNewLabel .setFont(fonte);
		
		
		JButton brVisualizarUsuarios = new JButton("Editar Usuários");
		brVisualizarUsuarios .setFont(fonte2);

		
		brVisualizarUsuarios.setBackground(new Color(235, 219, 194));
		brVisualizarUsuarios.setContentAreaFilled(false);
		brVisualizarUsuarios.setOpaque(false);
		brVisualizarUsuarios.setBorderPainted(false);
          
		brVisualizarUsuarios.setContentAreaFilled(true);
		brVisualizarUsuarios.setOpaque(true);
		brVisualizarUsuarios.setBorderPainted(false);

		brVisualizarUsuarios.setBackground(new Color(235, 219, 194 ));
	
		brVisualizarUsuarios.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		    }
		});
		
		panel.add(brVisualizarUsuarios, "cell 3 1,grow");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 3 3 1,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		panel_1.add(lblNewLabel_1, "cell 1 1");
		lblNewLabel_1 .setFont(fonte2);
		
		JLabel lblNewLabel_2 = new JLabel("Usuário");
		panel_1.add(lblNewLabel_2, "cell 3 1");
		lblNewLabel_2.setFont(fonte2);
		
		JLabel lblNewLabel_4 = new JLabel("Cargo");
		panel_1.add(lblNewLabel_4, "cell 5 1");
		lblNewLabel_4.setFont(fonte2);
		
		tfNome1 = new JTextField();
		panel_1.add(tfNome1, "cell 1 3,growx");
		tfNome1.setColumns(10);
		
		tfUsuario1 = new JTextField();
		panel_1.add(tfUsuario1, "cell 3 3,growx");
		tfUsuario1.setColumns(10);
		
		tfCargo1 = new JTextField();
		panel_1.add(tfCargo1, "cell 5 3,growx");
		tfCargo1.setColumns(10);
		
		tfNome2 = new JTextField();
		panel_1.add(tfNome2, "cell 1 5,growx");
		tfNome2.setColumns(10);
		
		tfUsuario2 = new JTextField();
		panel_1.add(tfUsuario2, "cell 3 5,growx");
		tfUsuario2.setColumns(10);
		
		tfCargo2 = new JTextField();
		panel_1.add(tfCargo2, "cell 5 5,growx");
		tfCargo2.setColumns(10);
		
		tfNome3 = new JTextField();
		panel_1.add(tfNome3, "cell 1 7,growx");
		tfNome3.setColumns(10);
		
		tfUsuario3 = new JTextField();
		panel_1.add(tfUsuario3, "cell 3 7,growx");
		tfUsuario3.setColumns(10);
		
		tfCargo3 = new JTextField();
		panel_1.add(tfCargo3, "cell 5 7,growx");
		tfCargo3.setColumns(10);

	}

}
