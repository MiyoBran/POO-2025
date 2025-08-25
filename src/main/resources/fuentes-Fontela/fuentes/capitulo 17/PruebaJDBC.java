import java.sql.*;	// para usar SQL-92 estándar

public class PruebaJDBC {

	// no vamos a capturar las excepciones: declaramos que podemos lanzarlas
	public static void main (String parametros[ ])
					throws SQLException, ClassNotFoundException {

		// con el subprotocolo ODBC, usar la base de datos "alumnos":
		String url = "jdbc:odbc:alumnos";
		String usuario = "carlos";
		String clave = "d4r2T3s7";

		// cargar el driver de ODBC provisto por Sun:
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		// establecer la conexión:
		Connection c = DriverManager.getConnection(url,usuario,clave);

		// crear la consulta utilizando la conexión:
		Statement s = c.createStatement( );

		// consulta SQL:
		ResultSet r = s.executeQuery("SELECT NOMBRE, APELLIDO FROM alumnos " +
 					"WHERE TELEFONO Is Not Null ORDER BY APELLIDO");

		// iteramos para encontrar los resultados de la consulta:
		// r es un iterador que devuelve false si se terminaron los resultados:
		while (r.next( ))
			System.out.println(r.getString("APELLIDO")+", "+r.getString("NOMBRE"));

		// cerramos la consulta y el iterador:
		s.close( );
	}
}

