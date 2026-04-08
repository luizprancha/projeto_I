package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class TelaPedidosConfeccoes extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaPedidosConfeccoes() throws FontFormatException, IOException {
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Confecções");
		mnNewMenu_4.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Lojas");
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte1 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
		).deriveFont(50f);
		
		JLabel lblNewLabel = new JLabel("Pedidos Confecções");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 3 1");
		lblNewLabel.setFont(fonte1);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel_1.setForeground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Confecção:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1, "cell 1 1");
		
		JLabel lbConfeccao = new JLabel("Confecção do zé");
		panel_1.add(lbConfeccao, "cell 3 1");
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade de peças:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2, "cell 1 3");
		
		JLabel lbQuantidade = new JLabel("800");
		panel_1.add(lbQuantidade, "cell 3 3");
		
		JLabel lblNewLabel_3 = new JLabel("Data de entrega:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_3, "cell 1 5");
		
		JLabel lbDataEntrega = new JLabel("15/02/2026");
		panel_1.add(lbDataEntrega, "cell 3 5");
		
		JLabel lblNewLabel_4 = new JLabel("Valor total:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_4, "cell 1 7");
		
		JLabel lbTotal = new JLabel("15000");
		panel_1.add(lbTotal, "cell 3 7");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(235, 219, 194)); 
		btnCadastrar.setContentAreaFilled(true);
		btnCadastrar.setOpaque(true);
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btnCadastrar, "cell 1 5,growx");
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(new Color(235, 219, 194)); 
		btnAlterar.setContentAreaFilled(true);
		btnAlterar.setOpaque(true);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btnAlterar, "cell 3 5,growx");

	}

}
