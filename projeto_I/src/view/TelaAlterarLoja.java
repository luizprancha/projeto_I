package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;
import model.Lojas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaAlterarLoja extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeLoja;
	private JTextField tfCNPJ;
	private JTextField tfTelefone;
	private JButton btnAlterarLoja;
	private JTextField tfResponsavel;
	private JTextField tfEndereco;
	private JTextField tfEmail;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaAlterarLoja() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(80f);
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(18f);
		
		JLabel lblNewLabel = new JLabel("Alterar Loja");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 2 1,alignx center,growy");
		lblNewLabel.setFont(fonte);
		
		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbNomeLoja = new JLabel("Nome da loja:");
		lbNomeLoja.setFont(fonte2);
		panel_1.add(lbNomeLoja, "cell 1 1");
		
		tfNomeLoja = new JTextField();
		tfNomeLoja.setFont(fonte2);
		panel_1.add(tfNomeLoja, "cell 3 1,growx");
		tfNomeLoja.setColumns(10);
		
		JLabel lbCNPJ = new JLabel("CNPJ:");
		lbCNPJ.setFont(fonte2);
		panel_1.add(lbCNPJ, "cell 1 3");
		
		tfCNPJ = new JTextField();
		tfCNPJ.setFont(fonte2);
		panel_1.add(tfCNPJ, "cell 3 3,growx");
		tfCNPJ.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Responsável:");
		lblNewLabel_1.setFont(fonte2);
		panel_1.add(lblNewLabel_1, "cell 1 5");
		
		tfResponsavel = new JTextField();
		tfResponsavel.setFont(fonte2);
		panel_1.add(tfResponsavel, "cell 3 5,growx");
		tfResponsavel.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Endereço:");
		lblNewLabel_2.setFont(fonte2);
		panel_1.add(lblNewLabel_2, "cell 1 7");
		
		tfEndereco = new JTextField();
		tfEndereco.setFont(fonte2);
		panel_1.add(tfEndereco, "cell 3 7,growx");
		tfEndereco.setColumns(10);
		
		JLabel lbEndereco = new JLabel("Telefone:");
		lbEndereco.setFont(fonte2);
		panel_1.add(lbEndereco, "cell 1 9");
		
		tfTelefone = new JTextField();
		tfTelefone.setFont(fonte2);
		panel_1.add(tfTelefone, "cell 3 9,growx");
		tfTelefone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(fonte2);
		panel_1.add(lblNewLabel_3, "cell 1 11");
		
		tfEmail = new JTextField();
		tfEmail.setFont(fonte2);
		panel_1.add(tfEmail, "cell 3 11,growx");
		tfEmail.setColumns(10);
		
		btnAlterarLoja = new JButtonOutLine();
		btnAlterarLoja.setText("Alterar");
		btnAlterarLoja.setFont(fonte2);
		panel.add(btnAlterarLoja, "cell 2 5,growx,aligny center");

	}
	
	public String getNomeLoja() {
		return tfNomeLoja.getText();
	}
	
	public String getCNPJ() {
		return tfCNPJ.getText();
	}
	
	public String getResponsavel() {
		return tfResponsavel.getText();
	}
	
	public String getEndereco() {
		return tfEndereco.getText();
	}
	
	public String getTelefone() {
		return tfTelefone.getText();
	}
	
	public String getEmail() {
		return tfEmail.getText();
	}
	
	public void alterarLoja(ActionListener acao) {
		btnAlterarLoja.addActionListener(acao);
	}
	public void limparCampos() {
		tfNomeLoja.setText("");
		tfCNPJ.setText("");
		tfResponsavel.setText("");
		tfEndereco.setText("");
		tfTelefone.setText("");
		tfEmail.setText("");
	}
	public void exibirMensagem(String titulo, String mensagem, int tipo) {
	    TelaMensagem.mostrar(titulo, mensagem);
	}
	
	public void setLojas(Lojas loja) {
		tfNomeLoja.setText(loja.getNome());
		tfCNPJ.setText(loja.getCnpj());
		tfResponsavel.setText(loja.getResponsavel());
		tfEndereco.setText(loja.getEndereco());
		tfTelefone.setText(loja.getTelefone());
		tfEmail.setText(loja.getEmail());
	}

}
