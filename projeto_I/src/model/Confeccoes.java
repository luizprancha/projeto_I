package model;

public class Confeccoes {


	private int idConfeccao;
	private String nome;
	private String localizacao;
	private String cnpj;
	
	public Confeccoes(int idConfeccao, String nome, String localizacao,
			String cnpj) {
		super();

		this.idConfeccao = idConfeccao;
		this.nome = nome;
		this.localizacao = localizacao;
		this.cnpj = cnpj;
	}


	public int getIdConfeccao() {
		return idConfeccao;
	}

	public void setIdConfeccao(int idConfeccao) {
		this.idConfeccao = idConfeccao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	
}
