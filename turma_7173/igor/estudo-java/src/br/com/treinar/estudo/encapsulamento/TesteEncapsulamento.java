package br.com.treinar.estudo.encapsulamento;

public class TesteEncapsulamento {

	public static void main(String[] args) {

		Funcionario p = new Funcionario("Igor Yuri", 18);

		p.setNome("Igor");
		p.setSobrenome("Yuri");
		p.setIdade(28);
		p.setApelido("Jhow");

		System.out.println("Meu nome �: " + p.getNome() + " "
				+ p.getSobrenome() + "\nTenho " + p.getIdade() + " anos");
	}
}
