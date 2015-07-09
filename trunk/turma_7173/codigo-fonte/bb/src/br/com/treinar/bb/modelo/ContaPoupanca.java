package br.com.treinar.bb.modelo;

import br.com.treinar.bb.modelo.banco.Conta;

public class ContaPoupanca extends Conta {

	private static int taxaRendimento;
	
	public ContaPoupanca() {
		//nao deve ser feita a inicializacao neste 
		//ponto pois o atributo taxaRendimento � static esta atribuicao
		//implicaria em modificar o seu valor a cada vez que um objeto
		//da classe ContaPoupanca for criado...
		//taxaRendimento = 0;
	}
	
	static {
		taxaRendimento = 0;
	}
	
	public static int getTaxaRendimento() {
		return taxaRendimento;
	}

	public static void setTaxaRendimento(int taxaRendimento) {
		ContaPoupanca.taxaRendimento = taxaRendimento;
	}
	
}