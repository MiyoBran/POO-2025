package carlosfontela.pruebas;

import carlosfontela.fisica.Vector3D;
import junit.framework.*;

public class PruebaVector3D extends TestCase {

	private Vector3D a;
	private Vector3D b;
	
	protected void setUp () {
		a = new Vector3D (1, 1, 0);
		b = new Vector3D (1, 2, 0);
	}
	
	public void testToString ( ) {
		assertEquals ("(1.0; 1.0; 0.0)", a.toString( ));
		assertEquals ("(1.0; 2.0; 0.0)", b.toString( ));
	}
	
	public void testModulo ( ) {
		assertEquals (Math.sqrt(2), a.getModulo(), 1E-5);
	}

	public void testProductoEscalar ( ) {
		assertEquals (3.0, a.productoEscalar(b), 1E-5);
	}

	public void testProductoVectorial ( ) {
		assertEquals ( "(0.0; 0.0; 1.0)", a.productoVectorial(b).toString( ) );
	}

	public void testProductoPorEscalar ( ) {
		assertEquals ( "(2.0; 2.0; 0.0)", a.productoPorEscalar(2).toString( ) );
	}
	
	public void testAngulos ( ) {
		assertEquals (Math.PI/4, a.getAnguloX(), 1E-5);
		assertEquals (Math.PI/4, a.getAnguloY(), 1E-5);
		assertEquals (Math.PI/2, a.getAnguloZ(), 1E-5);
	}

	public void testSuma ( ) {
		assertEquals ( "(2.0; 3.0; 0.0)", a.suma(b).toString( ));
	}

}
