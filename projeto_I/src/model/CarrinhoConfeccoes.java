package model;

public class CarrinhoConfeccoes {

	private int idCarrinho;
	private int idUsuario;
	private int idPedidoC;

	public CarrinhoConfeccoes() {
		super();
	}

	public CarrinhoConfeccoes(int idCarrinho, int idUsuario, int idPedidoC) {
		this.idCarrinho = idCarrinho;
		this.idUsuario = idUsuario;
		this.idPedidoC = idPedidoC;
	}

	public int getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(int idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdPedidoC() {
		return idPedidoC;
	}

	public void setIdPedidoC(int idPedidoC) {
		this.idPedidoC = idPedidoC;
	}
}
