package tp2.ejercicio3;

import tp2.ejercicio1.BinaryTree;
import java.util.*;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;
	
	public ContadorArbol(BinaryTree<Integer> a) {
		this.addArbol(a);
	}
	
	public ContadorArbol() {
		this.arbol=null;
	}
	
	public void addArbol(BinaryTree<Integer> a) {
		this.arbol=a;
	}
	
	public static void numerosParesInorden(BinaryTree<Integer> a,ArrayList<Integer> l){
		if(a.isEmpty()) return;
		if(a.hasLeftChild()) {
			numerosParesInorden(a.getLeftChild(),l);
		}
		
		if((a.getData() % 2) == 0) l.add(a.getData());
		
		if(a.hasRightChild()) {
			numerosParesInorden(a.getRightChild(),l);
		}
	}
	
	public static void numerosParesPostorden(BinaryTree<Integer> a,ArrayList<Integer> l){
		if(a.isEmpty()) return;
		if(a.hasLeftChild()) {
			numerosParesPostorden(a.getLeftChild(),l);
		}
		if(a.hasRightChild()) {
			numerosParesPostorden(a.getRightChild(),l);
		}
		
		if((a.getData() % 2) == 0) l.add(a.getData());
	}
	
	private static BinaryTree<Integer> cargarArbol() {
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
	
	public static void imprimirArbol(BinaryTree<Integer> a) {
		if(a.isEmpty()) return;
		System.out.println(a.getData());
		if(a.hasLeftChild()) {
			imprimirArbol(a.getLeftChild());
		}
		if(a.hasRightChild()) {
			imprimirArbol(a.getRightChild());
		}
	}
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		ArrayList<Integer> integerListInorden= new ArrayList<Integer>();
		ArrayList<Integer> integerListPostorden= new ArrayList<Integer>();
		BinaryTree<Integer> arbol= new BinaryTree<Integer>();
		arbol= cargarArbol();
		imprimirArbol(arbol);
		System.out.println("INORDEN");
		numerosParesInorden(arbol,integerListInorden);
		for(int i=0; i<integerListInorden.size();i++) {
			System.out.println(integerListInorden.get(i));
		}
		System.out.println("POSTORDEN");
		numerosParesPostorden(arbol,integerListPostorden);
		for(int i=0; i<integerListPostorden.size();i++) {
			System.out.println(integerListPostorden.get(i));
		}
	}
}
