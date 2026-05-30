package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import model.MateriaPrima;
import model.Produtos;
import net.miginfocom.swing.MigLayout;

public class Painel6 extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel lblTitulo;
    private JLabel lblNome;
    private JLabel lblInfo1;
    private JLabel lblInfo2;

    public Painel6(MateriaPrima mp) {

        configurarTela();

        lblTitulo.setText("⚠ Matéria-prima parada");
        lblNome.setText("Nome: " + mp.getNome());
        lblInfo1.setText("Quantidade: " + mp.getQuantidade());
        lblInfo2.setText("Tipo: " + mp.getTipo());
    }

    public Painel6(Produtos produto) {

        configurarTela();

        lblTitulo.setText("⚠ Produto parado");
        lblNome.setText("Nome: " + produto.getNome());
        lblInfo1.setText("Estoque: " + produto.getQuantidade());
        lblInfo2.setText("Tamanho: " + produto.getTamanho());
    }

    private void configurarTela() {

        setBackground(new Color(235,219,194));

        setLayout(new MigLayout(
                "",
                "[grow]",
                "[][][][]"));

        lblTitulo = new JLabel();
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));

        lblNome = new JLabel();
        lblInfo1 = new JLabel();
        lblInfo2 = new JLabel();

        add(lblTitulo, "cell 0 0");
        add(lblNome, "cell 0 1");
        add(lblInfo1, "cell 0 2");
        add(lblInfo2, "cell 0 3");
    }
}