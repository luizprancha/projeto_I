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

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaConfeccoes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnCadastrarConfeccao;

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
		        getClass().getResourceAsStream("/fontes/Abel-Regular.ttf")
		).deriveFont(70f);
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(18f);
		
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(15, 57, 87));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		PainelArredondado panel_2= new PainelArredondado();
		panel_2.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lbConfeccao = new JLabel("Nome confecção");
		panel_2.add(lbConfeccao, "cell 1 0,alignx center");
		lbConfeccao.setFont(fonte2);
		
		JLabel lbCNPJ = new JLabel("CNPJ");
		panel_2.add(lbCNPJ, "cell 1 2,alignx center");
		lbCNPJ.setFont(fonte2);
		
		PainelArredondado panel_7= new PainelArredondado();
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e);
			}
		});
		panel_7.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_7, "cell 2 0,grow");
		panel_7.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_2 = new JLabel("Nome confecção");
		panel_7.add(lblNewLabel_2, "cell 1 0,alignx center");
		lblNewLabel_2.setFont(fonte2);
		
		JLabel lblNewLabel_3 = new JLabel("CNPJ");
		panel_7.add(lblNewLabel_3, "cell 1 2,alignx center");
		lblNewLabel_3.setFont(fonte2);
		
		
		PainelArredondado panel_6= new PainelArredondado();
		panel_6.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_6, "cell 4 0,grow");
		panel_6.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("Nome confecção");
		panel_6.add(lblNewLabel_4, "cell 1 0,alignx center");
		lblNewLabel_4.setFont(fonte2);
		
		JLabel lblNewLabel_5 = new JLabel("CNPJ");
		panel_6.add(lblNewLabel_5, "cell 1 2,alignx center");
		lblNewLabel_5.setFont(fonte2);
		
		PainelArredondado panel_4 = new PainelArredondado();
		panel_4.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_4, "cell 0 2,grow");
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_6 = new JLabel("Nome confecção");
		panel_4.add(lblNewLabel_6, "cell 1 0,alignx center");
		lblNewLabel_6.setFont(fonte2);
		
		JLabel lblNewLabel_8 = new JLabel("CNPJ");
		panel_4.add(lblNewLabel_8, "cell 1 2,alignx center");
		lblNewLabel_8.setFont(fonte2);
		
		PainelArredondado panel_5 = new PainelArredondado();
		panel_5.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_5, "cell 2 2,grow");
		panel_5.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_7 = new JLabel("Nome confecção");
		panel_5.add(lblNewLabel_7, "cell 1 0,alignx center");
		lblNewLabel_7.setFont(fonte2);
		
		JLabel lblNewLabel_9 = new JLabel("CNPJ");
		panel_5.add(lblNewLabel_9, "cell 1 2,alignx center");
		lblNewLabel_9.setFont(fonte2);
		
		PainelArredondado panel_8= new PainelArredondado();
		panel_8.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_8, "cell 4 2,grow");
		panel_8.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_10 = new JLabel("Nome confecção");
		panel_8.add(lblNewLabel_10, "cell 1 0,alignx center");
		lblNewLabel_10.setFont(fonte2);
		
		JLabel lblNewLabel_11 = new JLabel("CNPJ");
		panel_8.add(lblNewLabel_11, "cell 1 2,alignx center");
		lblNewLabel_11.setFont(fonte2);
		
		PainelArredondado panel_3= new PainelArredondado();
		panel_3.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_3, "cell 0 4,grow");
		panel_3.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_12 = new JLabel("Nome confecção");
		panel_3.add(lblNewLabel_12, "cell 1 0,alignx center");
		lblNewLabel_12.setFont(fonte2);
		
		JLabel lblNewLabel_13 = new JLabel("CNPJ");
		panel_3.add(lblNewLabel_13, "cell 1 2,alignx center");
		lblNewLabel_13.setFont(fonte2);
		
		PainelArredondado panel_9 = new PainelArredondado();
		panel_9.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_9, "cell 2 4,grow");
		panel_9.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_14 = new JLabel("Nome confecção");
		panel_9.add(lblNewLabel_14, "cell 1 0,alignx center");
		lblNewLabel_14.setFont(fonte2);
		
		JLabel lblNewLabel_15 = new JLabel("CNPJ");
		panel_9.add(lblNewLabel_15, "cell 1 2,alignx center");
		lblNewLabel_15.setFont(fonte2);
		
		
		PainelArredondado panel_10 = new PainelArredondado();
		panel_10.setBackground(new Color(235, 219, 194));
		panel_1.add(panel_10, "cell 4 4,grow");
		panel_10.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_16 = new JLabel("Nome confecção");
		panel_10.add(lblNewLabel_16, "cell 1 0,alignx center");
		lblNewLabel_16.setFont(fonte2);
		
		JLabel lblNewLabel_17 = new JLabel("CNPJ");
		panel_10.add(lblNewLabel_17, "cell 1 2,alignx center");
		lblNewLabel_17.setFont(fonte2);

	}
	
	public void cadastrarConfeccao(ActionListener acao) {
		btnCadastrarConfeccao.addActionListener(acao);
	}

}
