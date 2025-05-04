package tp3.ejercicio6;

import tp3.ejercicio1.*;
import java.util.*;

public class RedDeAguaPotable {
	private GeneralTree<Character> red;
	
	public RedDeAguaPotable(GeneralTree<Character> r) {
		this.red=r;
	}
	
	public double minimoCaudal(double caudal) {
		double min=9999;
		if(this.red != null) {
			min = minimoCaudal(caudal,this.red);
		}
		return min;
	}
	
	private double minimoCaudal(double c, GeneralTree<Character> r) {
		double min;
		if(r.isLeaf()) {
			return c;
		}
		else {
			min = 9999;
			List<GeneralTree<Character>> children = r.getChildren();
			for(GeneralTree<Character> ch:children) {
				double aux = c/children.size();
				min= Math.min(minimoCaudal(aux,ch),min);
			}
		}
		return min;
	}
}
