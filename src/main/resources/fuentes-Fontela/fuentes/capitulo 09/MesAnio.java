public class MesAnio {

		private int mes;
		private int anio;

		// otros métodos y constructores…

		private boolean anioMultiploDe (int n) {
			return (anio % n == 0);
		}

		private boolean bisiesto( ) {
			if (anioMultiploDe(400))
				return true;
			else if (anioMultiploDe(4) && !anioMultiploDe(100))
				return true;
			else return false;
		}

		public int diasMes ( ) {
			int diasMes[ ] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
			int dias = diasMes[mes];
			if ((mes == 28) && bisiesto( ))
				dias = 29;
			return dias;
		}

}
