package Fecha2De2024;

public class ParcialArboles {
	
	BinaryTree<Integer> arbol;
	
	public BinaryTree<Integer> nuevoTree(){
		BinaryTree<Integer> nuevo = new BinaryTree<Integer>();
		if(arbol != null && !arbol.isEmpty()) {
			crearNuevoArbol(arbol,nuevo,0);
		}
		return nuevo;
	}
	
	private void crearNuevoArbol(BinaryTree<Integer> a, BinaryTree<Integer> nue, int padre) {
		int suma = a.getData() + padre;
		nue.setData(suma);
		if(a.hasLeftChild()) {
			BinaryTree<Integer> izq = new BinaryTree<Integer>();
			nue.addLeftChild(izq);
			crearNuevoArbol(a.getLeftChild(),nue.getLeftChild(),a.getData());
		}
		if(a.hasRightChild()) {
			BinaryTree<Integer> der = new BinaryTree<Integer>();
			nue.addRightChild(der);
			crearNuevoArbol(a.getRightChild(),nue.getRigthChild(),0);
		}
	}
}
