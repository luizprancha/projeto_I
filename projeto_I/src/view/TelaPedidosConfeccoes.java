package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JTextField;

public class TelaPedidosConfeccoes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfConfeccao;
	private JTextField tfEntrega;
	private JButton btnFinalizar;
	private JTextField tfCNPJ;
	private JTextField tfFormaPgmt;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaPedidosConfeccoes() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
		
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
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Confecção:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1, "cell 1 1");
		
		tfConfeccao = new JTextField();
		tfConfeccao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(tfConfeccao, "cell 3 1,growx");
		tfConfeccao.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("CNPJ:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_5, "cell 1 3");
		
		tfCNPJ = new JTextField();
		tfCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(tfCNPJ, "cell 3 3,growx");
		tfCNPJ.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade de peças:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_2, "cell 1 6");
		
		JLabel lbQuantidade = new JLabel("Quantidade de peças");
		lbQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lbQuantidade, "cell 3 6");
		
		JLabel lblNewLabel_3 = new JLabel("Data de entrega:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_3, "cell 1 8");
		
		tfEntrega = new JTextField();
		tfEntrega.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(tfEntrega, "cell 3 8,growx");
		tfEntrega.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Valor total:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_4, "cell 1 10");
		
		JLabel lbValor = new JLabel("valor");
		lbValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lbValor, "cell 3 10");
		
		JLabel lblNewLabel_6 = new JLabel("Forma de Pagamento:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_6, "cell 1 12");
		
		tfFormaPgmt = new JTextField();
		tfFormaPgmt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(tfFormaPgmt, "cell 3 12,growx");
		tfFormaPgmt.setColumns(10);
		
		btnFinalizar = new JButton("Finalizar Pedido");
		btnFinalizar.setBackground(new Color(235, 219, 194));
		btnFinalizar.setOpaque(true);
		btnFinalizar.setBorderPainted(false);
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btnFinalizar, "cell 2 5,growx");

	}
	
		public void finalizarPedido (ActionListener acao) {
			btnFinalizar.addActionListener(acao);
		}

}
