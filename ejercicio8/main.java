package tp3.ejercicio8;

import tp3.ejercicio1.*;

public class main {
	public static void main(String [] args) {
		GeneralTree<Integer> a = new GeneralTree<Integer>(9);
		GeneralTree<Integer> n1 = new GeneralTree<Integer>(100);
		GeneralTree<Integer> n2 = new GeneralTree<Integer>(12);
		GeneralTree<Integer> n3 = new GeneralTree<Integer>(90);
		GeneralTree<Integer> n4= new GeneralTree<Integer>(200);
		GeneralTree<Integer> n5= new GeneralTree<Integer>(88);
		GeneralTree<Integer> n6 = new GeneralTree<Integer>(400);
		GeneralTree<Integer> n7= new GeneralTree<Integer>(7);
		GeneralTree<Integer> n8 = new GeneralTree<Integer>(2);
		
		a.addChild(n1); a.addChild(n2); a.addChild(n3); 
		
		n1.addChild(n4); n1.addChild(n5); n1.addChild(n6);
		
		a.addChild(n8);
		
		n2.addChild(n7);
		
		Navidad n= new Navidad(a);
		
		System.out.println(n.esAbetoNavidenio());
	}
}
