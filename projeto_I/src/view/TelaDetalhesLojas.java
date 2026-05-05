package view;

import javax.swing.JPanel;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class TelaDetalhesLojas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnEditar;
	private JButton btnExcluir;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaDetalhesLojas() throws FontFormatException, IOException {
		setBackground(new Color(15, 57, 87));
		setLayout(new BorderLayout(0, 0));
		
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(80f);

		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(15f);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Lojas");
		lblNewLabel.setFont(fonte);
		lblNewLabel.setForeground(new Color(235, 219, 194));
		panel.add(lblNewLabel, "cell 1 1 4 1,grow");
		
		PainelArredondado panel_1 = new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 1 2 5 2,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Nome da Loja:");
		lblNewLabel_1.setFont(fonte2);
		panel_1.add(lblNewLabel_1, "cell 1 1,alignx left,growy");
		
		JLabel lbLoja = new JLabel("LOJA");
		lbLoja.setFont(fonte2);
		panel_1.add(lbLoja, "cell 3 1,alignx left,growy");
		
		JLabel lblNewLabel_2 = new JLabel("CNPJ:");
		lblNewLabel_2.setFont(fonte2);
		panel_1.add(lblNewLabel_2, "cell 1 3,alignx left,growy");
		
		JLabel lbCNPJ = new JLabel("CNPJ");
		lbCNPJ.setFont(fonte2);
		panel_1.add(lbCNPJ, "cell 3 3,alignx left,growy");
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setFont(fonte2);
		panel_1.add(lblNewLabel_3, "cell 1 5,alignx left,growy");
		
		JLabel lbID = new JLabel("ID");
		lbID.setFont(fonte2);
		panel_1.add(lbID, "cell 3 5,alignx left,growy");
		
		JLabel lblNewLabel_4 = new JLabel("Endereço:");
		lblNewLabel_4.setFont(fonte2);
		panel_1.add(lblNewLabel_4, "cell 1 7,alignx left,growy");
		
		JLabel lbEndereco = new JLabel("ENDEREÇO");
		lbEndereco.setFont(fonte2);
		panel_1.add(lbEndereco, "cell 3 7,alignx left,growy");
		
		btnExcluir = new JButtonOutLine();
		btnExcluir.setText("Excluir");
		btnExcluir.setFont(fonte2);
		panel.add(btnExcluir, "cell 2 5,growx");
		
		btnEditar = new JButtonOutLine();
		btnEditar.setText("Excluir");
		btnEditar.setFont(fonte2);
		panel.add(btnEditar, "cell 4 5,growx");

	}
	
	public void excluir (ActionListener acao) {
		btnExcluir.addActionListener(acao);
	}
	
	public void editar (ActionListener acao) {
		btnEditar.addActionListener(acao);
	}

}
