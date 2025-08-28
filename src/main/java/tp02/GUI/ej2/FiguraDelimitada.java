package tp02.GUI.ej2;


import java.awt.Color;


public abstract class FiguraDelimitada extends Figura {
  // La clase "Padre" MiFigura tiene X1, Y1, X2, Y2 y Color.
  // Esta clase calcula Ancho, Alto y agrega Relleno.

  // se definen como variables independientes para no calcularlas cada vez
  private final int ancho;
  private final int alto;
  // Exclusiva de Figuras Delimitadas
  private boolean relleno;

  // Por defecto el relleno es false
  public FiguraDelimitada() {
    super(); // Llama al constructor de MiFigura (X1=0, Y1=0, Color=BLACK)
    this.ancho = getX2() - getX1();
    this.alto = getY2() - getY1();
    this.relleno = false;
  }

  public FiguraDelimitada(int x1, int y1, int x2, int y2, Color color, boolean relleno) {
    super(x1, y1, x2, y2, color); // Llama al constructor de MiFigura
    this.ancho = getX2() - getX1();
    this.alto = getY2() - getY1();
    this.relleno = relleno;
  }

  // Getters.
  public int getAncho() {
    return ancho;
  }
  public int getAlto() {
    return alto;
  }
  public boolean isRelleno() {
    return relleno;
  }

  // Solo se puede setear el relleno.
  public void setRelleno(boolean relleno) {
    this.relleno = relleno;
  }

}
