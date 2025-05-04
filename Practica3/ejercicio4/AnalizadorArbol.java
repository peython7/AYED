package tp3.ejercicio4;

import java.util.List;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.*;

public class AnalizadorArbol {

	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> a) {
		double prom = 0;
		double promMax = 0;
		double cant = 0;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(a);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			GeneralTree<AreaEmpresa> ar = cola.dequeue();
			if(a != null) {
				prom += ar.getData().getTardanza();
				List<GeneralTree<AreaEmpresa>> children = ar.getChildren();
				cant++;
				for(GeneralTree<AreaEmpresa> c:children) {
					cola.enqueue(c);
				}
			}
			else {
				prom = prom/cant;
				promMax = Math.max(promMax, prom);
				prom = 0;
				cant = 0;
				if(!cola.isEmpty()) {
					cola.enqueue(null);
				}
			}
		}
		return promMax;
	}
}
