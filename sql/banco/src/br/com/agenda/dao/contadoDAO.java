package br.com.agenda.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;


public class contadoDAO {
	/*crud
	 * c  create ok
	 * r  read	ok
	 * u  update
	 * d  delete
	 * 
	 */
	//insert
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
	//read
	public List<Contato> getContatos() {
		String sql = "SELECT * FROM Contatos";
		
		List<Contato> Contatos = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//classe que vai recupera os dados  do banco. **select**
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm  = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Contato contato = new Contato();
				//recupera o do banco
				contato.setId(rset.getInt("id"));
				contato.setNome(rset.getString("nome"));
				contato.setIdade(rset.getInt("idade"));
				contato.setDataCadastro(rset.getDate("datacadastro"));
			
				Contatos.add(contato);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			}finally {
				try{
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}if(conn !=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
				

			} 
		   return Contatos;
		}
	
	public void update(Contato contato) {
		String sql = "UPDATE contatos SET nome = ? , idade = ? , dataCadastro = ? "+
	"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//cra conexao com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			pstm.setInt(4, contato.getId());
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstm != null) {
					pstm.close();
				}
					
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
}

