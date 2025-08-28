package tp02.GUI.ej2;

import java.awt.Color;
import java.awt.Graphics;


/**
 * Clase que representa un óvalo en el plano, definido por un punto de inicio (x1, y1)
 * heredado de MiFigura, un ancho, un alto y un color. Permite especificar si es relleno o solo contorno.
 * <p>
 * Permite crear óvalos con valores por defecto (en el origen, tamaño 0 y color negro) o
 * con valores personalizados para las coordenadas, tamaño y color.
 * </p>
 */
public class Ovalo extends FiguraDelimitada {
  // La clase "Padre" MiFigura tiene X1, Y1 ,X2 ,Y2 y Color.
  // La clase "Padre" MiFiguraDelimitada tiene Ancho, Alto (calculados) y Relleno.

  // Llama al constructor de MiFiguraDelimitada
  public Ovalo() {
    super();
  }

  public Ovalo(int x1, int y1, int x2, int y2, Color color, boolean relleno) {
    super(x1, y1, x2, y2, color, relleno); // Llama al constructor de MiFiguraDelimitada
  }


  @Override
  public void dibujar(Graphics g) {
    g.setColor(super.getColor());
    g.drawOval(super.getX1(), super.getY1(), super.getAncho(), super.getAlto());
    if (super.isRelleno()) {
      g.fillOval(super.getX1(), super.getY1(), super.getAncho(), super.getAlto());
    }
  }

}
