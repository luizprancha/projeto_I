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


import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;


public class TelaConfeccoes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnCadastrarConfeccao;
	private JComponent panel_2; 


	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaConfeccoes() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[::10px][::90px,grow][::10px][grow][grow]"));
		
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(80f);
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(13f);
		
		
		JLabel lbLojas = new JLabel("Confecções");
		lbLojas.setForeground(new Color(235, 219, 194));
		lbLojas.setFont(fonte);
		panel.add(lbLojas, "cell 1 1");
		
		btnCadastrarConfeccao = new JButtonOutLine();
		btnCadastrarConfeccao.setText("Cadastrar nova confecção");
		btnCadastrarConfeccao.setFont(fonte2);
		panel.add(btnCadastrarConfeccao, "cell 3 1,growx,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 3 3 1,grow");
		
	    panel_2 = new JPanel();
		panel_2.setBackground(new Color(15, 57, 87));
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
	
	}
	
	public void cadastrarConfeccao(ActionListener acao) {
		btnCadastrarConfeccao.addActionListener(acao);
	}
	
	public void limparPaineis() {
		panel_2.removeAll();
		panel_2.repaint();
		panel_2.revalidate();
	}
	
	public void addPanel(Painel p, String param) {
		panel_2.add(p, param);
	}
	

}
