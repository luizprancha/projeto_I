package view;

import javax.swing.JPanel;

import Botao.PainelArredondado;
import model.Confeccoes;
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
		
		JLabel lblNewLabel = new JLabel("R$");
		add(lblNewLabel, "flowx,cell 1 3");
		JLabel lbPreco = new JLabel(preco);
		add(lbPreco, "cell 1 3");
		lbPreco.setFont(fonte2);
	}
	
	public Painel(Confeccoes conf) throws FontFormatException, IOException {
		setBackground(new Color(235, 219, 194));
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(13f);
		
		JLabel lbNomeLoja = new JLabel(conf.getNome());
		add(lbNomeLoja, "cell 1 1");
		lbNomeLoja.setFont(fonte2);
		String cnpj = String.format(conf.getCnpj());
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel, "flowx,cell 1 3");
		JLabel lbCNPJ = new JLabel(cnpj);
		add(lbCNPJ, "cell 1 3");
		lbCNPJ.setFont(fonte2);
	}

}
