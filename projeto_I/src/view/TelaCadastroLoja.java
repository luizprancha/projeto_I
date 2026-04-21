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
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaCadastroLoja extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeLoja;
	private JTextField tfCNPJ;
	private JTextField tfEndereco;
	private JButton btnCadastroLoja;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaCadastroLoja() throws FontFormatException, IOException {
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
		
		JLabel lblNewLabel = new JLabel("Cadastro Loja");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 2 1,alignx center,growy");
		lblNewLabel.setFont(fonte);
		
		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbNomeLoja = new JLabel("Nome da loja:");
		lbNomeLoja.setFont(fonte2);
		panel_1.add(lbNomeLoja, "cell 1 1");
		
		tfNomeLoja = new JTextField();
		tfNomeLoja.setFont(fonte2);
		panel_1.add(tfNomeLoja, "cell 3 1,growx");
		tfNomeLoja.setColumns(10);
		
		JLabel lbCNPJ = new JLabel("CNPJ:");
		lbCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lbCNPJ, "cell 1 3");
		
		tfCNPJ = new JTextField();
		tfCNPJ.setFont(fonte2);
		panel_1.add(tfCNPJ, "cell 3 3,growx");
		tfCNPJ.setColumns(10);
		
		JLabel lbEndereco = new JLabel("Endereço:");
		lbEndereco.setFont(fonte2);
		panel_1.add(lbEndereco, "cell 1 5");
		
		tfEndereco = new JTextField();
		tfEndereco.setFont(fonte2);
		panel_1.add(tfEndereco, "cell 3 5,growx");
		tfEndereco.setColumns(10);
		
		btnCadastroLoja = new JButtonOutLine();
		btnCadastroLoja.setText("Cadastrar Loja");
		btnCadastroLoja.setFont(fonte2);
		panel.add(btnCadastroLoja, "cell 2 5,growx,aligny center");

	}
	
	public void cadastro(ActionListener acao) {
		btnCadastroLoja.addActionListener(acao);
	}

}
