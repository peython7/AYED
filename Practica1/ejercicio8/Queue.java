package tp1.ejercicio8;

import java.util.*; 

public class Queue<T> {
	private LinkedList<T> elements;
	
    public Queue() {
        this.elements = new LinkedList<>();
    }
    
    public void enqueue(T dato) {
        this.elements.addLast(dato);
    }
    
    public void enqueueFirst(T dato) {
        this.elements.addFirst(dato);
    }
    
    public T dequeue() {
        if (this.elements.isEmpty()) {
            System.out.print("La cola está vacía");
            return null;
        }
        return this.elements.removeFirst();
    }
    
    public T head() {
        if (isEmpty()) {
            System.out.print("La cola está vacía");
            return null;
        }
        return this.elements.getFirst();
    }
    
    public boolean isEmpty() {
    	return this.elements.isEmpty();
    }
    
    public int size() {
        return elements.size();
    }
    
    @Override
    public String toString() {
        return this.elements.toString();
    }
}
