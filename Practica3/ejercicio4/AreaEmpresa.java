package tp3.ejercicio4;

public class AreaEmpresa {
	private int tardanza;
	private String ident;
	
	public AreaEmpresa(int t, String i) {
		this.setIdent(i);
		this.setTardanza(t);
	}
	
	public int getTardanza() {
		return this.tardanza;
	}
	
	public void setTardanza(int t) {
		this.tardanza = t;
	}
	
	public String getIdent() {
		return this.ident;
	}
	
	public void setIdent(String i) {
		this.ident = i;
	}
}
