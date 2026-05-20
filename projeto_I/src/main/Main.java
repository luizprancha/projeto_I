package main;

import java.awt.EventQueue;

import view.MeuJFrame;

/**
 * A execução do programa começa por aqui.
 */
public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MeuJFrame frame = new MeuJFrame();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
} 