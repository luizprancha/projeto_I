package controller;

import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import model.Produtos;

import model.ProdutosDAO;
import view.Painel;
import view.TelaDetalheProduto;
import view.TelaProdutos;


/**
 * Classe responsável pela comunicação entre a view (TelaCadastro) e o model (candidatoDAO).
 */
public class ProdutosController {
	private final TelaProdutos view;
	private final ProdutosDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public ProdutosController(TelaProdutos view, ProdutosDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		
		
		List<Produtos> lista = model.listarProdutos();
		try {
			criarPaineis(lista);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Define o que será executado quando o botão 'Cadastrar Produto' da TelaProdutos for clicado.
		this.view.cadastrarProduto(e -> {
			
			this.navegador.navegarPara("CADASTRO_PRODUTO");
			
		});
	

	}
	
	public void criarPaineis(List<Produtos> lista) throws FontFormatException, IOException{
		int linha = 0;
		int coluna = 0;
		
		for(int i=0; i<lista.size(); i++) {
			Produtos prod = lista.get(i);
			Painel p = new Painel(prod);
			if(coluna > 4) {
				coluna = 0;
				linha = linha + 2;
			}
			
			p.addMouseListener(new MouseAdapter() {
				
				
				@Override
				public void mouseClicked(MouseEvent e) {
					  System.out.println("Painel clicado!");
					  ProdutosController.this.navegador.navegarPara("DETALHES_PRODUTOS");
					
				}
			});
			this.view.addPanel(p, "cell "+coluna+" "+linha+",grow");
			coluna = coluna+2;
		}
		
	}

}

