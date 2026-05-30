package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;

import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import Botao.PainelArredondado;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;


import java.awt.CardLayout;
import javax.swing.ImageIcon;

public class TelaNotificacao extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel painelNotificacoes;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 * 
	 * 
	 */
	
	Font fonte2 = Font.createFont(
	        Font.TRUETYPE_FONT,
	        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
	).deriveFont(14f);
	
	public TelaNotificacao() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(235, 219, 194));
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow 30][grow][grow][grow 30]", "[grow 30][grow 50][grow 30][grow][grow 30]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(100f);

		
		JLabel lbNotificacoes = new JLabel("Notificações");
		lbNotificacoes.setForeground(new Color(235, 219, 194));
		lbNotificacoes.setFont(fonte);
		panel.add(lbNotificacoes, "cell 1 1,align left");
		 
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1, "cell 1 3 2 1,grow");
		
		painelNotificacoes = new JPanel();

		painelNotificacoes.setBackground(
		        new Color(15,57,87));

		scrollPane_1.setViewportView(painelNotificacoes);

		painelNotificacoes.setLayout(new MigLayout("","[grow]",""));
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(20f);

	}
	
	public void adicionarNotificacao(String texto) {

	    JLabel label = new JLabel(texto);

	    painelNotificacoes.add(label);

	    painelNotificacoes.revalidate();
	    painelNotificacoes.repaint();
	}
	
	public void addPanel6(
	        Painel6 p6,
	        String param) {

	    painelNotificacoes.add(p6, param);

	    painelNotificacoes.revalidate();
	    painelNotificacoes.repaint();
	}

	public void limparPaineis() {

	    painelNotificacoes.removeAll();

	    painelNotificacoes.repaint();
	    painelNotificacoes.revalidate();
	}

}
