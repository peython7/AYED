package tp3.ejercicio7;

import tp3.ejercicio1.*;
import java.util.*;

public class Caminos {

	private GeneralTree<Integer> arbol;
	
	public Caminos(GeneralTree<Integer> a) {
		this.arbol = a;
	}
	
	public List<Integer> caminoAHojaMasLejana(){
		LinkedList<Integer> lista= new LinkedList<Integer>();
		if(!this.arbol.isEmpty()) {
			lista= caminoAHojaMasLejana(this.arbol);
		}
		return lista;
	}
	
	private LinkedList<Integer> caminoAHojaMasLejana(GeneralTree<Integer> a){
		LinkedList<Integer> lista= new LinkedList<Integer>();
		LinkedList<Integer> l= new LinkedList<Integer>();
		if(a.isLeaf()) {
			lista.add(a.getData());
			return lista;
		}
		else {
			List<GeneralTree<Integer>> children = a.getChildren();
			for(GeneralTree<Integer> c:children) {
				lista = new LinkedList<Integer>();
				lista.addAll(caminoAHojaMasLejana(c));
				if(l.size() < lista.size()) {
					l = lista;
				}
			}
			l.add(a.getData());
			return l;
		}
	}
}
