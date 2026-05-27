package controller;

import model.MateriaPrima;
import model.MateriaPrimaDAO;
import model.Produtos;
import model.ProdutosDAO;
import view.TelaAlterarConfeccao;
import view.TelaDetalheMateria;
import view.TelaDetalheProduto;
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
                "Produto excluído!",
                1
            );

            navegador.navegarPara("PRODUTOS");

        });

        this.view.EditarMateria(e -> {

        	try {

                TelaAlterarConfeccao tela = new TelaAlterarConfeccao();

//                new AlterarMateriaController(
//                        tela,
//                        model,
//                        navegador,
//                        materiaprima, 
//                        materiaprimacontroller
//                );

                navegador.adicionarPainel("ALTERAR_CONFECCAO", tela);
                navegador.navegarPara("ALTERAR_CONFECCAO");

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        });

    }
}