package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.JTextField;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuario;
	private JTextField tfSenha;
	private JButton btnEntrar;
	private JButton btnCadastro; 

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaLogin() throws FontFormatException, IOException {		
		setBackground(new Color(15, 57, 87));
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow 20][grow][grow 20][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(140f);
		
		JLabel lbTitulo = new JLabel("Nó de Estoque");
		lbTitulo.setFont(fonte);
		lbTitulo.setForeground(new Color(235, 219, 194));
		lbTitulo.setBackground(new Color(235, 219, 194));
		add(lbTitulo, "cell 1 1 5 1,alignx center,aligny center");
		
		
		
		PainelArredondado lbSenha = new PainelArredondado();
		lbSenha.setBackground(new Color(235, 219, 194));
		add(lbSenha, "cell 2 3 3 1,grow");
		lbSenha.setLayout(new MigLayout("", "[grow][grow][::20px][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
	
		
		Font fonte3 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(15f);
		
		JLabel lbUsuario = new JLabel("Usuário:");
		lbUsuario.setFont(fonte3);
		lbSenha.add(lbUsuario, "cell 1 1,grow");
	
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(fonte3);
		lbSenha.add(tfUsuario, "cell 3 1,grow");
		tfUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(fonte3);
		lbSenha.add(lblNewLabel_2, "cell 1 3,grow");

		
		tfSenha = new JTextField();
		tfSenha.setFont(fonte3);
		lbSenha.add(tfSenha, "cell 3 3,grow");
		tfSenha.setColumns(10);
		
		btnEntrar = new JButtonOutLine();
		btnEntrar.setText("Entrar");
		btnEntrar.setFont(fonte3);
		add(btnEntrar, "cell 3 5,grow");
		
		btnCadastro = new JButtonOutLine();
		btnCadastro.setText("Solicitar Cadastro");
		btnCadastro.setFont(fonte3);
		add(btnCadastro, "cell 3 7,grow");
	}
		
		public void entrar(ActionListener al) {
			btnEntrar.addActionListener(al);
		}

		public void irParaCadastro(ActionListener al) {
			btnCadastro.addActionListener(al);
		}

		public String getUsuario() {
			return tfUsuario.getText();
		}

		public String getSenha() {
			return tfSenha.getText();
		}
		
	

		public void exibirMensagem(String titulo, String mensagem, int tipo) {
			JOptionPane.showMessageDialog(this, mensagem, titulo, tipo);
		}
	

		
	

}
