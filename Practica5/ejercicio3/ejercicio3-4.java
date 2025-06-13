/*
 4. caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto): List<String>
Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.
*/

package tp5.ejercicio3;

import tp5.ejercicio1.*;
import java.util.*;

public class Mapa {
	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> grafo) {
		
		this.mapaCiudades = grafo;
	
	}
	
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> camino = new LinkedList<String>(); //Creamos la lista para guardar el camino
		boolean[] marcados = new boolean[this.mapaCiudades.getSize()]; //Creamos el array de visitados
		if(this.mapaCiudades != null && !this.mapaCiudades.isEmpty()) {
			//Si el mapa de ciudades no esta vacio entro
			Vertex<String> origen = this.mapaCiudades.search(ciudad1); //Me guardo el vertice donde comenzar el camino
			if(origen != null) {
				//Si origen existe entro
				caminoSinCargarCombustibleAux(origen,marcados,ciudad2,tanqueAuto,camino);
			}
		}
		return camino;
	}
	
	private void caminoSinCargarCombustibleAux(Vertex<String> origen,boolean[] marcados, String ciudad2,int tanqueAuto,List<String> camino) {
		camino.add(origen.getData()); //Agrego el origen a la lista
		marcados[origen.getPosition()] = true; //Lo marco como visitado
		if(!origen.getData().equals(ciudad2)) { //Si origen es distinto a destino entro
			List<Edge<String>> aristas = this.mapaCiudades.getEdges(origen); //Me guardo los adyacentes
			Iterator<Edge<String>> it = aristas.iterator(); //Creo el iterador para iterar los adyacentes
			while(it.hasNext() && !camino.contains(ciudad2)) {
				//Mientras haya siguiente y no hayamos llegado a destino 
				Edge<String> ari = it.next(); //Me guardo la siguiente arista
				Vertex<String> v = ari.getTarget(); //Tomo el valor del vertice destino de la arista
				int aux = tanqueAuto - ari.getWeight(); //Al tanque le resto el peso la arista
				if(aux > 0) {
					//Si el tanque no esta vacio llamo recursivamente
					caminoSinCargarCombustibleAux(v,marcados,ciudad2,aux,camino);
				}
			}
		}
		if(!camino.contains(ciudad2)) {
			//Si el camino no contiene a destino
			camino.remove(camino.size()-1); //Removemos el ultimo de la lista
			marcados[origen.getPosition()] = false; // Marcamos al origen como no visitado
		}
	}
}
