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

public class TelaCadastroProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomepeca;
	private JTextField tfTipo;
	private JTextField tfPreco;
	private JTextField tfQuantidade;
	private JTextField tfTamanho;

	/**
	 * Create the panel.
	 */
	public TelaCadastroProduto() {
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
		panel.setForeground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Cadastro Produto");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel, "cell 3 1,alignx center");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 5 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Nome da peça:");
		panel_1.add(lblNewLabel_1, "cell 1 1");
		
		tfNomepeca = new JTextField();
		panel_1.add(tfNomepeca, "cell 3 1,growx");
		tfNomepeca.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de produto:");
		panel_1.add(lblNewLabel_2, "cell 1 3");
		
		tfTipo = new JTextField();
		panel_1.add(tfTipo, "cell 3 3,growx");
		tfTipo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Preço R$:");
		panel_1.add(lblNewLabel_3, "cell 1 5");
		
		tfPreco = new JTextField();
		panel_1.add(tfPreco, "cell 3 5,growx");
		tfPreco.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Quantidade:");
		panel_1.add(lblNewLabel_4, "cell 1 7");
		
		tfQuantidade = new JTextField();
		panel_1.add(tfQuantidade, "cell 3 7,growx");
		tfQuantidade.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tamanho:");
		panel_1.add(lblNewLabel_5, "cell 1 9");
		
		tfTamanho = new JTextField();
		panel_1.add(tfTamanho, "cell 3 9,growx");
		tfTamanho.setColumns(10);
		
		JButton btCadastrar = new JButton("Cadastrar");
		panel.add(btCadastrar, "cell 3 5,growx");

	}

}
