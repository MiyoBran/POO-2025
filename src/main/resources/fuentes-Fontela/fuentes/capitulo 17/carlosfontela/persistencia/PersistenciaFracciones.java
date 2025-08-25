package carlosfontela.persistencia;

import java.io.*;
import carlosfontela.algebra.Fraccion;

public class PersistenciaFracciones {

	public static void guardarFraccion (String nombreArchivo, Fraccion fraccion)
			throws IOException, FileNotFoundException {
		ObjectOutputStream salida =
			new ObjectOutputStream (new FileOutputStream (nombreArchivo));
		salida.writeObject (fraccion);
	}

	public static Fraccion recuperarFraccion (String nombreArchivo)
			throws IOException, FileNotFoundException {
		ObjectInputStream entrada =
			new ObjectInputStream (new FileInputStream (nombreArchivo));
		Fraccion f = null;
		try {
			f = (Fraccion)entrada.readObject( );
		}
		catch (ClassNotFoundException e) { /* no puede ocurrir */}
		return f;
	}
}
