package carlosfontela.pruebas;

public class AuxiliaresCadenas {

	static boolean palindromo (String s) {
		if (s == "" || s == null)
			throw new IllegalArgumentException();
		boolean capicua = true;
		for (int ini = 0, fin = s.length() - 1; ini < fin && capicua; ini++, fin--)
			capicua = ( s.charAt(ini) == s.charAt(fin) );
		return (capicua);
	}
}
