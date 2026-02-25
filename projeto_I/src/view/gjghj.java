package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class gjghj extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gjghj frame = new gjghj();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gjghj() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(113, 50, 205, 120);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[][grow][]", "[][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel.add(lblNewLabel_1, "cell 1 0");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel.add(lblNewLabel_2, "cell 2 0");
		
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panel.add(lblNewLabel_4, "cell 0 4,alignx trailing");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 4,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		panel.add(lblNewLabel_7, "cell 0 5");
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		panel.add(lblNewLabel_8, "cell 0 6");
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		panel.add(lblNewLabel_6, "cell 0 7");
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel.add(lblNewLabel_5, "cell 0 8");

	}
}
