package atividade;

public class AtualizaIdade {
	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.nome = "Jo�o";
		p.calcIdade();
		System.out.println(p.idade);
	}
}
