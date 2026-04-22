package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPedidosLojas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfLoja;
	private JTextField tfEntrega;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaPedidosLojas() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
		).deriveFont(50f);
		
		JLabel lblNewLabel = new JLabel("Pedidos Lojas");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 3 1,alignx left,growy");
		lblNewLabel.setFont(fonte);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Loja:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1, "cell 1 1");
		
		tfLoja = new JTextField();
		tfLoja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(tfLoja, "cell 3 1,growx");
		tfLoja.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade de peças:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_3, "cell 1 3");
		
		JLabel lbQuantidade = new JLabel("20");
		lbQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lbQuantidade, "cell 3 3");
		
		JLabel lblNewLabel_2 = new JLabel("Data de Entrega:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_2, "cell 1 5");
		
		tfEntrega = new JTextField();
		tfEntrega.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(tfEntrega, "cell 3 5,growx");
		tfEntrega.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Valor Total:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_5, "cell 1 7");
		
		JLabel lbValorTotal = new JLabel("R$1.500,00");
		lbValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lbValorTotal, "cell 3 7");
		
		JButton btnFinalizar = new JButton("Finalizar pedido");
		btnFinalizar.setBackground(new Color(235, 219, 194));
		btnFinalizar.setOpaque(true);
		btnFinalizar.setBorderPainted(false);
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btnFinalizar, "cell 2 5,grow");

	}

}
