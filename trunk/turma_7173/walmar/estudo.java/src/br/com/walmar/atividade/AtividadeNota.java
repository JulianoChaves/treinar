package br.com.walmar.atividade;

public class AtividadeNota {
	public static void main(String[] args) {
		int nota = 30;
		String resultado;

		if (nota < 40) {
			resultado = "Reprovado";
		} else {
			if (nota >= 40) {
				resultado = "Recupera��o";
			} else {
				resultado = "Aprovado";
			}
		}
		System.out.println(resultado);
	}
}