package br.com.agenda.dao;
import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.model.contato;
import br.com.genda.factory.ConnectionFactory;


public class contadoDAO {
	/*crud
	 * c  create
	 * r  read
	 * u  update
	 * d  delete
	 * 
	 */
	
	public void save(contato contado){
		String sql = "INSERT INTO contatos(nome, idade,datacadastro) VALUES(?,?,?)";
			
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//cria uma conexao com banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//criamos uma preparedstatement para executar uma query
			pstm = (PreparedStatement) conn.prepareCall(sql);
			 	//adicionar os calores que sao esperados pela query
			pstm.setString(1, contado.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			pstm.execute();
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(pstm!=null) {
				pstm.close();
			}
			if(conn!=null) {
				conn.close();
				
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	}
}

