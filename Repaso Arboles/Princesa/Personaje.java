package ParcialPrincesa;

public class Personaje {

	private String nombre;
	private String tipo;
	
	public Personaje(String t, String n) {
		this.nombre = n;
		this.tipo = t;
	}
	
	public void setTipo(String t) {
		this.tipo = t;
	}
	
	public void setNombre(String n) {
		this.tipo = n;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getTipo() {
		return this.tipo;
	}
}
