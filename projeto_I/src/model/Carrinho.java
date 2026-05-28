package model;

public class Carrinho {

	private int idCarrinho;

	private int idProduto;

	private int quantidade;

	private double preco;

	public Carrinho() {
		super();
	}

	public Carrinho(
			int idCarrinho,
			int idProduto,
			int quantidade,
			double preco) {

		this.idCarrinho = idCarrinho;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public int getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(int idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}