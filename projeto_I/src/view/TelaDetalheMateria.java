package view;

import javax.swing.JPanel;

import Botao.JButtonOutLine;
import Botao.PainelArredondado;
import model.Confeccoes;
import model.MateriaPrima;

import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.IOException;

public class TelaDetalheMateria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btEditar;
	private JButton btExcluir;
	private JLabel lbTipoTecido;
	private JLabel lbCor;
	private JLabel lbQtdRolos;
	private JLabel lbID;
	private JLabel lblNome;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaDetalheMateria() throws FontFormatException, IOException {
		setLayout(new BorderLayout(0, 0));
		

		
			
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/Jomhuria-Regular.ttf")
		).deriveFont(100f);
		
		
		Font fonte2 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/fontes/PlayfairDisplay-Regular.ttf")
		).deriveFont(18f);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 57, 87));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow 30][grow 30][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbTitulo = new JLabel("Matéria Prima");
		lbTitulo.setForeground(new Color(235, 219, 194));
		lbTitulo.setFont(fonte);
		panel.add(lbTitulo, "cell 1 1 4 1");
		
		PainelArredondado panel_1= new PainelArredondado();
		panel_1.setBackground(new Color(235, 219, 194));
		panel.add(panel_1, "cell 3 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow][grow][grow][][][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Tipo:");
		lblNewLabel_1.setFont(fonte2);
		panel_1.add(lblNewLabel_1, "cell 1 1");
		
		
		lbTipoTecido = new JLabel("Malha");
		lbTipoTecido.setFont(fonte2);
		panel_1.add(lbTipoTecido, "cell 3 1");
		
		JLabel lblNewLabel_4 = new JLabel("Nome:");
		lblNewLabel_4.setFont(fonte2);
		panel_1.add(lblNewLabel_4, "cell 1 3");
		
		lblNome = new JLabel("New label");
		lblNome.setFont(fonte2);
		panel_1.add(lblNome, "cell 3 3");
		
		JLabel lblNewLabel_2 = new JLabel("Cor:");
		lblNewLabel_2.setFont(fonte2);
		panel_1.add(lblNewLabel_2, "cell 1 5");
		
		lbCor = new JLabel("Azul");
		lbCor.setFont(fonte2);
		panel_1.add(lbCor, "cell 3 5");
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade de rolos:");
		lblNewLabel_3.setFont(fonte2);
		panel_1.add(lblNewLabel_3, "cell 1 7");
		
		lbQtdRolos = new JLabel("50");
		lbQtdRolos.setFont(fonte2);
		panel_1.add(lbQtdRolos, "cell 3 7");
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(fonte2);
		panel_1.add(lblNewLabel, "cell 1 9");
		
		lbID = new JLabel("ID");
		lbID.setFont(fonte2);
		panel_1.add(lbID, "cell 3 9");
		
		btExcluir = new JButtonOutLine();
		btExcluir.setText("Excluir");
		btExcluir.setFont(fonte2);
		panel.add(btExcluir, "cell 2 5 2 1,growx");
		
		btEditar = new JButtonOutLine();
		btEditar.setText("Editar");
		btEditar.setFont(fonte2);
		panel.add(btEditar, "cell 5 5 2 1,growx");

	}
	
	public void ExcluirMateria(ActionListener acao) {
		btExcluir.addActionListener(acao);
	}
	
	public void EditarMateria(ActionListener acao) {
		btEditar.addActionListener(acao);
	}
	
	public void setMateria(MateriaPrima materia) {
		lblNome.setText(materia.getNome());
		lbTipoTecido.setText(materia.getTipo());
		lbCor.setText(materia.getCor());
		lbQtdRolos.setText(String.valueOf(materia.getQuantidade()));
		lbID.setText(String.valueOf(materia.getIdMateriaPrima()));
	}
	
	public void exibirMensagem(String titulo, String mensagem, int tipo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
	}

}
