package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

 

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {

	/*
	 * CRUD c: CREATE - OK - INSERT r: READ - SELECT u: UPDATE - UPDATE d: DELETE -
	 * DELETE
	 */

	public void save(Contato contato) {

		String sql = "INSERT INTO contatos(nome, idade ,salario,datacadastro) VALUES (?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();

			// Criamos uma PreparedStatement, para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			// Adicionar os valores que são esperados pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDouble(3, contato.getSalario());
			pstm.setDate(4, new Date (contato.getDatacadastro().getTime()));
			
			// Executar a query
			pstm.execute();

			System.out.println("Contato salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Fechar as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Contato> getContatos(){
		
		String sql = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. ***SELECT****
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Contato contato = new Contato();
				
				//Recuperar o id
				contato.setId(rset.getInt("id"));
				contato.setNome(rset.getString("nome"));
				contato.setIdade(rset.getInt("idade"));
				contato.setSalario(rset.getDouble("salario"));
				contato.setDatacadastro(rset.getDate("datacadastro"));
				
			
				contatos.add(contato);
				
			}
		}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}
					
					if(pstm!=null) {
						pstm.close();
					}
					
					if(conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		
			return contatos;
	}
		
	public void update(Contato contato) {
		String sql = "UPDATE contatos SET nome = ? , idade = ? ,salario = ?"
				+ "WHERE id = ?";
				
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//cra conexao com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			
			
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDouble(3, contato.getSalario());	
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
	//delete
	public void deleteByid (int id) {
		String sql = "DELETE FROM contatos WHERE id = ? ";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);		
			
			
			pstm.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}if(conn!= null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}}
}
