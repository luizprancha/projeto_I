package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import javax.swing.JScrollPane;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPedidosConfeccoesConfirmados extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnRealizar;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaPedidosConfeccoesConfirmados() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(80f);
		

		Font fonte3 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(15f);
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(25f);
		

		
		JLabel lblNewLabel = new JLabel("Pedidos Confecções");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		lblNewLabel.setBackground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1,grow");
		lblNewLabel.setFont(fonte);
		
		btnRealizar = new JButtonOutLine();
		btnRealizar.setText("Realizar novo pedido");
		btnRealizar.setFont(fonte3);
		panel.add(btnRealizar, "cell 3 1,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Confirmados:");
		lblNewLabel_1.setFont(fonte2);
		lblNewLabel_1.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel_1, "cell 1 3");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 4 3 1,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(15, 57, 87));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow]"));
		
		PainelArredondado panel_2 = new PainelArredondado();
		panel_2.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JLabel lbConfeccao = new JLabel("Nome Confecção");
		panel_2.add(lbConfeccao, "cell 1 1");
		lbConfeccao.setFont(fonte3);
		
		JLabel lbEntrega = new JLabel("data de entrega");
		panel_2.add(lbEntrega, "cell 1 3");
		lbEntrega.setFont(fonte3);
		
		PainelArredondado panel_4 = new PainelArredondado();
		panel_4.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_4, "cell 2 0,grow");
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("Nome Confecção");
		panel_4.add(lblNewLabel_4, "cell 1 1");
		lblNewLabel_4.setFont(fonte3);
		
		JLabel lblNewLabel_5 = new JLabel("data de entrega");
		panel_4.add(lblNewLabel_5, "cell 1 3");
		lblNewLabel_5.setFont(fonte3);
		
		PainelArredondado panel_6 = new PainelArredondado();
		panel_6.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_6, "cell 4 0,grow");
		panel_6.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][][grow][grow][][grow]"));
		
		JLabel lblNewLabel_6 = new JLabel("Nome Confecção");
		panel_6.add(lblNewLabel_6, "cell 1 1");
		lblNewLabel_6.setFont(fonte3);
		
		JLabel lblNewLabel_7 = new JLabel("data de entrega");
		panel_6.add(lblNewLabel_7, "cell 1 4");
		lblNewLabel_7.setFont(fonte3);
		
		PainelArredondado panel_3 = new PainelArredondado();
		panel_3.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_3, "cell 0 2,grow");
		panel_3.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_8 = new JLabel("Nome Confecção");
		panel_3.add(lblNewLabel_8, "cell 1 1");
		lblNewLabel_8.setFont(fonte3);
		
		JLabel lblNewLabel_9 = new JLabel("data de entrega");
		panel_3.add(lblNewLabel_9, "cell 1 3");
		lblNewLabel_9.setFont(fonte3);
		
		PainelArredondado panel_5 = new PainelArredondado();
		panel_5.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_5, "cell 2 2,grow");
		panel_5.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_10 = new JLabel("Nome Confecção");
		panel_5.add(lblNewLabel_10, "cell 1 1");
		lblNewLabel_10.setFont(fonte3);
		
		JLabel lblNewLabel_11 = new JLabel("data de entrega");
		panel_5.add(lblNewLabel_11, "cell 1 3");
		lblNewLabel_11.setFont(fonte3);
		
		PainelArredondado panel_7 = new PainelArredondado();
		panel_7.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_7, "cell 4 2,grow");
		panel_7.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_12 = new JLabel("Nome Confecção");
		panel_7.add(lblNewLabel_12, "cell 1 1");
		lblNewLabel_12.setFont(fonte3);
		
		JLabel lblNewLabel_13 = new JLabel("data de entrega");
		panel_7.add(lblNewLabel_13, "cell 1 3");
		lblNewLabel_13.setFont(fonte3);
		

	}

}
