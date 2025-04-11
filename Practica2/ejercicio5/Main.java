package tp2.ejercicio5;

import tp2.ejercicio1.BinaryTree;

public class Main {
	public static void main(String[] args){
		BinaryTree<Integer> arbol = new  BinaryTree<Integer>(4);
		BinaryTree<Integer> hi = new  BinaryTree<Integer>(8);
		BinaryTree<Integer> hd = new  BinaryTree<Integer>(19);
		BinaryTree<Integer> nodo4 = new  BinaryTree<Integer>(19);
		BinaryTree<Integer> nodo5 = new  BinaryTree<Integer>(20);
		BinaryTree<Integer> nodo6 = new  BinaryTree<Integer>(5);
		arbol.addLeftChild(hi);
		arbol.addRightChild(hd);
		hd.addLeftChild(nodo4);
		hd.addRightChild(nodo5);
		hi.addLeftChild(nodo6);
		ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario();
		prof.setAr(arbol);
		System.out.println(prof.sumaElementosProfundidad(2));
		
	}
}