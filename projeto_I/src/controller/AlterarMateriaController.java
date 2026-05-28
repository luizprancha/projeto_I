package controller;

import java.awt.FontFormatException;
import java.io.IOException;
import model.MateriaPrima;
import model.MateriaPrimaDAO;
import view.TelaAlterarMateria;

public class AlterarMateriaController {
	
	private final TelaAlterarMateria view;
	private final MateriaPrimaDAO model;
	private final Navegador navegador;
	private final MateriaPrima materiaprima;
	private final MateriaPrimaController materiaprimacontroller;

	public AlterarMateriaController(TelaAlterarMateria view, MateriaPrimaDAO model, Navegador navegador, MateriaPrima materiaprima, MateriaPrimaController materiaprimacontroller) {

		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.materiaprima = materiaprima;
		this.materiaprimacontroller = materiaprimacontroller;

		carregarDados();

		view.alterarMateria(e -> {

			String nome = view.getNome().trim();
			String cor = view.getCor().trim();
			int quantidade = view.getQuantidade();
			String tipo = view.getTipo().trim();

			StringBuilder erros = new StringBuilder();

			if (nome.isEmpty()) {
				erros.append("Nome é obrigatório\n");
			} else if (nome.length() < 3) {
				erros.append("Nome muito curto\n");
			}

			if (erros.length() > 0) {

				view.exibirMensagem("Erro", erros.toString(), 0);

			} else {

				MateriaPrima l = new MateriaPrima(
						nome,
						quantidade,
						cor,
						tipo
				);

				l.setIdMateriaPrima(materiaprima.getIdMateriaPrima());

				model.atualizarMateriaPrima(l);

				view.exibirMensagem(
						"Sucesso",
						"Loja alterada com sucesso",
						1
				);
				
				navegador.navegarPara("MATERIA_PRIMA");
				try {
					materiaprimacontroller.recriarPaineis();
				} catch (FontFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void carregarDados() {

		view.setMateria(materiaprima);

	}

}
