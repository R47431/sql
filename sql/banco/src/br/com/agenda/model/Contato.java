package br.com.agenda.model;

import java.util.Date;

public class Contato {
	private int id;
	private String nome;
	private static int idade;
	private static Date DataCadastro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public static int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public static Date getDataCadastro() {
		return DataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.DataCadastro = dataCadastro;
	}
	
	
}
