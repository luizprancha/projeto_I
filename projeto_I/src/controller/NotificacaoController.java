package controller;

import java.util.List;

import model.MateriaPrima;
import model.MateriaPrimaDAO;
import model.Produtos;
import model.ProdutosDAO;
import view.Painel6;
import view.TelaNotificacao;

public class NotificacaoController {

    private TelaNotificacao view;

    private MateriaPrimaDAO materiaDAO;

    private ProdutosDAO produtoDAO;

    public NotificacaoController(
            TelaNotificacao view,
            MateriaPrimaDAO materiaDAO,
            ProdutosDAO produtoDAO) {

        this.view = view;
        this.materiaDAO = materiaDAO;
        this.produtoDAO = produtoDAO;

        carregarNotificacoes();
    }

    public void carregarNotificacoes() {

        view.limparPaineis();

        int linha = 0;

        List<MateriaPrima> materias =
                materiaDAO.buscarMateriasParadas();

        for(MateriaPrima mp : materias) {

            Painel6 painel =
                    new Painel6(mp);

            view.addPanel6(
                    painel,
                    "cell 0 " + linha + ",growx");

            linha++;
        }

        List<Produtos> produtos =
                produtoDAO.buscarProdutosParados();

        for(Produtos produto : produtos) {

            Painel6 painel =
                    new Painel6(produto);

            view.addPanel6(
                    painel,
                    "cell 0 " + linha + ",growx");

            linha++;
        }
    }
}