package tp3.ejercicio6;

import tp3.ejercicio1.*;

public class main {

	public static void main(String[]args) {
		GeneralTree<Character> a= new GeneralTree<Character>('A');
		GeneralTree<Character> nodo1 =  new GeneralTree<Character>('P');
		GeneralTree<Character> nodo2 = new GeneralTree<Character>('O');
		GeneralTree<Character> nodo3 = new GeneralTree<Character>('L');
		GeneralTree<Character> nodo4 = new GeneralTree<Character>('U');
		GeneralTree<Character> nodo5 = new GeneralTree<Character>('Y');
		GeneralTree<Character> nodo6 = new GeneralTree<Character>('T');
		GeneralTree<Character> nodo7 = new GeneralTree<Character>('R');
		GeneralTree<Character> nodo8 = new GeneralTree<Character>('V');
		
		a.addChild(nodo1);
		a.addChild(nodo2);
		a.addChild(nodo3);
		
		nodo2.addChild(nodo8);
		
		nodo3.addChild(nodo4);
		
		nodo1.addChild(nodo5);
		nodo1.addChild(nodo6);
		
		nodo6.addChild(nodo7);
		
		RedDeAguaPotable r= new RedDeAguaPotable(a);
		
		System.out.println(r.minimoCaudal(900));
	}
}
