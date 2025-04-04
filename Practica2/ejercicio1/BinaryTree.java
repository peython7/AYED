package tp2.ejercicio1;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;
	
	public BinaryTree(T d){
		this.data= d;
		this.leftChild=null;
		this.rightChild=null;
	}
	
	public boolean hasLeftChild() {
		if(this.leftChild != null) {
			return true;
		}
		return false;
	}
	
	public BinaryTree<T> getLeftChild(){
		if(this.hasLeftChild()) {
			return this.leftChild;
		}
		throw new IllegalStateException("No tiene hijo izquierdo.");
	}
	
	public boolean hasRightChild() {
		if(this.rightChild != null) {
			return true;
		}
		return false;
	}
	
	public BinaryTree<T> getRightChild(){
		if(this.hasRightChild()) {
			return this.rightChild;
		}
		throw new IllegalStateException("No tiene hijo derecho.");
	}
	
	public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }
	
	public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
	}
	
	public void removeLeftChild() {
	        this.leftChild = null;
	}

	public void removeRightChild() {
	        this.rightChild = null;
	}
	 
	public boolean isEmpty() {
		return data == null && this.leftChild == null && this.rightChild == null;
	}

	public boolean isLeaf() {
		return this.leftChild == null && this.rightChild == null;
	}
}
