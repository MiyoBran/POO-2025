public class PotenciaException extends RuntimeException {

	private double base;
	private double exponente;

	// constructor vac�o:
	public PotenciaException( ) { }

	// constructor con un par�metro:
	public PotenciaException (String mensaje) {
		super (mensaje);
	}

	// constructor con tres par�metros:
	public PotenciaException (String mensaje, double base, double exponente) {
		super (mensaje);
		this.base = base;
		this.exponente = exponente;
	}

	public double getBase ( ) {
			return base;
	}

	public double getExponente ( ) {
			return exponente;
	}
}
