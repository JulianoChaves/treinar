package gilberto.excecao;

public class Principal {

	public static void main(String[] args) {

		Add();

	}

	private static void Add() {
		try {
			Venda v = new Venda();
			v.adicionarProduto();
		} catch (ProdutoNaoDisponivelException e) {
			System.out.println("N�o h� produto disponivel!");
		}finally
		{
			//Sempre ser� executado
		}
	}

}
