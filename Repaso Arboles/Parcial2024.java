package Parcial2024;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {

	private GeneralTree<Integer> arbol;
	
	public List<Integer> camino(int num){
		List<Integer> camino = new LinkedList<Integer>();
		if(arbol != null && !arbol.isEmpty && num>=0) {
			calcularCamino(arbol,num,camino);
		}
	}
	
	private boolean calcularCamino(GeneralTree<Integer> a,int n, LinkedList<Integer> camino) {
		if(a.isLeaf()) {
			camino.add(a.getData());
			return true;
		}
		if(a.getChildren().size() >= n) {
			List<Integer> temp = new LinkedList<Integer>();
			List<GeneralTree<Integer>> children = a.getChildren();
			for(GeneralTree<Integer> c:children) {
				boolean ok = calcularCamino(c,n,camino);
				if(ok) {
					temp.add(a.getData());
					temp.addAll(camino);
					camino.clear();
					camino.addAll(temp);
					return ok;
				}
			}
		}
		return false;
	}
}
