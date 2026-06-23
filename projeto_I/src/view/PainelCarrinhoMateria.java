package view;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import Botao.PainelArredondado;
import model.ItensCarrinhoConfeccoes;
import model.ItensCarrinhoConfeccoesDAO;
import model.MateriaPrima;
import model.MateriaPrimaDAO;
import view.TelaMensagem;
import java.awt.Color;
import java.awt.FontFormatException;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelCarrinhoMateria extends PainelArredondado {

	private static final long serialVersionUID = 1L;
	private JTextField tFQuantidade;
	private int quantidade = 1;
	private ItensCarrinhoConfeccoes item;
	public int selected, i;

	public PainelCarrinhoMateria(int i, ItensCarrinhoConfeccoes item)
			throws FontFormatException, IOException {

		this.i = i;
		this.item = item;
		this.quantidade = item.getQuantidade();

		setBackground(new Color(255, 255, 255));
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]",
				"[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));

		JLabel lbMateria = new JLabel(item.getNomeMateria());
		add(lbMateria, "cell 3 1,alignx center");

		JLabel lbQuantidade = new JLabel("Quantidade:");
		add(lbQuantidade, "cell 3 3,alignx center");

		JButton btnMenos = new JButton("-");
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (quantidade > 1) {
					quantidade--;
					atualizarQuantidade(true);
				}
			}
		});
		add(btnMenos, "cell 1 5,grow");

		tFQuantidade = new JTextField();
		tFQuantidade.setBackground(new Color(192, 192, 192));
		tFQuantidade.setEditable(false);
		tFQuantidade.setColumns(10);
		add(tFQuantidade, "cell 3 5,grow");

		JButton btnMais = new JButton("+");
		btnMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MateriaPrima materia = new MateriaPrimaDAO().buscarPorId(item.getIdMateriaPrima());
				int disponivel = materia != null ? materia.getQuantidade() : 0;

				if (quantidade + 1 > disponivel) {
					TelaMensagem.mostrar(
							"Aviso",
							"Estoque insuficiente! Disponível: " + disponivel);
					return;
				}

				quantidade++;
				atualizarQuantidade(true);
			}
		});
		add(btnMais, "cell 5 5,grow");

		atualizarQuantidade(false);
	}

	private void atualizarQuantidade(boolean salvar) {
		tFQuantidade.setText(String.valueOf(quantidade));
		item.setQuantidade(quantidade);
		if (salvar) {
			new ItensCarrinhoConfeccoesDAO().atualizarItem(item);
		}
	}
}
