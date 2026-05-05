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

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaCadastroConfeccao extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfResponsavel;
	private JTextField tfEndereco;
	private JTextField tfEmail;
	private JButton btnCadastrarConfeccao;
	private JTextField tfTelefone;
	private JTextField tfNomeConfeccao;
	private JTextField tfCNPJ;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaCadastroConfeccao() throws FontFormatException, IOException {
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
		
		
		JLabel lblNewLabel = new JLabel("Cadastro Confecção");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 3 1,alignx center,growy");
		lblNewLabel.setFont(fonte);
		
		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbNomeConfeccao = new JLabel("Nome da confecção:");
		lbNomeConfeccao.setFont(fonte2);
		panel_1.add(lbNomeConfeccao, "cell 2 1");
		
		tfNomeConfeccao = new JTextField();
		panel_1.add(tfNomeConfeccao, "cell 4 1,growx");
		tfNomeConfeccao.setColumns(10);
		
		JLabel lbResponsavel = new JLabel("Responsável");
		panel_1.add(lbResponsavel, "cell 2 3");
		lbResponsavel.setFont(fonte2);
		
		tfResponsavel = new JTextField();
		tfResponsavel.setFont(fonte2);
		panel_1.add(tfResponsavel, "cell 4 3,growx");
		tfResponsavel.setColumns(10);
		
		JLabel lbTelefone = new JLabel("Telefone");
		panel_1.add( lbTelefone, "cell 2 5");
		 lbTelefone.setFont(fonte2);
		
		tfTelefone = new JTextField();
		panel_1.add(tfTelefone, "cell 4 5,grow");
		tfTelefone.setColumns(10);
		
		JLabel lbCNPJ = new JLabel("CNPJ:");
		lbCNPJ.setFont(fonte2);
		panel_1.add(lbCNPJ, "cell 2 7");
		
	    tfCNPJ = new JTextField();
		panel_1.add(tfCNPJ, "cell 4 7,grow");
		tfCNPJ.setColumns(10);
		
		JLabel lbEndereco = new JLabel("Endereço");
		panel_1.add( lbEndereco, "cell 2 9");
		 lbEndereco.setFont(fonte2);
		 
		tfEndereco = new JTextField();
		tfEndereco.setFont(fonte2);
		panel_1.add(tfEndereco, "cell 4 9,growx");
		tfEndereco.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		panel_1.add(lblNewLabel_2, "cell 2 11");
		lblNewLabel_2.setFont(fonte2);
		
		tfEmail = new JTextField();
		tfEmail.setFont(fonte2);
		panel_1.add(tfEmail, "cell 4 11,growx");
		tfEmail.setColumns(10);
		
		btnCadastrarConfeccao = new JButtonOutLine();
		btnCadastrarConfeccao.setText("Cadastrar Confecção");
		btnCadastrarConfeccao.setFont(fonte2);
		panel.add(btnCadastrarConfeccao, "cell 2 5,growx,aligny center");

	}
	
	public String getEndereco() {
		return tfEndereco.getText();
	}
	
	public String getEmail() {
		return tfEmail.getText();
	}
	
	public String getCnpj() {
		return tfCNPJ.getText();
	}
	
	public String getNome() {
		return tfNomeConfeccao.getText();
	}
	
	public String getResponsavel() {
		return tfResponsavel.getText();
	}
	
	public String getTelefone() {
		return tfTelefone.getText();
	}
	
	
	
	public void cadastrarConfeccao (ActionListener acao) {
		btnCadastrarConfeccao.addActionListener(acao);
	}
	
	public void limparCampos() {
		tfEndereco.setText("");
		tfEmail.setText("");
		tfCNPJ.setText("");
		tfNomeConfeccao.setText("");
		tfResponsavel.setText("");
		tfTelefone.setText("");
	}
	
	public void exibirMensagem(String titulo, String mensagem, int tipo) {
		JOptionPane.showMessageDialog(this, mensagem, titulo, tipo);
	}
	

}
