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

import Botao.JButtonOutLine;
import Botao.PainelArredondado;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLojas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnCadastrarLoja;
	private JComponent panel_3; 

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
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[::10px][::90px,grow][::10px][grow][grow 50]"));
		

		Font fonte3 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(15f);
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(140f);
		
		
		JLabel lbLojas = new JLabel("Lojas");
		lbLojas.setForeground(new Color(235, 219, 194));
		lbLojas.setFont(fonte);
		panel.add(lbLojas, "cell 1 1");
		
		btnCadastrarLoja = new JButtonOutLine();
		btnCadastrarLoja.setText("Cadastrar Loja");
		btnCadastrarLoja.setFont(fonte3);
		panel.add(btnCadastrarLoja, "cell 3 1,growx,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 3 3 1,grow");
		
	    panel_3 = new JPanel();
		panel_3.setBackground(new Color(15, 57, 87));
		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		
	}
	
	public void novaLoja(ActionListener acao) {
		btnCadastrarLoja.addActionListener(acao);
	}

	public void addPanel3(Painel3 p3, String param) {
		panel_3.add(p3, param);
		
	}
	
	public void limparPaineis() {
		panel_3.removeAll();
		panel_3.repaint();
		panel_3.revalidate();}
}
