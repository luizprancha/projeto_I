package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JButton;

public class TelaDetalhesConfeccoes extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaDetalhesConfeccoes() throws FontFormatException, IOException {
		setBackground(new Color(15, 57, 87));
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
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
		).deriveFont(80f);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Confecções");
		lblNewLabel.setFont(fonte);
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 2 1,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 2 5 2,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Nome da Loja:");
		panel_1.add(lblNewLabel_1, "cell 1 1,alignx left,growy");
		
		JLabel lblNewLabel_5 = new JLabel("LOJA");
		panel_1.add(lblNewLabel_5, "cell 3 1,alignx left,growy");
		
		JLabel lblNewLabel_2 = new JLabel("CNPJ:");
		panel_1.add(lblNewLabel_2, "cell 1 3,alignx left,growy");
		
		JLabel lblNewLabel_6 = new JLabel("CNPJ");
		panel_1.add(lblNewLabel_6, "cell 3 3,alignx left,growy");
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		panel_1.add(lblNewLabel_3, "cell 1 5,alignx left,growy");
		
		JLabel lblNewLabel_7 = new JLabel("ID");
		panel_1.add(lblNewLabel_7, "cell 3 5,alignx left,growy");
		
		JLabel lblNewLabel_4 = new JLabel("Endereço:");
		panel_1.add(lblNewLabel_4, "cell 1 7,alignx left,growy");
		
		JLabel lblNewLabel_8 = new JLabel("ENDEREÇO");
		panel_1.add(lblNewLabel_8, "cell 3 7,alignx left,growy");
		
		JLabel lblNewLabel_9 = new JLabel("Prestando serviço:");
		panel_1.add(lblNewLabel_9, "cell 1 9,grow");
		
		JLabel lblNewLabel_10 = new JLabel("SIM/NÃO");
		panel_1.add(lblNewLabel_10, "cell 3 9,grow");
		
		JButton btnNewButton = new JButton("Excluir");
		panel.add(btnNewButton, "cell 2 5,grow");
		
		JButton btnNewButton_1 = new JButton("Editar");
		panel.add(btnNewButton_1, "cell 4 5,grow");

	}

}
