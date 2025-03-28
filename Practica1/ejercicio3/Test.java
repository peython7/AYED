package tp1.ejercicio3;

public class Test {

	public static void main (String[] args) {
		Estudiante [] estudiantes= new Estudiante[2];
		Profesor [] profesores= new Profesor [3];
		
		Estudiante e1= new Estudiante("Pedro","Vega","pedrovega@gmail.com",'a',"511 3376");
		Estudiante e2= new Estudiante("Damian","Vega","damianvega@gmail.com",'b',"511 3376");
		
		Profesor p1= new Profesor("Juan","Ferreyra","ferre@gmail.com","Mate 2","124 2010");
		Profesor p2= new Profesor("Pamela","Gomez","pame@gmail.com","Mate 1","124 2010");
		Profesor p3= new Profesor("Marco","Gonzalez","marcogon@gmail.com","Ingles 2","124 2010");
		
		estudiantes[0]= e1;
		estudiantes[1]=e2;
		
		profesores[0]=p1;
		profesores[1]=p2;
		profesores[2]=p3;
		
		for(int i=0;i<2;i++) {
			System.out.println(estudiantes[i].tusDatos());
			System.out.print("\n");
		}
		
		for(int i=0;i<3;i++) {
			System.out.println(profesores[i].tusDatos());
			System.out.print("\n");
		}
	}
}
