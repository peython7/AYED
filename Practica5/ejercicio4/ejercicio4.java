package tp5.ejercicio4;

import java.util.*;

import tp5.ejercicio1.*;

public class VisitaOslo {
	
	public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
		List<String> camino = new LinkedList<String>(); //Creamos la lista para guardar el camino
		boolean [] marcados = new boolean[lugares.getSize()]; //Creamos lista de visitados
		if(lugares != null && !lugares.isEmpty()) {
			//Si la lista de lugares no esta vacia entro
			Vertex<String> origen = lugares.search("Ayuntamiento"); //Nos posicionamos en el origen
			paseoEnBiciAux(origen,destino,marcados,maxTiempo,lugaresRestringidos,camino,lugares);
		}
		
		return camino;
		
	}
	private void paseoEnBiciAux(Vertex<String>origen, String destino,boolean[]marcados,int maxTiempo,List<String> lugaresRestringidos,List<String> camino, Graph<String> lugares) {
		camino.add(origen.getData()); //Aniadimos el origen a la lista del camino
		marcados[origen.getPosition()] = true; //Lo marcamos como visitado
		if(!origen.getData().equals(destino)) {
			//Si no encontre el destino entro
			List<Edge<String>> aristas = lugares.getEdges(origen);//Me guardo en una lista los adyacentes
			Iterator<Edge<String>> it = aristas.iterator(); //Creo el iterador para recorrer los adyacentes
			while(it.hasNext() && !camino.contains(destino)) {
				//Mientras haya siguiente y camino no contenga al destino
				Edge<String> arista = it.next(); //Me posiciono en la siguiente arista
				Vertex<String> v = arista.getTarget(); //Tomo el valor del destino de la arista
				int aux = maxTiempo - arista.getWeight(); //Descuento el tiempo tardado del tiempo maximo a tardar
				
				if(!marcados[v.getPosition()] && aux > 0 && !lugaresRestringidos.contains(v.getData())) {
					//Si el lugar no esta visitado y tiempo restante es mayor a 0 y el lugar no esta restringido
					paseoEnBiciAux(v,destino,marcados,aux,lugaresRestringidos,camino,lugares);
				}
					
			}
		}
		if(!camino.contains(destino)) { //Si el camino no contiene al destino buscado
			camino.remove(camino.size()-1); //Eliminamos del camino el ultimo vertice
			marcados[origen.getPosition()] = false; // Marcamos como no visitado el origen
		}
	}
}
