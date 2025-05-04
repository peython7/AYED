package tp3.ejercicio8;

import java.util.Iterator;
import java.util.List;
import tp3.ejercicio1.*;

public class Navidad {
	private GeneralTree<Integer> abeto;
	
	public Navidad(GeneralTree<Integer> a) {
		this.abeto = a;
	}
	
	public String esAbetoNavidenio() {
		String texto = "si";
		if(!this.abeto.isEmpty()) {
			if(!esAbetoNavidenio(this.abeto)) {
				texto = "No";
			}
		}
		else {
			texto="No";
		}
		return texto;
	}
	
	public boolean esAbetoNavidenio(GeneralTree<Integer> a) {
		boolean ok= true;
		int hojas = 0;
		if(!a.isLeaf()) {
			List<GeneralTree<Integer>> children = a.getChildren();
			Iterator<GeneralTree<Integer>> it = children.iterator();
			while(it.hasNext() && ok) {
				GeneralTree<Integer> c = it.next();
				if(c.isLeaf()) {
					hojas++;
				}
				else {
					ok = esAbetoNavidenio(c);
				}
			}
			if(hojas < 3) {
				ok=false;
			}
			else {
				ok=true;
			}
		}
		return ok;
	}
}
