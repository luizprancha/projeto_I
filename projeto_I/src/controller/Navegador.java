package controller;

import javax.swing.JPanel;

import view.JFrame;

public class Navegador {
	private JFrame jFrame;

	/**
	 * Construtor da classe.
	 * @param janela Referência ao JFrame.
	 */
	public Navegador(JFrame jFrame) {
		this.jFrame = jFrame;
	}

	/**
	 * Método responsável por chamar o método da view que adiciona as telas ao painel principal.
	 * @param nome Nome do painel.
	 * @param tela Painel que será adicionado.
	 */
	public void adicionarPainel(String nome, JPanel tela) {
		this.jFrame.adicionarTela(nome, tela);
	}

	/**
	 * Método responsável por chamar o método da view que navega para outra tela.
	 * @param nome Nome da tela.
	 */
	public void navegarPara(String nome) {
		this.jFrame.mostrarTela(nome);
	}

	/**
	 * Método responsável por chamar o método da view que fecha a aplicação.
	 */
	public void sair() {
		this.jFrame.dispose();
	}
}


