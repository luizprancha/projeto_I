package model;

public class Carrinho {

    private int idCarrinho;

    public Carrinho(int idCarrinho) {
    	
        this.idCarrinho = idCarrinho;
        
    }
    
    public Carrinho() {
    	super();
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

}