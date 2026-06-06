package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import javax.swing.JScrollPane;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComponent;

public class TelaPedidosLojasConfirmados extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnRealizar;
	private JComponent panel_7; 

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaPedidosLojasConfirmados() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][][grow][grow]"));

		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(60f);
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(15f);
		
		JLabel lblNewLabel = new JLabel("Pedidos Lojas");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		lblNewLabel.setBackground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1,grow");
		lblNewLabel.setFont(fonte);
		
		btnRealizar = new JButtonOutLine();
		btnRealizar.setText("Realizar novo pedido");
		btnRealizar.setFont(fonte2);
		panel.add(btnRealizar, "cell 3 1,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Confirmados:");
		lblNewLabel_1.setForeground(new Color(235, 219, 194));
		lblNewLabel_1.setFont(fonte2);
		panel.add(lblNewLabel_1, "cell 1 3");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 4 3 1,grow");
		
		panel_7 = new JPanel();
		panel_7.setBackground(new Color(15, 57, 87));
		scrollPane.setViewportView(panel_7);
		panel_7.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow]"));
		


	}
	
	public void realizarPedido (ActionListener acao) {
		btnRealizar.addActionListener(acao);
	}
	
	



	public void addPanel7(Painel7 p7, String param) {
		
		panel_7.add(p7, param);
		
	}


	public void limparPaineis() {
		panel_7.removeAll();

	    panel_7.repaint();

	    panel_7.revalidate();
	}
	
	public void recriarPaineis(Painel7 p7, String param) {
		limparPaineis();
		panel_7.add(p7, param);
		
	}
	
}
