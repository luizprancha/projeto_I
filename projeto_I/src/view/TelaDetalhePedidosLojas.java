package view;

import javax.swing.JPanel;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;
import model.PedidosLojas;
import model.Produtos;

import java.awt.BorderLayout;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TelaDetalhePedidosLojas extends JPanel {
	
	private JButton btnExcluir;
	private JButton btnEditar;
	private JLabel lbNomeLoja;
	private JLabel lbQuantidadePeca;
	private JLabel lbDataEntrega;
	private JLabel lbValor;
	
	

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaDetalhePedidosLojas() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
	
		JPanel panel = new JPanel();
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
		
		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 3 5 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
	

		
		JLabel lbLo = new JLabel("Loja:");
		lbLo.setFont(fonte2);
		panel_1.add(lbLo, "cell 1 1");
		
		lbNomeLoja = new JLabel("New label");
		lbNomeLoja.setFont(fonte2);
		panel_1.add(lbNomeLoja, "cell 3 1");
		
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
		
		JLabel lblNewLabel_5 = new JLabel("ValorTotal");
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
	
	public void excluirPedidoLojas(ActionListener acao) {
		btnExcluir.addActionListener(acao);
	}
	
	public void editarPedidoLoja(ActionListener acao) {
		btnEditar.addActionListener(acao);
	}
	

	
	public void setPedidosLojas(PedidosLojas pedidosLojas) {


	    lbNomeLoja.setText(pedidosLojas.getNomeLoja());
	    lbQuantidadePeca.setText(String.valueOf(pedidosLojas.getQuantidadeTotal()));
	    lbDataEntrega.setText(pedidosLojas.getEntrega());
	    lbValor.setText(String.valueOf(pedidosLojas.getValorTotal()));
	   
	}
	
	public void exibirMensagem(String titulo, String mensagem, int tipo) {
	    TelaMensagem.mostrar(titulo, mensagem);
	}
	
	
	
}
