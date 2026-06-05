package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoConfeccao {

	private int idPedidoC;
	private LocalDate entrega;
	private int idConfeccao;
	private double valorPedido;
	private String confeccoesCNPJ;
	private String forma_pgm;
	private String nomeConfeccao;
	private int quantidade;
	private List<Confeccoes> confeccoes = new ArrayList<Confeccoes>();
	
	public PedidoConfeccao(int idPedidoC, LocalDate entrega, int idConfeccao, double valorPedido, String confeccoesCNPJ,
			String forma_pgm, String nomeConfeccao, int quantidade) {
		super();
		this.idPedidoC = idPedidoC;
		this.entrega = entrega;
		this.idConfeccao = idConfeccao;
		this.valorPedido = valorPedido;
		this.confeccoesCNPJ = confeccoesCNPJ;
		this.forma_pgm = forma_pgm;
		this.nomeConfeccao = nomeConfeccao;
		this.quantidade = quantidade;
	}
	public PedidoConfeccao() {
		super();
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getNomeConfeccao() {
		return nomeConfeccao;
	}
	public void setNomeConfeccao(String nomeConfeccao) {
		this.nomeConfeccao = nomeConfeccao;
	}
	public int getIdPedidoC() {
		return idPedidoC;
	}
	public void setIdPedidoC(int idPedidoC) {
		this.idPedidoC = idPedidoC;
	}
	public LocalDate getEntrega() {
		return entrega;
	}
	public void setEntrega(LocalDate entrega) {
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