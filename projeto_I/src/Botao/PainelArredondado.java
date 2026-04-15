package Botao;

import java.awt.*;
import javax.swing.*;

public class PainelArredondado extends JPanel {

    private int raio;

    // ✅ construtor padrão (OBRIGATÓRIO pro NetBeans)
    public PainelArredondado() {
        this.raio = 20; // valor padrão
        setOpaque(false);
    }

    // ✅ seu construtor personalizado continua
    public PainelArredondado(int raio) {
        this.raio = raio;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), raio, raio);

        g2.dispose();
        super.paintComponent(g);
    }
}