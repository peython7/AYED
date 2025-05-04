package tp3.ejercicio9;

import java.util.*;
import tp3.ejercicio1.*;

public class ParcialArboles {

	public static boolean esDeSeleccion(GeneralTree<Integer> a) {
		if(a.isEmpty()) {
			return false;
		}
		return esDeSeleccion3(a);
	}
	
	private static boolean esDeSeleccion2(GeneralTree<Integer> a) {
		boolean ok = true;
		int min = 9999;
		if(!a.isLeaf()) {
			List<GeneralTree<Integer>> children  = a.getChildren();
			for(GeneralTree<Integer> c:children) {
				ok = esDeSeleccion2(c);
				if(c.getData() < min) {
					min = c.getData();
				}
			}
			if(min != a.getData()) {
				ok= false;
			}
		}
		return ok;
	}
	
	private static boolean esDeSeleccion3(GeneralTree<Integer> a) {
		if(!a.isLeaf()) {
			boolean isEqualRoot = false;
			List<GeneralTree<Integer>> children  = a.getChildren();
			for(GeneralTree<Integer> c:children) {
				if (c.getData() < a.getData()) {
					return false;
				}
				boolean ok = esDeSeleccion3(c);
				if (!ok) return false;
				
				if (!isEqualRoot && c.getData() == a.getData()) {
					isEqualRoot = true;
				}
			}
			return isEqualRoot; //si llego aca es porque asumo que todos los subarboles dieron true

		}
		return true;
	}

}
