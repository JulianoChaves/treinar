import java.util.Scanner;

import javax.swing.JOptionPane;

public class AtividadeDiaDaSemana {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		int opcao;

		do {

			System.out.print("Digite a op��o desejada ou 0 para sair: ");
			opcao = leitor.nextInt();

			switch (opcao) {
			case 0:
				JOptionPane.showMessageDialog(null, "Sistema Encerrado");
				break;
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

		} while (opcao != 0);

		JOptionPane.showMessageDialog(null, "Fim");

		leitor.close();
	}

}
