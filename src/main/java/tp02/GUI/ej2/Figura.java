package tp02.GUI.ej2;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {
  // Atributos comunes a todas las figuras.
  private final int x1;
  private final int y1;
  private final int x2; // en FiguraDelimitada se usa para definir el ancho
  private final int y2; // en FiguraDelimitada se usa para definir el// alto
  private Color color;

  // Constructor por defecto. Un punto en (0,0)
  public Figura(){
    this.x1 = 0;
    this.y1 = 0;
    this.x2 = 0;
    this.y2 = 0;
    this.color = Color.BLACK;
  }

  public Figura(int x1, int y1,  int x2, int y2, Color color){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.color = color;
  }

  // Getters y Setters.
  public void setColor(Color color) {
    this.color = color;
  }

  public int getX1() {
    return x1;
  }
  public int getY1() {
    return y1;
  }
  public int getX2() { return x2; }
  public int getY2() { return y2; }
  public Color getColor() {
    return color;
  }

  // Se llamara desde el metodo paintComponent del programa principal.
  public abstract void dibujar(Graphics g);
}
