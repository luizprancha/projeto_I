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

import Botao.JButtonOutLine;
import Botao.PainelArredondado;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroMateria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfCor;
	private JTextField tfQuantidade;
	private JButton btnCadastrar;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaCadastroMateria() throws FontFormatException, IOException {
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
		
		JLabel lbCadastroMateriaPrima = new JLabel("Cadastro Matéria Prima");
		lbCadastroMateriaPrima.setForeground(new Color(235, 219, 194));
		panel.add(lbCadastroMateriaPrima, "cell 1 1 5 1,alignx left");
		lbCadastroMateriaPrima.setFont(fonte);
		
		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 2 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[][][][grow][]", "[][][][][][][]"));
		
		JLabel lbTipoProduto = new JLabel("Tipo de Produto:");
		lbTipoProduto.setFont(fonte2);
		panel_1.add(lbTipoProduto, "cell 1 1");
		
		JComboBox<String> cbTipoProduto = new JComboBox<>();
		cbTipoProduto.setFont(fonte2);
		cbTipoProduto.setModel(new DefaultComboBoxModel<>(new String[] {"Tecido", "Aviamentos"}));
		panel_1.add(cbTipoProduto, "cell 3 1,growx");
		
		JLabel lbCor = new JLabel("Cor:");
		lbCor.setFont(fonte2);
		panel_1.add(lbCor, "cell 1 3");
		
		tfCor = new JTextField();
		tfCor.setFont(fonte2);
		panel_1.add(tfCor, "cell 3 3,growx");
		tfCor.setColumns(10);
		
		JLabel lbQuantidade = new JLabel("Quantidade (unidade):");
		lbQuantidade.setFont(fonte2);
		panel_1.add(lbQuantidade, "cell 1 5");
		
		tfQuantidade = new JTextField();
		tfQuantidade.setFont(fonte2);
		panel_1.add(tfQuantidade, "cell 3 5,growx");
		tfQuantidade.setColumns(10);
		
		btnCadastrar = new JButtonOutLine();
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.setFont(fonte2);
		btnCadastrar.setBackground(new Color(235, 219, 194 ));
		
		
		panel.add(btnCadastrar, "cell 3 5,growx");

	}
	
	public void cadastro(ActionListener acao) {
		btnCadastrar.addActionListener(acao);
	}

}
