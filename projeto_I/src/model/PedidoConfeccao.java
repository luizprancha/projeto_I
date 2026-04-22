package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoConfeccao {

	private int idPedido;
	private String status;
	private int idConfeccao;
	private double valorPedido;
	private String listaConfeccoes;
	private LocalDate dataEntrega;
	private LocalDate dataDevolucao;
	private List<Confeccoes> confeccoes = new ArrayList<Confeccoes>();
	
	public PedidoConfeccao(int idPedido, String status, int idConfeccao, double valorPedido, String listaConfeccoes,
			LocalDate dataEntrega, LocalDate dataDevolucao, List<Confeccoes> confeccoes) {
		super();
		this.idPedido = idPedido;
		this.status = status;
		this.idConfeccao = idConfeccao;
		this.valorPedido = valorPedido;
		this.listaConfeccoes = listaConfeccoes;
		this.dataEntrega = dataEntrega;
		this.dataDevolucao = dataDevolucao;
		this.confeccoes = confeccoes;
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getIdConfeccao() {
		return idConfeccao;
	}
	public void setIdConfeccao(int idConfeccao) {
		this.idConfeccao = idConfeccao;
	}
	public double getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
	}
	public String getListaConfeccoes() {
		return listaConfeccoes;
	}
	public void setListaConfeccoes(String listaConfeccoes) {
		this.listaConfeccoes = listaConfeccoes;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public List<Confeccoes> getConfeccoes() {
		return confeccoes;
	}

	public void setConfeccoes(List<Confeccoes> confeccoes) {
		this.confeccoes = confeccoes;
	}
	
	public void adicionarConfeccao(Confeccoes c) {
		confeccoes.add(c);
	}
	public void removerConfeccao(Confeccoes c) {
		confeccoes.remove(c);
	}
	
}