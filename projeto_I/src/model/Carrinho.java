package model;

public class Carrinho {

	private int idCarrinho;
	private int idUsuario;
	private int idPedidosL;


	public Carrinho() {
		super();
	}

	public Carrinho(
			int idCarrinho,
		    int idUsuario,
		    int idPedidosL
			) {

		this.idCarrinho = idCarrinho;
		this.idUsuario = idUsuario;
		this.idPedidosL =idPedidosL;
		

	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdPedidosL() {
		return idPedidosL;
	}

	public void setIdPedidosL(int idPedidosL) {
		this.idPedidosL = idPedidosL;
	}

	public int getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(int idCarrinho) {
		this.idCarrinho = idCarrinho;
	}


}