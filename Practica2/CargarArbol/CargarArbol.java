package CargarArbol;

import tp2.ejercicio1.BinaryTree;
import tp2.ejercicio2.*;

public class CargarArbol {

	public BinaryTree<Integer> cargarArbolEnteros(){
		BinaryTree<Integer> a1= new BinaryTree<Integer>(20);
		BinaryTree<Integer> hoja1= new BinaryTree<Integer>(12);
		BinaryTree<Integer> hoja2= new BinaryTree<Integer>(34);
		a1.addLeftChild(hoja1);
		a1.addRightChild(hoja2);
		
		BinaryTree<Integer> a2= new BinaryTree<Integer>(23);
		BinaryTree<Integer> hoja3= new BinaryTree<Integer>(45);
		a2.addLeftChild(a1);
		a2.addRightChild(hoja3);
		
		BinaryTree<Integer> a3= new BinaryTree<Integer>(72);
		BinaryTree<Integer> hoja4= new BinaryTree<Integer>(3);
		BinaryTree<Integer> hoja5= new BinaryTree<Integer>(14);
		a3.addLeftChild(hoja4);
		a3.addRightChild(hoja5);
		
		BinaryTree<Integer> raiz= new BinaryTree<Integer>(5);
		raiz.addLeftChild(a2);
		raiz.addRightChild(a3);
		
		return raiz;
	}
}
