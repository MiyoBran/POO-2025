// ComparadorVectoresPorModulo.java
package carlosfontela.fisica;

public class ComparadorVectoresPorModulo 
	implements java.util.Comparator {

	public int compare (Object o1, Object o2) {
		if (o1 instanceof Vector3D && o2 instanceof Vector3D &&
				o1 != null && o2 != null) {
			Vector3D vector1 = (Vector3D)o1; Vector3D vector2 = (Vector3D)o2;
			if (vector1.getModulo( ) < vector2.getModulo( ))
				return -1;
			else if (vector1.getModulo( ) > vector2.getModulo( ))
				return 1;
			else return 0;
		}
		else throw new IllegalArgumentException( );
	}
} 
