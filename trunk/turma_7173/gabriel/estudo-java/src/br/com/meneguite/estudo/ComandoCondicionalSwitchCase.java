package br.com.meneguite.estudo;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ComandoCondicionalSwitchCase {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Op��o: ");
		int opcao = leitor.nextInt();
		
		System.out.println("Op��o selecinada: " + opcao);
		
		switch (opcao) {
		case 1:
			JOptionPane.showMessageDialog(null, "Domingo");
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Segunda-feira");
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Ter�a-feira");
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Quarta-feira");
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Quinta-feira");
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "Sexta-feira");
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "S�bado");
			break;

		default: JOptionPane.showMessageDialog(null, "Inexistente");
			break;
		}
		
		leitor.close();
	}

}
