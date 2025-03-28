package tp1.ejercicio3;

public class Estudiante extends Persona{
	private char comision;
	private String direccion;
	
	public Estudiante(String n, String a, String e, char c, String d) {
		super(n, a, e);
		this.comision = c;
		this.direccion = d;
	}

	public char getComision() {
		return comision;
	}

	public void setComision(char comision) {
		this.comision = comision;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String tusDatos() {
		String aux= super.toString();
		aux+= " Pertenezco a la comision " + this.getComision() + " y vivo en " + this.getDireccion();
		return aux;
	}
	
	
}
