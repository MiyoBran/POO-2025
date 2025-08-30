package carlosfontela.utilidades;

public class DiaSemana implements Numerable {
	
	private String nombreDia;
	private int numeroDia;
	private String[ ] numerosNombres =
		{"", "lunes", "martes", "mi�rcoles", "jueves", "viernes", "s�bado", "domingo"};
	
	public DiaSemana (int numeroDia) {
		if (numeroDia > 0 && numeroDia < 8) {
			this.numeroDia = numeroDia;
			this.nombreDia = numerosNombres[numeroDia];
		}
		else throw new IllegalArgumentException ( );
	}
	
	public int ToInt( ) {
		return numeroDia;
	}
}
