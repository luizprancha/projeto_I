package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import model.PedidoConfeccao;

public class TelaPedidosConfeccoesCadastrar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfCNPJConfeccao;
	private JTextField tfQuantidade;
	private JTextField tfRetirada;
	private JTextField tfValor;
	private JComboBox<String> cbPgmt;
	private JButton btnConfirmar;

	public TelaPedidosConfeccoesCadastrar() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));

		Font fonte1 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(60f);

		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(15f);

		JLabel lblNewLabel = new JLabel("Alterar Pedido Confecção");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 3 1");
		lblNewLabel.setFont(fonte1);

		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel_1.setForeground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));

		JLabel lblNewLabel_1 = new JLabel("CNPJ:");
		lblNewLabel_1.setFont(fonte2);
		panel_1.add(lblNewLabel_1, "cell 1 1");

		tfCNPJConfeccao = new JTextField();
		tfCNPJConfeccao.setFont(fonte2);
		panel_1.add(tfCNPJConfeccao, "cell 3 1,growx");
		tfCNPJConfeccao.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Quantidade de peças:");
		lblNewLabel_2.setFont(fonte2);
		panel_1.add(lblNewLabel_2, "cell 1 3");

		tfQuantidade = new JTextField();
		tfQuantidade.setFont(fonte2);
		panel_1.add(tfQuantidade, "cell 3 3,growx");
		tfQuantidade.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Data de entrega:");
		lblNewLabel_3.setFont(fonte2);
		panel_1.add(lblNewLabel_3, "cell 1 5");

		tfRetirada = new JTextField();
		tfRetirada.setFont(fonte2);
		panel_1.add(tfRetirada, "cell 3 5,growx");
		tfRetirada.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Valor total:");
		lblNewLabel_4.setFont(fonte2);
		panel_1.add(lblNewLabel_4, "cell 1 7");

		tfValor = new JTextField();
		tfValor.setFont(fonte2);
		panel_1.add(tfValor, "cell 3 7,growx");
		tfValor.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Forma de Pagamento:");
		lblNewLabel_5.setFont(fonte2);
		panel_1.add(lblNewLabel_5, "cell 1 9");

		cbPgmt = new JComboBox<>();
		cbPgmt.setModel(new DefaultComboBoxModel<>(new String[] {"", "Boleto", "Pix", "Cartao Crédito", "Cartao Debito"}));
		cbPgmt.setFont(fonte2);
		panel_1.add(cbPgmt, "cell 3 9,growx");

	    btnConfirmar = new JButtonOutLine();
	    btnConfirmar.setText("Confirmar Alterações");
		btnConfirmar.setFont(fonte2);
		panel.add(btnConfirmar, "cell 2 5,growx");
	}

	public void confirmarAlteracoes(ActionListener acao) {
		btnConfirmar.addActionListener(acao);
	}

	public String getCNPJConfeccao() {
		return tfCNPJConfeccao.getText();
	}

	public String getQuantidadePecas() {
		return tfQuantidade.getText();
	}

	public String getDataRetirada() {
		return tfRetirada.getText();
	}

	public String getValorTotal() {
		return tfValor.getText();
	}

	public String getFormaPgmt() {
		Object selecionado = cbPgmt.getSelectedItem();
		return selecionado != null ? selecionado.toString() : "";
	}

	public void setPedido(PedidoConfeccao pedido) {
		tfCNPJConfeccao.setText(pedido.getConfeccoesCNPJ() != null ? pedido.getConfeccoesCNPJ() : "");
		tfQuantidade.setText(String.valueOf(pedido.getQuantidade()));
		if (pedido.getEntrega() != null) {
			tfRetirada.setText(pedido.getEntrega().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		} else {
			tfRetirada.setText("");
		}
		tfValor.setText(String.valueOf(pedido.getValorPedido()));

		String formaPgmt = pedido.getForma_pgm();
		if (formaPgmt != null && !formaPgmt.isEmpty()) {
			cbPgmt.setSelectedItem(formaPgmt);
		} else {
			cbPgmt.setSelectedIndex(0);
		}
	}
}
