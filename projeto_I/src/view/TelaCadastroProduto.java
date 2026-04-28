package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JTextField;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomepeca;
	private JTextField tfTipoProduto;
	private JTextField tfPreco;
	private JTextField tfQuantidade;
	private JTextField tfTamanho;
	private JButton btnCadastrar;
	private JTextField tfCor;

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
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(18f);
		
		JLabel lbCadastro = new JLabel("Cadastro Produto");
		lbCadastro.setForeground(new Color(235, 219, 194));
		lbCadastro.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lbCadastro, "cell 1 1 5 1,alignx left,growy");
		lbCadastro.setFont(fonte);
		
		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 5 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][][grow][grow]"));
		
		JLabel lbNomePeca = new JLabel("Nome da peça:");
		lbNomePeca.setFont(fonte2);
		panel_1.add(lbNomePeca, "cell 1 1");
		
		tfNomepeca = new JTextField();
		tfNomepeca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(tfNomepeca, "cell 3 1,growx");
		tfNomepeca.setColumns(10);
		
		JLabel lbTipoProduto =  new JLabel("Tipo de produto:");
		lbTipoProduto.setFont(fonte2);
		panel_1.add(lbTipoProduto, "cell 1 3");
		
		tfTipoProduto = new JTextField();
		tfTipoProduto.setFont(fonte2);
		panel_1.add(tfTipoProduto, "cell 3 3,growx");
		tfTipoProduto.setColumns(10);
		
		JLabel lbPreco = new JLabel("Preço R$:");
		lbPreco.setFont(fonte2);
		panel_1.add(lbPreco, "cell 1 5");
		
		tfPreco = new JTextField();
		tfPreco.setFont(fonte2);
		panel_1.add(tfPreco, "cell 3 5,growx");
		tfPreco.setColumns(10);
		
		JLabel lbQuantidade = new JLabel("Quantidade:");
		lbQuantidade.setFont(fonte2);
		panel_1.add(lbQuantidade, "cell 1 7");
		
		tfQuantidade = new JTextField();
		tfQuantidade.setFont(fonte2);
		panel_1.add(tfQuantidade, "cell 3 7,growx");
		tfQuantidade.setColumns(10);
		
		JLabel lbTamanho = new JLabel("Tamanho:");
		lbTamanho.setFont(fonte2);
		panel_1.add(lbTamanho, "cell 1 9");
		
		tfTamanho = new JTextField();
		tfTamanho.setFont(fonte2);
		panel_1.add(tfTamanho, "cell 3 9,growx");
		tfTamanho.setColumns(10);
		
		JLabel lbCor = new JLabel("Cor:");
		panel_1.add(lbCor, "cell 1 11");
		lbCor.setFont(fonte2);
		
		tfCor = new JTextField();
		panel_1.add(tfCor, "cell 3 11,growx");
		tfCor.setColumns(10);
		tfCor.setFont(fonte2);
		
		
		btnCadastrar = new JButtonOutLine();
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.setFont(fonte2);
		panel.add(btnCadastrar, "cell 3 5,growx");

	}
	
	public void cadastrarProduto (ActionListener acao) {
		btnCadastrar.addActionListener(acao);
	}
	public String getNomeProduto() {
		return tfNomepeca.getText();
	}
	public String getTipoProduto() {
		return tfTipoProduto.getText();
	}
	public double getPreco() {
		return Double.parseDouble(tfPreco.getText());
	}
	public int getQuantidade() {
		return Integer.parseInt(tfQuantidade.getText());
	}
	public String getTamanho() {
		return tfTamanho.getText();
	}
	public String getCor() {
		return tfCor.getText();
	}
	
	public void limparCampos() {
	    tfNomepeca.setText("");
	    tfTipoProduto.setText("");
	    tfPreco.setText("");
	    tfQuantidade.setText("");
	    tfTamanho.setText("");
	    tfCor.setText("");
	}
	
	public void exibirMensagem(String titulo, String mensagem, int tipo) {
		JOptionPane.showMessageDialog(this, mensagem, titulo, tipo);
	}

}
