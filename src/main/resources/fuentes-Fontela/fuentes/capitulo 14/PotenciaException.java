public class PotenciaException extends RuntimeException {

	private double base;
	private double exponente;

	// constructor vacío:
	public PotenciaException( ) { }

	// constructor con un parámetro:
	public PotenciaException (String mensaje) {
		super (mensaje);
	}

	// constructor con tres parámetros:
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
