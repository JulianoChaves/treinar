package br.com.treinar.agenda;

import java.io.Serializable;
import java.util.Date;

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private Date dataNascimento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
