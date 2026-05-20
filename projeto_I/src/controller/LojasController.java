package controller;

import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import model.Lojas;
import model.LojasDAO;
import view.Painel3;
import view.TelaDetalhesLojas;
import view.TelaLojas;

public class LojasController {

    private final TelaLojas view;
    private final LojasDAO model;
    private final Navegador navegador;
    

    public LojasController(
            TelaLojas view,
            LojasDAO model,
            Navegador navegador) {

        this.view = view;
        this.model = model;
        this.navegador = navegador;

        List<Lojas> lista = model.listarLojas();

        try {
            criarPaineis(lista);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        // Botão nova loja
        this.view.novaLoja(e -> {

            this.navegador.navegarPara("CADASTRO_LOJAS");

        });

    }

    public void criarPaineis(List<Lojas> lista)
            throws FontFormatException, IOException {

        this.view.limparPaineis();

        int linha = 0;
        int coluna = 0;

        for (int i = 0; i < lista.size(); i++) {

            Lojas loja = lista.get(i);

            Painel3 p3 = new Painel3(loja);

            if (coluna > 4) {
                coluna = 0;
                linha = linha + 2;
            }

            p3.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    try {

                        TelaDetalhesLojas telaDetalhe =
                                new TelaDetalhesLojas();

                        new DetalhesLojasController(
                                telaDetalhe,
                                model,
                                navegador,
                                loja,
                                LojasController.this
                        );

                        LojasController.this.navegador.adicionarPainel(
                                "DETALHES_LOJAS",
                                telaDetalhe
                        );

                        LojasController.this.navegador.navegarPara(
                                "DETALHES_LOJAS"
                        );

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            });

            this.view.addPanel3(
                    p3,
                    "cell " + coluna + " " + linha + ",grow"
            );

            coluna = coluna + 2;

            this.view.revalidate();
            this.view.repaint();
        }

    }

    public void recriarPaineis()
            throws FontFormatException, IOException {

        List<Lojas> lista = model.listarLojas();

        criarPaineis(lista);
    }

}