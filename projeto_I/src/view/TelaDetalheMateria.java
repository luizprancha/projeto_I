package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TelaDetalheMateria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btEditar;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaDetalheMateria() throws FontFormatException, IOException {
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
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
		).deriveFont(50f);
		
		Font fonteInter = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Inter.ttf")
		).deriveFont(15f);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow 30][grow 30][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbTitulo = new JLabel("Matéria Prima");
		lbTitulo.setForeground(new Color(235, 219, 194));
		lbTitulo.setFont(fonte);
		panel.add(lbTitulo, "cell 1 1 4 1");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 3 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Tipo do tecido:");
		lblNewLabel_1.setFont(fonteInter);
		panel_1.add(lblNewLabel_1, "cell 1 1");
		
		JLabel lbTipoTecido = new JLabel("Malha");
		lbTipoTecido.setFont(fonteInter);
		panel_1.add(lbTipoTecido, "cell 3 1");
		
		JLabel lblNewLabel_2 = new JLabel("Cor:");
		lblNewLabel_2.setFont(fonteInter);
		panel_1.add(lblNewLabel_2, "cell 1 3");
		
		JLabel lbCor = new JLabel("Azul");
		lbCor.setFont(fonteInter);
		panel_1.add(lbCor, "cell 3 3");
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade de rolos:");
		lblNewLabel_3.setFont(fonteInter);
		panel_1.add(lblNewLabel_3, "cell 1 5");
		
		JLabel lbQtdeRolos = new JLabel("5");
		lbQtdeRolos.setFont(fonteInter);
		panel_1.add(lbQtdeRolos, "cell 3 5");
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.setBackground(new Color(235, 219, 194)); 
		btExcluir.setContentAreaFilled(true);
		btExcluir.setOpaque(true);
		btExcluir.setBorderPainted(false);
		btExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btExcluir, "cell 2 5 2 1,growx");
		
		btEditar = new JButton("Editar");
		btEditar.setBackground(new Color(235, 219, 194)); 
		btEditar.setContentAreaFilled(true);
		btEditar.setOpaque(true);
		btEditar.setBorderPainted(false);
		btEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btEditar, "cell 5 5 2 1,growx");

	}

}
