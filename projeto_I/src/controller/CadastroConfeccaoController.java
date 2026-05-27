		package controller;

import model.Confeccoes;
import model.ConfeccoesDAO;
import view.TelaCadastroConfeccao;

public class CadastroConfeccaoController {
	private final TelaCadastroConfeccao view;
	private final ConfeccoesDAO model;
	@SuppressWarnings("unused")
	private final Navegador navegador;
	private final ConfeccaoController confeccaocontroller;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastroProdutos).
	 * @param model Referência ao modelo de dados (ProdutosDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public CadastroConfeccaoController(TelaCadastroConfeccao view, ConfeccoesDAO model, Navegador navegador, ConfeccaoController confeccaocontroller) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.confeccaocontroller = confeccaocontroller;

		view.cadastrarConfeccao(e -> {
			String nome = view.getNome().trim();
			String CNPJ = view.getCnpj().trim();
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
			    erros.append("Cnpj é obrigatório\n");
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
			    erros.append("Tipo é obrigatório\n");
			} else if (email.length() < 10) {
			    erros.append("Tipo inválido\n");
			}

			if (erros.length() > 0) {
			    view.exibirMensagem("Erro", erros.toString(), 0);
			    
			} else {
			    Confeccoes c = new Confeccoes(nome, CNPJ, responsavel, endereco, telefone, email);
			    if (model.existeCNPJ(CNPJ)) {
			    	view.exibirMensagem(
			    		"Erro",
			    		"Já existe uma confecção cadastrada com esse CNPJ",
			    		0
			    	);

			    	return;
			    }
			    else {
			    	model.adicionarConfeccoes(c);
			    	view.limparCampos();
			    	view.exibirMensagem("Sucesso", "Confecção Cadastratada", 1);
			    }
			}
			});


}
}

