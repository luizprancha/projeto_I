package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLojas extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaLojas() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[::10px][::90px,grow][::10px][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
		).deriveFont(80f);
		
		JLabel lbLojas = new JLabel("Lojas");
		lbLojas.setForeground(new Color(235, 219, 194));
		lbLojas.setFont(fonte);
		panel.add(lbLojas, "cell 1 1");
		
		JButton btnCadastrarLoja = new JButton("Cadastrar Loja");
		btnCadastrarLoja.setBackground(new Color(235, 219, 194));
		btnCadastrarLoja.setOpaque(true);
		btnCadastrarLoja.setBorderPainted(false);
		btnCadastrarLoja.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btnCadastrarLoja, "cell 3 1,growx,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 3 3 1,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(15, 57, 87));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbNomeLoja = new JLabel("Nome da Loja");
		panel_2.add(lbNomeLoja, "cell 1 0");
		
		JLabel lbCNPJ = new JLabel("CNPJ");
		panel_2.add(lbCNPJ, "cell 1 2");
		
		JPanel panel_7 = new JPanel();
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e);
			}
		});
		panel_7.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_7, "cell 2 0,grow");
		panel_7.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_2 = new JLabel("Nome da Loja");
		panel_7.add(lblNewLabel_2, "cell 1 0");
		
		JLabel lblNewLabel_3 = new JLabel("CNPJ");
		panel_7.add(lblNewLabel_3, "cell 1 2");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_6, "cell 4 0,grow");
		panel_6.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("Nome da Loja");
		panel_6.add(lblNewLabel_4, "cell 1 0");
		
		JLabel lblNewLabel_5 = new JLabel("CNPJ");
		panel_6.add(lblNewLabel_5, "cell 1 2");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_4, "cell 0 2,grow");
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_6 = new JLabel("Nome da Loja");
		panel_4.add(lblNewLabel_6, "cell 1 0");
		
		JLabel lblNewLabel_8 = new JLabel("CNPJ");
		panel_4.add(lblNewLabel_8, "cell 1 2");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_5, "cell 2 2,grow");
		panel_5.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_7 = new JLabel("Nome da Loja");
		panel_5.add(lblNewLabel_7, "cell 1 0");
		
		JLabel lblNewLabel_9 = new JLabel("CNPJ");
		panel_5.add(lblNewLabel_9, "cell 1 2");
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_8, "cell 4 2,grow");
		panel_8.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_10 = new JLabel("Nome da Loja");
		panel_8.add(lblNewLabel_10, "cell 1 0");
		
		JLabel lblNewLabel_11 = new JLabel("CNPJ");
		panel_8.add(lblNewLabel_11, "cell 1 2");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_3, "cell 0 4,grow");
		panel_3.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_12 = new JLabel("Nome da Loja");
		panel_3.add(lblNewLabel_12, "cell 1 0");
		
		JLabel lblNewLabel_13 = new JLabel("CNPJ");
		panel_3.add(lblNewLabel_13, "cell 1 2");
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_9, "cell 2 4,grow");
		panel_9.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_14 = new JLabel("Nome da Loja");
		panel_9.add(lblNewLabel_14, "cell 1 0");
		
		JLabel lblNewLabel_15 = new JLabel("CNPJ");
		panel_9.add(lblNewLabel_15, "cell 1 2");
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_10, "cell 4 4,grow");
		panel_10.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_16 = new JLabel("Nome da Loja");
		panel_10.add(lblNewLabel_16, "cell 1 0");
		
		JLabel lblNewLabel_17 = new JLabel("CNPJ");
		panel_10.add(lblNewLabel_17, "cell 1 2");

	}

}
