package model;

public class PedidoLoja {

	private int idPedido;
	private String status;
	private int idLoja;
	private double valorTotal;
	private String listaProdutos;
	public PedidoLoja(int idPedido, String status, int idLoja, double valorTotal, String listaProdutos) {
		super();
		this.idPedido = idPedido;
		this.status = status;
		this.idLoja = idLoja;
		this.valorTotal = valorTotal;
		this.listaProdutos = listaProdutos;
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
	public String getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(String listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	
	
}
