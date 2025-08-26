package tp02.GUI.ej2;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

/**
 * Clase abstracta que representa una figura delimitada en el plano, definida por un punto de inicio (x1, y1)
 * heredado de MiFigura, un ancho, un alto, un color y si es rellena o solo contorno.
 * <p>
 * Esta clase sirve como base para figuras que comparten las propiedades de ancho, alto y relleno,
 * como óvalos y rectángulos. Proporciona la funcionalidad común y deja el método de dibujo
 * como abstracto para que cada subclase lo implemente según su forma específica.
 * </p>
 */
public abstract class MiFiguraDelimitada extends MiFigura {
  // La clase "Padre" MiFigura tiene X1, Y1 y Color.
  // Esta clase agrega Ancho, Alto y Relleno.

  /** Ancho de la figura delimitada. */
  private int ancho;
  /** Alto de la figura delimitada. */
  private int alto;
  /** Indica si la figura es rellena (true) o solo contorno (false). */
  private boolean relleno;

  /**
   * Constructor sin argumentos.
   * <p>
   * Inicializa la figura delimitada en el origen (0,0), tamaño 0 y color negro, no rellena.
   * Utiliza el constructor por defecto de la superclase MiFigura.
   * </p>
   */
  public MiFiguraDelimitada() {
    super(); // Llama al constructor de MiFigura (X1=0, Y1=0, Color=BLACK)
    this.ancho = 0;
    this.alto = 0;
    this.relleno = false;
  }

  /**
   * Constructor que permite especificar las coordenadas, tamaño, color y si es rellena.
   * <p>
   * El punto inicial (x, y) y el color se pasan a la superclase MiFigura.
   * El ancho, alto y estado de relleno se establecen en esta clase.
   * </p>
   *
   * @param x coordenada X del punto inicial de la figura
   * @param y coordenada Y del punto inicial de la figura
   * @param ancho ancho de la figura delimitada
   * @param alto alto de la figura delimitada
   * @param color color de la figura delimitada
   * @param relleno true si es rellena, false si es solo contorno
   * @see MiFigura#MiFigura(int, int, Color)
   */
  public MiFiguraDelimitada(int x, int y, int ancho, int alto, Color color, boolean relleno) {
    super(x, y, color); // Llama al constructor de MiFigura
    this.ancho = ancho;
    this.alto = alto;
    this.relleno = relleno;
  }

  /**
   * Obtiene el ancho de la figura.
   *
   * @return ancho de la figura
   */
  public int getAncho() {
    return ancho;
  }

  /**
   * Establece el ancho de la figura.
   *
   * @param ancho nuevo ancho de la figura
   */
  public void setAncho(int ancho) {
    this.ancho = ancho;
  }

  /**
   * Obtiene el alto de la figura.
   *
   * @return alto de la figura
   */
  public int getAlto() {
    return alto;
  }

  /**
   * Establece el alto de la figura.
   *
   * @param alto nuevo alto de la figura
   */
  public void setAlto(int alto) {
    this.alto = alto;
  }

  /**
   * Verifica si la figura es rellena o solo contorno.
   *
   * @return true si es rellena, false si es solo contorno
   */
  public boolean isRelleno() {
    return relleno;
  }

  /**
   * Establece si la figura es rellena o solo contorno.
   *
   * @param relleno true para rellena, false para solo contorno
   */
  public void setRelleno(boolean relleno) {
    this.relleno = relleno;
  }

  /**
   * Calcula el hashCode en base a todos los campos heredados y propios.
   * <p>
   * Incluye los campos de MiFigura (x1, y1, color) mediante super.hashCode()
   * y los campos propios (ancho, alto, relleno).
   * </p>
   *
   * @return hashCode consistente con equals
   * @see MiFigura#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), ancho, alto, relleno);
  }

  /**
   * Compara igualdad por valor de todos los campos de MiFiguraDelimitada.
   * <p>
   * Verifica que el objeto sea del mismo tipo, que los campos heredados sean iguales
   * (mediante super.equals()) y que los campos propios (ancho, alto, relleno) coincidan.
   * </p>
   *
   * @param o objeto a comparar
   * @return true si es del mismo tipo y tiene los mismos valores en todos los campos
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MiFiguraDelimitada that)) return false;
    if (!super.equals(o)) return false;
    return ancho == that.ancho && alto == that.alto && relleno == that.relleno;
  }

  /**
   * Método abstracto para dibujar la figura en el contexto gráfico dado.
   * <p>
   * Cada subclase debe implementar este método según su forma específica
   * (óvalo, rectángulo, etc.), utilizando los campos heredados y propios.
   * </p>
   *
   * @param g contexto gráfico donde dibujar la figura
   */
  public abstract void dibujar(Graphics g);
}
