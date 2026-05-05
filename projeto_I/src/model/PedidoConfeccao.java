package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoConfeccao {

	private int idPedidoC;
	private String entrega;
	private int idConfeccao;
	private double valorPedido;
	private String confeccoesCNPJ;
	private LocalDate dataEntrega;
	private LocalDate dataDevolucao;
	private String forma_pgm;
	private List<Confeccoes> confeccoes = new ArrayList<Confeccoes>();
	
	public PedidoConfeccao(int idPedidoC, String entrega, int idConfeccao, double valorPedido, String confeccoesCNPJ,
			LocalDate dataEntrega, LocalDate dataDevolucao, String forma_pgm) {
		super();
		this.idPedidoC = idPedidoC;
		this.entrega = entrega;
		this.idConfeccao = idConfeccao;
		this.valorPedido = valorPedido;
		this.confeccoesCNPJ = confeccoesCNPJ;
		this.dataEntrega = dataEntrega;
		this.dataDevolucao = dataDevolucao;
		this.forma_pgm = forma_pgm;
	}
	public PedidoConfeccao() {
		super();
	}
	
	public int getIdPedidoC() {
		return idPedidoC;
	}
	public void setIdPedidoC(int idPedidoC) {
		this.idPedidoC = idPedidoC;
	}
	public String getEntrega() {
		return entrega;
	}
	public void setEntrega(String entrega) {
		this.entrega = entrega;
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
	public String getConfeccoesCNPJ() {
		return confeccoesCNPJ;
	}

	public void setConfeccoesCNPJ(String confeccoesCNPJ) {
		this.confeccoesCNPJ = confeccoesCNPJ;
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

	public String getForma_pgm() {
		return forma_pgm;
	}

	public void setForma_pgm(String forma_pgm) {
		this.forma_pgm = forma_pgm;
	}
	
	
	
}