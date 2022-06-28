package br.com.agenda.teste;
import java.util.Date;

import br.com.agenda.dao.contatoDAO;
import br.com.agenda.model.Contato;

public class Main {
	public static void main(String[] args) throws Exception {
		contatoDAO contatoDao = new contatoDAO();
		Contato contato = new Contato();
	
		contato.setNome("maria ");
		contato.setIdade(55);
		contato.setDataCadastro(new Date());
		//contatoDao.save(contato);

		Contato c1 = new Contato();
		c1.setId(9);
		c1.setNome("RAFAEKL ");
		c1.setIdade(141);
		c1.setDataCadastro(new Date());
		contatoDao.Update(c1);
		
		//delete o contato pelo id
		 contatoDao.deleteByid(22);
		
		//visualiza�ao do registro do bancos de dados TODO
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("Contato: id "+c.getId()+" Nome "+ c.getNome() + "idade "+c.getIdade());
			}
	}
}
