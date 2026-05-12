package controller;

import model.Confeccoes;
import model.ConfeccoesDAO;
import model.ProdutosDAO;
import view.TelaDetalhesConfeccoes;

public class DetalhesConfeccoesController {

    private final TelaDetalhesConfeccoes view;
    private final ConfeccoesDAO model;
    private final Navegador navegador;

    private Confeccoes confeccoes;

    public DetalhesConfeccoesController(
    		TelaDetalhesConfeccoes view,
    		ConfeccoesDAO model,
            Navegador navegador,
            Confeccoes confeccoes) {

        this.view = view;
        this.model = model;
        this.navegador = navegador;
        this.confeccoes = confeccoes;

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
                "Produto excluído!",
                1
            );

            navegador.navegarPara("CONFECCAO");

        });

        this.view.editarConfeccao(e -> {

            navegador.navegarPara("CADASTRO_CONFECCAO");

        });

    }
}