package ParcialPrincesa;

import java.util.LinkedList;

public class Parcial {

	private GeneralTree<Personaje> arbol;
	
	public Parcial(GeneralTree<Personaje> a) {
		this.arbol = a;
	}
	
	public List<Personaje> devolverCamino(){
		List<Personaje> lista = new LinkedList<Personaje>();
		if(arbol != null && !arbol.isEmpty()) {
			boolean ok = buscarPrincesa(lista,arbol);
			return lista;
		}
		return null;
	}
	
	private boolean buscarPrincesa(LinkedList<Personaje> l,GeneralTree<Personaje> a){
		String personaje = a.getData(); 
		if(personaje.getTipo() == "Dragon") {
			return false;
		}
		if(personaje.getTipo() == "Princesa") {
			l.add(personaje);
			return true;
		}
		if(a.hasChildren()) {
			List<GeneralTree<Personaje>> temp = new LinkedList<GeneralTree<Personaje>>();
			List<GeneralTree<Personaje>> children = a.getChildren();
			for(GeneralTree<Personaje> c: children) {
				boolean ok= buscarPrincesa(l,c); 
				if(ok) {
					temp.add(a.getData());
					temp.addAll(l);
                    			l.clear();
                    			l.addAll(temp);
					return ok;
				}
			}		
		}
		return false;
	}
}

