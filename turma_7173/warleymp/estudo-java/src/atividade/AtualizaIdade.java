package atividade;

public class AtualizaIdade {
	public static void main(String[] args) {
		Pessoa p = new Pessoa("warley",35);
		p.nome = "Jo�o";
		p.calcIdade();
		System.out.println(p.idade);
	}
}
