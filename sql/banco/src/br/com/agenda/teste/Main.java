package br.com.agenda.teste;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;


import br.com.agenda.model.Contato;



public class Main {

	public static void main(String[] args) {
		
		ContatoDAO contatoDao = new ContatoDAO();

		Contato contato = new Contato();
		contato.setNome("Maria Gabriela Dias");
		contato.setIdade(35);
		contato.setDatacadastro(new Date());
		contato.setSalario(1000);
		//contatoDao.save(contato);
		
		//contatoDao.deleteByid(0);
		
		//atualiza contato
		Contato c1 = new Contato();
		
		c1.setNome("maria_7777");
		c1.setIdade(5);
		c1.setSalario(9999);
		c1.setId(10);
		 contatoDao.update(c1);
		//Visualização dos registros do banco de dados TODOS
		
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("   "+c.getId()+" Nome "+c.getNome()+"  Idade "+c.getIdade()
			+"  salario  "+c.getSalario());
		}
	}

}
