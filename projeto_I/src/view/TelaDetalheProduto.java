package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
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
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("Notificações");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Produtos");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Confecções");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Lojas");
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Pedidos");
		menuBar.add(mnNewMenu_4);
		
		JMenu mnNewMenu_5 = new JMenu("Permissões");
		menuBar.add(mnNewMenu_5);
		
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
		
		JLabel lbNomepeca = new JLabel("camisa oversized");
		panel_1.add(lbNomepeca, "cell 3 1");
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de produto:");
		panel_1.add(lblNewLabel_2, "cell 1 3");
		
		JLabel ldTipo = new JLabel("camisa");
		panel_1.add(ldTipo, "cell 3 3");
		
		JLabel lblNewLabel_3 = new JLabel("Preço R$:");
		panel_1.add(lblNewLabel_3, "cell 1 5");
		
		JLabel lbPreco = new JLabel("50");
		panel_1.add(lbPreco, "cell 3 5");
		
		JLabel lblNewLabel_4 = new JLabel("Quantidade em estoque:");
		panel_1.add(lblNewLabel_4, "cell 1 7");
		
		JLabel lbQuantidade = new JLabel("100");
		panel_1.add(lbQuantidade, "cell 3 7");
		
		JLabel lblNewLabel_5 = new JLabel("Tamanho:");
		panel_1.add(lblNewLabel_5, "cell 1 9");
		
		JLabel lbTamanho = new JLabel("GG");
		panel_1.add(lbTamanho, "cell 3 9");
		
		JLabel lblNewLabel_6 = new JLabel("ID produto:");
		panel_1.add(lblNewLabel_6, "cell 1 11");
		
		JLabel lbID = new JLabel("435423542452");
		panel_1.add(lbID, "cell 3 11");
		
		JButton btnAdicionar = new JButton("Adicionar ao carrinho");
		btnAdicionar.setBackground(new Color(255, 255, 255)); 
		btnAdicionar.setContentAreaFilled(true);
		btnAdicionar.setOpaque(true);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel_1.add(btnAdicionar, "cell 5 11");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(235, 219, 194)); 
		btnExcluir.setContentAreaFilled(true);
		btnExcluir.setOpaque(true);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnExcluir, "cell 2 5,growx");
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(235, 219, 194)); 
		btnEditar.setContentAreaFilled(true);
		btnEditar.setOpaque(true);
		btnEditar.setBorderPainted(false);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnEditar, "cell 4 5,growx");
		

	}

}
