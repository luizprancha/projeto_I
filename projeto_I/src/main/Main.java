package main;

import java.awt.EventQueue;

import view.JFrame;

/**
 * A execução do programa começa por aqui.
 */
public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				JFrame frame = new JFrame();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
} 