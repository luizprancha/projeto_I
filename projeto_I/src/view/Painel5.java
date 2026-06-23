package view;


import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import Botao.PainelArredondado;
import model.Carrinho;
import model.ItensCarrinho;
import model.ItensCarrinhoDAO;
import model.Produtos;
import model.ProdutosDAO;
import view.TelaMensagem;
import java.awt.Color;
import java.awt.FontFormatException;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Painel5 extends PainelArredondado  {

	private static final long serialVersionUID = 1L;
	private JTextField tFQuantidade;
	private int quantidade = 1; 
	private JLabel lbpreco;
	private ItensCarrinho itenscarrinhos;
	public int selected,i;
	

	/**
	 * Create the panel.
	 * @param i 
	 */
	public Painel5(int i, ItensCarrinho itenscarrinhos ) throws FontFormatException, IOException {
		this.i=i;
	    this.itenscarrinhos = itenscarrinhos;
	    this.quantidade = itenscarrinhos.getQuantidade();
	    
	    
		setBackground(new Color(255, 255, 255));
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbProduto = new JLabel(itenscarrinhos.getNomeProduto());
		add(lbProduto, "cell 3 1,alignx center");
		
		JLabel lbQuantidade = new JLabel("Quantidade:");
		add(lbQuantidade, "cell 3 3,alignx center");
		
	       JButton btnMenos = new JButton("-");

	        btnMenos.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {

	                if (quantidade > 1) {
	                    quantidade--;
	                    atualizarQuantidade(true);
	                }
	            }
	        });
	        add(btnMenos, "cell 1 5,grow");

	      
	        tFQuantidade = new JTextField();
	        tFQuantidade.setBackground(new Color(192, 192, 192));
	        tFQuantidade.setEditable(false);
	        tFQuantidade.setColumns(10);
	        add(tFQuantidade, "cell 3 5,grow");

	     
	        JButton btnMais = new JButton("+");
	        btnMais.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
	                Produtos produto = new ProdutosDAO().buscarPorId(itenscarrinhos.getIdProduto());
	                int disponivel = produto != null ? produto.getQuantidade() : 0;

	                if (quantidade + 1 > disponivel) {
	                    TelaMensagem.mostrar(
	                            "Aviso",
	                            "Estoque insuficiente! Disponível: " + disponivel);
	                    return;
	                }

	                quantidade++;
	                atualizarQuantidade(true);

	            }
	        });

	        add(btnMais, "cell 5 5,grow");
	      
	        JLabel lbValor = new JLabel("Valor:");
	        add(lbValor, "cell 3 7,alignx center");

	        lbpreco = new JLabel();
	        add(lbpreco, "cell 3 9,alignx center");

	        atualizarQuantidade(false);
	    }

	    private void atualizarQuantidade(boolean salvar) {
	     
	        tFQuantidade.setText(String.valueOf(quantidade));
	        itenscarrinhos.setQuantidade(quantidade);
	        if (salvar) {
	            new ItensCarrinhoDAO().atualizarItensCarrinho(itenscarrinhos);
	        }
	        double total = itenscarrinhos.getPreco() * quantidade;
	        lbpreco.setText(String.format("R$ %.2f", total));
	    }
	}
