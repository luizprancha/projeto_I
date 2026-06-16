package view;

import javax.swing.JPanel;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;
import model.PedidoConfeccao;

import java.awt.BorderLayout;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class TelaDetalhePedidosConfeccoes extends JPanel {
	
	private JButton btnExcluir;
	private JButton btnEditar;
	private JLabel lbNomeConfeccao;
	private JLabel lbQuantidadePeca;
	private JLabel lbDataEntrega;
	private JLabel lbValor;
	
	

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaDetalhePedidosConfeccoes() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
	
		JPanel panel = new JPanel();
		panel.setForeground(new Color(235, 219, 194));
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(80f);

		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(15f);
		
		JLabel lbPedidosConf = new JLabel("Pedidos Confecções");
		lbPedidosConf.setForeground(new Color(235, 219, 194));
		panel.add(lbPedidosConf, "cell 1 1 2 1");
		lbPedidosConf.setFont(fonte);
		
		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 5 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
	

		
		JLabel lbLo = new JLabel("Confecção:");
		lbLo.setFont(fonte2);
		panel_1.add(lbLo, "cell 1 1");
		
		lbNomeConfeccao = new JLabel("New label");
		lbNomeConfeccao.setFont(fonte2);
		panel_1.add(lbNomeConfeccao, "cell 3 1");
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade de peças:");
		lblNewLabel_3.setFont(fonte2);
		panel_1.add(lblNewLabel_3, "cell 1 3");
		
		lbQuantidadePeca = new JLabel("New label");
		lbQuantidadePeca.setFont(fonte2);
		panel_1.add(lbQuantidadePeca, "cell 3 3");
		
		JLabel lblNewLabel_4 = new JLabel("Data de entrega:");
		lblNewLabel_4.setFont(fonte2);
		panel_1.add(lblNewLabel_4, "cell 1 5");
		
		lbDataEntrega = new JLabel("New label");
		lbDataEntrega.setFont(fonte2);
		panel_1.add(lbDataEntrega, "cell 3 5");
		
		JLabel lblNewLabel_5 = new JLabel("Valor Total:");
		lblNewLabel_5.setFont(fonte2);
		panel_1.add(lblNewLabel_5, "cell 1 7");
		
		lbValor = new JLabel("New label");
		lbValor.setFont(fonte2);
		panel_1.add(lbValor, "cell 3 7");
		
		btnExcluir = new JButtonOutLine();
		btnExcluir.setText("Excluir");
		btnExcluir.setFont(fonte2);
		panel.add(btnExcluir, "cell 1 5,growx");
		
		btnEditar = new JButtonOutLine();
		btnEditar.setText("Editar");
		btnEditar.setFont(fonte2);
		panel.add(btnEditar, "cell 2 5,growx");
		
	}
	
	public void excluirPedidoConfeccao(ActionListener acao) {
		btnExcluir.addActionListener(acao);
	}
	
	public void editarPedidoConfeccao(ActionListener acao) {
		btnEditar.addActionListener(acao);
	}
	

	
	public void setPedidoConfeccao(PedidoConfeccao pedido) {


	    lbNomeConfeccao.setText(pedido.getNomeConfeccao());
	    lbQuantidadePeca.setText(String.valueOf(pedido.getQuantidade()));
	    if (pedido.getEntrega() != null) {
	    	lbDataEntrega.setText(pedido.getEntrega().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	    } else {
	    	lbDataEntrega.setText("");
	    }
	    lbValor.setText(String.valueOf(pedido.getValorPedido()));
	   
	}
	
	public void exibirMensagem(String titulo, String mensagem, int tipo) {
	    TelaMensagem.mostrar(titulo, mensagem);
	}
	
	
	
}
