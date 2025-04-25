package tp2.ejercicio8;

import tp2.ejercicio1.*;

public class Main {
	public static void main(String[] args) {
		BinaryTree<Integer> arbol= new BinaryTree<Integer>(10);
		BinaryTree<Integer> hi= new BinaryTree<Integer>(70);
		BinaryTree<Integer> hd= new BinaryTree<Integer>(50);
		BinaryTree<Integer> nodo1= new BinaryTree<Integer>(90);
		arbol.addLeftChild(hi);
		arbol.addRightChild(hd);
		hi.addRightChild(nodo1);
		
		BinaryTree<Integer> arbol2= new BinaryTree<Integer>(10);
		BinaryTree<Integer> hi2= new BinaryTree<Integer>(70);
		BinaryTree<Integer> hd2= new BinaryTree<Integer>(50);
		BinaryTree<Integer> nodo2= new BinaryTree<Integer>(90);
		BinaryTree<Integer> nodo3= new BinaryTree<Integer>(90);
		arbol2.addLeftChild(hi2);
		arbol2.addRightChild(hd2);
		hi2.addRightChild(nodo2);
		hi2.addLeftChild(nodo3);
		
		ParcialArboles p = new ParcialArboles();
		
		System.out.println(p.esPrefijo(arbol, arbol2));
	}
}
