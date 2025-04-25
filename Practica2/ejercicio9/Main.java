package tp2.ejercicio9;

import tp2.ejercicio1.BinaryTree;

public class Main {

	public static void main(String[] args) {
		BinaryTree<Integer> arbol= new BinaryTree<Integer>(10);
		BinaryTree<Integer> hi= new BinaryTree<Integer>(70);
		BinaryTree<Integer> hd= new BinaryTree<Integer>(50);
		BinaryTree<Integer> nodo1= new BinaryTree<Integer>(90);
		arbol.addLeftChild(hi);
		arbol.addRightChild(hd);
		hi.addRightChild(nodo1);
		
		ParcialArboles p= new ParcialArboles();
		BinaryTree<int[]> a= p.sumAndDif(arbol);

		System.out.println(p.toString(a));
	}

}
