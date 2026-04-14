package model;

public class Produtos {

	private String nome;
	private String tipoProduto;
	private int idProduto;
	private double preco;
	private int quantidade;
	private String tamanho;
	
	public Produtos(String nome, String tipoProduto, int idProduto, double preco, int quantidade, String tamanho) {
		super();
		this.nome = nome;
		this.tipoProduto = tipoProduto;
		this.idProduto = idProduto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.tamanho = tamanho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
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

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	
	
}
