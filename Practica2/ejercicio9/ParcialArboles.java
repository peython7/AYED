package tp2.ejercicio9;

import tp1.ejercicio8.Queue;
import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {

	public BinaryTree<int[]> sumAndDif(BinaryTree<Integer> arbol){
		if(!arbol.isEmpty()) {
			BinaryTree<int[]> a= sumAndDifPriv(arbol,0,0);
			return a;
		}
		return null;
	}
	
	private BinaryTree<int[]> sumAndDifPriv(BinaryTree<Integer> arbol, int padre, int suma){
		int[] v= new int[2];
		v[0] = arbol.getData() + suma;
		v[1]  = arbol.getData() - padre;
		BinaryTree<int[]> a = new BinaryTree<int[]>();
		a.setData(v);
		if(arbol.hasLeftChild()) {
			a.addLeftChild(sumAndDifPriv(arbol.getLeftChild(),arbol.getData(),suma + arbol.getData()));
		}
		if(arbol.hasRightChild()) {
			a.addRightChild(sumAndDifPriv(arbol.getRightChild(),arbol.getData(), suma + arbol.getData()));
		}
		return a;
 	}
	
	public String toString(BinaryTree<int[]> arbol) {
		String aux= "";
		Queue<BinaryTree<int[]>> cola= new Queue<BinaryTree<int[]>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			BinaryTree<int[]> aux1= cola.dequeue();
			if(aux1 != null) {
				aux+= " | " + aux1.getData()[0] + " | " + aux1.getData()[1];
				if(aux1.hasLeftChild()) {
					cola.enqueue(aux1.getLeftChild());
				}
				if(aux1.hasRightChild()) {
					cola.enqueue(aux1.getRightChild());
				}
			}
			else if(!cola.isEmpty()) {
				aux+= "\n";
				cola.enqueue(null);
			}
		}
		return aux;
	}
}
