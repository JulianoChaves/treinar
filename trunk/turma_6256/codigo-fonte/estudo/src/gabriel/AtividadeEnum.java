package gabriel;

import javax.swing.JOptionPane;

import estudo.dominiodiscreto.Turno;

public class AtividadeEnum {
	public static void main(String[] args) {
		String num = JOptionPane.showInputDialog(null,"Informe um n�mero");
		
		switch (num) {
		case "0":
			System.out.println(Turno.MANHA);
			break;
		case "1":
			System.out.println(Turno.TARDE);
			break;
		case "2":
			System.out.println(Turno.NOITE);
			break;

		default:
			System.out.println("Op��o inv�lida");
			break;
		}
	}

}
