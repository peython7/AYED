package Colapinto;

import java.util.List;

public class Estrategia {
	private GeneralTree<Compuesto> arbol;
	
	public List<Compuesto> mejorEstrategia(GeneralTree<Compuesto> a){
		List<Compuesto> mejor= new List<Compuesto>();
		if(a.isEmpty()) {
			return mejor;
		}
		mejorEstrategia2(a,mejor,true);
		return mejor;
	}
	 
	private double mejorEstrategia2(GeneralTree<Compuesto> a, List<Compuesto> l,boolean soyRaiz){
		List<Compuesto> temporal= new List<Compuesto>();
		List<GeneralTree<Compuesto>> children = a.getChildren();
		double baseScore = (a.getVueltas * a.getCompuesto);
		double bestScore = -9999;
		double scoreArista = 0;
		if(!soyRaiz) {
			scoreArista+=10;
		}
		if(a.hasChildren()) {
			for(GeneralTree<Compuesto> c: children) {
				double score = mejorEstrategia2(c,temporal,false);
				if(score > bestScore) {
					bestScore = score;
					l.clear();
					l.add(a.getData());
					l.addAll(temporal);
				}
			}
			return bestScore + scoreArista + baseScore;
		}
		else {
			temporal.add(a.getData());
			return baseScore + scoreArista;
		}
	}
}
