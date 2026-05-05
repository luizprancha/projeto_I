package model;

public class MateriaPrima {
	
	private String nome;
	private int quantidade;
	private String cor;
	private int idMateriaPrima;
	private String tipo;
	
	public MateriaPrima(String nome, int quantidade, String cor, String tipo) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.cor = cor;
	}

	public MateriaPrima() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getIdMateriaPrima() {
		return idMateriaPrima;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setIdMateriaPrima(int idMateriaPrima) {
		this.idMateriaPrima = idMateriaPrima;
	}
	
	
	
}
