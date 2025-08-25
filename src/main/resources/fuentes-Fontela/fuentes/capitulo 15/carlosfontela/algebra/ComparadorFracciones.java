package carlosfontela.algebra;

public class ComparadorFracciones implements java.util.Comparator {

	public int compare (Object o1, Object o2) {
		Fraccion f1 = (Fraccion)o1; Fraccion f2 = (Fraccion)o2;
		if ( f1.getNumerador( ) * f2.getDenominador( ) > f1.getDenominador( ) * f2.getNumerador( ) )
			return 1;
		else if ( f1.getNumerador( ) * f2.getDenominador( ) <
						f1.getDenominador( ) * f2.getNumerador( ) )
			return -1;
		else return 0;
	}
}
