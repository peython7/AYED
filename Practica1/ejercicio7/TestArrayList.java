package tp1.ejercicio7;

import java.util.*;
import tp1.ejercicio3.Estudiante;
public class TestArrayList {
	
	public static LinkedList<Estudiante> generarLista(){
		LinkedList<Estudiante> lista = new LinkedList<Estudiante>();
		Estudiante est = new Estudiante("Damian","Vega","1A","Dami@gmail.com","Gonnet");
		Estudiante est3 = new Estudiante("Pedro","Fernandez","1A","Pedro@gmail.com","Berisso");
		Estudiante est2 = new Estudiante("Marcos","Acunia","1A","Marcos@gmail.com","Ensenada");
		lista.add(est);
		lista.add(est2);
		lista.add(est3);
	 return lista;
	}
	
  public static void main(String[]args) {
	  ArrayList<Integer> lista = new ArrayList<Integer>(); //CREO LA LISTA 1 
	  Scanner s = new Scanner(System.in);
	  System.out.print("Ingrese un numero\n");
	  int n = s.nextInt();
	  while( n != -1) {
		  lista.add(n);
		  System.out.print("Ingrese un numero \n");
		  n = s.nextInt();
	  }
	  s.close();
	  System.out.print(lista); //IMPRIMO LA LISTA 1
	  
	  LinkedList<Estudiante> lista2 = new LinkedList<Estudiante>(); //CREO LA LISTA 2
	  lista2 = generarLista();
	  LinkedList<Estudiante> lista3 = new LinkedList<Estudiante>(); //CREO LA LISTA 3
	  lista3.addAll(lista2);
	  for(Estudiante est: lista2) {
		  System.out.print(est.tusDatos()+ "\n");
	  }
	  for(Estudiante est: lista3) {
		  System.out.print(est.tusDatos()+ "\n");
	  }
	 Estudiante est = lista2.get(1);
	 est.setApellido("Troglio");
	 lista2.set(1, est);
	 for(Estudiante est2: lista2) {
		  System.out.print(est2.tusDatos()+ "\n");
	  }
   	  
  }
}
