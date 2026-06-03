package view;

import javax.swing.JPanel;
import Botao.PainelArredondado;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import model.Notificacao;
import net.miginfocom.swing.MigLayout;

public class Painel6 extends PainelArredondado {

    private static final long serialVersionUID = 1L;

    private String mensagem;
    private JButton btnFechar;

    public Painel6(Notificacao notificacao)
            throws FontFormatException, IOException {

        if ("MATERIA_PRIMA".equals(notificacao.getTipo())) {
            this.mensagem ="<html>A matéria-prima <b>"+ notificacao.getNome()+ "</b><br>está há 30 dias no estoque.</html>";
        } else {
            this.mensagem = "<html>O produto <b>"+ notificacao.getNome()+ "</b><br>está há 30 dias no estoque.</html>";
        }
        inicializar();
    }

    private void inicializar()
        throws FontFormatException, IOException {
        setBackground(new Color(235, 219, 194));
        setLayout(new MigLayout("insets 0", "[grow][grow][grow]", "[50px!][grow][grow]"));

        Font fonte2 = Font.createFont(
                Font.TRUETYPE_FONT,
                getClass().getResourceAsStream(
                        "/fontes/Jomhuria-Regular.ttf"))
                .deriveFont(30f);

        Font fonte3 = Font.createFont(
                Font.TRUETYPE_FONT,
                getClass().getResourceAsStream(
                        "/fontes/PlayfairDisplay-Regular.ttf"))
                .deriveFont(13f);
        

        JPanel topo = new PainelArredondado();
        topo.setBackground(new Color(145, 131, 131));
        add(topo, "cell 0 0 3 1,grow");
        topo.setLayout(new MigLayout(
                "",
                "[20px!][80px!][grow][40px!]",
                "[grow]"
        ));
        

        JLabel icone = new JLabel();
        icone.setIcon(
        new ImageIcon(Painel6.class.getResource("/imagem/novelo1.png")));
        topo.add(icone, "cell 0 0,alignx center");

        JLabel titulo = new JLabel("Nó de Estoque");
        titulo.setForeground(new Color(235, 219, 194));
        titulo.setFont(fonte2);
        topo.add(titulo, "cell 1 0");

        btnFechar = new JButton("X");
        btnFechar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnFechar.setOpaque(false);
        btnFechar.setContentAreaFilled(false);
        btnFechar.setBorderPainted(false);
        btnFechar.setFocusPainted(false);
        topo.add(btnFechar, "cell 3 0,alignx right");
        
        JLabel lblMensagem = new JLabel(mensagem);
        lblMensagem.setFont(fonte3);
        add(lblMensagem, "cell 1 1,grow");
    }
    
    public void fechar(ActionListener acao) {
        btnFechar.addActionListener(acao);
    }
}