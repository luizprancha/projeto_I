package model;

public class Confeccoes {


	private int idConfeccoes;
	private String nome;
	private String cnpj;
	private String responsavel;
	private String endereco;
	private String telefone;
	private String email;
	
	public Confeccoes(String nome, String cnpj, String responsavel, int idConfeccoes, String endereco, String telefone, String email) {
		super();

		this.idConfeccoes = idConfeccoes;
		this.nome = nome;
		this.cnpj = cnpj;
		this.responsavel = responsavel;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Confeccoes() {
		super();
	}

	public int getIdConfeccoes() {
		return idConfeccoes;
	}

	public void setidConfeccoes(int idConfeccoes) {
		this.idConfeccoes = idConfeccoes;
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


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdConfeccoes(int idConfeccoes) {
		this.idConfeccoes = idConfeccoes;
	}
	
	
}
