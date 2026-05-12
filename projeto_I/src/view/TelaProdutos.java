package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Panel;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;
import model.Produtos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TelaProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfBuscar;

	private JButton btnCadastrar;
	private JComponent panel_1; 


	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaProdutos() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[::10px][::90px,grow][::10px][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(80f);
		
		
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(13f);
		 
		JLabel lbLojas = new JLabel("Produtos");
		lbLojas.setForeground(new Color(235, 219, 194));
		lbLojas.setFont(fonte);
		panel.add(lbLojas, "cell 1 1");
		

	    btnCadastrar = new JButtonOutLine();
	    
	    btnCadastrar.setText("Cadastrar produto");
		btnCadastrar.setFont(fonte2);

		panel.add(btnCadastrar, "cell 3 1,growx,aligny center");
		
		tfBuscar = new JTextField();
		panel.add(tfBuscar, "cell 5 1,growx,aligny center");
		tfBuscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 3 5 1,grow");
		
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(15, 57, 87));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		

		
		

	}
	

	
	
	


	public void cadastrarProduto(ActionListener acao) {
		btnCadastrar.addActionListener(acao);
	}







	public void addPanel(Painel p, String param) {
		
		panel_1.add(p, param);
		
	}







	public void limparPaineis() {
		panel_1.removeAll();

	    panel_1.repaint();

	    panel_1.revalidate();

		
	}
	
	


}
