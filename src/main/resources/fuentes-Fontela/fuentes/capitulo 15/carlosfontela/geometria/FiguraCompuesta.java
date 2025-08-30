// FiguraCompuesta.java

package carlosfontela.geometria;

import java.util.*;

public class FiguraCompuesta implements Figura {

	private List componentes;
	
	public FiguraCompuesta (Figura[ ] componentes) {
		this.componentes = new ArrayList(componentes.length);
		for (Figura f : componentes)
			this.componentes.add (f);
	}

	public double getArea ( ) {
		// TODO: hacer bien este método
		// esta es una simplificación
		// supone que no hay superposición entre componentes
		double superficie = 0;
		Iterator i = componentes.iterator();
		while ( i.hasNext() ) {
			Figura componente = (Figura)i.next();
			superficie += componente.getArea();
		}
		return superficie;
	}

	public double getPerimetro ( ) {
		// TODO: hacer bien este método
		// esta es una simplificación
			// supone que no hay superposición entre componentes
		double perimetro = 0;
		Iterator i = componentes.iterator();
		while ( i.hasNext() ) {
			Figura componente = (Figura)i.next();
			perimetro += componente.getPerimetro();
		}
		return perimetro;
	}

	public String getTipo ( ) {
			return "figura compuesta";
	}

	public void trasladar (double deltaX, double deltaY) {
		Iterator i = componentes.iterator();
		while ( i.hasNext() ) {
			Figura componente = (Figura)i.next();
			componente.trasladar (deltaX, deltaY);
		}
	}

	public void Agregar (Figura f) {
		componentes.add(f);
	}

	public void Eliminar (Figura f) {
		componentes.remove(f);
	}

}
