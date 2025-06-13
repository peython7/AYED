/*1. devolverCamino (String ciudad1, String ciudad2): List<String>
Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).*/

package tp5.ejercicio3;

import tp5.ejercicio1.*;
import java.util.*;

public class Mapa {
	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> grafo) {
		
		this.mapaCiudades = grafo;
	
	}
	
	public List<String> devolverCamino (String ciudad1, String ciudad2){
		List<String> lista = new LinkedList<String>();
		boolean [] marcados = new boolean[this.mapaCiudades.getSize()];
		
		if(!this.mapaCiudades.isEmpty()) { //Chequea que no este vacio el Grafo
			Vertex<String> origen = this.mapaCiudades.search(ciudad1); // Se posiciona en el vertice elegido
			
			if(origen != null) {
				devolverCaminoAux(origen,marcados,ciudad2,lista);// Llama a la funcion que arma la lista
			}
			
		}
		return lista;
	}
	
	private void devolverCaminoAux(Vertex<String>origen,boolean[]marcados, String ciudad2,List<String> camino) {
			camino.add(origen.getData()); //Aniadimos el vertice a la lista
			marcados[origen.getPosition()] = true; //Lo marcamos como visitado
			if(!origen.getData().equals(ciudad2)) { //Chequeamos no estar en el valor de destino
			  List<Edge<String>> aristas = this.mapaCiudades.getEdges(origen); // Me guardo los adyacentes del vertice
			  Iterator<Edge<String>> it = aristas.iterator();
			  while(it.hasNext() && !camino.get(camino.size()-1).equals(ciudad2)) {
				  //Mientras haya siguiente y no se haya encontrado a ciudad2
				  Edge<String> ari = it.next(); // Me guardo la siguiente arista
				  Vertex<String> v = ari.getTarget(); // Me guardo el vertice de la siguiente arista
				  if(!marcados[v.getPosition()]) { //Si no esta marcado como visitado, lo visito
					  devolverCaminoAux(v,marcados,ciudad2,camino);
				  }
			  }
			}
		     if(!camino.contains(ciudad2)) { //Si ciudad2 no esta en camino
		    	 camino.remove(camino.size()-1); // Elimino el ultimo del camino
		    	 marcados[origen.getPosition()] = false; //Marco como no visitado 
		    }
		    
	}
	
}
