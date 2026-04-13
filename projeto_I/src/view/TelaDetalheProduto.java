package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class TelaDetalheProduto extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaDetalheProduto() {
		setLayout(new BorderLayout(0, 0));
		
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 2 1");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 5 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Nome da peça:");
		panel_1.add(lblNewLabel_1, "cell 1 1");
		
		JLabel lbNomepeca = new JLabel("New label");
		panel_1.add(lbNomepeca, "cell 3 1");
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de produto:");
		panel_1.add(lblNewLabel_2, "cell 1 3");
		
		JLabel ldTipo = new JLabel("New label");
		panel_1.add(ldTipo, "cell 3 3");
		
		JLabel lblNewLabel_3 = new JLabel("Preço R$:");
		panel_1.add(lblNewLabel_3, "cell 1 5");
		
		JLabel lbPreco = new JLabel("New label");
		panel_1.add(lbPreco, "cell 3 5");
		
		JLabel lblNewLabel_4 = new JLabel("Quantidade em estoque:");
		panel_1.add(lblNewLabel_4, "cell 1 7");
		
		JLabel lbQuantidade = new JLabel("New label");
		panel_1.add(lbQuantidade, "cell 3 7");
		
		JLabel lblNewLabel_5 = new JLabel("Tamanho:");
		panel_1.add(lblNewLabel_5, "cell 1 9");
		
		JLabel lbTamanho = new JLabel("New label");
		panel_1.add(lbTamanho, "cell 3 9");
		
		JLabel lblNewLabel_6 = new JLabel("ID produto:");
		panel_1.add(lblNewLabel_6, "cell 1 11");
		
		JLabel lbID = new JLabel("New label");
		panel_1.add(lbID, "cell 3 11");
		
		JButton btnNewButton_2 = new JButton("Adicionar ao carrinho");
		panel_1.add(btnNewButton_2, "cell 5 11");
		
		JButton btnNewButton = new JButton("Excluir");
		panel.add(btnNewButton, "cell 2 5,growx");
		
		JButton btnNewButton_1 = new JButton("Editar");
		panel.add(btnNewButton_1, "cell 4 5,growx");

	}

}
