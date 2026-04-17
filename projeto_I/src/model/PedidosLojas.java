package model;

public class PedidosLojas {

	private int idPedido;
	private String entrega;
	private int idLoja;
	private double valorTotal;
	private String listaProdutos;
	private String lojas_CNPJ;
	public PedidosLojas(int idPedido, String entrega, int idLoja, double valorTotal, String listaProdutos, String lojas_CNPJ) {
		super();
		this.idLoja = idLoja;
		this.idPedido = idPedido;
		this.entrega = entrega;
		this.valorTotal = valorTotal;
		this.listaProdutos = listaProdutos;
		this.lojas_CNPJ = lojas_CNPJ;
	}
	public PedidosLojas() {
		super();
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getEntrega() {
		return entrega;
	}
	public void setEntrega(String entrega) {
		this.entrega = entrega;
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
	public String getLojas_CNPJ() {
		return lojas_CNPJ;
	}
	public void setLojas_CNPJ(String lojas_CNPJ) {
		this.lojas_CNPJ = lojas_CNPJ;
	}
	
	
	
}
