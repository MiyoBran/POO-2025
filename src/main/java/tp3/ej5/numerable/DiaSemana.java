package tp3.ej5.numerable;

public class DiaSemana implements Numerable {

	private String nombreDia;
	private int numeroDia;
	private String[ ] numerosNombres =
		{"", "lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};

	public DiaSemana (int numeroDia) {
		if (numeroDia > 0 && numeroDia < 8) {
			this.numeroDia = numeroDia;
			this.nombreDia = numerosNombres[numeroDia];
		}
		else throw new IllegalArgumentException ( );
	}

	public int toInt( ) {
		return numeroDia;
	}

  // Muestra el contenido del objeto, y el numero que le corresponde.Ej: martes -> 2
  @Override
  public String mostrar() {
    StringBuilder sb = new StringBuilder();
    sb.append(nombreDia);
    sb.append(" -> ");
    sb.append(numeroDia);
    return sb.toString();
  }

  public String toString( ) {
    return nombreDia;
  }
}
