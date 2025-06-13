/*2. devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades): List<String>
Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
vacía. (Sin tener en cuenta el combustible).*/

package tp5.ejercicio3;

import tp5.ejercicio1.*;
import java.util.*;

public class Mapa {
	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> grafo) {
		
		this.mapaCiudades = grafo;
	
	}
	
	public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
		/*Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
		  que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
	      vacía. (Sin tener en cuenta el combustible)*/
		
		List<String> camino = new LinkedList<String>();
		boolean [] marcados = new boolean[this.mapaCiudades.getSize()];
		
		if(this.mapaCiudades != null && !this.mapaCiudades.isEmpty() ) {
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);// Se posiciona en el vertice elegido
			
			if(origen != null) {
				devolverCaminoExceptuandoAux(origen,camino,ciudad2,marcados,ciudades);// Llama a la funcion que arma la lista
			}
			
		}
		return camino;
	}
	
	private void devolverCaminoExceptuandoAux(Vertex<String> origen,List<String> camino, String destino,boolean[] marcados,List<String> restringidos) {
		   camino.add(origen.getData()); //Agrego el origen/vertice a la lista
		   marcados[origen.getPosition()] = true; //Marcamos el origen como visitado
		   
		   if(!origen.getData().equals(destino)) { //Si origen es distinto a destino entro al if
			   
			   List<Edge<String>> aristas = this.mapaCiudades.getEdges(origen); //Me guardo los adyacentes del vertice
			   Iterator<Edge<String>> it = aristas.iterator(); //Creo el iterador para recorrer los adyacentes
				  while(it.hasNext() && !camino.get(camino.size()-1).equals(destino)) {
					  //Mientras haya siguiente y no se haya encontrado al destino
					  Edge<String> ari = it.next(); //Me guardo la siguiente arista
					  Vertex<String> v = ari.getTarget(); //Me guardo el vertice destino de la arista o el vertice de la arista
					  if(!marcados[v.getPosition()] && !restringidos.contains(v.getData())) {
						  //si el vertice no esta visitado y el dato del vertice no se encuentra en la lista de restringidos
						  //Llamamos a devolver camino aux parado en el nuevo vertice
						  devolverCaminoExceptuandoAux(v,camino,destino,marcados,restringidos);
					  }
				  }
			   
		   }
		   if(!camino.contains(destino)) {
			   	//si el camino no contiene el destino buscado
		    	camino.remove(camino.size()-1); //elimino el ultimo del camino
		    	marcados[origen.getPosition()] = false; //Marco al origen como no visitado
		     }
		  
		
	}
	
}
