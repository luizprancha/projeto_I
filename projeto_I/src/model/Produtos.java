package model;

public class Produtos {

	private String nome;
	private int idProduto;
	private double preco;
	private int quantidade;
	private String tamanho;
	private String cor;
	
	public Produtos(String nome, double preco, String tamanho, int quantidade, String cor) {
		this.nome = nome;
		this.preco = preco;
		this.tamanho = tamanho;
		this.quantidade = quantidade;
		this.cor = cor;
}
	
	public Produtos() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	
	
	
}
