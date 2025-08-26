package tp02.GUI.ej2;

import java.awt.*;
import java.util.Objects;

public abstract class MiFigura {
  /** Coordenada X del punto inicial. */
  private int x1;
  /** Coordenada Y del punto inicial. */
  private int y1;
  /** Color de la figura. */
  protected Color color;

  public MiFigura(){
    this.x1 = 0;
    this.y1 = 0;
    this.color = Color.BLACK;
  }

  public MiFigura(int x1, int y1, Color color){
    this.x1 = x1;
    this.y1 = y1;
    this.color = color;
  }

  // Getters y Setters.
  public int getX1() {
    return x1;
  }
  public void setX1(int x1) {
    this.x1 = x1;
  }
  public int getY1() {
    return y1;
  }
  public void setY1(int y1) {
    this.y1 = y1;
  }
  public Color getColor() {
    return color;
  }
  public void setColor(Color color) {
    this.color = color;
  }

  /**
   * Compara igualdad por valor de x1, y1 y color.
   * @param o objeto a comparar
   * @return true si es del mismo tipo y tiene los mismos valores en x1, y1 y color
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MiFigura miFigura = (MiFigura) o;
    return x1 == miFigura.x1 &&
           y1 == miFigura.y1 &&
           Objects.equals(color, miFigura.color);
  }

  // Se llamara desde el metodo paintComponent del programa principal.
  public abstract void dibujar(Graphics g);
}
