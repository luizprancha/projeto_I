package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.JTextField;

public class TelaAlterarCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfUsuario;
	private JTextField tfCargo;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaAlterarCadastro() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow 60][grow][grow]", "[grow 10][grow][grow 10][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(100f);
		
		
		JLabel lblNewLabel = new JLabel("Alterar Cadastro");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1,alignx left");
		lblNewLabel.setFont(fonte);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 2 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow 70][grow 50][grow][grow 30][grow 30][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbNomeCadastro = new JLabel("Nome:");
		lbNomeCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lbNomeCadastro, "cell 1 1");
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNome.setText("Sofia Martins Pascoalini");
		panel_1.add(tfNome, "cell 2 1 3 1,growx");
		tfNome.setColumns(10);
		
		JLabel lbUsuarioCadastro = new JLabel("Usuário:");
		lbUsuarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lbUsuarioCadastro, "cell 1 3");
		
		tfUsuario = new JTextField();
		tfUsuario.setText("somapa");
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(tfUsuario, "cell 2 3 3 1,growx");
		tfUsuario.setColumns(10);
		
		JLabel lbCargoCadastro = new JLabel("Cargo:");
		lbCargoCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lbCargoCadastro, "cell 1 5");
		
		tfCargo = new JTextField();
		tfCargo.setText("Vendedor(a)");
		tfCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(tfCargo, "cell 2 5 3 1,growx");
		tfCargo.setColumns(10);
		
		JLabel lbPermissaoCadastro = new JLabel("Permissão:");
		lbPermissaoCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lbPermissaoCadastro, "cell 1 7");
		
		JRadioButton rdbUsuario = new JRadioButton("Usuário");
		rdbUsuario.setBackground(new Color(235, 219, 194));
		rdbUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(rdbUsuario, "cell 2 7,alignx left");
		
		JRadioButton rdbAdministrador = new JRadioButton("Administrador");
		rdbAdministrador.setBackground(new Color(235, 219, 194));
		rdbAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(rdbAdministrador, "cell 4 7 2 1,alignx left");
		
		
		
		JButton btnUsuario = new JButton("Remover usuário");
		btnUsuario.setBackground(new Color(255, 255, 255));
		btnUsuario.setOpaque(true);
		btnUsuario.setBorderPainted(false);
		btnUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnUsuario, "cell 1 9 2 1,grow");
		
		JButton btnConfirmar = new JButton("Confirmar Alterações");
		btnConfirmar.setBackground(new Color(255, 255, 255));
		btnConfirmar.setOpaque(true);
		btnConfirmar.setBorderPainted(false);
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnConfirmar, "cell 4 9 2 1,grow");

	}

}
