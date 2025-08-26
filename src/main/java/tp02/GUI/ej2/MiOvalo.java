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
public class MiOvalo extends MiFiguraDelimitada {
  // La clase "Padre" MiFigura tiene X1, Y1 y Color.
  // La clase "Padre" MiFiguraDelimitada tiene Ancho, Alto y Relleno.

  /**
   * Constructor sin argumentos.
   * <p>
   * Inicializa el óvalo en el origen (0,0), tamaño 0 y color negro, no relleno.
   * Utiliza el constructor por defecto de la superclase MiFiguraDelimitada.
   * </p>
   */
  public MiOvalo() {
    super(); // Llama al constructor de MiFiguraDelimitada (X1=0, Y1=0, Color= black)
  }

  /**
   * Constructor que permite especificar las coordenadas, tamaño, color y si es relleno.
   * <p>
   * El punto inicial (x, y) y el color se pasan a la superclase MiFigura a través de MiFiguraDelimitada.
   * </p>
   *
   * @param x       coordenada X del punto inicial del óvalo
   * @param y       coordenada Y del punto inicial del óvalo
   * @param ancho   ancho del óvalo
   * @param alto    alto del óvalo
   * @param color   color del óvalo
   * @param relleno true si es relleno, false si es solo contorno
   * @see MiFigura#MiFigura(int, int, Color)
   */
  public MiOvalo(int x, int y, int ancho, int alto, Color color, boolean relleno) {
    super(x, y, ancho, alto, color, relleno); // Llama al constructor de MiFiguraDelimitada
  }

  /**
   * Dibuja el óvalo en el contexto gráfico dado.
   *
   * @param g contexto gráfico
   */
  @Override
  public void dibujar(Graphics g) {
    g.setColor(super.getColor());
    if (super.isRelleno()) {
      g.fillOval(super.getX1(), super.getY1(), super.getAncho(), super.getAlto());
    } else {
      g.drawOval(super.getX1(), super.getY1(), super.getAncho(), super.getAlto());
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MiOvalo)) return false;
    return super.equals(o);
  }

  @Override
  public String toString() {
    return "MiOvalo{" +
      "x=" + super.getX1() +
      ", y=" + super.getY1() +
      ", ancho=" + super.getAncho() +
      ", alto=" + super.getAlto() +
      ", color=" + super.getColor() +
      ", relleno=" + super.isRelleno() +
      '}';
  }

}
