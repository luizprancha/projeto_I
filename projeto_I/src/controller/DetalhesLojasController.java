package controller;

import java.awt.FontFormatException;
import java.io.IOException;

import model.Lojas;
import model.LojasDAO;
import view.TelaAlterarLoja;
import view.TelaDetalhesLojas;

public class DetalhesLojasController {

    private final TelaDetalhesLojas view;
    private final LojasDAO model;
    private final Navegador navegador;
    private final LojasController lojasController;
    private Lojas loja;

    public DetalhesLojasController(
            TelaDetalhesLojas view,
            LojasDAO model,
            Navegador navegador,
            Lojas loja,
            LojasController lojasController) {

        this.view = view;
        this.model = model;
        this.navegador = navegador;
        this.loja = loja;
        this.lojasController = lojasController;

        carregarDados();
        configurarEventos();
    }

    private void carregarDados() {

        view.setLojas(loja);

    }

    private void configurarEventos() {

        this.view.excluir(e -> {

            int id = loja.getIdLoja();

            LojasDAO.removerLojas(id);

            view.exibirMensagem(
                "Sucesso",
                "Loja excluída!",
                1
            );

            navegador.navegarPara("LOJAS");

            try {
                lojasController.recriarPaineis();
            } catch (FontFormatException | IOException e1) {
                e1.printStackTrace();
            }

        });

        this.view.editar(e -> {

            try {

                TelaAlterarLoja tela = new TelaAlterarLoja();

                new AlterarLojaController(
                        tela,
                        model,
                        navegador,
                        loja, 
                        lojasController
                );

                navegador.adicionarPainel("ALTERAR_LOJA", tela);
                navegador.navegarPara("ALTERAR_LOJA");

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

    }
}