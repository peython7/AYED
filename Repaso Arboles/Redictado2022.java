package redictado2022;

import java.util.List;

public class Parcial {

	public List<Integer> resolver(BinaryTree<Integer> arbol, int num){
		List<Integer> camino = new LinkedList<Integer>();
		if(!arbol.isEmpty && arbol != null) {
			caminoPares(arbol,camino,0,num);
		}
		return camino;
	}
	
	private boolean caminoPares(BinaryTree<Integer> a,List<Integer> caminoAct,int paresActual, int num) {
		caminoAct.addLast(a.getData());
		int pares = 0; 
		if(a.getData() %2 == 0) {
			pares ++;
		}
		if(a.isLeaf()) {
			if((pares + paresActual)>= num) {
				return true;
			}
			caminoAct.removeLast();
			return false;
		}
		if(a.hasLeftChild()) {
			boolean ok = caminoPares(a.getLeftChild(),caminoAct,pares + paresActual,num);
			if(ok) {
				return ok;
			}
		}
		if(a.hasRightChild()) {
			boolean ok = caminoPares(a.getRightChild(),caminoAct,pares + paresActual,num);
			if(ok) {
				return ok;
			}
		}
		caminoAct.removeLast();
		return false;
	}
}
