package br.com.meneguite.estudo;

import java.util.Scanner;

public class ComandoRepeticaoWhile {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int condicao;
		System.out.println("Op��o: ");
		condicao = leitor.nextInt();
		
		while (condicao != 0) {
		
			System.out.println("Gabriel...");
			System.out.println("Op��o�: ");
			condicao = leitor.nextInt();
		}
		leitor.close();
	}
}
