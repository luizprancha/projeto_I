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
import model.Lojas;
import model.MateriaPrima;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAlterarMateria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfCor;
	private JTextField tfQuantidade;
	private JButton btnAlterar;
	private JTextField tfNome;
	private JComboBox<String> cbTipoProduto;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaAlterarMateria() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
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
		
		JLabel lbCadastroMateriaPrima = new JLabel("Alterar Matéria Prima");
		lbCadastroMateriaPrima.setForeground(new Color(235, 219, 194));
		panel.add(lbCadastroMateriaPrima, "cell 1 1 5 1,alignx left");
		lbCadastroMateriaPrima.setFont(fonte);
		
		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 2 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[][][][grow][]", "[][][][][][][][][]"));
		
		JLabel lbTipo = new JLabel("Tipo:");
		panel_1.add(lbTipo, "cell 1 1");
		lbTipo.setFont(fonte2);
		
		cbTipoProduto = new JComboBox<>();
		cbTipoProduto.setFont(fonte2);
		cbTipoProduto.setModel(new DefaultComboBoxModel<>(new String[] {"Tecido", "Aviamentos"}));
		panel_1.add(cbTipoProduto, "cell 3 1,growx");
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(fonte2);
		panel_1.add(lbNome, "cell 1 3");
		
		tfNome = new JTextField();
		panel_1.add(tfNome, "cell 3 3,growx");
		tfNome.setColumns(10);
		tfNome.setFont(fonte2);
		
		JLabel lbCor = new JLabel("Cor:");
		lbCor.setFont(fonte2);
		panel_1.add(lbCor, "cell 1 5");
		
		tfCor = new JTextField();
		tfCor.setFont(fonte2);
		panel_1.add(tfCor, "cell 3 5,growx");
		tfCor.setColumns(10);
		
		JLabel lbQuantidade = new JLabel("Quantidade (unidade):");
		lbQuantidade.setFont(fonte2);
		panel_1.add(lbQuantidade, "cell 1 7");
		
		tfQuantidade = new JTextField();
		tfQuantidade.setFont(fonte2);
		panel_1.add(tfQuantidade, "cell 3 7,growx");
		tfQuantidade.setColumns(10);
		
		btnAlterar = new JButtonOutLine();
		btnAlterar.setText("Alterar ");
		btnAlterar.setFont(fonte2);
		btnAlterar.setBackground(new Color(235, 219, 194 ));
		
		
		panel.add(btnAlterar, "cell 3 5,growx");

	}
	
	public void exibirMensagem(String titulo, String mensagem, int tipo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
	}
	
	public void alterarMateria(ActionListener acao) {
		btnAlterar.addActionListener(acao);
	}
	
	public String getNome() {
		return tfNome.getText();
	}
	
	public String getTipo() {
		return (String) cbTipoProduto.getSelectedItem();
	}
	
	public int getQuantidade() {
		return Integer.parseInt(tfQuantidade.getText());
	}
	
	public String getCor() {
		return tfCor.getText();
	}
	
	public void limparCampos() {
	    tfNome.setText("");
	    tfQuantidade.setText("");
	    tfCor.setText("");
	}
	
	public void setMateria(MateriaPrima materiaprima) {
		tfNome.setText(materiaprima.getNome());
		tfQuantidade.setText(String.valueOf(materiaprima.getQuantidade()));
		tfCor.setText(materiaprima.getCor());
	}

}
