package estudo.java;

public class Operador {
	
	public static void main(String[] args) {
		int x=10;
		int y=20;
		int z=x+y;
		
		int a=10;
		int b =20;
		int c=a+b;
		
		int m=10;
		int n=20;
		int o =a*b;
		
		int e=10;
		int f=20;
		int g=1/b;
		
		double i =2.5;
		int j =2;
		double k=(i % j);
		
		System.out.println("x[10] + y[20] : "+z);
		System.out.println("a[10] - b[20] :"+c);
		System.out.println("m[10] * n[20] :"+o);
		System.out.println("e[20] / f[11] :"+g);
		System.out.println("i[2.5] % j[2] : +k");
		
		System.out.println(a);
		a++;
		int posIncremento = a;
		System.out.println(a);
		System.out.println("Incremento: "+ posIncremento);
		
		System.out.println(a--);
		
		int preIncremento = ++a;
		System.out.println(preIncremento);
		
		a=10;
		b=20;
		
		boolean igual = (a==b);
		System.out.println(igual);
		
		boolean diferente = (a!=b);
		System.out.println(diferente);
		
		boolean t = false;
		boolean w = false;
		boolean operadorOu= t || w;
		boolean operadorE = t && w;

		System.out.println("a= " +a + " b = " +b);
		System.out.println("T || w: "+ operadorOu);
		System.out.println("T && w: "+operadorE);
		
		operadorOu = t | w & a > 10;
		operadorE = t & w & b < 20;
		operadorE = t & w & b > 20;
		operadorE = t & w & b <= 20;
		operadorE = t & w & b >= 20;
		
		System.out.println("T | w & a > 10: "+operadorOu);
		System.out.println("T & w & b < 20 " +operadorE);
			
		
		
}	

}
