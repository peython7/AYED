package Programacion3;

import java.util.List;

public class ParcialArboles {
	
	public GeneralTree<String> tesoroAccesibleMasCercano(GeneralTree<String> camaras){
		if(camaras!= null && !camaras.isEmpty()) {
			GeneralTree<String> inicio = buscarEntrada(camaras);
			if(inicio != null) {
				
			}
		}
		return null;
	}
	
	private boolean buscarTesoroMasCercano(GeneralTree<String> a, List<String> caminoMin, List<String> caminoActual, GeneralTree<String> tesoro) {
		if(a.getData() == "Bloqueo") {
			return false;
		}
		if(a.getData() == "Tesoro") {
			caminoActual.add(a.getData);
			return true;
		}
		if(a.hasChildren()) {
			List<GeneralTree<String>> children = a.getChildren();
			List<String> temp = new LinkedList<String>();
			for(GeneralTree<String> c: children) {
				boolean ok = buscarTesoroMasCercano(c,caminoMin,caminoActual,tesoro);
				if(ok) {
					temp.add(a.getData());
					temp.addAll(caminoActual);
					caminoActual.clear();
					caminoActual.addAll(temp);
					if( caminoMin.isEmpty() || caminoActual.size() < caminoMin.size()) {
						caminoMin.clear();
						caminoMin.addAll(caminoActual);
					}
					return ok;
				}
			}
		}
		return false;\
	}
}
