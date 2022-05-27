package br.com.agenda.teste;


import java.util.Date;

import br.com.agenda.dao.contadoDAO;
import br.com.agenda.model.Contato;

public class Main {
	public static void main(String[] args) {
		contadoDAO contatoDAO = new contadoDAO();
		
		Contato contato = new Contato();
		
		contato.setNome("maria");
		contato.setIdade(55);
		contato.setDataCadastro(new Date());
		
		
		contatoDAO.save(contato);
	}
}
