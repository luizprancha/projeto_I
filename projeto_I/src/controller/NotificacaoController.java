package controller;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

import model.Notificacao;
import model.NotificacaoDAO;
import view.Painel6;
import view.TelaNotificacao;

public class NotificacaoController {

    private TelaNotificacao view;
    private NotificacaoDAO notificacaoDAO;

    public NotificacaoController(
            TelaNotificacao view,
            NotificacaoDAO notificacaoDAO) {

        this.view = view;
        this.notificacaoDAO = notificacaoDAO;

        carregarNotificacoes();
    }

    public void carregarNotificacoes() {

        view.limparPaineis();

        int linha = 0;
        int coluna = 0;

        List<Notificacao> notificacoes =
                notificacaoDAO.buscarNotificacoes();

        for (Notificacao notificacao : notificacoes) {

            try {

                Painel6 painel = new Painel6(notificacao);
                painel.fechar((ActionEvent e) -> fecharNotificacao(notificacao));

                view.addPanel6(painel, "cell " + coluna + " " + linha + ",grow"
                );
                coluna++;

                if (coluna >= 2) {
                    coluna = 0;
                    linha++;
                }
            } catch (FontFormatException | IOException e) {
                e.printStackTrace();
            }
        }
        view.revalidate();
        view.repaint();
    }
    
    public void recriarPaineis() {
        carregarNotificacoes();        
    }
    
    private void fecharNotificacao(Notificacao notificacao) {
        notificacaoDAO.descartar(notificacao.getTipo(), notificacao.getNome());
        recriarPaineis();
    }
    
}