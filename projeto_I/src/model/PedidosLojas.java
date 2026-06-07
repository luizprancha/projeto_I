package model;

import java.util.ArrayList;

public class PedidosLojas {

    private int idPedidoL;
    private String entrega;
    private double valorTotal;
    private String lojas_CNPJ;
    private ArrayList<String> listaProdutos;
    private int idLoja;
    private String endereco;
    private String nomeLoja;
    private int quantidadeTotal;

    public PedidosLojas(int idPedidoL, String entrega, int idLoja, double valorTotal, ArrayList<String> listaProdutos,String lojas_CNPJ, String endereco, String nomeLoja) {

        super();
        this.idLoja = idLoja;
        this.idPedidoL = idPedidoL;
        this.entrega = entrega;
        this.valorTotal = valorTotal;
        this.lojas_CNPJ = lojas_CNPJ;
        this.listaProdutos = listaProdutos;
        this.endereco = endereco;
        this.nomeLoja = nomeLoja;
    }

    public PedidosLojas() {
        super();
    }

    public int getIdPedidoL() {
        return idPedidoL;
    }

    public void setIdPedidoL(int idPedidoL) {
        this.idPedidoL = idPedidoL;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }
    public String getLojas_CNPJ() {
        return lojas_CNPJ;
    }

    public void setLojas_CNPJ(String lojas_CNPJ) {
        this.lojas_CNPJ = lojas_CNPJ;
    }

    public ArrayList<String> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<String> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }
}
