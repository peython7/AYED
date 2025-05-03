package tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	private boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		int alt=0;
		if(!this.isEmpty()) {
			alt = altura(0,this);
		}
		return alt;
	}
	
	private int altura(int nivel, GeneralTree<T> a) {
		int max = 0;
		if(a.hasChildren()) {
			List<GeneralTree<T>> children = a.getChildren();
			for(GeneralTree<T> c:children) {
				max = Math.max(altura(nivel + 1,c),max);
			}
		}
		if(this.isLeaf()) {
			return nivel;
		}
		return Math.max(nivel, max);
	}
	
	public int nivel(T dato){
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		boolean ok= false;
		int nivel = 0;
		while(!cola.isEmpty() && !ok) {
			GeneralTree<T> aux= cola.dequeue();
			if(aux != null) {
				if(aux.getData()==dato) {
					ok= true;
				}
				else {
					List<GeneralTree<T>> children = aux.getChildren();
					for(GeneralTree<T> c:children) {
						cola.enqueue(c);
					}
				}
			}
			else {
				if(!cola.isEmpty()) {
					nivel++;
					cola.enqueue(null);
				}
			}
		}
		return nivel;
	}

	public int ancho(){
		int max= 0;
		Queue<GeneralTree<T>> cola= new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		int cant= 0;
		while(!cola.isEmpty()) {
			GeneralTree<T> aux = cola.dequeue();
			if(aux != null) {
				List<GeneralTree<T>> children= aux.getChildren();
				for(GeneralTree<T> c:children) {
					cola.enqueue(c);
					cant++;
				}
			}
			else {
				if(!cola.isEmpty()) {
					max = Math.max(max, cant);
					cant= 0;
					cola.enqueue(null);
				}
			}
		}
		return max;
	}
	public boolean esAncestro(T a,T b) {
		GeneralTree<T> ancestro = buscarNodo(a,this);
		boolean ok= true;
		GeneralTree<T> descendiente = new GeneralTree<T>();
		if(ancestro != null) {
			descendiente = buscarNodo(b,ancestro);
		}
		if(descendiente == null) {
			ok = false;
		}
		return ok;
	}
	
	private GeneralTree<T> buscarNodo(T a, GeneralTree<T> arbol){
		GeneralTree<T> aux= null;
		if(arbol.getData() == a) {
			return arbol;
		}
		else {
			boolean ok = false;
			Iterator<GeneralTree<T>> it = arbol.getChildren().iterator();
			while(it.hasNext() && !ok) {
				GeneralTree<T> c = it.next();
				aux = buscarNodo(a,c);
				if(aux != null && aux.getData()==a){
					ok=true;
				}
			}
		}
		return aux;
	}
}
