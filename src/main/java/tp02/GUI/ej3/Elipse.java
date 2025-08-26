// Elipse.java
package tp02.GUI.ej3;

import java.awt.Color;
import java.awt.Graphics;

public class Elipse extends Figura {

  private double radioMayor;
  private double radioMenor;
  private Punto centro;
  private double anguloRadioMayor;
  // atributos agregados por la consigna
  private boolean relleno;
  private Color color;

  // Constructor completo
  public Elipse(double radioMayor, double radioMenor, Punto centro, double anguloRadioMayor, boolean relleno, Color color) {
    this.radioMayor = radioMayor;
    this.radioMenor = radioMenor;
    this.centro = centro;
    this.anguloRadioMayor = anguloRadioMayor;
    this.relleno = relleno;
    this.color = color;
  }

  public Elipse(double radioMayor, double radioMenor) {
    this.radioMayor = radioMayor;
    this.radioMenor = radioMenor;
    this.centro = new Punto(0, 0);
    this.anguloRadioMayor = 0;
    // valores por defecto para relleno y color segun la consigna
    this.relleno = false;
    this.color = Color.BLACK;
  }

  public double getRadioMayor() {
    return radioMayor;
  }

  public double getRadioMenor() {
    return radioMenor;
  }

  public Punto getCentro() {
    return centro;
  }

  public double getAnguloRadioMayor() {
    return anguloRadioMayor;
  }

  // Setters para Relleno y Color como pide la consigna
  public void setRelleno(boolean relleno) {
    this.relleno = relleno;
  }

  // Metodo Abstracto de la consigna para cambiar el color.
  @Override
  public void setColor(Color color) {
    this.color = color;
  }

  /// Metodos
  public double area() {
    return Math.PI * getRadioMayor() * getRadioMenor();
  }

  private static double E1(double k) {
    // TODO: tabla de integral eliptica
    return 0;
  }

  public double perimetro() {
    // caso del c�rculo:
    if (getRadioMayor() == getRadioMenor())
      return (Math.PI * 2 * getRadioMayor());
    // caso general:
    double k = Math.sqrt(Math.pow(getRadioMayor(), 2) -
      Math.pow(getRadioMenor(), 2)) / Math.pow(getRadioMayor(), 2);
    return (4 * getRadioMayor() * E1(k));
  }

  public String tipo() {
    if (getRadioMayor() == getRadioMenor())
      return "circulo";
    else return "elipse";
  }

  public void trasladar(double deltaX, double deltaY) {
    centro.trasladar(deltaX, deltaY);
  }

  // Dibuja la figura en el contexto de dibujo dado.
  @Override
  public void dibujar(Graphics g) {
    g.setColor(color);
    int x = (int) (centro.getX() - radioMayor);
    int y = (int) (centro.getY() - radioMenor);
    int width = (int) (2 * radioMayor);
    int height = (int) (2 * radioMenor);
    if (relleno) {
      g.fillOval(x, y, width, height);
    } else {
      g.drawOval(x, y, width, height);
    }
  }


}
