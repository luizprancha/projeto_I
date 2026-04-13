package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;

import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;


import java.awt.CardLayout;
import javax.swing.ImageIcon;

public class TelaNotificacao extends JPanel {

	private static final long serialVersionUID = 1L;

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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(15, 57, 87));
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow][grow 30][grow]", "[grow][grow 20][grow][grow 20][grow]"));
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(20f);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(145, 131, 131));
		panel_2.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new CardLayout(0, 0));
		
		JLabel lbNo1 = new JLabel("Nó de Estoque");
		lbNo1.setIcon(new ImageIcon(TelaNotificacao.class.getResource("/imagem/novelo1.png")));
		lbNo1.setForeground(new Color(235, 219, 194));
		panel_8.add(lbNo1, "name_9304160647600");
		lbNo1.setFont(fonte2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(235, 219, 194));
		panel_2.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_5, "cell 2 0,grow");
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(145, 131, 131));
		panel_5.add(panel_14, BorderLayout.NORTH);
		panel_14.setLayout(new CardLayout(0, 0));
		
		JLabel lbNo2 = new JLabel("Nó de Estoque");
		lbNo2.setIcon(new ImageIcon(TelaNotificacao.class.getResource("/imagem/novelo1.png")));
		lbNo2.setForeground(new Color(235, 219, 194));
		panel_14.add(lbNo2, "name_9600362844400");
		lbNo2.setFont(fonte2);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(235, 219, 194));
		panel_5.add(panel_15, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_3, "cell 0 2,grow");
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(145, 131, 131));
		panel_3.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new CardLayout(0, 0));
		
		JLabel lbNo3 = new JLabel("Nó de Estoque");
		lbNo3.setIcon(new ImageIcon(TelaNotificacao.class.getResource("/imagem/novelo1.png")));
		lbNo3.setForeground(new Color(235, 219, 194));
		panel_10.add(lbNo3, "name_9655721472700");
		lbNo3.setFont(fonte2);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(235, 219, 194));
		panel_3.add(panel_11, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_6, "cell 2 2,grow");
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(145, 131, 131));
		panel_6.add(panel_16, BorderLayout.NORTH);
		panel_16.setLayout(new CardLayout(0, 0));
		
		JLabel lbNo4 = new JLabel("Nó de Estoque");
		lbNo4.setIcon(new ImageIcon(TelaNotificacao.class.getResource("/imagem/novelo1.png")));
		lbNo4.setForeground(new Color(235, 219, 194));
		panel_16.add(lbNo4, "name_9790329387800");
		lbNo4.setFont(fonte2);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(235, 219, 194));
		panel_6.add(panel_17, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_4, "cell 0 4,grow");
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(145, 131, 131));
		panel_4.add(panel_12, BorderLayout.NORTH);
		panel_12.setLayout(new CardLayout(0, 0));
		
		JLabel lbNo5 = new JLabel("Nó de Estoque");
		lbNo5.setIcon(new ImageIcon(TelaNotificacao.class.getResource("/imagem/novelo1.png")));
		lbNo5.setForeground(new Color(235, 219, 194));
		panel_12.add(lbNo5, "name_9698410286500");
		lbNo5.setFont(fonte2);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(235, 219, 194));
		panel_4.add(panel_13, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_7, "cell 2 4,grow");
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(145, 131, 131));
		panel_7.add(panel_18, BorderLayout.NORTH);
		panel_18.setLayout(new CardLayout(0, 0));
		
		JLabel lbNo6 = new JLabel("Nó de Estoque");
		lbNo6.setIcon(new ImageIcon(TelaNotificacao.class.getResource("/imagem/novelo1.png")));
		lbNo6.setForeground(new Color(235, 219, 194));
		panel_18.add(lbNo6, "name_9793065763000");
		lbNo6.setFont(fonte2);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(235, 219, 194));
		panel_7.add(panel_19, BorderLayout.CENTER);

	}

}
