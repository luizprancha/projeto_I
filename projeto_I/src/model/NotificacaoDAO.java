package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotificacaoDAO {

	    public List<Notificacao> buscarNotificacoes() {

	        List<Notificacao> notificacoes = new ArrayList<>();
	        Connection conexao = null;
	        PreparedStatement pstm = null;
	        ResultSet rset = null;

	        try {

	            String sql = """
	                SELECT 'MATERIA_PRIMA' AS tipo, nome, dataCadastro
	            	FROM materiaprima
	            	WHERE TIMESTAMPDIFF(SECOND, dataCadastro, NOW()) > 20

	            	UNION ALL

	            	SELECT 'PRODUTO' AS tipo, nome, dataCadastro
	            	FROM produtos
	            	WHERE TIMESTAMPDIFF(SECOND, dataCadastro, NOW()) > 20

	            	ORDER BY dataCadastro ASC; 
	            	""";

	            conexao = database.BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);

	            rset = pstm.executeQuery();

	            while(rset.next()) {

	            	notificacoes.add(
	                        new Notificacao(
	                            rset.getString("tipo"),
	                            rset.getString("nome"),
	                            rset.getTimestamp("dataCadastro")
	                              .toLocalDateTime()
	                        )
	                    );
	            }

	        } catch(Exception e) {
	            e.printStackTrace();
	        }

	        return notificacoes;
	    }
	}
