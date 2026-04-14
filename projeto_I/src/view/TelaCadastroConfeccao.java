package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class TelaCadastroConfeccao extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeConfecção;
	private JTextField tfCNPJ;
	private JTextField tfEndereço;

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
		
		JLabel lblNewLabel = new JLabel("Cadastro Confecção");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 3 1,alignx center,growy");
		lblNewLabel.setFont(fonte);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbNomeConfeccao = new JLabel("Nome da confecção:");
		lbNomeConfeccao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lbNomeConfeccao, "cell 1 1");
		
		tfNomeConfecção = new JTextField();
		tfNomeConfecção.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(tfNomeConfecção, "cell 3 1,growx");
		tfNomeConfecção.setColumns(10);
		
		JLabel lbCNPJ = new JLabel("CNPJ:");
		lbCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lbCNPJ, "cell 1 3");
		
		tfCNPJ = new JTextField();
		tfCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(tfCNPJ, "cell 3 3,growx");
		tfCNPJ.setColumns(10);
		
		JLabel lbEndereco = new JLabel("Endereço:");
		lbEndereco.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lbEndereco, "cell 1 5");
		
		tfEndereço = new JTextField();
		tfEndereço.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(tfEndereço, "cell 3 5,growx");
		tfEndereço.setColumns(10);
		
		JButton btnCadastrarConfecção = new JButton("Cadastrar Confecção");
		btnCadastrarConfecção.setBackground(new Color(235, 219, 194));
		btnCadastrarConfecção.setOpaque(true);
		btnCadastrarConfecção.setBorderPainted(false);
		btnCadastrarConfecção.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnCadastrarConfecção, "cell 2 5,growx,aligny center");

	}

}
