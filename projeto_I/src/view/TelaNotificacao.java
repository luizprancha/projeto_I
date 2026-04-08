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
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(235, 219, 194));
		add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("Notificações");
		menuBar.add(mnNewMenu);
		mnNewMenu.setFont(fonte2);
		
		
		JMenu mnNewMenu_1 = new JMenu("Produtos");
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.setFont(fonte2);
		
		
		JMenu mnNewMenu_2 = new JMenu("Confecções");
		menuBar.add(mnNewMenu_2);
		mnNewMenu_2.setFont(fonte2);
		
		JMenu mnNewMenu_3 = new JMenu("Lojas");
		menuBar.add(mnNewMenu_3);
		mnNewMenu_3.setFont(fonte2);
		
		JMenu mnNewMenu_4 = new JMenu("Pedidos");
		menuBar.add(mnNewMenu_4);
		mnNewMenu_4.setFont(fonte2);
		
		JMenu mnNewMenu_5 = new JMenu("Permissões");
		menuBar.add(mnNewMenu_5);
		mnNewMenu_5.setFont(fonte2);
		
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
		
		JPanel notificacao1 = new JPanel();
		notificacao1.setBackground(new Color(235, 219, 194));
		panel_1.add(notificacao1, "cell 0 0,grow");
		notificacao1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(145, 131, 131));
		notificacao1.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new CardLayout(0, 0));
		
		JLabel lbNo1 = new JLabel("Nó de Estoque");
		lbNo1.setIcon(new ImageIcon(TelaNotificacao.class.getResource("/imagem/novelo1.png")));
		lbNo1.setForeground(new Color(235, 219, 194));
		panel_8.add(lbNo1, "name_9304160647600");
		lbNo1.setFont(fonte2);
		
		JPanel mensagem1 = new JPanel();
		mensagem1.setBackground(new Color(235, 219, 194));
		notificacao1.add(mensagem1, BorderLayout.CENTER);
		mensagem1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel notificacao2 = new JPanel();
		notificacao2.setBackground(new Color(235, 219, 194));
		panel_1.add(notificacao2, "cell 2 0,grow");
		notificacao2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(145, 131, 131));
		notificacao2.add(panel_14, BorderLayout.NORTH);
		panel_14.setLayout(new CardLayout(0, 0));
		
		JLabel lbNo2 = new JLabel("Nó de Estoque");
		lbNo2.setIcon(new ImageIcon(TelaNotificacao.class.getResource("/imagem/novelo1.png")));
		lbNo2.setForeground(new Color(235, 219, 194));
		panel_14.add(lbNo2, "name_9600362844400");
		lbNo2.setFont(fonte2);
		
		JPanel mensagem2 = new JPanel();
		mensagem2.setBackground(new Color(235, 219, 194));
		notificacao2.add(mensagem2, BorderLayout.CENTER);
		
		JPanel notificacao3 = new JPanel();
		notificacao3.setBackground(new Color(235, 219, 194));
		panel_1.add(notificacao3, "cell 0 2,grow");
		notificacao3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(145, 131, 131));
		notificacao3.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new CardLayout(0, 0));
		
		JLabel lbNo3 = new JLabel("Nó de Estoque");
		lbNo3.setIcon(new ImageIcon(TelaNotificacao.class.getResource("/imagem/novelo1.png")));
		lbNo3.setForeground(new Color(235, 219, 194));
		panel_10.add(lbNo3, "name_9655721472700");
		lbNo3.setFont(fonte2);
		
		JPanel mensagem3 = new JPanel();
		mensagem3.setBackground(new Color(235, 219, 194));
		notificacao3.add(mensagem3, BorderLayout.CENTER);
		
		JPanel notificacao4 = new JPanel();
		notificacao4.setBackground(new Color(235, 219, 194));
		panel_1.add(notificacao4, "cell 2 2,grow");
		notificacao4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(145, 131, 131));
		notificacao4.add(panel_16, BorderLayout.NORTH);
		panel_16.setLayout(new CardLayout(0, 0));
		
		JLabel lbNo4 = new JLabel("Nó de Estoque");
		lbNo4.setIcon(new ImageIcon(TelaNotificacao.class.getResource("/imagem/novelo1.png")));
		lbNo4.setForeground(new Color(235, 219, 194));
		panel_16.add(lbNo4, "name_9790329387800");
		lbNo4.setFont(fonte2);
		
		JPanel mensagem4 = new JPanel();
		mensagem4.setBackground(new Color(235, 219, 194));
		notificacao4.add(mensagem4, BorderLayout.CENTER);
		
		JPanel notificacao5 = new JPanel();
		notificacao5.setBackground(new Color(235, 219, 194));
		panel_1.add(notificacao5, "cell 0 4,grow");
		notificacao5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(145, 131, 131));
		notificacao5.add(panel_12, BorderLayout.NORTH);
		panel_12.setLayout(new CardLayout(0, 0));
		
		JLabel lbNo5 = new JLabel("Nó de Estoque");
		lbNo5.setIcon(new ImageIcon(TelaNotificacao.class.getResource("/imagem/novelo1.png")));
		lbNo5.setForeground(new Color(235, 219, 194));
		panel_12.add(lbNo5, "name_9698410286500");
		lbNo5.setFont(fonte2);
		
		JPanel mensagem5 = new JPanel();
		mensagem5.setBackground(new Color(235, 219, 194));
		notificacao5.add(mensagem5, BorderLayout.CENTER);
		
		JPanel notificacao6 = new JPanel();
		notificacao6.setBackground(new Color(235, 219, 194));
		panel_1.add(notificacao6, "cell 2 4,grow");
		notificacao6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(145, 131, 131));
		notificacao6.add(panel_18, BorderLayout.NORTH);
		panel_18.setLayout(new CardLayout(0, 0));
		
		JLabel lbNo6 = new JLabel("Nó de Estoque");
		lbNo6.setIcon(new ImageIcon(TelaNotificacao.class.getResource("/imagem/novelo1.png")));
		lbNo6.setForeground(new Color(235, 219, 194));
		panel_18.add(lbNo6, "name_9793065763000");
		lbNo6.setFont(fonte2);
		
		JPanel mensagem6 = new JPanel();
		mensagem6.setBackground(new Color(235, 219, 194));
		notificacao6.add(mensagem6, BorderLayout.CENTER);

	}

}
