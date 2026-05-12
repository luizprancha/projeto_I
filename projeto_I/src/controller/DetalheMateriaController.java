package controller;

import model.MateriaPrima;
import model.MateriaPrimaDAO;
import model.Produtos;
import model.ProdutosDAO;
import view.TelaDetalheMateria;
import view.TelaDetalheProduto;

public class DetalheMateriaController {

    private final TelaDetalheMateria view;
    private final MateriaPrimaDAO model;
    private final Navegador navegador;

    private MateriaPrima materiaprima;

    public DetalheMateriaController(
    		TelaDetalheMateria view,
    		MateriaPrimaDAO model,
            Navegador navegador,
            MateriaPrima materiaprima) {

        this.view = view;
        this.model = model;
        this.navegador = navegador;
        this.materiaprima = materiaprima;

        carregarDados();

        configurarEventos();
    }

    private void carregarDados() {
    	
        view.setMateria(materiaprima);

    }

    private void configurarEventos() {

        this.view.ExcluirMateria(e -> {

            int id = materiaprima.getIdMateriaPrima();

            MateriaPrimaDAO.removerMateria(id);

            view.exibirMensagem(
                "Sucesso",
                "Produto excluído!",
                1
            );

            navegador.navegarPara("PRODUTOS");

        });

        this.view.EditarMateria(e -> {

            navegador.navegarPara("CADASTRO_PRODUTO");

        });

    }
}