package br.com.agenda.teste;

import br.com.agenda.dao.ContatoDAO;

import br.com.agenda.model.Contato;



public class Main {

	public static void main(String[] args) {
		
		ContatoDAO contatoDao = new ContatoDAO();

		Contato contato = new Contato();
		contato.setNome("Maria Gabriela Dias");
		contato.setIdade(35);
		
		
		//contatoDao.save(contato);
		
		//contatoDao.deleteByid(0);
		
		//atualiza contato
		Contato c1 = new Contato();
		
		c1.setNome("maria_7777");
		c1.setIdade(5);
		c1.setId(8);
		contatoDao.update(c1);
		//Visualização dos registros do banco de dados TODOS
		
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("    "+c.getId()+"   Contato:  "+c.getNome()+"     idade "+c.getId());
		}
	}

}
