package view;

import javax.swing.JPanel;

import Botao.PainelArredondado;
import model.Confeccoes;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class Painel2 extends PainelArredondado {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param prod 
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public Painel2(Confeccoes conf) throws FontFormatException, IOException {
		setBackground(new Color(235, 219, 194));
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(13f);
		
		JLabel lbNomeConfeccao = new JLabel(conf.getNome());
		add(lbNomeConfeccao, "cell 1 1");
		lbNomeConfeccao.setFont(fonte2);

		JLabel lbCNPJ = new JLabel(conf.getCnpj());
		add(lbCNPJ, "cell 1 2");
		lbCNPJ.setFont(fonte2);
		
		

	}

}
