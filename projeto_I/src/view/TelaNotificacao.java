package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class TelaNotificacao extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaNotificacao() {
		setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(235, 219, 194));
		add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("Notificações");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Produtos");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Confecções");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Lojas");
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Pedidos");
		menuBar.add(mnNewMenu_4);
		
		JMenu mnNewMenu_5 = new JMenu("Permissões");
		menuBar.add(mnNewMenu_5);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(235, 219, 194));
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow 30][grow][grow][grow 30]", "[grow 30][grow 50][grow 30][grow][grow 30]"));
		
		JLabel lblNewLabel = new JLabel("Notificações");
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 2 1");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1, "cell 1 3 2 1,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(15, 57, 87));
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow][grow 30][grow]", "[grow][grow 20][grow][grow 20][grow]"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(145, 131, 131));
		panel_2.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Nó de Estoque");
		lblNewLabel_1.setForeground(new Color(235, 219, 194));
		panel_8.add(lblNewLabel_1, "name_9304160647600");
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Nó de Estoque");
		lblNewLabel_2.setForeground(new Color(235, 219, 194));
		panel_14.add(lblNewLabel_2, "name_9600362844400");
		
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
		
		JLabel lblNewLabel_3 = new JLabel("Nó de Estoque");
		lblNewLabel_3.setForeground(new Color(235, 219, 194));
		panel_10.add(lblNewLabel_3, "name_9655721472700");
		
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
		
		JLabel lblNewLabel_5 = new JLabel("Nó de Estoque");
		lblNewLabel_5.setForeground(new Color(235, 219, 194));
		panel_16.add(lblNewLabel_5, "name_9790329387800");
		
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
		
		JLabel lblNewLabel_4 = new JLabel("Nó de Estoque");
		lblNewLabel_4.setForeground(new Color(235, 219, 194));
		panel_12.add(lblNewLabel_4, "name_9698410286500");
		
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
		
		JLabel lblNewLabel_6 = new JLabel("Nó de Estoque");
		lblNewLabel_6.setForeground(new Color(235, 219, 194));
		panel_18.add(lblNewLabel_6, "name_9793065763000");
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(235, 219, 194));
		panel_7.add(panel_19, BorderLayout.CENTER);

	}

}
