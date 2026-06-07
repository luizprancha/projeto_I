package view;

import Botao.PainelArredondado;
import model.PedidoConfeccao;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Painel8 extends PainelArredondado {

	private static final long serialVersionUID = 1L;

	public Painel8(PedidoConfeccao pedido) throws FontFormatException, IOException {
		setBackground(new Color(235, 219, 194));
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow]"));

		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(13f);

		String nome = pedido.getNomeConfeccao() != null ? pedido.getNomeConfeccao() : "Confecção";
		JLabel lbNome = new JLabel(nome);
		add(lbNome, "cell 1 1");
		lbNome.setFont(fonte2);

		String dataEntrega = "";
		if (pedido.getEntrega() != null) {
			dataEntrega = pedido.getEntrega().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}
		JLabel lbEntrega = new JLabel("Entrega: " + dataEntrega);
		add(lbEntrega, "cell 1 3");
		lbEntrega.setFont(fonte2);
	}
}
