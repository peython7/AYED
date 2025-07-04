package PrimeraFecha;

import java.util.List;

public class ParcialArboles {

	public List<Integer> caminoSignoAlternante(GeneralTree<Integer> arbol){
		List<Integer> camino = new LinkedList<Integer>();
		if(!arbol.isEmpty() && arbol != null) {
			boolean ok = calcularMinimo(arbol,camino,new LinkedList<Integer>(),-9999,0);
		}
		return camino;
	}
	 private static int caminoHelper(GeneralTree<Integer> a, List<Integer> caminoMax, List<Integer> caminoAct, int sumaCaminoMax, int sumaCaminoAct) {
	        caminoAct.add(a.getData());
	        sumaCaminoAct += a.getData();
	        if(a.isLeaf()) {
	            if(sumaCaminoAct > sumaCaminoMax) {
	                caminoMax.clear();
	                caminoMax.addAll(caminoAct);
	                sumaCaminoMax = sumaCaminoAct;
	            }
	        } else {
	        	List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
	            for(GeneralTree<Integer> c : children) {
	                if((c.getData() < 0 && a.getData() >= 0)||(c.getData() >= 0 && a.getData() < 0))
	                    sumaCaminoMax = caminoHelper(c,caminoMax,caminoAct,sumaCaminoMax,sumaCaminoAct);
	            }
	        }
	        caminoAct.removeLast();
	        return sumaCaminoMax;
	    }
}
