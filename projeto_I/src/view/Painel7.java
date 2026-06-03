package view;


import Botao.PainelArredondado;
import model.Lojas;
import model.MateriaPrima;
import model.PedidosLojas;
import model.PedidosLojasProdutos;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class Painel7 extends PainelArredondado {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param prod 
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public Painel7(PedidosLojas pedidosLojas) throws FontFormatException, IOException {
		setBackground(new Color(235, 219, 194));
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));
		
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(13f);
		
		JLabel lbNomeLoja = new JLabel(pedidosLojas.getNome()); //inserir nome na tabela pedidos lojas e fazer ee pegar de lojas o nome
		add(lbNomeLoja, "cell 1 1");
		lbNomeLoja.setFont(fonte2);

		JLabel lbCnpj = new JLabel(pedidosLojas.getLojas_CNPJ());
		add(lbCnpj, "cell 1 2");
		lbCnpj.setFont(fonte2);
		
		

	}

}
