package controller;

import java.awt.FontFormatException;
import java.io.IOException;
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

    public NotificacaoController(TelaNotificacao view, MateriaPrimaDAO materiaDAO, ProdutosDAO produtoDAO) {
        this.view = view;
        this.materiaDAO = materiaDAO;
        this.produtoDAO = produtoDAO;
        carregarNotificacoes();
    }

    public void carregarNotificacoes() {

        view.limparPaineis();

        int linha = 0;
        int coluna = 0;

        List<MateriaPrima> materias =
                materiaDAO.buscarMateriasParadas();

        for(MateriaPrima mp : materias) {
        

            Painel6 painel;
			try {
				painel = new Painel6(mp);
				
			view.addPanel6(painel,  "cell "+coluna+" "+ linha+",grow");
            
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			linha++;
        }
        
        linha = 0;
        coluna = 0;

        List<Produtos> produtos =
                produtoDAO.buscarProdutosParados();
        

        for(Produtos produto : produtos) {
        	
        	if(coluna > 1) {
				coluna = 0;
				linha ++;
			}

            Painel6 painel;
			try {
				painel = new Painel6(produto);

            view.addPanel6(painel,  "cell "+coluna+" "+ linha+",grow");
            coluna = coluna+2;
            
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			coluna++;
        }
    }
}