package br.com.agenda.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;


public class contadoDAO {
	/*crud
	 * c  create
	 * r  read
	 * u  update
	 * d  delete
	 * 
	 */
	
	public void save(Contato contado){
		String sql = "INSERT INTO contatos(nome, idade,DataCadastro) VALUES(?,?,?)";
			
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//cria uma conexao com banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//criamos uma preparedstatement para executar uma query
			pstm = (PreparedStatement) conn.prepareCall(sql);
			 	//adicionar os valores que sao esperados pela query
			
			pstm.setString(1, contado.getNome());
			pstm.setInt(2, Contato.getIdade());
			pstm.setDate(3, new Date(Contato.getDataCadastro().getTime()));
			//executar a query
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

