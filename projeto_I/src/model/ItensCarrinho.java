package model;

public class ItensCarrinho {

    private int idItem;
    private int idCarrinho;

    private int idProduto;
    private String nomeProduto;
    private double preco;
    private int quantidade;

    public ItensCarrinho(int idItem, int idCarrinho, int idProduto, String nomeProduto, double preco, int quantidade) {

    	this.idItem = idItem;
        this.idCarrinho = idCarrinho;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
      

    }
    
    public ItensCarrinho() {
    	super();
    }

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
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

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	

    
}