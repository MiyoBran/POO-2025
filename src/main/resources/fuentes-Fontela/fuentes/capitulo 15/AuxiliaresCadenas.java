import java.util.StringTokenizer;

public class AuxiliaresCadenas {

	public static void separarPalabrasImprimir (String s) {
		StringTokenizer palabras = new StringTokenizer(s);
		while (palabras.hasMoreTokens( ))
			System.out.println(palabras.nextToken( ));
	}

}
