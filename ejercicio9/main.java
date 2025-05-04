package tp3.ejercicio9;

import tp3.ejercicio1.*;

public class main {
	public static void main(String[] args) {
		GeneralTree<Integer> a = new GeneralTree<Integer>(4);
		GeneralTree<Integer> n1 = new GeneralTree<Integer>(4);
		GeneralTree<Integer> n2 = new GeneralTree<Integer>(8);
		GeneralTree<Integer> n3 = new GeneralTree<Integer>(4);
		GeneralTree<Integer> n4= new GeneralTree<Integer>(9);
		GeneralTree<Integer> n5= new GeneralTree<Integer>(8);
		GeneralTree<Integer> n6 = new GeneralTree<Integer>(8);
		GeneralTree<Integer> n7= new GeneralTree<Integer>(14);
		GeneralTree<Integer> n8 = new GeneralTree<Integer>(13);
		GeneralTree<Integer> n9 = new GeneralTree<Integer>(9);
		GeneralTree<Integer> n10 = new GeneralTree<Integer>(4);
		
		a.addChild(n1); a.addChild(n2); a.addChild(n4);
		
		n1.addChild(n3); n1.addChild(n5);
		
		n2.addChild(n6);
		
		n4.addChild(n7); n4.addChild(n9);
		
		n3.addChild(n10); n3.addChild(n8);
		
		System.out.print(ParcialArboles.esDeSeleccion(a));
	}
}
