package carlosfontela.inmobiliarias;

public class InmuebleNull extends Inmueble {

	private InmuebleNull ( ) {
		super ("", 0, 0, 0);
	}

	private static InmuebleNull instancia = new InmuebleNull( );
		
	public static InmuebleNull getInstancia ( ) {
		return instancia;
	}

	public int getPrecio ( ) {
		return 0;
	}

	public boolean getReservado ( ) {
		return false;
	}

	public boolean getVendido ( ) {
		return false;
	}

	public void imprimirDatos ( ) { }
	
	public double comisionVendedor ( ) {
		return 0;
	}

	public double beneficioParcial (double comisionesCobradas) {
		return 0;
	}
}
