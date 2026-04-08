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
public class TelaDetalhesLojas extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaDetalhesLojas() throws FontFormatException, IOException {
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
		
		JLabel lblNewLabel = new JLabel("Lojas");
		lblNewLabel.setFont(fonte);
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 5 1,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 2 5 2,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Nome da Loja:");
		panel_1.add(lblNewLabel_1, "cell 1 1,alignx left,growy");
		
		JLabel lbNomeLoja = new JLabel("LOJA");
		panel_1.add(lbNomeLoja, "cell 3 1,alignx left,growy");
		
		JLabel lblNewLabel_2 = new JLabel("CNPJ:");
		panel_1.add(lblNewLabel_2, "cell 1 3,alignx left,growy");
		
		JLabel lbCNPJ = new JLabel("CNPJ");
		panel_1.add(lbCNPJ, "cell 3 3,alignx left,growy");
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		panel_1.add(lblNewLabel_3, "cell 1 5,alignx left,growy");
		
		JLabel lbID = new JLabel("ID");
		panel_1.add(lbID, "cell 3 5,alignx left,growy");
		
		JLabel lblNewLabel_4 = new JLabel("Endereço:");
		panel_1.add(lblNewLabel_4, "cell 1 7,alignx left,growy");
		
		JLabel lbEndereco = new JLabel("ENDEREÇO");
		panel_1.add(lbEndereco, "cell 3 7,alignx left,growy");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(235, 219, 194)); 
		btnExcluir.setContentAreaFilled(true);
		btnExcluir.setOpaque(true);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnExcluir, "cell 2 5,grow");
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(235, 219, 194)); 
		btnEditar.setContentAreaFilled(true);
		btnEditar.setOpaque(true);
		btnEditar.setBorderPainted(false);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnEditar, "cell 4 5,grow");

	}

}
