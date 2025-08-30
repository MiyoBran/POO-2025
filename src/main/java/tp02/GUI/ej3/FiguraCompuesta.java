// FiguraCompuesta.java
package tp02.GUI.ej3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Color;

public class FiguraCompuesta extends Figura {

	private Figura[ ] componentes;
  private Color color;

  // Constructor que recibe un array de componentes
	public FiguraCompuesta (Figura[ ] componentes) {
		this.componentes = componentes;
	}

	public double area( ) {
		// TODO: hacer bien este m�todo
		// esta es una simplificaci�n que supone que no hay superposici�n entre componentes
		double superficie = 0;
		for (int i = 0; i < componentes.length; i++)
			superficie += componentes[i].area( );
		return superficie;
	}

	public double perimetro( ) {
		// TODO: hacer bien este m�todo
		// esta es una simplificaci�n que supone que no hay superposici�n entre componentes
		double perimetro = 0;
		for (int i = 0; i < componentes.length; i++)
			perimetro += componentes[i].perimetro( );
		return perimetro;
	}

  public void setColor(Color color) {
    for (Figura componente : componentes) {
      componente.setColor(color);
    }
  }

	public String tipo( ) {
		return "figura compuesta";
	}

	public void trasladar (double deltaX, double deltaY) {
		for (int i = 0; i < componentes.length; i++)
			componentes[i].trasladar (deltaX, deltaY);
	}

  @Override
  public void dibujar(Graphics g) {
    for (Figura componente : componentes) {
      componente.dibujar(g);
    }
  }
}
