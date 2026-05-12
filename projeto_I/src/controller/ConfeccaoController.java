package controller;

import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import model.Confeccoes;
import model.ConfeccoesDAO;
import model.Produtos;
import model.ProdutosDAO;
import view.Painel;
import view.Painel2;
import view.TelaConfeccoes;
import view.TelaProdutos;

public class ConfeccaoController {
	
	private final TelaConfeccoes view;
	private final ConfeccoesDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public ConfeccaoController(TelaConfeccoes view, ConfeccoesDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		
		List<Confeccoes> lista = model.listarConfeccoes();
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
		this.view.cadastrarConfeccao(e -> {
			
			this.navegador.navegarPara("CADASTRO_CONFECCAO");
			
		});
	

	}
	
	public void criarPaineis(List<Confeccoes> lista) throws FontFormatException, IOException{
		
		this.view.limparPaineis();
		int linha = 0;
		int coluna = 0;
		
		for(int i=0; i<lista.size(); i++) {
			Confeccoes conf = lista.get(i);
			Painel2 p2 = new Painel2(conf);
			if(coluna > 4) {
				coluna = 0;
				linha = linha + 2;
			}
			
			p2.addMouseListener(new MouseAdapter() {
				
				
				@Override
				public void mouseClicked(MouseEvent e) {
					  System.out.println("Painel clicado!");
					  ConfeccaoController.this.navegador.navegarPara("DETALHES_CONFECCOES");
					
				}
			});
			this.view.addPanel2(p2, "cell "+coluna+" "+linha+",grow");
			coluna = coluna+2;
			
		
		}
		
		
		}
		
	public void recriarPaineis() throws FontFormatException, IOException {
		
		List<Confeccoes> lista = model.listarConfeccoes();
		criarPaineis(lista);
	}
}




