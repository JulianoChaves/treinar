package luis;

import javax.swing.JOptionPane;

import estudo.dominiodiscreto.DiaSemana;


public class RetornaDiaSemana{

	public static void main(String[] args) {
		Integer dia = Integer.valueOf(JOptionPane.showInputDialog("Numera��o do dia"));
		JOptionPane.showMessageDialog(null, DiaSemana.values()[dia]);
		
	}
	
}
	