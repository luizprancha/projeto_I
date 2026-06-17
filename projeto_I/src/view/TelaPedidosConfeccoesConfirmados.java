package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComponent;

import Botao.JButtonOutLine;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class TelaPedidosConfeccoesConfirmados extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnRealizar;
	private JComponent panelPedidos;
	private JTextField tfBuscar;

	public TelaPedidosConfeccoesConfirmados() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow 90][grow][grow][grow][grow][grow]", "[grow][grow][][grow][grow][grow]"));

		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(60f);

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
		
		tfBuscar = new JTextField();
		panel.add(tfBuscar, "cell 5 1,growx");
		tfBuscar.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Confirmados:");
		lblNewLabel_1.setFont(fonte2);
		lblNewLabel_1.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel_1, "cell 1 3");

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 4 5 1,grow");

		panelPedidos = new JPanel();
		panelPedidos.setBackground(new Color(15, 57, 87));
		scrollPane.setViewportView(panelPedidos);
		panelPedidos.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow]"));
	}

	public void realizarPedido(ActionListener acao) {
		btnRealizar.addActionListener(acao);
	}

	public void limparPaineis() {
		panelPedidos.removeAll();
		panelPedidos.repaint();
		panelPedidos.revalidate();
	}

	public void addPanel(Painel8 p, String param) {
		panelPedidos.add(p, param);
	}
	
	public JTextField getTfBuscar() {
	    return tfBuscar;
	}

	public void revalidatePanel() {
		panelPedidos.revalidate();
		panelPedidos.repaint();
	}
}
