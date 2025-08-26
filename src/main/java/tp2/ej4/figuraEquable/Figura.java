// Figura.java
package tp2.ej4.figuraEquable;

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

}
