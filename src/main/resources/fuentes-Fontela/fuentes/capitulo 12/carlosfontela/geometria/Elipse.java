// Elipse.java
package carlosfontela.geometria;

public class Elipse extends Figura {

	private double radioMayor;
	private double radioMenor;
	private Punto centro;
	private double anguloRadioMayor;

	public Elipse (double radioMayor, double radioMenor, Punto centro, double anguloRadioMayor) {
		this.radioMayor = radioMayor;
		this.radioMenor = radioMenor;
		this.centro = centro;
		this.anguloRadioMayor = anguloRadioMayor;
	}

	public Elipse (double radioMayor, double radioMenor) {
		this.radioMayor = radioMayor;
		this.radioMenor = radioMenor;
		this.centro = new Punto(0, 0);
		this.anguloRadioMayor = 0;
	}

	public double getRadioMayor ( ) {
		return radioMayor;
	}

	public double getRadioMenor ( ) {
		return radioMenor;
	}

	public Punto getCentro ( ) {
		return centro;
	}

	public double getAnguloRadioMayor ( ) {
		return anguloRadioMayor;
	}

	public double area ( ) {
		return Math.PI * getRadioMayor( ) * getRadioMenor( );
	}

	private static double E1 (double k) {
		// TODO: tabla de integral elíptica
		return 0;
	}

	public double perimetro ( ) {
		// caso del círculo:
		if (getRadioMayor( ) == getRadioMenor( ))
			return (Math.PI * 2 * getRadioMayor( ));
		// caso general:
		double k = Math.sqrt (Math.pow(getRadioMayor( ), 2) -
				Math.pow (getRadioMenor( ), 2) ) / Math.pow (getRadioMayor( ), 2);
		return (4* getRadioMayor( ) * E1(k));
	}
	
	public String tipo( ) {
		if (getRadioMayor( ) == getRadioMenor( ))
			return "círculo";
		else return "elipse";
	}

	public void trasladar (double deltaX, double deltaY) {
		centro.trasladar (deltaX, deltaY);
	}
	
}
