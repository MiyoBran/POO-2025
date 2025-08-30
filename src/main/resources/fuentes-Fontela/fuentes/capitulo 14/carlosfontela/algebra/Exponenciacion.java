package carlosfontela.algebra;

public class Exponenciacion {

	public static double potencia (double x, double exponente) {
		try {
			return (potenciaReal (x, exponente));
		}
		catch (ArithmeticException e) {
			if (Math.abs(exponente - Math.floor(exponente)) < 1.0e-008)
				// el exponente es entero:
				return potenciaEntera(x,(int)Math.round(exponente));
			else throw new ArithmeticException("Resultado complejo");
		}
	}

	private static double potenciaReal (double x, double exponente) {
		double temp = Math.log(x);
		if ( Double.isNaN(temp) || Double.isInfinite(temp) )
			// base 0 o negativa:
			throw new ArithmeticException( );
		return Math.exp(exponente*temp);
	}

	public static double potenciaEntera (double x, int exponente) {
		if ((x < 1.0e-008) && (exponente == 0))
			throw new ArithmeticException("Se está intentando elevar 0 a la 0");
		double pot = 1.0;
		for (int i = 1; i <= Math.abs(exponente); i++)
			pot *= x;
		if (exponente < 0)
			return 1/pot;
		else return pot;
	}
}

