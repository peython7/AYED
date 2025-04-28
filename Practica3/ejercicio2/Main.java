package tp3.ejercicio2;

import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class Main {
	public static void main(String[]args) {
		GeneralTree<Integer> a = new GeneralTree<Integer>(101);
		GeneralTree<Integer> n1 = new GeneralTree<Integer>(7);
		GeneralTree<Integer> n2= new GeneralTree<Integer>(40);
		GeneralTree<Integer> n4 = new GeneralTree<Integer>(97);
		GeneralTree<Integer> n5 = new GeneralTree<Integer>(19);
		GeneralTree<Integer> n6 = new GeneralTree<Integer>(4);
        a.addChild(n1); a.addChild(n2); 
        n1.addChild(n4); n1.addChild(n5); n2.addChild(n6);
        RecorridoAG rec = new RecorridoAG();
    	System.out.println("-----------Pre orden----------------");
        List<Integer> l = rec.numerosImparesMayoresQuePreorden(a,3);
        System.out.println(l);
    	System.out.println("-----------In orden----------------");
        l = rec.numerosImparesMayoresQueInorden(a, 3);
		System.out.println(l);
		System.out.println("-----------PostOrden----------------");
		System.out.println(rec.numerosImparesMayoresQuePostorden(a,3));
		System.out.println("-----------Por Niveles----------------");
		System.out.println(rec.numerosImparesMayoresQuePorNiveles(a,3));
	}

}
