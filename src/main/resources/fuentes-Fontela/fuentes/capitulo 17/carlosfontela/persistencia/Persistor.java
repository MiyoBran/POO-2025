// Persistor.java

package carlosfontela.persistencia;

import java.io.*;

public class Persistor {

	private String nombreArchivo;
	
	public Persistor (String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	public void guardar (Object objeto)
			throws IOException, FileNotFoundException {
		ObjectOutputStream salida =
			new ObjectOutputStream (new FileOutputStream (nombreArchivo));
		salida.writeObject (objeto);
		salida.close( );
	}

	public Object recuperar( )
			throws IOException, FileNotFoundException {
		ObjectInputStream entrada =
			new ObjectInputStream (new FileInputStream (nombreArchivo));
		Object objeto = null;
		try {
			objeto = entrada.readObject( );
		}
		catch (ClassNotFoundException e) { /* no puede ocurrir */}
		entrada.close( );
		return objeto;
	}
}
