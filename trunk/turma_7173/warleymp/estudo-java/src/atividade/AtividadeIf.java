package atividade;

public class AtividadeIf {

	public static void main(String[] args) {
		int hora = 22;
		String oi;

		if (hora > 12 && hora < 18) {
			System.out.println("Boa tarde s�o " + hora + " horas");
		}

		if (hora < 12) {
			System.out.println("Bom dia s�o " + hora + " horas");
		}

		if (hora > 18) {
			System.out.println("Bom noite s�o " + hora + " horas");
		}

		hora = 20;

		oi = hora < 12 ? "Bom dia" : "Boa Tarde";
		boolean humor = false;

		System.out.println(oi);
		System.out.println(hora < 12 && humor ? "Bom dia" : "Boa Tarde");

	}
}