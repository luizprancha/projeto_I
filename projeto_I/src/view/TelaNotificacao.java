package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.JComponent;

public class TelaNotificacao extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComponent painel_6;

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
		
		painel_6 = new JPanel();
		painel_6.setBackground(new Color(15, 57, 87));
		scrollPane_1.setViewportView(painel_6);
		painel_6.setLayout(new MigLayout("", "[grow]", "[grow][grow][grow][grow][grow]"));

	}
	
	public void addPanel6(Painel6 p6, String param) {
	    painel_6.add(p6, param);
	    painel_6.revalidate();
	    painel_6.repaint();
	}

	public void limparPaineis() {

	    painel_6.removeAll();

	    painel_6.repaint();
	    painel_6.revalidate();
	}

}
