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
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class TelaMateriaPrima extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnNovaMateria;
	private JComponent panel_4; 
	private JTextField tfBusca;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaMateriaPrima() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[::10px][::90px,grow][::10px][grow][grow]"));
		
		Font fonte1 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(60f);

		

		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(15f);
		
		
		JLabel lbLojas = new JLabel("Matéria prima");
		lbLojas.setForeground(new Color(235, 219, 194));
		lbLojas.setFont(fonte1);
		panel.add(lbLojas, "cell 1 1");
		
		btnNovaMateria = new JButtonOutLine();
		btnNovaMateria.setText("Nova matéria prima");
		btnNovaMateria.setFont(fonte2);
		panel.add(btnNovaMateria, "cell 3 1,growx,aligny center");
		
		tfBusca = new JTextField();
		tfBusca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(tfBusca, "cell 5 1,growx");
		tfBusca.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 3 5 1,grow");
		
	    panel_4 = new JPanel();
		panel_4.setBackground(new Color(15, 57, 87));
		scrollPane.setViewportView(panel_4);
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
	
	}

	public void novaMateria(ActionListener acao) {
		btnNovaMateria.addActionListener(acao);
	}
	
	public void addPanel4(Painel4 p4, String param) {
		panel_4.add(p4, param);
		
	}
	
	
	public void limparPaineis() {
		panel_4.removeAll();
		panel_4.repaint();
		panel_4.revalidate();}
	
	public String getTextoBusca() {
	    return tfBusca.getText();
	}

	public void buscar(KeyListener acao) {
	    tfBusca.addKeyListener(acao);
	}
}



