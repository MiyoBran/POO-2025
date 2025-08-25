// FiguraCompuesta.java
package carlosfontela.geometria;

public class FiguraCompuesta extends Figura {

	private Figura[ ] componentes;
	
	public FiguraCompuesta (Figura[ ] componentes) {
		this.componentes = componentes;
	}

	public double area( ) {
		// TODO: hacer bien este método
		// esta es una simplificación que supone que no hay superposición entre componentes
		double superficie = 0;
		for (int i = 0; i < componentes.length; i++)
			superficie += componentes[i].area( );
		return superficie;
	}

	public double perimetro( ) {
		// TODO: hacer bien este método
		// esta es una simplificación que supone que no hay superposición entre componentes
		double perimetro = 0;
		for (int i = 0; i < componentes.length; i++)
			perimetro += componentes[i].perimetro( );
		return perimetro;
	}

	public String tipo( ) {
		return "figura compuesta";
	}

	public void trasladar (double deltaX, double deltaY) {
		for (int i = 0; i < componentes.length; i++)
			componentes[i].trasladar (deltaX, deltaY);
	}
}
