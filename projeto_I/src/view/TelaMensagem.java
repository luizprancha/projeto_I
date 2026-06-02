package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TelaMensagem extends JDialog {

    private static final long serialVersionUID = 1L;

    public TelaMensagem(String titulo, String mensagem) {

        setTitle(titulo);
        setModal(true);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel(new BorderLayout());
        painel.setBackground(new Color(240, 240, 240));

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel lblMensagem = new JLabel(
                "<html><div style='text-align:center'>" + mensagem + "</div></html>");
        lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
        lblMensagem.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton btnOk = new JButton("OK");

        btnOk.addActionListener(e -> dispose());

        painel.add(lblTitulo, BorderLayout.NORTH);
        painel.add(lblMensagem, BorderLayout.CENTER);
        painel.add(btnOk, BorderLayout.SOUTH);

        add(painel);
    }

    public static void mostrar(String titulo, String mensagem) {
        TelaMensagem tela = new TelaMensagem(titulo, mensagem);
        tela.setVisible(true);
    }
}