package br.com.treinar.estudo;

import java.util.Scanner;

public class ComandoRepeticaoWhile {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		int condicao;
		System.out.print("Op��o: ");
		condicao = leitor.nextInt();
		
		while (condicao != 0) {
			while (condicao > 0) {
				System.out.println("Gleidson " + condicao--);
			}
			System.out.print("Op��o: ");
			condicao = leitor.nextInt();
		}
		leitor.close();
		
	}

	
}
