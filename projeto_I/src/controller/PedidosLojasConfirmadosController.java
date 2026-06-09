package controller;

import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.LojasDAO;
import model.PedidosLojas;
import model.PedidosLojasDAO;
import view.Painel7;
import view.TelaDetalhePedidosLojas;
import view.TelaPedidosLojasConfirmados;


public class PedidosLojasConfirmadosController {

    private final TelaPedidosLojasConfirmados view;
    private final PedidosLojasDAO model;
    private final Navegador navegador;
    private final LojasDAO lojasDAO;

    private List<PedidosLojas> lista;

    public PedidosLojasConfirmadosController(
            TelaPedidosLojasConfirmados view,
            PedidosLojasDAO model,
            Navegador navegador,
            LojasDAO lojasDAO) {

        this.view = view;
        this.model = model;
        this.navegador = navegador;
        this.lojasDAO = new LojasDAO();

        this.view.realizarPedido(e -> {
            this.navegador.navegarPara("PEDIDOS_LOJAS_VIZU");
        });

        try {

            lista = model.listarPedidosLojas();

            for (PedidosLojas pedido : lista) {

                if (pedido.getNomeLoja() == null
                        || pedido.getNomeLoja().isEmpty()) {

                    pedido.setNomeLoja(
                            lojasDAO.buscarNomePorCNPJ(
                                    pedido.getLojas_CNPJ()));
                }
            }

            criarPaineis(lista);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        this.view.getTfBuscar().getDocument().addDocumentListener(
                new DocumentListener() {

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        filtrar();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        filtrar();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        filtrar();
                    }

                    private void filtrar() {

                        String texto = view.getTfBuscar()
                                .getText()
                                .trim()
                                .toLowerCase();

                        if (texto.isEmpty()) {

                            try {
                                criarPaineis(lista);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                            return;
                        }

                        List<PedidosLojas> filtrados = new ArrayList<>();

                        for (PedidosLojas pedido : lista) {

                            String nome = pedido.getNomeLoja();

                            if (nome != null
                                    && nome.toLowerCase().contains(texto)) {

                                filtrados.add(pedido);
                            }
                        }

                        try {
                            criarPaineis(filtrados);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
    }

    public void criarPaineis(List<PedidosLojas> lista)
            throws FontFormatException, IOException {

        this.view.limparPaineis();

        int linha = 0;
        int coluna = 0;

        for (int i = 0; i < lista.size(); i++) {

            PedidosLojas ped = lista.get(i);

            Painel7 p7 = new Painel7(ped);

            if (coluna > 4) {
                coluna = 0;
                linha = linha + 2;
            }

            p7.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    try {

                        TelaDetalhePedidosLojas telaDetalhePedidosLojas =
                                new TelaDetalhePedidosLojas();

                        new DetalhesPedidosLojasController(
                                telaDetalhePedidosLojas,
                                model,
                                navegador,
                                ped,
                                PedidosLojasConfirmadosController.this
                        );

                        PedidosLojasConfirmadosController.this.navegador
                                .adicionarPainel(
                                        "DETALHES_CONFECCAO",
                                        telaDetalhePedidosLojas
                                );

                        PedidosLojasConfirmadosController.this.navegador
                                .navegarPara("DETALHES_CONFECCAO");

                    } catch (FontFormatException | IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            this.view.addPanel7(
                    p7,
                    "cell " + coluna + " " + linha + ",grow"
            );

            coluna = coluna + 2;
        }

        this.view.revalidate();
        this.view.repaint();
    }

    public void recriarPaineis() {

        try {

            lista = model.listarPedidosLojas();

            for (PedidosLojas pedido : lista) {

                if (pedido.getNomeLoja() == null
                        || pedido.getNomeLoja().isEmpty()) {

                    pedido.setNomeLoja(
                            lojasDAO.buscarNomePorCNPJ(
                                    pedido.getLojas_CNPJ()));
                }
            }

            criarPaineis(lista);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}