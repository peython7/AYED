package tp2.ejercicio2;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;
	
	public BinaryTree(T d){
		this.data= d;
		this.leftChild=null;
		this.rightChild=null;
	}
	
	public boolean hasLeftChild() {
		if(this.leftChild != null) {
			return true;
		}
		return false;
	}
	
	public BinaryTree<T> getLeftChild(){
		if(this.hasLeftChild()) {
			return this.leftChild;
		}
		throw new IllegalStateException("No tiene hijo izquierdo.");
	}
	
	public boolean hasRightChild() {
		if(this.rightChild != null) {
			return true;
		}
		return false;
	}
	
	public BinaryTree<T> getRightChild(){
		if(this.hasRightChild()) {
			return this.rightChild;
		}
		throw new IllegalStateException("No tiene hijo derecho.");
	}
	
	public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }
	
	public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
	}
	
	public void removeLeftChild() {
	        this.leftChild = null;
	}

	public void removeRightChild() {
	        this.rightChild = null;
	}
	 
	public boolean isEmpty() {
		return data == null && this.leftChild == null && this.rightChild == null;
	}

	public boolean isLeaf() {
		return this.leftChild == null && this.rightChild == null;
	}
	
	public T getData() {
		return this.data;
	}
	
	//Inciso A
    public int contarHojas() {
        if (this.isEmpty()) return 0;
        if (this.isLeaf()) return 1;
        
        int hojasDer;
        int hojasIzq;
        
        if(leftChild != null) {
        	hojasIzq= leftChild.contarHojas();
        }else {
        	hojasIzq= 0;
        }
        
        if(rightChild != null) {
        	hojasDer= rightChild.contarHojas();
        }else {
        	hojasDer= 0;
        }
        
        return hojasIzq + hojasDer;
    }
	
	//Inciso B
	public BinaryTree<T> espejo() {
	    BinaryTree<T> copia = new BinaryTree<>(this.data);

	    // Llamada recursiva para intercambiar
	    if (this.leftChild != null) {
	        copia.rightChild = this.leftChild.espejo();
	    }

	    if (this.rightChild != null) {
	        copia.leftChild = this.rightChild.espejo();
	    }

	    return copia;
	}
	
	//Inciso C
	public void entreNiveles(int n,int m) {
		if((this.isEmpty()) || n<0 || m<n) return;
		Queue<BinaryTree<T>> cola= new LinkedList<BinaryTree<T>>();
		cola.add(this);
		int nivelActual= 0;
		
		while(!cola.isEmpty()) {
			int nodoNivel= cola.size();
			if(nivelActual >= n && nivelActual <= m) {
				BinaryTree<T> nodo= cola.remove();
				System.out.println(nodo.getData() + " | ");
				if(nodo.hasLeftChild()) {
					cola.add(nodo.getLeftChild());
				}
				if(nodo.hasRightChild()) {
					cola.add(nodo.getRightChild());
				}
			}
			else {
				for(int i=0;i< nodoNivel;i++) {
					cola.remove();
				}
			}
			nivelActual++;
			System.out.println("");
		}
	}
}
