package main;

import java.awt.EventQueue;

import view.Janela;

/**
 * Classe responsável por inicializar os elementos das camadas: model, view e controller.
 * A execução do programa começa por aqui.
 */
public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Janela frame = new Janela();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}