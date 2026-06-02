package view;

import javax.swing.JPanel;

import Botao.PainelArredondado;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import model.MateriaPrima;
import model.Produtos;
import net.miginfocom.swing.MigLayout;

public class Painel6 extends PainelArredondado {

	private static final long serialVersionUID = 1L;
	private String nome;
	/**
	 * Create the panel.
	 * @param prod 
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public Painel6(MateriaPrima materia) throws FontFormatException, IOException {
		this.nome  = "<html>A Materia prima "+materia.getNome()+"<br>está a 30 dias no estoque</html>";
		inicializar();

	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public Painel6(Produtos produto) throws FontFormatException, IOException {
		this.nome  = "<html>O produto " +produto.getNome()+"<br> está a 30 dias no estoque</html>";
		inicializar();
	}

	private void inicializar() throws FontFormatException, IOException {
		setBackground(new Color(235, 219, 194));
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(13f);
		
		JLabel lbNomeMateria = new JLabel(this.nome);
		add(lbNomeMateria, "cell 1 1");
		lbNomeMateria.setFont(fonte2);
		
	}
	
	

}