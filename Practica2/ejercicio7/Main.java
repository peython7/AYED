package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

public class Main{
	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new  BinaryTree<Integer>(4);
		BinaryTree<Integer> hi = new  BinaryTree<Integer>(8);
		BinaryTree<Integer> hd = new  BinaryTree<Integer>(19);
		BinaryTree<Integer> nodo6 = new  BinaryTree<Integer>(5);
		arbol.addLeftChild(hi);
		arbol.addRightChild(hd);
		hi.addRightChild(nodo6);
		ParcialArboles par = new ParcialArboles();
		par.setAr(arbol);
		System.out.println(par.isLeftTree(4));
		
	}
}