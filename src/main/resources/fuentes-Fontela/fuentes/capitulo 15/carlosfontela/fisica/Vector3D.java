// Vector3D.java
package carlosfontela.fisica;

public class Vector3D {

	private double proyeccionX;
	private double proyeccionY;
	private double proyeccionZ;

	// crea un Vector3D en base a sus tres componentes
	public Vector3D (double proyeccionX, double proyeccionY, double proyeccionZ) {
		this.proyeccionX = proyeccionX;
		this.proyeccionY = proyeccionY;
		this.proyeccionZ = proyeccionZ;
	}
	
	// crea un Vector3D en base a su módulo y su versor:
	public Vector3D (double modulo, Vector3D versor) {
		this.proyeccionX = modulo * versor.getProyeccionX( );
		this.proyeccionY = modulo * versor.getProyeccionY( );
		this.proyeccionZ = modulo * versor.getProyeccionZ( );
	}

	public boolean equals (Object otro) {
		if (otro instanceof Vector3D && this != null && otro != null) {
			Vector3D vOtro = (Vector3D)otro;
			return (
					proyeccionX == vOtro.proyeccionX &&
					proyeccionY == vOtro.proyeccionY &&
					proyeccionZ == vOtro.proyeccionZ
			);
		}
		else return false;
	}
	
	public double getProyeccionX( ) {
		return proyeccionX;
	}
	
	public double getProyeccionY( ) {
		return proyeccionY;
	}
	
	public double getProyeccionZ( ) {
		return proyeccionZ;
	}
	
	public double getModulo( ) {
			return Math.sqrt (
				getProyeccionX( ) * getProyeccionX( ) +
				getProyeccionY( ) * getProyeccionY( ) +
				getProyeccionZ( ) * getProyeccionZ( ) );
	}

	public Vector3D getVersor( ) {
			return this.productoPorEscalar((1/getModulo( )));
	}

	// ángulo con el eje "x" en radianes:
	public double getAnguloX( ) {
			return Math.acos (getProyeccionX( ) / getModulo( ));
	}

	// ángulo con el eje "y" en radianes:
	public double getAnguloY( ) {
			return Math.acos (getProyeccionY( ) / getModulo( ));
	}

	// ángulo con el eje "z" en radianes:
	public double getAnguloZ( ) {
			return Math.acos (getProyeccionZ( ) / getModulo( ));
	}
	
	// producto escalar:
	public double productoEscalar (Vector3D w) {
		return (
			this.getProyeccionX( ) * w.getProyeccionX( ) +
			this.getProyeccionY( ) * w.getProyeccionY( ) +
			this.getProyeccionZ( ) * w.getProyeccionZ( ) );
	}

	// producto vectorial:
	public Vector3D productoVectorial (Vector3D w) {
		return new Vector3D (
			this.getProyeccionY( ) * w.getProyeccionZ( ) -
 				this.getProyeccionZ( ) * w.getProyeccionY( ) ,
			this.getProyeccionZ( ) * w.getProyeccionX( ) -
 				this.getProyeccionX( ) * w.getProyeccionZ( ) ,
			this.getProyeccionX( ) * w.getProyeccionY( ) -
 				this.getProyeccionY( ) * w.getProyeccionX( ) );
	}
	
	// producto por un escalar:
	public Vector3D productoPorEscalar (double factor) {
		return new Vector3D (
				factor * this.getProyeccionX( ),
				factor * this.getProyeccionY( ),
				factor * this.getProyeccionZ( ) );
	}
	
	// suma de vectores:
	public Vector3D suma (Vector3D w) {
		return new Vector3D (
				this.getProyeccionX( ) + w.getProyeccionX( ) ,
				this.getProyeccionY( ) + w.getProyeccionY( ) ,
				this.getProyeccionZ( ) + w.getProyeccionZ( ) );
	}

	public String toString( ) {
		return "(" +
			Double.toString (getProyeccionX( )) + "; " +
			Double.toString (getProyeccionY( )) + "; " +
			Double.toString (getProyeccionZ( )) + ")";
	}
}

