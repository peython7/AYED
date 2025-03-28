package tp1.ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
	
	public static void main (String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("Ingrese valor: ");
		int valor= s.nextInt();
		
		int[] arreglo = multiplos.arrayMultiplos(valor);
		
		for(int i=0;i<valor;i++) {
			System.out.println(arreglo[i]);
		}
	}
}
