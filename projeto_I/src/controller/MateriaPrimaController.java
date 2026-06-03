package controller;

import java.awt.FontFormatException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import model.MateriaPrima;
import model.MateriaPrimaDAO;
import view.Painel4;
import view.TelaDetalheMateria;
import view.TelaMateriaPrima;


/**
 * Classe responsável pela comunicação entre a view (TelaCadastro) e o model (candidatoDAO).
 */
public class MateriaPrimaController {
	private final TelaMateriaPrima view;
	private final MateriaPrimaDAO model;
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public MateriaPrimaController(TelaMateriaPrima view, MateriaPrimaDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		
		List<MateriaPrima> lista = model.listarMateriasPrimas();
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
		this.view.novaMateria(e -> {
			
			this.navegador.navegarPara("CADASTRO_MATERIA");
			
		});
		
		this.view.buscar(new KeyAdapter() {

		    public void keyReleased(KeyEvent e) {

		        String textoBusca = view.getTextoBusca();

		        List<MateriaPrima> lista;

		        if (textoBusca.isEmpty()) {

		            lista = model.listarMateriasPrimas();

		        } else {

		            lista = model.buscarMateria(textoBusca);
		        }

		        try {

		            criarPaineis(lista);

		        } catch (FontFormatException | IOException ex) {

		            ex.printStackTrace();
		        }
		    }
		});
	

	}
	
	public void criarPaineis(List<MateriaPrima> lista) throws FontFormatException, IOException{
		
		this.view.limparPaineis();
		int linha = 0;
		int coluna = 0;
		
		for(int i=0; i<lista.size(); i++) {			
			MateriaPrima materia = lista.get(i);
			Painel4 p4 = new Painel4(materia);
			if(coluna > 4) {
				coluna = 0;
				linha = linha + 2;
			}
			
			p4.addMouseListener(new MouseAdapter() {

			    @Override
			    public void mouseClicked(MouseEvent e) {

			        try {

			            TelaDetalheMateria telaDetalhe =
			                    new TelaDetalheMateria();

			            new DetalheMateriaController(
			                    telaDetalhe,
			                    model,
			                    navegador,
			                    materia,
			                    MateriaPrimaController.this
			            );

			            MateriaPrimaController.this.navegador
			                    .adicionarPainel(
			                            "DETALHE_MATERIA",
			                            telaDetalhe
			                    );

			            MateriaPrimaController.this.navegador
			                    .navegarPara("DETALHE_MATERIA");

			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			    }
			});
			
			
			this.view.addPanel4(p4, "cell "+coluna+" "+linha+",grow");
			coluna = coluna+2;
			
		
		}
		
		
		}
		
	public void recriarPaineis() throws FontFormatException, IOException {		
		List<MateriaPrima> lista = model.listarMateriasPrimas();
		criarPaineis(lista);
	}
}





