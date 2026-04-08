package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastroMateria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfCor;
	private JTextField tfQuantidade;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaCadastroMateria() throws FontFormatException, IOException {
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
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(100f);
		
		JLabel lbCadastroMateriaPrima = new JLabel("Cadastro Matéria Prima");
		lbCadastroMateriaPrima.setForeground(new Color(235, 219, 194));
		panel.add(lbCadastroMateriaPrima, "cell 1 1 5 1,alignx left");
		lbCadastroMateriaPrima.setFont(fonte);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 2 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[][][][grow][]", "[][][][][][][]"));
		
		JLabel lbTipoProduto = new JLabel("Tipo de Produto:");
		panel_1.add(lbTipoProduto, "cell 1 1");
		
		JComboBox<String> cbTipoProduto = new JComboBox<>();
		cbTipoProduto.setModel(new DefaultComboBoxModel<>(new String[] {"Tecido", "Aviamentos"}));
		panel_1.add(cbTipoProduto, "cell 3 1,growx");
		
		JLabel lbCor = new JLabel("Cor:");
		panel_1.add(lbCor, "cell 1 3");
		
		tfCor = new JTextField();
		panel_1.add(tfCor, "cell 3 3,growx");
		tfCor.setColumns(10);
		
		JLabel lbQuantidade = new JLabel("Quantidade (unidade):");
		panel_1.add(lbQuantidade, "cell 1 5");
		
		tfQuantidade = new JTextField();
		panel_1.add(tfQuantidade, "cell 3 5,growx");
		tfQuantidade.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(235, 219, 194)); 
		btnCadastrar.setContentAreaFilled(true);
		btnCadastrar.setOpaque(true);
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnCadastrar, "cell 3 5,growx");

	}

}
