// Elipse.java

package carlosfontela.geometria;

public class Elipse implements Figura {

	private double radioMayor;
	private double radioMenor;
	private Punto centro;
	private double anguloRadioMayor;

	public Elipse (double radioMayor, double radioMenor, Punto centro,
									double anguloRadioMayor) {
		this.radioMayor = radioMayor;
		this.radioMenor = radioMenor;
		this.centro = centro;
		this.anguloRadioMayor = anguloRadioMayor;
	}

	public Elipse (double radioMayor, double radioMenor) {
		this.radioMayor = radioMayor;
		this.radioMenor = radioMenor;
		this.centro = new Punto(0,0);
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

	public double getArea ( ) {
			return Math.PI * radioMayor * radioMenor;
	}

	private static double E1 (double k) {
		// TODO: tabla de integral elíptica
		return 0;
	}

	public double getPerimetro ( ) {
		// caso del círculo:
		if (radioMayor == radioMenor)
			return (Math.PI * 2 * radioMayor);
		// caso general:
		double k = Math.sqrt (Math.pow (radioMayor, 2) -
			Math.pow (radioMenor, 2) ) / Math.pow (radioMayor, 2);
		return (4* radioMayor * E1(k));
	}

	public String getTipo ( ) {
		if (radioMayor == radioMenor)
			return "círculo";
		else return "elipse";
	}

	public void trasladar (double deltaX, double deltaY) {
		centro.trasladar (deltaX, deltaY);
	}

}
