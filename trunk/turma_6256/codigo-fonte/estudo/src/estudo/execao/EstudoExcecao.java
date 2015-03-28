package estudo.execao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EstudoExcecao {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Inform um n�mero inteiro: ");
			//enviar email
			Integer inteiro = sc.nextInt();
			System.out.println("N�mero digitado: " + inteiro);
		} catch (InputMismatchException e) {
			System.out.println("N�mero inv�lido");
		}
		sc.close();
	}
	
	
	
}
