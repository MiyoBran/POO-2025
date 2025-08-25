import java.util.*;
import carlosfontela.geometria.Figura;

public class ArrayListFiguras {

	private ArrayList implementacion = new ArrayList( );

	public void add (Figura e) {
		implementacion.add(e);
	}

	public Figura get (int i) {
		return (Figura)implementacion.get(i);
	}

	// todos los métodos adicionales necesarios

}
