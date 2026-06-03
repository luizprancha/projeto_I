package model;

import java.time.LocalDateTime;

public class Notificacao {
	private String tipo;
    private String nome;
    private LocalDateTime dataCadastro;

    public Notificacao(String tipo, String nome, LocalDateTime dataCadastro) {
        this.tipo = tipo;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getdataCadastro() {
        return dataCadastro;
    }

}
