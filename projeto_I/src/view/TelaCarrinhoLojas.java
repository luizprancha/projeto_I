package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class TelaCarrinhoLojas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfBuscar;
	private JTextField tfQuantidade;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	private JButton btnExcluir; 
	private JButton btnFinalizarPedido; 
	private JButton btnAlterarPedido;

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
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(80f);
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(15f);
		
		
		JLabel lblNewLabel = new JLabel("Carrinho de pedidos ");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 4 1");
		lblNewLabel.setFont(fonte);
		
		tfBuscar = new JTextField();
		panel.add(tfBuscar, "cell 5 1,growx");
		tfBuscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 3 5 1,grow");
		
		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow 10][grow][grow 10][grow][grow 10][grow][grow 10]", "[grow 5][grow][grow 5][][grow 5]"));
		
		PainelArredondado panel_2 = new PainelArredondado();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_2, "cell 1 1,grow");
		panel_2.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbCamisa = new JLabel("Camisa");
		panel_2.add(lbCamisa, "cell 1 1,alignx center,growy");
		lbCamisa.setFont(fonte2);
		
		JLabel lbQuantidade = new JLabel("Quantidade");
		panel_2.add(lbQuantidade, "cell 1 3,alignx center,aligny center");
		lbQuantidade.setFont(fonte2);
		
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
		lbValor.setFont(fonte2);
		
		JLabel lbTotal = new JLabel("R$1 500,00");
		panel_2.add(lbTotal, "cell 1 8,alignx center");
		lbTotal.setFont(fonte2);
		
		PainelArredondado panel_4 = new PainelArredondado();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_4, "cell 3 1,grow");
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_9 = new JLabel("Camisa");
		panel_4.add(lblNewLabel_9, "cell 1 1,alignx center");
		lblNewLabel_9.setFont(fonte2);
		
		JLabel lblNewLabel_10 = new JLabel("Quantidade");
		panel_4.add(lblNewLabel_10, "cell 1 2,alignx center");
		lblNewLabel_10.setFont(fonte2);
		
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
		lblNewLabel_11.setFont(fonte2);
		
		
		JLabel lblNewLabel_12 = new JLabel("R$1500,00");
		panel_4.add(lblNewLabel_12, "cell 1 7,alignx center");
		lblNewLabel_12.setFont(fonte2);
		
		
		PainelArredondado panel_6 = new PainelArredondado();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_6, "cell 5 1,grow");
		panel_6.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_17 = new JLabel("Camisa");
		panel_6.add(lblNewLabel_17, "cell 1 1,alignx center");
		lblNewLabel_17.setFont(fonte2);
		
		
		JLabel lblNewLabel_18 = new JLabel("Quantidade");
		panel_6.add(lblNewLabel_18, "cell 1 2,alignx center");
		lblNewLabel_18.setFont(fonte2);
		
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
		lblNewLabel_19.setFont(fonte2);
		
		JLabel lblNewLabel_20 = new JLabel("R$1 500,00");
		panel_6.add(lblNewLabel_20, "cell 1 8,alignx center");
		lblNewLabel_20.setFont(fonte2);
		
		PainelArredondado panel_3= new PainelArredondado();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_3, "cell 1 3,grow");
		panel_3.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][][grow][][grow][][grow][][grow][][grow]"));
		
		JLabel lblNewLabel_5 = new JLabel("Camisa");
		panel_3.add(lblNewLabel_5, "cell 1 1,alignx center,aligny center");
		lblNewLabel_5.setFont(fonte2);
		
		JLabel lblNewLabel_6 = new JLabel("Quantidade");
		panel_3.add(lblNewLabel_6, "cell 1 3,alignx center");
		lblNewLabel_6.setFont(fonte2);
		
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
		lblNewLabel_7.setFont(fonte2);
		
		JLabel lblNewLabel_8 = new JLabel("R$1 500,00");
		panel_3.add(lblNewLabel_8, "cell 1 9,alignx center");
		lblNewLabel_8.setFont(fonte2);
		
		PainelArredondado panel_5 = new PainelArredondado();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_5, "cell 3 3,grow");
		panel_5.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_13 = new JLabel("Camisa");
		panel_5.add(lblNewLabel_13, "cell 1 1,alignx center");
		lblNewLabel_13.setFont(fonte2);
		
		JLabel lblNewLabel_14 = new JLabel("Quantidade");
		panel_5.add(lblNewLabel_14, "cell 1 3,alignx center");
		lblNewLabel_14.setFont(fonte2);
		
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
		lblNewLabel_15.setFont(fonte2);
		
		JLabel lblNewLabel_16 = new JLabel("R$ 1 500,00");
		panel_5.add(lblNewLabel_16, "cell 1 10,alignx center");
		lblNewLabel_16.setFont(fonte2);
		
		PainelArredondado panel_7 = new PainelArredondado();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_7, "cell 5 3,grow");
		panel_7.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][][grow][][grow][][grow][][grow][][grow]"));
		
		JLabel lblNewLabel_21 = new JLabel("Camisa");
		panel_7.add(lblNewLabel_21, "cell 1 1,alignx center");
		lblNewLabel_21.setFont(fonte2);
		
		JLabel lblNewLabel_22 = new JLabel("Quantidade");
		panel_7.add(lblNewLabel_22, "cell 1 3,alignx center");
		lblNewLabel_22.setFont(fonte2);
		
		
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
		lblNewLabel_23.setFont(fonte2);
		
		JLabel lblNewLabel_24 = new JLabel("R$1 500,00");
		panel_7.add(lblNewLabel_24, "cell 1 9,alignx center");
		lblNewLabel_24.setFont(fonte2);
		
		btnExcluir = new JButtonOutLine();
		btnExcluir.setText("Excluir");
		btnExcluir.setFont(fonte2);
		panel.add(btnExcluir, "cell 1 5,growx,aligny center");
		

		btnFinalizarPedido = new JButtonOutLine();
		btnFinalizarPedido.setText("Finalizar Pedido");
		btnFinalizarPedido.setFont(fonte2);
		panel.add(btnFinalizarPedido, "cell 3 5,growx,aligny center");
		
		btnAlterarPedido = new JButtonOutLine();
		btnAlterarPedido.setText("Alterar Pedido");
		btnAlterarPedido.setFont(fonte2);
		panel.add(btnAlterarPedido, "cell 5 5,growx,aligny center");

	}
	
	public void excluir(ActionListener acao) {
		btnExcluir.addActionListener(acao);
	}
	
	public void finalizarPedido(ActionListener acao) {
		btnFinalizarPedido.addActionListener(acao);
	}
	
	public void alterarPedido (ActionListener acao) {
		btnAlterarPedido.addActionListener(acao);
	}

}
