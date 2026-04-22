package model;

public class Lojas {

	private int idLoja;
	private String cnpj;
	private String nome;
	private String responsavel;
	private String endereco;
	private String telefone;
	private String email;
	
	public Lojas(String nome, String cnpj, int idLoja, String responsavel, String endereco, String telefone, String email) {
		super();
		this.idLoja = idLoja;
		this.nome = nome;
		this.cnpj = cnpj;
		this.responsavel = responsavel;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Lojas() {
		super();
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
	
}
