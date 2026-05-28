package view;

import javax.swing.JPanel;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;
import model.Produtos;

import java.awt.BorderLayout;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaDetalheProduto extends JPanel {
	
	private JButton btnExcluir;
	private JButton btnEditar;
	private JButton btnAdicionar;
	private JLabel lbNomepeca;
	private JLabel lbPreco;
	private JLabel lbQuantidade;
	private JLabel lbTamanho;
	private JLabel lbID;
	
	

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaDetalheProduto() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(80f);

		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(15f);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(fonte);
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 4 1");
		
		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 5 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
	

		
		JLabel lblNewLabel_1 = new JLabel("Nome da peça:");
		lblNewLabel_1.setFont(fonte2);
		panel_1.add(lblNewLabel_1, "cell 1 1");
		
		lbNomepeca = new JLabel("New label");
		lbNomepeca.setFont(fonte2);
		panel_1.add(lbNomepeca, "cell 3 1");
		
		JLabel lblNewLabel_3 = new JLabel("Preço R$:");
		lblNewLabel_3.setFont(fonte2);
		panel_1.add(lblNewLabel_3, "cell 1 3");
		
		lbPreco = new JLabel("New label");
		lbPreco.setFont(fonte2);
		panel_1.add(lbPreco, "cell 3 3");
		
		JLabel lblNewLabel_4 = new JLabel("Quantidade em estoque:");
		lblNewLabel_4.setFont(fonte2);
		panel_1.add(lblNewLabel_4, "cell 1 5");
		
		lbQuantidade = new JLabel("New label");
		lbQuantidade.setFont(fonte2);
		panel_1.add(lbQuantidade, "cell 3 5");
		
		JLabel lblNewLabel_5 = new JLabel("Tamanho:");
		lblNewLabel_5.setFont(fonte2);
		panel_1.add(lblNewLabel_5, "cell 1 7");
		
		lbTamanho = new JLabel("New label");
		lbTamanho.setFont(fonte2);
		panel_1.add(lbTamanho, "cell 3 7");
		
		JLabel lblNewLabel_6 = new JLabel("ID produto:");
		lblNewLabel_6.setFont(fonte2);
		panel_1.add(lblNewLabel_6, "cell 1 9");
		
		lbID = new JLabel("New label");
		lbID.setFont(fonte2);
		panel_1.add(lbID, "cell 3 9");
		
		btnExcluir = new JButtonOutLine();
		btnExcluir.setText("Excluir");
		btnExcluir.setFont(fonte2);
		panel.add(btnExcluir, "cell 1 5,growx");
		
		btnEditar = new JButtonOutLine();
		btnEditar.setText("Editar");
		btnEditar.setFont(fonte2);
		panel.add(btnEditar, "cell 2 5,growx");
		
		btnAdicionar = new JButtonOutLine();
		btnAdicionar.setText("Adicionar ao Carrinho");
		panel.add(btnAdicionar, "cell 5 5,growx");
		btnAdicionar.setFont(fonte2);

	}
	
	public void excluirProduto(ActionListener acao) {
		btnExcluir.addActionListener(acao);
	}
	
	public void editarProduto(ActionListener acao) {
		btnEditar.addActionListener(acao);
	}
	
	public void adicionarProduto(ActionListener acao) {
		btnAdicionar.addActionListener(acao);
	}
	
	public void setProduto(Produtos produto) {

	    lbNomepeca.setText(produto.getNome());
	    lbPreco.setText(String.valueOf(produto.getPreco()));
	    lbQuantidade.setText(String.valueOf(produto.getQuantidade()));
	    lbTamanho.setText(produto.getTamanho());
	    lbID.setText(String.valueOf(produto.getIdProduto()));
	}
	
	public void exibirMensagem(String titulo, String mensagem, int tipo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
	}
	
	
	
}
