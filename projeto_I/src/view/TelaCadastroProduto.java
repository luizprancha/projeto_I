package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JTextField;

public class TelaCadastroProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomepeca;
	private JTextField tfTipoProduto;
	private JTextField tfPreco;
	private JTextField tfQuantidade;
	private JTextField tfTamanho;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaCadastroProduto() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		panel.setForeground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(100f);
		
		JLabel lbCadastro = new JLabel("Cadastro Produto");
		lbCadastro.setForeground(new Color(235, 219, 194));
		lbCadastro.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lbCadastro, "cell 1 1 5 1,alignx left,growy");
		lbCadastro.setFont(fonte);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 5 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbNomePeca = new JLabel("Nome da peça:");
		panel_1.add(lbNomePeca, "cell 1 1");
		
		tfNomepeca = new JTextField();
		panel_1.add(tfNomepeca, "cell 3 1,growx");
		tfNomepeca.setColumns(10);
		
		JLabel lbTipoProduto = new JLabel("Tipo de produto:");
		panel_1.add(lbTipoProduto, "cell 1 3");
		
		tfTipoProduto = new JTextField();
		panel_1.add(tfTipoProduto, "cell 3 3,growx");
		tfTipoProduto.setColumns(10);
		
		JLabel lbPreco = new JLabel("Preço R$:");
		panel_1.add(lbPreco, "cell 1 5");
		
		tfPreco = new JTextField();
		panel_1.add(tfPreco, "cell 3 5,growx");
		tfPreco.setColumns(10);
		
		JLabel lbQuantidade = new JLabel("Quantidade:");
		panel_1.add(lbQuantidade, "cell 1 7");
		
		tfQuantidade = new JTextField();
		panel_1.add(tfQuantidade, "cell 3 7,growx");
		tfQuantidade.setColumns(10);
		
		JLabel lbTamanho = new JLabel("Tamanho:");
		panel_1.add(lbTamanho, "cell 1 9");
		
		tfTamanho = new JTextField();
		panel_1.add(tfTamanho, "cell 3 9,growx");
		tfTamanho.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setOpaque(false);
		btnCadastrar.setBorderPainted(false);
          
		btnCadastrar.setContentAreaFilled(true);
		btnCadastrar.setOpaque(true);
		btnCadastrar.setBorderPainted(false);

		btnCadastrar.setBackground(new Color(235, 219, 194 ));
		panel.add(btnCadastrar, "cell 3 5,growx");

	}

}
