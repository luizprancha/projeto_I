package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JPasswordField;

public class TelaCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfUsuario;
	private JTextField tfCargo;
	private JPasswordField pfSenha;
	Color begeFundo = new Color(235, 219, 194);

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaCadastro() throws FontFormatException, IOException {
		setBackground(new Color(15, 57, 87));
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("../fontes/Jomhuria-Regular.ttf")
		).deriveFont(150f);
		
		Font fonteInter = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("../fontes/Inter.ttf")
		).deriveFont(15f);
		
		JLabel lbBemVindo = new JLabel("Bem-vindo");
		lbBemVindo.setForeground(new Color(235, 219, 194));
		add(lbBemVindo, "cell 1 1 5 1,alignx center,aligny center");
		lbBemVindo.setFont(fonte);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(235, 219, 194));
		add(panel, "cell 2 3 3 1,grow");
		panel.setLayout(new MigLayout("", "[grow][][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbNome = new JLabel("Nome");
		lbNome.setFont(fonteInter);
		panel.add(lbNome, "cell 1 1,growx");
		
		tfNome = new JTextField();
		panel.add(tfNome, "cell 3 1,growx");
		tfNome.setFont(fonteInter);
		tfNome.setColumns(10);
		
		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setFont(fonteInter);
		panel.add(lbUsuario, "cell 1 3,growx");
		
		tfUsuario = new JTextField();
		panel.add(tfUsuario, "cell 3 3,growx");
		tfUsuario.setColumns(10);
		tfUsuario.setFont(fonteInter);
		
		JLabel lbCargo = new JLabel("Cargo");
		lbCargo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lbCargo, "cell 1 5,growx");
		lbCargo.setFont(fonteInter);
		
		tfCargo = new JTextField();
		panel.add(tfCargo, "cell 3 5,growx");
		tfCargo.setColumns(10);
		tfCargo.setFont(fonteInter);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lbSenha, "cell 1 7,growx");
		lbSenha.setFont(fonteInter);
		
		pfSenha = new JPasswordField();
		panel.add(pfSenha, "cell 3 7,growx");
		
		JButton btnCadastro = new JButton("Solicitar Cadastro");
		add(btnCadastro, "cell 3 5,grow");
		btnCadastro.setBackground(begeFundo);
		btnCadastro.setOpaque(true);
		btnCadastro.setBorderPainted(false); // opcional
		btnCadastro.setFocusPainted(false);  // opcional
		btnCadastro.setFont(fonteInter);

	}

}
