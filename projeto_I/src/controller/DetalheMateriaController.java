package controller;

import java.sql.SQLException;

import model.CarrinhoConfeccoes;
import model.ItensCarrinhoConfeccoes;
import model.ItensCarrinhoConfeccoesDAO;
import model.MateriaPrima;
import model.MateriaPrimaDAO;
import view.TelaAlterarMateria;
import view.TelaDetalheMateria;
import java.awt.FontFormatException;
import java.io.IOException;

public class DetalheMateriaController {

    private final TelaDetalheMateria view;
    private final MateriaPrimaDAO model;
    private final Navegador navegador;
    private final MateriaPrima materiaprima;
    private final MateriaPrimaController materiaprimacontroller;
    private final CarrinhoConfeccoes carrinho;

    public DetalheMateriaController(
    		TelaDetalheMateria view,
    		MateriaPrimaDAO model,
            Navegador navegador,
            MateriaPrima materiaprima,
            MateriaPrimaController materiaprimacontroller,
            CarrinhoConfeccoes carrinho) {

        this.view = view;
        this.model = model;
        this.navegador = navegador;
        this.materiaprima = materiaprima;
        this.materiaprimacontroller = materiaprimacontroller;
        this.carrinho = carrinho;

        carregarDados();

        configurarEventos();
    }

    private void carregarDados() {
        view.setMateria(materiaprima);
    }

    private void configurarEventos() {

        this.view.ExcluirMateria(e -> {

            int id = materiaprima.getIdMateriaPrima();

            ItensCarrinhoConfeccoesDAO.removerItensPorMateria(id);
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

        this.view.adicionarAoCarrinho(e -> {

            try {

                ItensCarrinhoConfeccoes item = new ItensCarrinhoConfeccoes();
                item.setIdCarrinho(carrinho.getIdCarrinho());
                item.setIdMateriaPrima(materiaprima.getIdMateriaPrima());
                item.setNomeMateria(materiaprima.getNome());
                item.setQuantidade(1);

                ItensCarrinhoConfeccoesDAO itensDAO = new ItensCarrinhoConfeccoesDAO();
                itensDAO.adicionarItem(item);

                view.exibirMensagem(
                    "Sucesso",
                    "Matéria-prima adicionada ao carrinho!",
                    1
                );

                navegador.recarregarCarrinhoConfeccoes();
                navegador.navegarPara("CARRINHO_CONFECCOES");

            } catch (SQLException exsso) {

                if (exsso.getErrorCode() == 1062) {
                    view.exibirMensagem(
                        "Erro",
                        "Matéria-prima já existe no carrinho!",
                        0
                    );
                } else {
                    view.exibirMensagem(
                        "Erro",
                        "Não foi possível adicionar ao carrinho: " + exsso.getMessage(),
                        0
                    );
                    exsso.printStackTrace();
                }

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        });

    }
}
