package tp3.ej5.numerable;

public class FechaDC implements Numerable {

	private int dia;
	private int mes;
	private int anio;

	public FechaDC (int dia, int mes, int anio) {
		super();
		if ( !valida (dia, mes, anio) )
			throw new IllegalArgumentException ();
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	private static boolean bisiesto (int anio) {
		if ((anio % 4 == 0) &&
				((anio % 400 == 0) || (anio % 100 != 0)))
			return true;
		else return false;
	}

	private static int diasMes (int mes, int anio) {
		int [ ] dias = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (mes != 2) return dias[mes];
		if ( bisiesto (anio) )
			return 29;
		else return 28;
	}

	private static boolean valida (int dia, int mes, int anio) {
		if ( dia < 1 || dia > diasMes (mes, anio) )
			return false;
		if ( mes < 1 || mes > 12)
			return false;
		if ( anio < 1 || anio > 1000000 )
			return false;
		return true;
	}

	private static int diasAnio (int anio) {
		if ( bisiesto (anio) )
			return 366;
		else return 365;
	}

	public int toInt() {
		int sumaDias = 0;
		// sumo los d�as de todos los a�os anteriores:
		for (int a = 1; a < anio; a++)
			sumaDias += diasAnio (a);
		// sumo los d�as de todos los meses anteriores del mismo a�o:
		for (int m = 1; m < mes; m++)
			sumaDias += diasMes (m, anio);
		sumaDias += dia;
		return sumaDias;
	}

  // Muestra el contenido del objeto, y el numero que le corresponde.Ej: martes -> 2
  @Override
  public String mostrar() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.toString());
    sb.append(" -> ");
    sb.append(toInt());
    return sb.toString();
  }
  public String toString() {
    return dia + "/" + mes + "/" + anio;
  }

}
