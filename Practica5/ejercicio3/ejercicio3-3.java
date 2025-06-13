/*3. caminoMasCorto(String ciudad1, String ciudad2): List<String>
Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
existe camino retorna la lista vacía. (Las rutas poseen la distancia).*/

package tp5.ejercicio3;

import tp5.ejercicio1.*;
import java.util.*;

public class Mapa {
	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> grafo) {
		
		this.mapaCiudades = grafo;
	
	}
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> lista = new LinkedList<String>(); //Creamos una lista
		boolean [] marcados = new boolean[this.mapaCiudades.getSize()]; //Creamos un array de visitados
		List<String> caminoMinimo = new LinkedList<String>(); //Creamos una lista para el camino minimo
		if(this.mapaCiudades != null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> origen = this.mapaCiudades.search(ciudad1); //Nos posicionamos en el vertice origen
			if(origen != null) {
				//Si origen existe
				caminoMasCortoAux(origen,marcados,ciudad2,lista,caminoMinimo,0,9999);//Llamamos a la funcion
		}
		}
		
		return caminoMinimo;
	}
	
	private int caminoMasCortoAux(Vertex<String> origen,boolean[]marcados,String ciudad2,List<String>camino,List<String> caminoMin,int total,int min) {
		camino.add(origen.getData()); //Nos guardamos el valor del origen
		marcados[origen.getPosition()] = true; //Lo marcamos como visitado
		
		if(camino.contains(ciudad2)&& (total < min ) ) { //Si el camino contiene al destino y total es menor a min, entro
			caminoMin.removeAll(caminoMin); //Remuevo todo del camino minimo
			caminoMin.addAll(camino); //Aniado todo lo del nuevo camino
			min = total; //Total ahora es el nuevo minimo	
		}
		
		else {
			List<Edge<String>> aristas = this.mapaCiudades.getEdges(origen); //Me guardo los adyacentes del vertice
			Iterator<Edge<String>> it = aristas.iterator(); //Creo el iterador para recorrer los adyacentes
			while(it.hasNext() && total < min) { //Mientras haya siguiente y total sea menor al minimo, entro 
				Edge<String> ari = it.next(); //Me guardo el siguiente
				Vertex<String> v = ari.getTarget(); //Tomo el valor del vertice
				int suma = total + ari.getWeight(); //Sumo el total y el peso de la arista
				if(!marcados[v.getPosition()] && suma < min) { //Si el vertice no esta visitado y suma es menor al min
					//entro a calcular min llamando recursivamente
					min = caminoMasCortoAux(v,marcados,ciudad2,camino,caminoMin,suma,min);
				}
			}
		}
	    camino.remove(camino.size()-1); //Eliminamos el último vértice agregado a la lista camino
	    marcados[origen.getPosition()] = false; //Desmarcamos el vértice origen para poder usarlo en otros caminos
	    return min;
	}
}

/*
 	Si no hacés el remove y el desmarcado, te pasaría que:

	Los vértices se quedarían marcados para siempre en la búsqueda.

	La lista camino acumularía vértices que ya no están en el camino actual.

	El algoritmo no podría explorar caminos alternativos, y podrías obtener un resultado incorrecto o incompleto.
*/
