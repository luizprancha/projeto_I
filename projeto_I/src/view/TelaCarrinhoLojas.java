package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class TelaCarrinhoLojas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfBuscar;
	private JTextField tfQuantidade;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaCarrinhoLojas() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
		).deriveFont(40f);
		
		JLabel lblNewLabel = new JLabel("Carrinho de pedidos ");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 4 1");
		lblNewLabel.setFont(fonte);
		
		tfBuscar = new JTextField();
		panel.add(tfBuscar, "cell 5 1,growx");
		tfBuscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 3 5 1,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow 10][grow][grow 10][grow][grow 10][grow][grow 10][grow][grow 10]", "[grow 5][grow][grow 5][grow][grow 5]"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_2, "cell 1 1,grow");
		panel_2.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbCamisa = new JLabel("Camisa");
		panel_2.add(lbCamisa, "cell 1 1,alignx center,growy");
		
		JLabel lbQuantidade = new JLabel("Quantidade");
		panel_2.add(lbQuantidade, "cell 1 3,alignx center,aligny center");
		
		JButton btnMenos = new JButton("-");
		btnMenos.setBackground(new Color(240, 240, 240));
		panel_2.add(btnMenos, "cell 0 5,alignx right");
		
		tfQuantidade = new JTextField();
		tfQuantidade.setBackground(new Color(240, 240, 240));
		panel_2.add(tfQuantidade, "cell 1 5,growx");
		tfQuantidade.setColumns(10);
		
		JButton btnMais = new JButton("+");
		btnMais.setBackground(new Color(240, 240, 240));
		panel_2.add(btnMais, "cell 2 5,alignx left");
		
		JLabel lbValor = new JLabel("Valor");
		panel_2.add(lbValor, "cell 1 6,alignx center");
		
		JLabel lbTotal = new JLabel("R$1 500,00");
		panel_2.add(lbTotal, "cell 1 8,alignx center");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_4, "cell 3 1,grow");
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_9 = new JLabel("Camisa");
		panel_4.add(lblNewLabel_9, "cell 1 1,alignx center");
		
		JLabel lblNewLabel_10 = new JLabel("Quantidade");
		panel_4.add(lblNewLabel_10, "cell 1 2,alignx center");
		
		JButton btnNewButton_6 = new JButton("-");
		panel_4.add(btnNewButton_6, "cell 0 4,alignx right");
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(240, 240, 240));
		panel_4.add(textField_3, "cell 1 4,alignx center");
		textField_3.setColumns(10);
		
		JButton btnNewButton_7 = new JButton("+");
		panel_4.add(btnNewButton_7, "cell 2 4,alignx left");
		
		JLabel lblNewLabel_11 = new JLabel("Valor");
		panel_4.add(lblNewLabel_11, "cell 1 6,alignx center");
		
		JLabel lblNewLabel_12 = new JLabel("R$1500,00");
		panel_4.add(lblNewLabel_12, "cell 1 7,alignx center");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_6, "cell 5 1,grow");
		panel_6.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_17 = new JLabel("Camisa");
		panel_6.add(lblNewLabel_17, "cell 1 1,alignx center");
		
		JLabel lblNewLabel_18 = new JLabel("Quantidade");
		panel_6.add(lblNewLabel_18, "cell 1 2,alignx center");
		
		JButton btnNewButton_10 = new JButton("-");
		panel_6.add(btnNewButton_10, "cell 0 4,alignx right");
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(240, 240, 240));
		panel_6.add(textField_5, "cell 1 4,growx");
		textField_5.setColumns(10);
		
		JButton btnNewButton_11 = new JButton("+");
		panel_6.add(btnNewButton_11, "cell 2 4,alignx left");
		
		JLabel lblNewLabel_19 = new JLabel("Valor");
		panel_6.add(lblNewLabel_19, "cell 1 6,alignx center");
		
		JLabel lblNewLabel_20 = new JLabel("R$1 500,00");
		panel_6.add(lblNewLabel_20, "cell 1 8,alignx center");
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_8, "cell 7 1,grow");
		panel_8.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][][grow][][grow][][grow][][grow][][grow]"));
		
		JLabel lblNewLabel_25 = new JLabel("Camisa");
		panel_8.add(lblNewLabel_25, "cell 1 1,alignx center");
		
		JLabel lblNewLabel_26 = new JLabel("Quantidade");
		panel_8.add(lblNewLabel_26, "cell 1 3,alignx center");
		
		JButton btnNewButton_14 = new JButton("-");
		panel_8.add(btnNewButton_14, "cell 0 5,alignx right");
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(240, 240, 240));
		panel_8.add(textField_7, "cell 1 5,growx");
		textField_7.setColumns(10);
		
		JButton btnNewButton_15 = new JButton("+");
		panel_8.add(btnNewButton_15, "cell 2 5,alignx left");
		
		JLabel lblNewLabel_27 = new JLabel("Valor");
		panel_8.add(lblNewLabel_27, "cell 1 7,alignx center");
		
		JLabel lblNewLabel_28 = new JLabel("R$ 1 500,00");
		panel_8.add(lblNewLabel_28, "cell 1 9,alignx center");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_3, "cell 1 3,grow");
		panel_3.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][][grow][][grow][][grow][][grow][][grow]"));
		
		JLabel lblNewLabel_5 = new JLabel("Camisa");
		panel_3.add(lblNewLabel_5, "cell 1 1,alignx center,aligny center");
		
		JLabel lblNewLabel_6 = new JLabel("Quantidade");
		panel_3.add(lblNewLabel_6, "cell 1 3,alignx center");
		
		JButton btnNewButton = new JButton("-");
		panel_3.add(btnNewButton, "cell 0 5,alignx right");
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(240, 240, 240));
		panel_3.add(textField_2, "cell 1 5,growx");
		textField_2.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("+");
		panel_3.add(btnNewButton_3, "cell 2 5,alignx left");
		
		JLabel lblNewLabel_7 = new JLabel("Valor");
		panel_3.add(lblNewLabel_7, "cell 1 7,alignx center");
		
		JLabel lblNewLabel_8 = new JLabel("R$1 500,00");
		panel_3.add(lblNewLabel_8, "cell 1 9,alignx center");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_5, "cell 3 3,grow");
		panel_5.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_13 = new JLabel("Camisa");
		panel_5.add(lblNewLabel_13, "cell 1 1,alignx center");
		
		JLabel lblNewLabel_14 = new JLabel("Quantidade");
		panel_5.add(lblNewLabel_14, "cell 1 3,alignx center");
		
		JButton btnNewButton_8 = new JButton("-");
		panel_5.add(btnNewButton_8, "cell 0 5,alignx right");
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(240, 240, 240));
		panel_5.add(textField_4, "cell 1 5,growx");
		textField_4.setColumns(10);
		
		JButton btnNewButton_9 = new JButton("+");
		panel_5.add(btnNewButton_9, "cell 2 5");
		
		JLabel lblNewLabel_15 = new JLabel("Valor");
		panel_5.add(lblNewLabel_15, "cell 1 7,alignx center");
		
		JLabel lblNewLabel_16 = new JLabel("R$ 1 500,00");
		panel_5.add(lblNewLabel_16, "cell 1 10,alignx center");
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_7, "cell 5 3,grow");
		panel_7.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][][grow][][grow][][grow][][grow][][grow]"));
		
		JLabel lblNewLabel_21 = new JLabel("Camisa");
		panel_7.add(lblNewLabel_21, "cell 1 1,alignx center");
		
		JLabel lblNewLabel_22 = new JLabel("Quantidade");
		panel_7.add(lblNewLabel_22, "cell 1 3,alignx center");
		
		JButton btnNewButton_12 = new JButton("-");
		panel_7.add(btnNewButton_12, "cell 0 5,alignx right");
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(240, 240, 240));
		panel_7.add(textField_6, "cell 1 5,growx");
		textField_6.setColumns(10);
		
		JButton btnNewButton_13 = new JButton("+");
		panel_7.add(btnNewButton_13, "cell 2 5,alignx left");
		
		JLabel lblNewLabel_23 = new JLabel("Valor");
		panel_7.add(lblNewLabel_23, "cell 1 7,alignx center");
		
		JLabel lblNewLabel_24 = new JLabel("R$1 500,00");
		panel_7.add(lblNewLabel_24, "cell 1 9,alignx center");
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_9, "cell 7 3,grow");
		panel_9.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][][grow][][grow][][grow][][grow][][grow]"));
		
		JLabel lblNewLabel_29 = new JLabel("Camisa");
		panel_9.add(lblNewLabel_29, "cell 1 1,alignx center");
		
		JLabel lblNewLabel_30 = new JLabel("Quantidade");
		panel_9.add(lblNewLabel_30, "cell 1 3,alignx center");
		
		JButton btnNewButton_16 = new JButton("-");
		panel_9.add(btnNewButton_16, "cell 0 5,alignx right");
		
		textField_8 = new JTextField();
		textField_8.setBackground(new Color(240, 240, 240));
		panel_9.add(textField_8, "cell 1 5,growx");
		textField_8.setColumns(10);
		
		JButton btnNewButton_17 = new JButton("+");
		panel_9.add(btnNewButton_17, "cell 2 5");
		
		JLabel lblNewLabel_31 = new JLabel("Valor");
		panel_9.add(lblNewLabel_31, "cell 1 7,alignx center");
		
		JLabel lblNewLabel_32 = new JLabel("R$1 500,00");
		panel_9.add(lblNewLabel_32, "cell 1 9,alignx center");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(235, 219, 194));
		btnExcluir.setOpaque(true);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnExcluir, "cell 1 5,growx,aligny center");
		
		JButton btnFinalizarPedido = new JButton("Finalizar Pedido");
		btnFinalizarPedido.setBackground(new Color(235, 219, 194));
		btnFinalizarPedido.setOpaque(true);
		btnFinalizarPedido.setBorderPainted(false);
		btnFinalizarPedido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnFinalizarPedido, "cell 3 5,growx,aligny center");
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(new Color(235, 219, 194));
		btnAlterar.setOpaque(true);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnAlterar, "cell 5 5,growx,aligny center");

	}

}
