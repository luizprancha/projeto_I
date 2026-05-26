package controller;

import java.awt.FontFormatException;
import java.io.IOException;

import model.Confeccoes;
import model.ConfeccoesDAO;
import view.TelaAlterarConfeccao;

public class AlterarConfeccaoController {

    private final TelaAlterarConfeccao view;
    private final ConfeccoesDAO model;
    private final Navegador navegador;
    private final ConfeccaoController confeccaoController;
    private final Confeccoes confeccao;

    public AlterarConfeccaoController(
            TelaAlterarConfeccao view,
            ConfeccoesDAO model,
            Navegador navegador,
            Confeccoes confeccao,
            ConfeccaoController confeccaoController) {

        this.view = view;
        this.model = model;
        this.navegador = navegador;
        this.confeccao = confeccao;
        this.confeccaoController = confeccaoController;

        carregarDados();
        configurarEventos();
    }

    private void configurarEventos() {

        view.alterarConfeccao(e -> alterarConfeccao());
    }

    private void alterarConfeccao() {

        String nome = view.getNome().trim();
        String cnpj = view.getCNPJ().trim();
        String responsavel = view.getResponsavel().trim();
        String endereco = view.getEndereco().trim();
        String telefone = view.getTelefone().trim();
        String email = view.getEmail().trim();

        String erros = validarCampos(
                nome,
                cnpj,
                endereco,
                telefone,
                email
        );

        if (!erros.isEmpty()) {
            view.exibirMensagem("Erro", erros, 0);
            return;
        }

        Confeccoes confeccaoAtualizada = new Confeccoes(
                nome,
                cnpj,
                responsavel,
                endereco,
                telefone,
                email
        );

        confeccaoAtualizada.setIdConfeccoes(
                confeccao.getIdConfeccoes()
        );

        model.atualizarConfeccoes(confeccaoAtualizada);

        view.exibirMensagem(
                "Sucesso",
                "Confecção alterada com sucesso",
                1
        );

        navegador.navegarPara("CONFECCOES");

        try {
            confeccaoController.recriarPaineis();
        } catch (FontFormatException | IOException ex) {

            view.exibirMensagem(
                    "Erro",
                    "Erro ao atualizar a tela",
                    0
            );

            ex.printStackTrace();
        }
    }

    private String validarCampos(
            String nome,
            String cnpj,
            String endereco,
            String telefone,
            String email) {

        StringBuilder erros = new StringBuilder();

        if (nome.isEmpty()) {
            erros.append("Nome é obrigatório\n");
        } else if (nome.length() < 3) {
            erros.append("Nome muito curto\n");
        }

        if (cnpj.isEmpty()) {
            erros.append("CNPJ é obrigatório\n");
        } else if (cnpj.length() < 14) {
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
        } else if (!email.contains("@")) {
            erros.append("Email inválido\n");
        }

        return erros.toString();
    }

    private void carregarDados() {

        view.setConfeccao(confeccao);
    }
}