import java.util.Scanner;

import javax.swing.JOptionPane;

public class ComandoCondicionalSwitchCase {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Digite a op��o desejada: ");
		int opcao = leitor.nextInt();
		
		System.out.println("Op��o selecionada: " + opcao);
		
		System.out.print("Digite a op��o desejada: ");
		opcao = leitor.nextInt();
		
		switch (opcao) {
		case 1:
			JOptionPane.showMessageDialog(null, "Domingo");
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Segunda");
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Ter�a");
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Quarta");
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Quinta");
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "Sexta");
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "S�bado");
			break;

		default:
			JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
			break;
		}

		leitor.close();
	}

}
