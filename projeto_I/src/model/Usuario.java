package model;

public class Usuario {

	private String user;
	private String senha;
	private String cargo;
	private String nome;
	private int id;
	
	public Usuario(String user, String senha, String cargo, String CPF, String nome, int id) {
		super();
		this.user = user;
		this.senha = senha;
		this.cargo = cargo;
		this.nome = nome;
		this.id = id;
	}
	public Usuario() {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	
	
	
	
	
}
