// Figura.java
package tp02.GUI.ej3;

import java.awt.*;

public abstract class Figura {
	public abstract double area ( );
	public abstract double perimetro ( );
	public abstract String tipo( );
	public abstract void trasladar (double deltaX, double deltaY);
  /**
   * Una forma ecuable bidimensional, es aquella cuya área es
   * numéricamente igual a su perímetro
   *
   * @return true si el area de la figura es igual al perímetro
   */
  public boolean figuraEquable(){
    return (this.area() == this.perimetro());
  }

  // Metodos abstractos de la consigna del TP2.GUI.Ej3
  public abstract void dibujar( );
  public abstract void setColor(Color color);
}
