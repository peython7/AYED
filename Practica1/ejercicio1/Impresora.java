package tp1.ejercicio1;

public class Impresora {

	public static void ejercicioConFor(int a, int b) {
		for(int i=a;i<=b;i++) {
			System.out.println(i);
		}
	}
	
	public static void ejercicioConWhile(int a, int b) {
		int z=a;
		while(z<=b) {
			System.out.println(z);
			z++;
		}
	}
	
	public static void conRecursion(int a, int b) {
		if(a<=b) {
			System.out.println(a);
			conRecursion(a+1,b);
		}
	}
}
