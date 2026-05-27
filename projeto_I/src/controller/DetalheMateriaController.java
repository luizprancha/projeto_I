package controller;

import model.LojasDAO;
import model.MateriaPrima;
import model.MateriaPrimaDAO;
import model.Produtos;
import model.ProdutosDAO;
import view.TelaAlterarConfeccao;
import view.TelaAlterarLoja;
import view.TelaAlterarMateria;
import view.TelaDetalheMateria;
import view.TelaDetalheProduto;

import java.awt.FontFormatException;
import java.io.IOException;

import controller.AlterarMateriaController;

public class DetalheMateriaController {

    private final TelaDetalheMateria view;
    private final MateriaPrimaDAO model;
    private final Navegador navegador;
    private final MateriaPrima materiaprima;
    private final MateriaPrimaController materiaprimacontroller;

    public DetalheMateriaController(
    		TelaDetalheMateria view,
    		MateriaPrimaDAO model,
            Navegador navegador,
            MateriaPrima materiaprima,
            MateriaPrimaController materiaprimacontroller) {

        this.view = view;
        this.model = model;
        this.navegador = navegador;
        this.materiaprima = materiaprima;
        this.materiaprimacontroller = materiaprimacontroller;

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
                "Materia prima excluída!",
                1
            );

            navegador.navegarPara("MATERIA_PRIMA");

            try {
            	materiaprimacontroller.recriarPaineis();
            } catch (FontFormatException | IOException e1) {
                e1.printStackTrace();
            }

        });

        this.view.EditarMateria(e -> {

            try {

                TelaAlterarMateria tela = new TelaAlterarMateria();

                new AlterarMateriaController(
                        tela,
                        model,
                        navegador,
                        materiaprima, 
                        materiaprimacontroller
                );

                navegador.adicionarPainel("ALTERAR_MATERIA", tela);
                navegador.navegarPara("ALTERAR_MATERIA");

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

    }
}