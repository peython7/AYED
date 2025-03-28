package tp1.ejercicio2;

public class multiplos {

	public static int[] arrayMultiplos(int n) {
		int [] m= new int[n];
		for(int i=0; i< n;i++) {
			m[i]=n*(i+1);
		}
		return m;
	}
}
