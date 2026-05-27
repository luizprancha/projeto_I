package controller;

import model.Confeccoes;
import model.Lojas;
import model.LojasDAO;
import view.TelaCadastroLoja;

public class CadastroLojaController {
	private final TelaCadastroLoja view;
	private final LojasDAO model;
	private final Navegador navegador;
	private final LojasController lojascontroller;
	
	public CadastroLojaController(TelaCadastroLoja view, LojasDAO model, Navegador navegador, LojasController lojascontroller) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.lojascontroller = lojascontroller;
		
		view.cadastroLoja(e ->{
			String nomeLoja = view.getNomeLoja().trim();
			String CNPJ = view.getCNPJ().trim();
			String responsavel = view.getResponsavel().trim();
			String endereco = view.getEndereco().trim();
			String telefone = view.getTelefone().trim();
			String email = view.getEmail().trim();
			
			StringBuilder erros = new StringBuilder();
			
			if (nomeLoja.isEmpty()) {
			    erros.append("Nome é obrigatório\n");
			} else if (nomeLoja.length() < 3) {
			    erros.append("Nome muito curto\n");
			}

			if (CNPJ.isEmpty()) {
			    erros.append("CNPJ é obrigatório\n");
			} else if (CNPJ.length() < 14) {
			    erros.append("CNPJ inválido\n");
			}

			if (endereco.isEmpty()) {
			    erros.append("Endereço é obrigatório\n");
			} else if (!endereco.matches("[a-zA-ZÀ-ÿ ]+")) {
			    erros.append("Endereço inválido\n");
			}
			
			if (erros.length() > 0) {
			    view.exibirMensagem("Erro", erros.toString(), 0);
			    
			} else {
			    Lojas l = new Lojas(nomeLoja, CNPJ, responsavel, endereco, telefone, email);
			    model.adicionarLojas(l);
			    view.limparCampos();
			    view.exibirMensagem("Sucesso", "Loja salva!", 1);
			    try {

			    	lojascontroller.recriarPaineis();

				    navegador.navegarPara("LOJAS");

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
