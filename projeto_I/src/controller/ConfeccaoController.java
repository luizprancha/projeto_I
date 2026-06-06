package controller;

import java.awt.FontFormatException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import model.Confeccoes;
import model.ConfeccoesDAO;
import view.Painel;
import view.TelaConfeccoes;
import view.TelaDetalhesConfeccoes;

public class ConfeccaoController {

    private final TelaConfeccoes view;
    private final ConfeccoesDAO model;
    private final Navegador navegador;

    /**
     * Construtor da classe
     * @param view Referência à tela
     * @param model Referência ao DAO
     * @param navegador Navegador de telas
     */
    public ConfeccaoController(TelaConfeccoes view,ConfeccoesDAO model,Navegador navegador) {

        this.view = view;
        this.model = model;
        this.navegador = navegador;

        List<Confeccoes> lista = model.listarConfeccoes();

        try {
            criarPaineis(lista);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        // Botão cadastrar
        this.view.cadastrarConfeccao(e -> {

            this.navegador.navegarPara("CADASTRO_CONFECCAO");

        });
        
        this.view.buscar(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {

                String textoBusca = view.getTextoBusca();

                List<Confeccoes> lista;

                if (textoBusca.isEmpty()) {
                    lista = model.listarConfeccoes();
                } else {
                    lista = model.buscarConfeccoes(textoBusca);
                }

                try {
                    criarPaineis(lista);
                } catch (FontFormatException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    public void criarPaineis(List<Confeccoes> lista)
            throws FontFormatException, IOException {

        this.view.limparPaineis();

        int linha = 0;
        int coluna = 0;

        for (int i = 0; i < lista.size(); i++) {

            Confeccoes conf = lista.get(i);

            Painel p = new Painel(conf);

            if (coluna > 4) {
                coluna = 0;
                linha = linha + 2;
            }

            p.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    try {

                        TelaDetalhesConfeccoes telaDetalhe =
                                new TelaDetalhesConfeccoes();

                        new DetalhesConfeccoesController(
                                telaDetalhe,
                                model,
                                navegador,
                                conf,
                                ConfeccaoController.this
                        );

                        ConfeccaoController.this.navegador.adicionarPainel(
                                "DETALHES_CONFECCAO",
                                telaDetalhe
                        );

                        ConfeccaoController.this.navegador.navegarPara(
                                "DETALHES_CONFECCAO"
                        );

                    } catch (FontFormatException | IOException ex) {
                        ex.printStackTrace();
                    }

                }
            });

            this.view.addPanel(
                    p,
                    "cell " + coluna + " " + linha + ",grow"
            );

            coluna = coluna + 2;

            this.view.revalidate();
            this.view.repaint();
        }

    }

    public void recriarPaineis()
        throws FontFormatException, IOException {

        List<Confeccoes> lista = model.listarConfeccoes();

        criarPaineis(lista);
    }

}