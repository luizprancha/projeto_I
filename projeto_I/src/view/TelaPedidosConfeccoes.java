package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaPedidosConfeccoes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfEntrega;
	private JButtonOutLine btnFinalizar;
	private JTextField tfCNPJ;
	private JTextField tfQtdePecas;
	private JTextField tfValorTotal;
	private JLabel lbQtdeMateriaPrima;
	private JComboBox cbPgmt;
	
	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaPedidosConfeccoes() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte1 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
		).deriveFont(50f);
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(18f);
		
		JLabel lblNewLabel = new JLabel("Pedidos Confecções");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 3 1");
		lblNewLabel.setFont(fonte1);
		
		
		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel_1.setForeground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_5 = new JLabel("CNPJ:");
		lblNewLabel_5.setFont(fonte2);
		panel_1.add(lblNewLabel_5, "cell 1 1");
		
		tfCNPJ = new JTextField();
		tfCNPJ.setFont(fonte2);
		panel_1.add(tfCNPJ, "cell 3 1,growx");
		tfCNPJ.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade de peças:");
		lblNewLabel_2.setFont(fonte2);
		panel_1.add(lblNewLabel_2, "cell 1 3");
		
		tfQtdePecas = new JTextField();
		tfQtdePecas.setFont(fonte2);
		panel_1.add(tfQtdePecas, "cell 3 3,growx");
		tfQtdePecas.setColumns(10);

		JLabel lblQtdeMateriaPrima = new JLabel("Quantidade de Matéria-Prima:");
		lblQtdeMateriaPrima.setFont(fonte2);
		panel_1.add(lblQtdeMateriaPrima, "cell 1 5");

		lbQtdeMateriaPrima = new JLabel("0");
		lbQtdeMateriaPrima.setFont(fonte2);
		panel_1.add(lbQtdeMateriaPrima, "cell 3 5");
		
		JLabel lblNewLabel_3 = new JLabel("Data de entrega:");
		lblNewLabel_3.setFont(fonte2);
		panel_1.add(lblNewLabel_3, "cell 1 7");
		
		tfEntrega = new JTextField();
		tfEntrega.setFont(fonte2);
		panel_1.add(tfEntrega, "cell 3 7,growx");
		tfEntrega.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Valor total:");
		lblNewLabel_4.setFont(fonte2);
		panel_1.add(lblNewLabel_4, "cell 1 9");
		
		tfValorTotal = new JTextField();
		tfValorTotal.setFont(fonte2);
		panel_1.add(tfValorTotal, "cell 3 9,growx");
		tfValorTotal.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Forma de Pagamento:");
		lblNewLabel_6.setFont(fonte2);
		panel_1.add(lblNewLabel_6, "cell 1 11");
		
		cbPgmt = new JComboBox();
		cbPgmt.setModel(new DefaultComboBoxModel(new String[] {"", "Boleto", "Pix", "Cartao Crédito", "Cartao Debito"}));
		cbPgmt.setFont(fonte2);
		panel_1.add(cbPgmt, "cell 3 11,growx");
		
		btnFinalizar = new JButtonOutLine();
		btnFinalizar.setText("Finalizar Pedido");
		btnFinalizar.setBackground(new Color(235, 219, 194));
		btnFinalizar.setFont(fonte2);
		panel.add(btnFinalizar, "cell 2 5,growx");

	}
	
		public void finalizarPedido (ActionListener acao) {
			btnFinalizar.addActionListener(acao);
		}
		
		public String getCNPJ() {
			return tfCNPJ.getText();
		}
		
		public int getQtdePecas() {
			return Integer.parseInt(tfQtdePecas.getText()); 
		}
		
		public LocalDate getDataEntrega() {
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    return LocalDate.parse(tfEntrega.getText(), formatter);
		}
		
		public double getValorTotal() {
			return Double.parseDouble(tfValorTotal.getText());
		}
		
		public String getFormaPgmt() {
			Object selecionado = cbPgmt.getSelectedItem();
			return selecionado != null ? selecionado.toString() : "";
		}

		public void limparCampos() {
			tfCNPJ.setText("");
			tfQtdePecas.setText("");
			lbQtdeMateriaPrima.setText("0");
			tfEntrega.setText("");
			tfValorTotal.setText("");
			cbPgmt.setSelectedIndex(0);
		}

		public void setQuantidadeMateriaPrima(int quantidade) {
			lbQtdeMateriaPrima.setText(String.valueOf(quantidade));
		}

}
