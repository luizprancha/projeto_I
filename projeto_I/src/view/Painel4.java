package view;


import Botao.PainelArredondado;
import model.Lojas;
import model.MateriaPrima;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class Painel4 extends PainelArredondado {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param prod 
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public Painel4(MateriaPrima materia) throws FontFormatException, IOException {
		setBackground(new Color(235, 219, 194));
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(13f);
		
		JLabel lbNomeMateria = new JLabel(materia.getNome());
		add(lbNomeMateria, "cell 1 1");
		lbNomeMateria.setFont(fonte2);

		JLabel lbCor = new JLabel(materia.getCor());
		add(lbCor, "cell 1 2");
		lbCor.setFont(fonte2);
		
		

	}

}
