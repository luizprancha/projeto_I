package controller;

import model.LojasDAO;
import view.TelaDetalhesLojas;

public class DetalhesLojasController {

	private final TelaDetalhesLojas view;
	private final LojasDAO model;
	private final Navegador navegador;

	public DetalhesLojasController(
			TelaDetalhesLojas view,
			LojasDAO model,
			Navegador navegador) {

		this.view = view;
		this.model = model;
		this.navegador = navegador;

		// EXCLUIR
		this.view.excluir(e -> {

			try {

				int id = lojas.getIdLoja();

				LojasDAO.removerLojas(id);

				view.exibirMensagem(
					"Sucesso",
					"Loja excluída!",
					1
				);

				navegador.navegarPara(
					"LOJAS"
				);

			} catch (Exception ex) {

				ex.printStackTrace();

				view.exibirMensagem(
					"Erro",
					"Erro ao excluir loja!",
					0
				);
			}
		});

		// EDITAR
		this.view.editar(e -> {

			this.navegador.navegarPara(
				"CADASTRO_LOJA"
			);

		});
	}
}