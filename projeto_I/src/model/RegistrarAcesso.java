package model;

import java.time.LocalDateTime;

public class RegistrarAcesso {

	private int idAcesso;
	private LocalDateTime dataHora;
	private Usuario usuario;
	public RegistrarAcesso(int idAcesso, LocalDateTime dataHora, Usuario usuario) {
		super();
		this.idAcesso = idAcesso;
		this.dataHora = dataHora;
		this.usuario = usuario;
	}
	public int getIdAcesso() {
		return idAcesso;
	}
	public void setIdAcesso(int idAcesso) {
		this.idAcesso = idAcesso;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
