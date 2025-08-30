// Figura.java

package carlosfontela.geometria;

public interface Figura {
	double getArea();
	double getPerimetro();
	String getTipo();
	void trasladar (double deltaX, double deltaY);
}
