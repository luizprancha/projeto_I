package model;

public class ItensCarrinhoConfeccoes {

	private int idItem;
	private int idCarrinho;
	private int idMateriaPrima;
	private String nomeMateria;
	private int quantidade;

	public ItensCarrinhoConfeccoes() {
		super();
	}

	public ItensCarrinhoConfeccoes(
			int idItem,
			int idCarrinho,
			int idMateriaPrima,
			String nomeMateria,
			int quantidade) {
		this.idItem = idItem;
		this.idCarrinho = idCarrinho;
		this.idMateriaPrima = idMateriaPrima;
		this.nomeMateria = nomeMateria;
		this.quantidade = quantidade;
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

	public int getIdMateriaPrima() {
		return idMateriaPrima;
	}

	public void setIdMateriaPrima(int idMateriaPrima) {
		this.idMateriaPrima = idMateriaPrima;
	}

	public String getNomeMateria() {
		return nomeMateria;
	}

	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
