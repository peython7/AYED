package tp1.ejercicio8;

public class CircularQueue<T> extends Queue<T>{
	
	 public T shift() {
	        if (isEmpty()) {
	            System.out.print("La cola está vacía");
	            return null;
	        }
	        T firstElement = dequeue();
	        enqueue(firstElement);
	        return firstElement;
	 }
}
