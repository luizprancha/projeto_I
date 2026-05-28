package model;

public class PedidosLojasProdutos {

	private int idPedido;

	private int idProduto;

	private double preco;

	private int quantidade;

	public PedidosLojasProdutos() {
		super();
	}

	public PedidosLojasProdutos(
			int idPedido,
			int idProduto,
			double preco,
			int quantidade) {

		this.idPedido = idPedido;
		this.idProduto = idProduto;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}