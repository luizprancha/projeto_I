package controller;

import java.time.LocalDate;

import model.MateriaPrima;
import model.MateriaPrimaDAO;
import view.TelaCadastroMateria;

public class CadastroMateriaController {
	private final TelaCadastroMateria view;
	private final MateriaPrimaDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;
	private final MateriaPrimaController materiaPrimaController;

	public CadastroMateriaController(TelaCadastroMateria view, MateriaPrimaDAO model, Navegador navegador, MateriaPrimaController materiaPrimaController) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.materiaPrimaController = materiaPrimaController;
		

		this.view.cadastro(e -> {

			
			String nome = view.getNome().trim();
			String tipo = view.getTipo().trim();
			int quantidade = view.getQuantidade();
			String cor = view.getCor().trim();

			StringBuilder erros = new StringBuilder();

			if (nome.isEmpty()) {
				erros.append("Nome é obrigatório\n");
			} else if (nome.length() < 3) {
				erros.append("Nome muito curto\n");
			}

			if (quantidade < 0) {
				erros.append("Quantidade não pode ser negativa\n");
			}

			if (cor.isEmpty()) {
				erros.append("Cor é obrigatória\n");
			} else if (cor.length() < 2) {
				erros.append("Cor inválida\n");
			}

			
			if (erros.length() > 0) {
				view.exibirMensagem("Erro", erros.toString(), 0);
			} else {
				MateriaPrima m = new MateriaPrima(nome, quantidade, cor, tipo, LocalDate.now());
				model.adicionarMateriaPrima(m);
				view.limparCampos();
				view.exibirMensagem("Sucesso", "Matéria-Prima salva!", 1);
				try {

				    materiaPrimaController.recriarPaineis();

				    navegador.navegarPara("MATERIA_PRIMA");

				} catch (Exception ex) {

				    view.exibirMensagem(
				            "Erro",
				            "Erro ao atualizar a tela",
				            0
				    );

				    ex.printStackTrace();
				}
			}
		});
	}
}