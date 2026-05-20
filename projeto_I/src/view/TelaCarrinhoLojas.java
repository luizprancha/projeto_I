package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComponent;



public class TelaCarrinhoLojas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfBuscar;

	
	private JButton btnExcluir; 
	private JButton btnFinalizarPedido; 
	private JButton btnAlterarPedido;
	private JButton btnContinuarCompra;
	private JComponent panel_5; 

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaCarrinhoLojas() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(80f);
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(15f);
		
		
		JLabel lblNewLabel = new JLabel("Carrinho de pedidos ");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 5 1");
		lblNewLabel.setFont(fonte);
		
		tfBuscar = new JTextField();
		panel.add(tfBuscar, "cell 7 1,growx");
		tfBuscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 3 7 1,grow");
		
	    panel_5 = new PainelArredondado();
		panel_5.setBackground(new Color(235, 219, 194));
		scrollPane.setViewportView(panel_5);
		panel_5.setLayout(new MigLayout("", "[grow 10][grow][grow 10][grow][grow 10][grow][grow 10]", "[grow 5][grow][grow 5][][grow 5]"));
		

		
		btnExcluir = new JButtonOutLine();
		btnExcluir.setText("Excluir");
		btnExcluir.setFont(fonte2);
		panel.add(btnExcluir, "cell 1 5,growx,aligny center");
		

		btnFinalizarPedido = new JButtonOutLine();
		btnFinalizarPedido.setText("Finalizar Pedido");
		btnFinalizarPedido.setFont(fonte2);
		panel.add(btnFinalizarPedido, "cell 3 5,growx,aligny center");
		
		btnAlterarPedido = new JButtonOutLine();
		btnAlterarPedido.setText("Alterar Pedido");
		btnAlterarPedido.setFont(fonte2);
		panel.add(btnAlterarPedido, "cell 5 5,growx,aligny center");
		
	     btnContinuarCompra = new JButtonOutLine();
	     btnContinuarCompra.setText ("Continuar Compra");
		panel.add(btnContinuarCompra, "cell 7 5,growx,aligny center");

	}
	
	public void excluir(ActionListener acao) {
		btnExcluir.addActionListener(acao);
	}
	
	public void finalizarPedido(ActionListener acao) {
		btnFinalizarPedido.addActionListener(acao);
	}
	
	public void alterarPedido (ActionListener acao) {
		btnAlterarPedido.addActionListener(acao);
	}
	
	public void continuarCompra (ActionListener acao) {
		btnContinuarCompra.addActionListener(acao);
	}
	
	
public void addPanel5(Painel5 p5, String param) {
		
		panel_5.add(p5, param);
		
	}


	public void limparPaineis() {
		panel_5.removeAll();

	    panel_5.repaint();

	    panel_5.revalidate();
	}
	
	public void exibirMensagem(String titulo, String mensagem, int tipo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
	}

}
