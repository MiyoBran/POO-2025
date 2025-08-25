// Reflector.java
package carlosfontela.reflexion;

import java.lang.reflect.*;

public class Reflector {
	
	// clase interna:
	private class Atributo {
		public String visibilidad;
		public String nombre;
		public String tipo;
		public String deClase;
	}
	
	// clase interna:
	private class Metodo {
		public String abstracto;
		public String visibilidad;
		public String nombre;
		public String tipo;
		public String deClase;
		public String[ ] tipoParametro;
	}
	
	private Class clase;

	public Reflector (Class clase) {
		this.clase = clase;
	}

	public Reflector (String nombreClase) throws ClassNotFoundException {
		this.clase = Class.forName(nombreClase);
	}
	
	private String getNombre( ) {
		return clase.getName( );
	}
	
	private String esAbstracta( ) {
		int calificadores = clase.getModifiers( );
		boolean abstracta = Modifier.isAbstract(calificadores);
		if (abstracta)
			return "sí";
		else return "no";
	}
	
	private String getEstereotipo( ) {
		if (clase.isInterface( ))
			return "interfaz";
		else if (clase.isEnum( ))
			return "enumeración";
		else if (clase.isPrimitive( ))
			return "tipo primitivo";
		else if (clase.isAnnotation( ))
			return "anotación";
		else return "no";
	}

	private static boolean esConstante (Field atributoReflejado) {
		if ((atributoReflejado.toString( ).indexOf("final") > -1) ||
				(atributoReflejado.isEnumConstant( )))
			return true;
		else return false;
	}
	
	private static String esDeClase (int calificadores) {
		boolean deClase = Modifier.isStatic(calificadores);
		if (deClase)
			return "sí";
		else return "no";
	}
	
	private static String visibilidad (int calificadores) {
		if (Modifier.isPublic(calificadores))
			return "pública";
		else if (Modifier.isPrivate(calificadores))
			return "privada";
		else if (Modifier.isProtected(calificadores))
			return "protegida";
		else return "paquete";
	}
	
	private Atributo[ ] getAtributos( ) {
		Field[ ] atributosReflejados = clase.getDeclaredFields( );
		int cantidadAtributos = 0;
		for (int i = 0; i < atributosReflejados.length; i++)
			if (! esConstante (atributosReflejados[i]))
				cantidadAtributos++;
		Atributo[ ] atributos = new Atributo[cantidadAtributos];
		int pos = 0;
		for (int i = 0; i < atributosReflejados.length; i++)
			if (! esConstante (atributosReflejados[i])) {
				atributos[pos] = new Atributo( );
				atributos[pos].nombre = atributosReflejados[i].getName( );
				atributos[pos].tipo = atributosReflejados[i].getType( ).getSimpleName( );
				atributos[pos].visibilidad = visibilidad(atributosReflejados[i].getModifiers( ));
				atributos[pos].deClase = esDeClase(atributosReflejados[i].getModifiers( ));
				pos++;
			}
		return atributos;
	}
	
	private static String esAbstracto (Method metodoReflejado) {
		int calificadores = metodoReflejado.getModifiers( );
		boolean abstracto = Modifier.isAbstract(calificadores);
		if (abstracto)
			return "sí";
		else return "no";
	}
	
	private Metodo[ ] getMetodos( ) {
		Method[ ] metodosReflejados = clase.getDeclaredMethods( );
		Metodo[ ] metodos = new Metodo[metodosReflejados.length];
		for (int i = 0; i < metodos.length; i++) {
			metodos[i] = new Metodo( );
			metodos[i].nombre = metodosReflejados[i].getName( );
			metodos[i].tipo = metodosReflejados[i].getReturnType( ).getSimpleName( );
			metodos[i].abstracto = esAbstracto(metodosReflejados[i]);
			metodos[i].visibilidad = visibilidad(metodosReflejados[i].getModifiers( ));
			metodos[i].deClase = esDeClase(metodosReflejados[i].getModifiers( ));
			Class[ ] tiposParametrosReflejados = metodosReflejados[i].getParameterTypes( ); 
			metodos[i].tipoParametro = new String [tiposParametrosReflejados.length];
			for (int j = 0; j < tiposParametrosReflejados.length; j++)
				metodos[i].tipoParametro[j] = tiposParametrosReflejados[j].getSimpleName( );   
		}
		return metodos;
	}
	
	private String encabezadoClaseXML ( ) {
		return
			"<clase nombre = \"" + getNombre( ) +
			"\" abstracta = \"" + esAbstracta( ) +
			"\" estereotipo = \"" + getEstereotipo( ) +
			"\" >";
	}
	
	private String cierreClaseXML ( ) {
		return "</clase>";
	}
	
	private String atributosXML ( ) {
		String atributos = "<atributos>";
		for (int i= 0; i < getAtributos( ).length; i++)
			atributos += atributoXML(getAtributos( )[i]);
		atributos += "</atributos>";
		return atributos;
	}
	
	private static String atributoXML (Atributo atributo) {
		return
			"<atributo nombre = \""+ atributo.nombre +
			"\" tipo = \"" + atributo.tipo +
			"\" visibilidad = \"" + atributo.visibilidad +
			"\" de_clase = \"" + atributo.deClase +
			"\" />";
	}
	
	private String metodosXML ( ) {
		String metodos = "<metodos>";
		for (int i= 0; i < getMetodos( ).length; i++)
			metodos += metodoXML(getMetodos( )[i]);
		metodos += "</metodos>";
		return metodos;
	}
	
	private static String metodoXML (Metodo metodo) {
		String metodoS =
			"<metodo nombre = \"" + metodo.nombre +
			"\" tipo_devuelto = \"" + metodo.tipo +
			"\" abstracto = \"" + metodo.abstracto +
			"\" visibilidad = \"" + metodo.visibilidad +
			"\" de_clase = \"" + metodo.deClase + "\" >";
		for (int i = 0; i < metodo.tipoParametro.length; i++)
			metodoS += ("<parametro_tipo = \"" + metodo.tipoParametro[i] + "\" />"); 
		return metodoS + "</metodo>";
	}
	
	public String claseXML ( ) {
		return encabezadoClaseXML( ) +
			atributosXML( ) +
			metodosXML( ) +
			cierreClaseXML( );
	}
}
