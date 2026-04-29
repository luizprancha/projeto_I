package controller;

import model.Confeccoes;
import model.ConfeccoesDAO;
import view.TelaCadastroConfeccao;

public class CadastroConfeccaoController {
	private final TelaCadastroConfeccao view;
	private final ConfeccoesDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public CadastroConfeccaoController(TelaCadastroConfeccao view, ConfeccoesDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		//Define o que será executado quando o botão 'Cadastrar' da TelaCadastroProdutos for clicado.
		view.cadastrarConfeccao(e -> {
			String nomeConfeccao = view.getNomeConfeccao().trim();
			String CNPJ = view.getCNPJ().trim();
			String Endereco = view.getEndereco().trim();
		

			StringBuilder erros = new StringBuilder();

			if (nomeConfeccao.isEmpty()) {
			    erros.append("Nome é obrigatório\n");
			} else if (nomeConfeccao.length() < 3) {
			    erros.append("Nome muito curto\n");
			}

			if (CNPJ.isEmpty()) {
			    erros.append("Tipo é obrigatório\n");
			} else if (CNPJ.length() < 14) {
			    erros.append("Tipo inválido\n");
			}

			if (Endereco.isEmpty()) {
			    erros.append("Endereço é obrigatório\n");
			} else if (!Endereco.matches("[a-zA-ZÀ-ÿ ]+")) {
			    erros.append("Endereço inválido\n");
			}

			if (erros.length() > 0) {
			    view.exibirMensagem("Erro", erros.toString(), 0);
			    
			} else {
			    Confeccoes c = new Confeccoes(nomeConfeccao, CNPJ, Endereco);
			    model.adicionarProduto(p);
			    view.limparCampos();
			    view.exibirMensagem("Sucesso", "Produto salvo!", 1);
			}
			});


}
}

