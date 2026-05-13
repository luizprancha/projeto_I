package controller;

import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;


import model.Lojas;
import model.LojasDAO;
import view.Painel3;
import view.TelaLojas;


public class LojasController {
	
	private final TelaLojas view;
	private final LojasDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public LojasController(TelaLojas view, LojasDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		
		List<Lojas> lista = model.listarLojas();
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
		this.view.novaLoja(e -> {
			
			this.navegador.navegarPara("CADASTRO_LOJAS");
			
		});
	}
	
public void criarPaineis(List<Lojas> lista) throws FontFormatException, IOException{
		
		this.view.limparPaineis();
		int linha = 0;
		int coluna = 0;
		
		for(int i=0; i<lista.size(); i++) {
			Lojas loja = lista.get(i);
			Painel3 p3 = new Painel3(loja);
			if(coluna > 4) {
				coluna = 0;
				linha = linha + 2;
			}
			
			p3.addMouseListener(new MouseAdapter() {
				
				
				@Override
				public void mouseClicked(MouseEvent e) {
					  System.out.println("Painel clicado!");
					  LojasController.this.navegador.navegarPara("DETALHES_LOJAS");
					
				}
			});
			this.view.addPanel3(p3, "cell "+coluna+" "+linha+",grow");
			coluna = coluna+2;
			
		
		}
		
		
		}
		
	public void recriarPaineis() throws FontFormatException, IOException {
		
		List<Lojas> lista = model.listarLojas();
		criarPaineis(lista);
	}

}


