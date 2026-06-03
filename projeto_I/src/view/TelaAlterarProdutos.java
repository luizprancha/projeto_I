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
import model.Produtos;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaAlterarProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeProduto;
	private JTextField tfTamanho;
	private JButton btnAlterarProduto;
	private JTextField tfPreco;
	private JTextField tfQuantidade;
	private JTextField tfCor;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaAlterarProdutos() throws FontFormatException, IOException {
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
		
		JLabel lblNewLabel = new JLabel("Alterar Produtos");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 2 1,alignx center,growy");
		lblNewLabel.setFont(fonte);
		
		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbNomeProdutos = new JLabel("Nome do Produto:");
		lbNomeProdutos.setFont(fonte2);
		panel_1.add(lbNomeProdutos, "cell 1 1");
		
		tfNomeProduto = new JTextField();
		tfNomeProduto.setFont(fonte2);
		panel_1.add(tfNomeProduto, "cell 3 1,growx");
		tfNomeProduto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Preço R$:");
		lblNewLabel_1.setFont(fonte2);
		panel_1.add(lblNewLabel_1, "cell 1 3");
		
		tfPreco = new JTextField();
		tfPreco.setFont(fonte2);
		panel_1.add(tfPreco, "cell 3 3,growx");
		tfPreco.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		lblNewLabel_2.setFont(fonte2);
		panel_1.add(lblNewLabel_2, "cell 1 5");
		
		tfQuantidade = new JTextField();
		tfQuantidade.setFont(fonte2);
		panel_1.add(tfQuantidade, "cell 3 5,growx");
		tfQuantidade.setColumns(10);
		
		JLabel lbTamanho = new JLabel("Tamanho:");
		lbTamanho.setFont(fonte2);
		panel_1.add(lbTamanho, "cell 1 7");
		
		tfTamanho = new JTextField();
		tfTamanho.setFont(fonte2);
		panel_1.add(tfTamanho, "cell 3 7,growx");
		tfTamanho.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cor:");
		lblNewLabel_3.setFont(fonte2);
		panel_1.add(lblNewLabel_3, "cell 1 9");
		
		tfCor = new JTextField();
		tfCor.setFont(fonte2);
		panel_1.add(tfCor, "cell 3 9,growx");
		tfCor.setColumns(10);
		
		btnAlterarProduto = new JButtonOutLine();
		btnAlterarProduto.setText("Alterar");
		btnAlterarProduto.setFont(fonte2);
		panel.add(btnAlterarProduto, "cell 2 5,growx,aligny center");

	}
	
	public String getNomeProduto() {
		return tfNomeProduto.getText();
	}
	
	public String getPreco() {
		return tfPreco.getText();
	}
	
	public String getQuantidade() {
		return tfQuantidade.getText();
	}
	
	public String getTamanho() {
		return tfTamanho.getText();
	}
	
	public String getCor() {
		return tfCor.getText();
	}
	
	public void alterarProduto(ActionListener acao) {
		btnAlterarProduto.addActionListener(acao);
	}
	public void limparCampos() {
		tfNomeProduto.setText("");

		tfPreco.setText("");
		tfQuantidade.setText("");
		tfTamanho.setText("");
		tfCor.setText("");
	}
	public void exibirMensagem(String titulo, String mensagem, int tipo) {
	    TelaMensagem.mostrar(titulo, mensagem);
	}
	
	public void setProdutos(Produtos p) {
		tfNomeProduto.setText(p.getNome());
		tfPreco.setText(String.valueOf(p.getPreco()));
		tfQuantidade.setText(String.valueOf(p.getQuantidade()));
		tfTamanho.setText(String.valueOf(p.getTamanho()));
		tfCor.setText(p.getCor());
	}

}
