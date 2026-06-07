package controller;

import java.awt.FontFormatException;
import java.io.IOException;

import model.Lojas;
import model.LojasDAO;
import model.PedidosLojas;
import model.PedidosLojasDAO;
import view.TelaAlterarLoja;
import view.TelaPedidosLojasAlterar;

public class PedidosLojasAlterarController {

	private final TelaPedidosLojasAlterar view;
	private final PedidosLojasDAO model;
	private final Navegador navegador;
	private final PedidosLojas pedidosloja;
	private final PedidosLojasConfirmadosController pedidoslojasController;

	public PedidosLojasAlterarController(
			TelaPedidosLojasAlterar view,
			PedidosLojasDAO model,
			Navegador navegador,
			PedidosLojas pedidosloja,
			PedidosLojasConfirmadosController pedidoslojasController) {

		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.pedidosloja = pedidosloja;
		this.pedidoslojasController = pedidoslojasController;

		carregarDados();

		view.confirmarAlteracoes(e -> {

		    String loja = view.getNomeLoja().trim();
		    String quantidade = view.getQuantidadePecas().trim();
		    String entrega = view.getDataEntrega().trim();
		    String valor = view.getValorTotal().trim();

		    StringBuilder erros = new StringBuilder();

		    if (loja.isEmpty()) {
		        erros.append("Loja é obrigatória\n");
		    }

		    if (quantidade.isEmpty()) {
		        erros.append("Quantidade de peças é obrigatória\n");
		    } else {
		        try {
		            int qtd = Integer.parseInt(quantidade);

		            if (qtd <= 0) {
		                erros.append("Quantidade deve ser maior que zero\n");
		            }

		        } catch (NumberFormatException ex) {
		            erros.append("Quantidade inválida\n");
		        }
		    }

		    if (entrega.isEmpty()) {
		        erros.append("Data de entrega é obrigatória\n");
		    }

		    if (valor.isEmpty()) {
		        erros.append("Valor total é obrigatório\n");
		    } else {
		        try {
		            double valorTotal = Double.parseDouble(valor.replace(",", "."));

		            if (valorTotal <= 0) {
		                erros.append("Valor total deve ser maior que zero\n");
		            }

		        } catch (NumberFormatException ex) {
		            erros.append("Valor total inválido\n");
		        }
		    }

		    if (erros.length() > 0) {

		        view.exibirMensagem("Erro", erros.toString(), 0);

			} else {

				 PedidosLojas pedidoAtualizado = new PedidosLojas();

				    pedidoAtualizado.setIdPedidoL(pedidosloja.getIdPedidoL());
				    pedidoAtualizado.setLojas_CNPJ(pedidosloja.getLojas_CNPJ());
				    pedidoAtualizado.setEndereco(pedidosloja.getEndereco());
				    pedidoAtualizado.setEntrega(entrega);
				    pedidoAtualizado.setValorTotal(Double.parseDouble(valor.replace(",", ".")));

				    model.atualizarPedidosLojas(pedidoAtualizado);

				    view.exibirMensagem(
				            "Sucesso",
				            "Pedido alterado com sucesso",
				            1
				    );

				    navegador.navegarPara("PEDIDOS_LOJAS");

				    try {
				        pedidoslojasController.recriarPaineis();
				    } catch (FontFormatException | IOException e1) {
				        e1.printStackTrace();
				    }
				}
				
		});
	}

	private void carregarDados() {
	    view.setPedidosLojas(pedidosloja);
	}
}