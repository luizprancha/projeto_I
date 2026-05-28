package controller;

import java.awt.FontFormatException;
import java.io.IOException;
import model.Confeccoes;
import model.ConfeccoesDAO;
import view.TelaAlterarConfeccao;
import view.TelaDetalhesConfeccoes;

public class DetalhesConfeccoesController {

	private final TelaDetalhesConfeccoes view;
    private final ConfeccoesDAO model;
    private final Navegador navegador;
    private final ConfeccaoController confeccaoController;
    private Confeccoes confeccoes;

    public DetalhesConfeccoesController(
            TelaDetalhesConfeccoes view,
            ConfeccoesDAO model,
            Navegador navegador,
            Confeccoes confeccoes,
            ConfeccaoController confeccaoController) {

        this.view = view;
        this.model = model;
        this.navegador = navegador;
        this.confeccoes = confeccoes;
        this.confeccaoController = confeccaoController;

        carregarDados();

        configurarEventos();
    }

    private void carregarDados() {
    	
        view.setConfeccao(confeccoes);

    }

    private void configurarEventos() {

        this.view.excluirConfeccao(e -> {

            int id = confeccoes.getIdConfeccoes();

            ConfeccoesDAO.removerConfeccoes(id);

            view.exibirMensagem(
                "Sucesso",
                "Confecção excluída!",
                1
            );

            navegador.navegarPara("CONFECCAO");
            try {
				confeccaoController.recriarPaineis();
			} catch (FontFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

        });

        this.view.editarConfeccao(e -> {

            try {

                TelaAlterarConfeccao tela = new TelaAlterarConfeccao();

                new AlterarConfeccaoController(
                        tela,
                        model,
                        navegador,
                        confeccoes, 
                        confeccaoController
                );

                navegador.adicionarPainel("ALTERAR_CONFECCAO", tela);
                navegador.navegarPara("ALTERAR_CONFECCAO");

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

    }
}