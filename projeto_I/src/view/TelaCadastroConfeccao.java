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

public class TelaCadastroConfeccao extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeConfecção;
	private JTextField tfCNPJ;
	private JTextField tfEndereço;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaCadastroConfeccao() throws FontFormatException, IOException {
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
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(80f);
		
		JLabel lblNewLabel = new JLabel("Cadastro Confecção");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 2 1,alignx center,growy");
		lblNewLabel.setFont(fonte);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbNomeConfeccao = new JLabel("Nome da confecção:");
		panel_1.add(lbNomeConfeccao, "cell 1 1");
		
		tfNomeConfecção = new JTextField();
		panel_1.add(tfNomeConfecção, "cell 3 1,growx");
		tfNomeConfecção.setColumns(10);
		
		JLabel lbCNPJ = new JLabel("CNPJ:");
		panel_1.add(lbCNPJ, "cell 1 3");
		
		tfCNPJ = new JTextField();
		panel_1.add(tfCNPJ, "cell 3 3,growx");
		tfCNPJ.setColumns(10);
		
		JLabel lbEndereco = new JLabel("Endereço:");
		panel_1.add(lbEndereco, "cell 1 5");
		
		tfEndereço = new JTextField();
		panel_1.add(tfEndereço, "cell 3 5,growx");
		tfEndereço.setColumns(10);
		
		JButton btnCadastrarConfecção = new JButton("Cadastrar Confecção");
		btnCadastrarConfecção.setBackground(new Color(235, 219, 194)); 
		btnCadastrarConfecção.setContentAreaFilled(true);
		btnCadastrarConfecção.setOpaque(true);
		btnCadastrarConfecção.setBorderPainted(false);
		btnCadastrarConfecção.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnCadastrarConfecção, "cell 2 5,growx,aligny center");

	}

}
