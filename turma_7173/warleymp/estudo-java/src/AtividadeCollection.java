import java.util.Collection;
import java.util.HashSet;


public class AtividadeCollection {
	public static void main(String[] args) {
		
		Collection<String> nome = new HashSet<>();
		
		nome.add("Jo�o"); 
		nome.add("Maria"); 
		nome.add("Eduardo"); 
		nome.add("Silvana"); 
		nome.add("M�rio"); 
		nome.add("5");
		
        System.out.println("Nomes :" + nome.toString());
		
	}

}

//Nomes :[Silvana, Jo�o, Maria, M�rio, Eduardo]
//Nomes :[Jo�o, Maria, Eduardo, Silvana, M�rio]