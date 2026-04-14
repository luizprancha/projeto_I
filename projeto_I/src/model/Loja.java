package model;

public class Loja {

	private String nome;
	private String cnpj;
	private int idLoja;
	private String localizacao;
	
	public Loja(String nome, String cnpj, int idLoja, String localizacao) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.idLoja = idLoja;
		this.localizacao = localizacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(int idLoja) {
		this.idLoja = idLoja;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	
	
}
