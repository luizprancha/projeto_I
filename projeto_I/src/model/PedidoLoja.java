package model;

import java.util.ArrayList;
import java.util.List;

public class PedidoLoja {

	private int idPedido;
	private String status;
	private int idLoja;
	private double valorTotal;
	private List<Produtos> produtos = new ArrayList<Produtos>();
	private List<Loja> lojas = new ArrayList<Loja>();
	
	public PedidoLoja(int idPedido, String status, int idLoja, double valorTotal, List<Produtos> produtos, List<Loja> lojas) {
		super();
		this.idPedido = idPedido;
		this.status = status;
		this.idLoja = idLoja;
		this.valorTotal = valorTotal;
		this.produtos = produtos;
		this.lojas = lojas;
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
	public int getIdLoja() {
		return idLoja;
	}
	public void setIdLoja(int idLoja) {
		this.idLoja = idLoja;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}
	
	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	public void adicionarProduto(Produtos p) {
		produtos.add(p);
	}
	public void removerProduto(Produtos p) {
		produtos.remove(p);
	}
	
	
	
}
