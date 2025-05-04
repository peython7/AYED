package tp3.ejercicio7;

import tp3.ejercicio1.*;

public class main {
	
	public static void main(String[]args) {
		GeneralTree<Integer> a= new GeneralTree<Integer>(7);
		GeneralTree<Integer> nodo1 = new GeneralTree<Integer>(90);
		GeneralTree<Integer> nodo2 = new GeneralTree<Integer>(30);
		GeneralTree<Integer> nodo3 = new GeneralTree<Integer>(18);
		GeneralTree<Integer> nodo4 = new GeneralTree<Integer>(77);
		GeneralTree<Integer> nodo5 = new GeneralTree<Integer>(2);
		GeneralTree<Integer> nodo6 = new GeneralTree<Integer>(9);
		GeneralTree<Integer> nodo7 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> nodo8 = new GeneralTree<Integer>(20);
		GeneralTree<Integer> nodo9 = new GeneralTree<Integer>(100); 
		
		a.addChild(nodo1); a.addChild(nodo2); a.addChild(nodo3);
		
		nodo1.addChild(nodo8); nodo1.addChild(nodo7);
		
		nodo7.addChild(nodo9);
		
		nodo2.addChild(nodo4);
		
		nodo3.addChild(nodo5);
		
		nodo5.addChild(nodo6);
		
		Caminos c= new Caminos(a);
		System.out.println(c.caminoAHojaMasLejana());
	}
}
