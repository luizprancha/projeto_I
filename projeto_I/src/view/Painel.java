package view;

import javax.swing.JPanel;

import Botao.PainelArredondado;
import model.Produtos;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class Painel extends PainelArredondado {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param prod 
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public Painel(Produtos prod) throws FontFormatException, IOException {
		setBackground(new Color(235, 219, 194));
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(13f);
		
		JLabel lbNomePeca = new JLabel(prod.getNome());
		add(lbNomePeca, "cell 1 1");
		lbNomePeca.setFont(fonte2);
		String preco = String.format("%.2f", prod.getPreco());
		JLabel lbPreco = new JLabel(preco);
		add(lbPreco, "cell 1 3");
		lbPreco.setFont(fonte2);
		

	}

}
