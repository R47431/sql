package br.com.agenda.teste;
import java.util.Date;
import br.com.agenda.dao.contadoDAO;
import br.com.agenda.model.Contato;

public class Main {
	public static void main(String[] args) {
		contadoDAO contatoDao = new contadoDAO();
		
		Contato contato = new Contato();
		
		contato.setNome("maria");
		contato.setIdade(55);
		contato.setDataCadastro(new Date());
		
		
		//contatoDao.save(contato);
		
		//atualiza contato
		Contato c1 = new Contato();
		c1.setNome("maria gdad");
		c1.setIdade(35);
		c1.setDataCadastro(new Date());
		c1.setId(1);
		
		contatoDao.update(c1);
		//visualizaçao do registro do bancos de dados TODO
		for(Contato c : contatoDao.getContatos()) {
		System.out.println("Contato:"+ c.getNome());
		
		}
	}
}
