package carlosfontela.simulacion;

import java.util.Date;

public class Microondas {

	private int tiempoEnSeg;
	private int potenciaEnWatt;
	private boolean andando;
	private long horaInicio;	// en tics desde 1/1/1

	public Microondas( ) {
		tiempoEnSeg = 0;
		potenciaEnWatt = 0;
		andando = false;
		horaInicio = 0;
	}

	public int getTiempoEnSeg () {
			return tiempoEnSeg;
	}

	public void setTiempoEnSeg (int valor) {
			tiempoEnSeg = valor;
		}

	public int getPotenciaEnWatt () {
			return potenciaEnWatt;
	}

	public void setPotenciaEnWatt (int valor) {
			potenciaEnWatt = valor;
	}

	// aumenta la potenciaEnWatt en 100 W:
	public void incrementarPotencia( ) {
		potenciaEnWatt += 100;
	}

	// disminuye la potenciaEnWatt en 100 W:
	public void decrementarPotencia( ) {
		potenciaEnWatt -= 100;
	}

	// aumenta el tiempoEnSeg en 30 s
	public void incrementarTiempo( ) {
		tiempoEnSeg += 30;
	}

	// disminuye el tiempoEnSeg en 30 s
	public void decrementarTiempo( ) {
		tiempoEnSeg -= 30;
	}

	public void inicioCoccion( ) {
		andando = true;
		horaInicio = new Date().getTime();			// tiempo en tics desde 1/1/1
	}

	// en segundos:
	public int verTiempoRestanteEnSeg( ) {
		if (!andando)
				return 0;
		else {
			long horaActual = new Date().getTime();		// tiempo en tics desde 1/1/1
			long falta = horaActual - horaInicio + tiempoEnSeg;
			if (falta > 0) {
				// conversión de tics en segundos:
				long s = falta / 10000000000L;
				return (int)s;			// conversión de tipos de long a int
			}
			else {
				andando = false;
				return 0;
			}
		}
	}

	public void detenerCoccion( ) {
		andando = false;
	}

	public boolean estaAndando( ) {
		int aux = verTiempoRestanteEnSeg( );
		return andando;
	}

}
