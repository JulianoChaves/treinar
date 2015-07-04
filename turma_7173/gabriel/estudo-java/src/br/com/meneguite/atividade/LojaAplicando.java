package br.com.meneguite.atividade;


public class LojaAplicando {

	
	public static void main(String[] args) {
		
		Loja p = new Loja();
		p.salarioFuncionario = 22.50;
		p.nomeFuncionario = "Carne";
		p.funcionario = 1;
		p.produto = new Produto();
		p.produto.preco = 2.5;
		p.produto.quantidade = 1000;
		p.produto.nome = "Produto loc�o";
		
		System.out.println("Quantidade inicial do produto: " + p.funcionario);
		p.cadastrarFuncionario();
		System.out.println("Quantidade ap�s o cadastro: " + p.funcionario);
		
		Loja c = p;
		System.out.println("____________");
		p.funcionario = 2;
		p.cadastrarFuncionario();
		
		System.out.println("\nAp�s um novo cadastro: " + c.funcionario);
	
		
		
		
	}
	
	
}
