package tp1.ejercicio3;

public class Profesor extends Persona{
	private String facultad;
	private String catedra;
	
	public Profesor(String n, String a, String e, String f, String c) {
		super(n, a, e);
		this.facultad = f;
		this.catedra = c;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public String getCatedra() {
		return catedra;
	}

	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	
	public String tusDatos() {
		String aux= super.toString();
		aux+= " Pertenezco a la facultad de " + this.getFacultad() + " y mi catedra es " + this.getCatedra();
		return aux;
	}
	
}
