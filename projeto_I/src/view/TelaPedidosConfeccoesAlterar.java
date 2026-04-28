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
import java.awt.event.ActionEvent;

public class TelaPedidosConfeccoesAlterar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfConfeccao;
	private JTextField tfQuantidade;
	private JTextField tfEntrega;
	private JTextField tfValor;
	private JButton btnConfirmar;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaPedidosConfeccoesAlterar() throws FontFormatException, IOException {
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
		
		JLabel lblNewLabel = new JLabel("Pedidos Confecções");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 3 1");
		lblNewLabel.setFont(fonte1);
		
		
		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel_1.setForeground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Confecção:");
		lblNewLabel_1.setFont(fonte2);
		panel_1.add(lblNewLabel_1, "cell 1 1");
		
		tfConfeccao = new JTextField();
		tfConfeccao.setFont(fonte2);
		panel_1.add(tfConfeccao, "cell 3 1,growx");
		tfConfeccao.setColumns(10);
		
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
		
		tfEntrega = new JTextField();
		tfEntrega.setFont(fonte2);
		panel_1.add(tfEntrega, "cell 3 5,growx");
		tfEntrega.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Valor total:");
		lblNewLabel_4.setFont(fonte2);
		panel_1.add(lblNewLabel_4, "cell 1 7");
		
		tfValor = new JTextField();
		tfValor.setFont(fonte2);
		panel_1.add(tfValor, "cell 3 7,growx");
		tfValor.setColumns(10);
		
	    btnConfirmar = new JButtonOutLine();
	    btnConfirmar.setText("Confirmar Alterações");
		btnConfirmar.setFont(fonte2);
		panel.add(btnConfirmar, "cell 2 5,growx");

	}
	
	public void confirmarAlteracoes (ActionListener acao) {
		btnConfirmar.addActionListener(acao);
	}
	
	public String getEntrega() {
		return tfConfeccao.getText();
	}
	
	public String getQuantidadePecas() {
		return tfQuantidade.getText();
	}
	public String getDataEntrega() {
		return tfEntrega.getText();
	}
	
	public String getValorTotal() {
		return tfValor.getText();
	}
}
