package tp1.ejercicio1;

public class ejercicio1 {
	public static void main (String[] args) {
		int valor1= 7;
		int valor2= 12;
		
		System.out.println("Impresion con For: "+"/n");
		Impresora.ejercicioConFor(valor1, valor2);
		
		System.out.println("Impresion con While: "+ "/n");
		Impresora.ejercicioConWhile(valor1, valor2);
		
		System.out.println("Impresion con Recursion: "+ "/n");
		Impresora.conRecursion(valor1, valor2);
	}
}
