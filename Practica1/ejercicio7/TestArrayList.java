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
	
	public static ArrayList<Integer> combinarListas(ArrayList<Integer> l1,ArrayList<Integer> l2) {
		ArrayList<Integer> l3= new ArrayList<Integer>();
		int i=0;
		int j=0;
		while((i < l1.size()) && ((j < l2.size()))){
			if(l1.get(i) < l2.get(j)) {
				l3.add(l1.get(i));
				i++;
			}
			else if(l2.get(j) < l1.get(i)){
				l3.add(l2.get(j));
				j++;
			}
			else {
				l3.add(l1.get(i));
				j++;
				i++;
			}
		}

        while (i < l1.size()) {
            l3.add(l1.get(i++));
        }
        
        while (j < l2.size()) {
            l3.add(l2.get(j++));
        }
        return l3;
	}
	
	public static int sumarLinkedList(LinkedList<Integer> l, int index) {
		 if (index >= l.size()) {
	            return 0; // Caso base: si el índice supera el tamaño de la lista
	        }
		 return l.get(index) + sumarLinkedList(l, index + 1);
	}
	
	/*
	 if (index >= l.size()) {
            return 0; // Caso base: si el índice supera el tamaño de la lista
        }
        return l.get(index) + sumarLinkedList(l, index + 1);
	 */
	
	public static void invertirArrayList(int i,int f,ArrayList<Integer> l) {
		if(i<=f) {
			int aux=l.get(i);
			l.set(i, l.get(f));
			l.set(f, aux);
			invertirArrayList(i+1,f-1,l);
		}
	}
	
	public static ArrayList<Integer> generarListaEnteros(int n, ArrayList<Integer> l){
		if(n != 1) {
			if((n%2)==0) {
				n= n/2;
			}
			else {
				n= (3*n) + 1;
			}
			l.add(n);
			generarListaEnteros(n,l);
		}
		return l;
	}
	
	public static boolean esCapicua(ArrayList lista) {
		boolean ok=true;
		int izq=0;
		int der= lista.size()-1;
		while((izq<der) && (ok)) {
			if(!lista.get(izq).equals(lista.get(der))) {
				ok=false;
			}
			else {
				izq++;
				der--;
			}
		}
		return ok;
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
	  System.out.println(lista); //IMPRIMO LA LISTA 1
	  System.out.println(esCapicua(lista) + "\n"); 
	  
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
   	  
	 ArrayList<Integer> lista4= new ArrayList<Integer>();
	 int num;
	 System.out.println("Ingrese un numero para la lista de sucesion: ");
	 num= s.nextInt();
	 lista4.add(num);
	 generarListaEnteros(num,lista4);
	 for(Integer i: lista4) {
		  System.out.print(i); // 1era forma de imprimir
	  }
	 for(int i=0;i< (lista4.size()) ;i++) {
		 System.out.print(lista4.get(i));// 2da forma de imprimir
	 }
	 
	 System.out.println(lista4);// 3er forma de imprimir
	 
	 int inicio= 0;
	 int fin= lista4.size() -1;
	 invertirArrayList(inicio,fin,lista4);
	 System.out.println(lista4);
	 LinkedList<Integer> lista5= new LinkedList<Integer>();
	 lista5.add(2);
	 lista5.add(3);
	 lista5.add(5);
	 lista5.add(10);
	 lista5.add(20);
	 int index=0;
	 System.out.println("El valor total de la linkedList es de: " + sumarLinkedList(lista5,index));
	 
	 ArrayList<Integer> lista6= new ArrayList<Integer>();
	 lista6.add(1);
	 lista6.add(4);
	 lista6.add(5);
	 lista6.add(9);
	 lista6.add(12);
	 
	 ArrayList<Integer> lista7= new ArrayList<Integer>();
	 lista7.add(2);
	 lista7.add(5);
	 lista7.add(8);
	 lista7.add(10);
	 lista7.add(16);
	 
	 ArrayList<Integer> lista8= new ArrayList<Integer>();
	 System.out.print(combinarListas(lista6,lista7));
  }
}
