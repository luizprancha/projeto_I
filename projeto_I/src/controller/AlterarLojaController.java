package controller;

import java.awt.FontFormatException;
import java.io.IOException;

import model.Lojas;
import model.LojasDAO;
import view.TelaAlterarLoja;

public class AlterarLojaController {

	private final TelaAlterarLoja view;
	private final LojasDAO model;
	private final Navegador navegador;
	private final Lojas loja;
	private final LojasController lojasController;

	public AlterarLojaController(
			TelaAlterarLoja view,
			LojasDAO model,
			Navegador navegador,
			Lojas loja,
			LojasController lojasController) {

		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.loja = loja;
		this.lojasController = lojasController;

		carregarDados();

		view.alterarLoja(e -> {

			String nome = view.getNomeLoja().trim();
			String CNPJ = view.getCNPJ().trim();
			String responsavel = view.getResponsavel().trim();
			String endereco = view.getEndereco().trim();
			String telefone = view.getTelefone().trim();
			String email = view.getEmail().trim();

			StringBuilder erros = new StringBuilder();

			if (nome.isEmpty()) {
				erros.append("Nome é obrigatório\n");
			} else if (nome.length() < 3) {
				erros.append("Nome muito curto\n");
			}

			if (CNPJ.isEmpty()) {
				erros.append("CNPJ é obrigatório\n");
			} else if (CNPJ.length() < 14) {
				erros.append("CNPJ inválido\n");
			}

			if (endereco.isEmpty()) {
				erros.append("Endereço é obrigatório\n");
			}

			if (telefone.isEmpty()) {
				erros.append("Telefone é obrigatório\n");
			} else if (telefone.length() < 9) {
				erros.append("Telefone inválido\n");
			}

			if (email.isEmpty()) {
				erros.append("Email é obrigatório\n");
			} else if (email.length() < 10) {
				erros.append("Email inválido\n");
			}

			if (erros.length() > 0) {

				view.exibirMensagem("Erro", erros.toString(), 0);

			} else {

				Lojas l = new Lojas(
						nome,
						CNPJ,
						responsavel,
						endereco,
						telefone,
						email
				);

				l.setIdLoja(loja.getIdLoja());

				model.atualizarLojas(l);

				view.exibirMensagem(
						"Sucesso",
						"Loja alterada com sucesso",
						1
				);
				
				navegador.navegarPara("LOJAS");
				try {
					lojasController.recriarPaineis();
				} catch (FontFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void carregarDados() {

		view.setLojas(loja);

	}
}