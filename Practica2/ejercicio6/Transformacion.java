package tp2.ejercicio6;

import tp1.ejercicio8.Queue;
import tp2.ejercicio1.BinaryTree;

public class Transformacion {

	private BinaryTree<Integer> arbol;
	
	public void setArbol(BinaryTree<Integer> a) {
		this.arbol=a;
	}
	
	public BinaryTree<Integer> sum(){
		if(!this.arbol.isEmpty()) {
			suma(this.arbol);
			return this.arbol;
		}
		else {
			return null;
		}
	}
	
	private int suma(BinaryTree<Integer> a){
		if(a.isLeaf()) {
			int num= a.getData();
			a.setData(0);
			return num;
		}
		else {
			int l=0;
			int r=0;
			if(a.hasLeftChild()) {
				l= suma(a.getLeftChild());
			}
			if(a.hasRightChild()) {
				r= suma(a.getRightChild());
			}
			int aux= a.getData();
			a.setData(l+r);
			return aux + l + r;
		}
	}
	
	public void imprimir() {
		if(this.arbol==null)return;
		
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		BinaryTree<Integer> aux= new BinaryTree<Integer>();
		cola.enqueue(this.arbol);
		while(!cola.isEmpty()) {
			int cantidadNodosNivel = cola.size();
			for (int i = 0; i < cantidadNodosNivel; i++) {
				aux= cola.dequeue();
				System.out.print("  " + aux.getData() + "  ");
				if(aux.hasLeftChild()) {
					cola.enqueue(aux.getLeftChild());
				}
				if(aux.hasRightChild()) {
					cola.enqueue(aux.getRightChild());
				}
			}
			System.out.println();
		}
	}
}
