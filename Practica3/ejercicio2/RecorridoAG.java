package tp3.ejercicio2;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.*;
import tp1.ejercicio8.*;

public class RecorridoAG {

	public List<Integer> numerosImparesMayoresQuePreorden(GeneralTree<Integer> a, int n){
		List<Integer> lista= new LinkedList<Integer>();
		if(a.getData() > n && a.getData()%2 !=0) {
			lista.add(a.getData());
		}
		List<GeneralTree<Integer>> children = a.getChildren();
		for(GeneralTree<Integer> c:children) {
			lista.addAll(numerosImparesMayoresQuePreorden(c,n));
		}
		return lista;
	}
	
	public List<Integer> numerosImparesMayoresQueInorden(GeneralTree<Integer> a, int n){
		List<Integer> lista= new LinkedList<Integer>();
		if(!a.isEmpty()) {
			Inorden(lista,a,n);
			return lista;
		}
		else {
			return null;
		}
	}
	
	private void Inorden(List<Integer> lista, GeneralTree<Integer> a, int n) {
		if(!a.isLeaf()) {
			List<GeneralTree<Integer>> children= a.getChildren();
			Inorden(lista,children.get(0),n);
			int num= a.getData();
			if(num > n && num%2!=0) {
				lista.add(num);
			}
			for(int i=1; i<children.size();i++) {
				Inorden(lista,children.get(i),n);
			}
		}
		else {
			if(a.getData() > n && a.getData()%2!=0) {
				lista.add(a.getData());
			}
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePostorden(GeneralTree<Integer> a, int n){
		List<Integer> lista= new LinkedList<Integer>();
		if(!a.isEmpty()) {
			Postorden(lista,a,n);
		}
		return lista;
	}
	
	private void Postorden(List<Integer> l,GeneralTree<Integer> a, int n) {
		if(!a.isLeaf()) {
			List<GeneralTree<Integer>> children= a.getChildren();
			Postorden(l,children.get(0),n);
			for(int i=1;i < children.size();i++) {
				Postorden(l,children.get(i),n);
			}
			if(a.getData() > n && a.getData()%2 != 0) {
				l.add(a.getData());
			}
		}
		else {
			if(a.getData() > n && a.getData()%2 != 0) {
				l.add(a.getData());
			}
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, int n){
		Queue<GeneralTree<Integer>> cola= new Queue<GeneralTree<Integer>>();
		List<Integer> lista= new LinkedList<Integer>();
		cola.enqueue(a);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			GeneralTree<Integer> elemento= cola.dequeue();
			if(elemento != null) {
				if(elemento.getData()%2 != 0 && elemento.getData() > n) {
					lista.add(elemento.getData());
				}
				List<GeneralTree<Integer>> children= elemento.getChildren();
				for(GeneralTree<Integer> c:children) {
					cola.enqueue(c);
				}
			}
			else {
				if(!cola.isEmpty()) {
					cola.enqueue(null);
				}
			}
		}
		return lista;
	}
	
}
