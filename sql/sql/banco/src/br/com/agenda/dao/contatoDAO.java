package br.com.agenda.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class contatoDAO {
    Connection conn= null;
    PreparedStatement pstm = null;

    public void save(Contato contato) throws Exception {
       String sql = "INSERT INTO contatos(nome,idade,datacadastro)VALUES (?,?,?)";
       
        conn = ConnectionFactory.createConnectionToMySQL();
        pstm = conn.prepareStatement(sql);
        
        pstm.setString(1,contato.getNome());
        pstm.setInt(2,contato.getIdade());
        pstm.setDate(3,new Date(contato.getDataCadastro().getTime()));
        pstm.execute();

    }   
    public List<Contato> getContatos() throws Exception  {
    String sql = "SELECT * FROM Contatos";
    
    List<Contato> contatos = new ArrayList<>();
    ResultSet rset = null;
        conn = ConnectionFactory.createConnectionToMySQL();
        pstm = conn.prepareStatement(sql);
        rset = pstm.executeQuery();
        
        while(rset.next()){
            Contato contato = new Contato();
            contato.setId(rset.getInt("id"));
            contato.setNome(rset.getString("nome"));
            contato.setIdade(rset.getInt("idade"));
            contato.setDataCadastro(rset.getDate("datacadastro"));
            contatos.add(contato);
        }return contatos;      
}
    public void Update(Contato contato) throws Exception {
        String sql = "UPDATE contatos SET nome = ?,idade = ?,dataCadastro = ?"
        +"WHERE id = ?"; 
        conn = ConnectionFactory.createConnectionToMySQL();
        pstm = conn.prepareStatement(sql);
        
        pstm.setString(1,contato.getNome());
        pstm.setInt(2,contato.getIdade());
        pstm.setDate(3,new Date(contato.getDataCadastro().getTime()));
        pstm.setInt(4,contato.getId());
        pstm.execute();
    }
    public void deleteByid (int id) throws Exception {
        String sql = "DELETE FROM contatos WHERE id = ?";
        conn = ConnectionFactory.createConnectionToMySQL();
        pstm = conn.prepareStatement(sql);

        pstm.setInt(1,id);
        pstm.execute();
    }


}