package model;

public class Administrador extends Usuario{

	private int idAdministrador;

	public Administrador(String user, String senha, String cargo, String nome, int idAdministrador) {
		super(user, senha, cargo, nome);
		this.idAdministrador = idAdministrador;
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}
	
	
}
