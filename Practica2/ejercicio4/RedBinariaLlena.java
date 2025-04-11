package tp2.ejercicio4;

import tp2.ejercicio1.BinaryTree;

public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;
	
	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	public int retardoReenvio() {
		  if(!arbol.isEmpty()) {
			  return retardoReenvio(arbol);
		  }
		  else return 0;
		}
		
	private int retardoReenvio(BinaryTree<Integer> ab) {
		
		if(ab.isLeaf()) {
			return ab.getData();
		}
		else {
			int l = 0;
			int r = 0;
			if(ab.hasLeftChild()) {
				l= retardoReenvio(ab.getLeftChild());
			}
			if(ab.hasRightChild()) {
				r= retardoReenvio(ab.getRightChild());
			}
		return ab.getData() + Math.max(l, r);
		}
		
	}
}