package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField tfNome;
	private JTextField tfUsuario;
	private JTextField tfCargo;
	private JPasswordField tfSenha;

	
	private JButton btnCadastro;

	Color begeFundo = new Color(235, 219, 194);
	private JLabel lbNome;
	private JLabel lbUsuario;
	private JLabel lbCargo;
	private JLabel lbSenha;

	public TelaCadastro() throws FontFormatException, IOException {
		setBackground(new Color(15, 57, 87));
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));

		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(150f);

		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(18f);
		

		JLabel lbBemVindo = new JLabel("Bem-vindo");
		lbBemVindo.setForeground(begeFundo);
		lbBemVindo.setFont(fonte);
		add(lbBemVindo, "cell 1 1 5 1,alignx center,aligny center");

		PainelArredondado panel = new PainelArredondado();
		panel.setBackground(begeFundo);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		add(panel, "cell 2 2 3 2,grow");
		
		lbNome = new JLabel("Nome:");
		lbNome.setFont(fonte2);
		panel.add(lbNome, "cell 1 1");
		tfNome = new JTextField();
		tfNome.setFont(fonte2);
		panel.add(tfNome, "cell 2 1,growx");
		
		lbUsuario = new JLabel("Usuário:");
		lbUsuario.setFont(fonte2);
		panel.add(lbUsuario, "cell 1 3");
		tfUsuario = new JTextField();
		tfUsuario.setFont(fonte2);
		panel.add(tfUsuario, "cell 2 3,growx");
		
		lbCargo = new JLabel("Cargo:");
		lbCargo.setFont(fonte2);
		panel.add(lbCargo, "cell 1 5");
		tfCargo = new JTextField();
		tfCargo.setFont(fonte2);
		panel.add(tfCargo, "cell 2 5,growx");
		
		lbSenha = new JLabel("Senha:");
		lbSenha.setFont(fonte2);
		panel.add(lbSenha, "cell 1 7");
		
		tfSenha = new JPasswordField();
		tfSenha.setFont(fonte2);
		panel.add(tfSenha, "cell 2 7,growx");

		btnCadastro = new JButtonOutLine();
		btnCadastro.setText("Solicitar Cadastro");
		btnCadastro.setFont(fonte2);
		add(btnCadastro, "cell 3 5,grow");
	}



	public String getNome() {
		return tfNome.getText();
	}

	public String getUsuario() {
		return tfUsuario.getText();
	}

	public String getCargo() {
		return tfCargo.getText();
	}

	public String getSenha() {
		return new String(tfSenha.getPassword());
	}


	public void cadastrar(ActionListener actionListener) {
		btnCadastro.addActionListener(actionListener);
	}


	public void exibirMensagem(String titulo, String mensagem, int tipo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
	}
	
	public void irParaLogin(ActionListener al) {
		btnCadastro.addActionListener(al);
	}

	
	public void limparFormulario() {
		tfNome.setText("");
		tfUsuario.setText("");
		tfCargo.setText("");
		tfSenha.setText("");
	}
}