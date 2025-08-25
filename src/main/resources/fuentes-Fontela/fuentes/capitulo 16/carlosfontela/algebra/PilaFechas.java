package carlosfontela.algebra;

import java.util.Date;

public class PilaFechas {

	private int tope;
	private Date[ ] elementos;

	public PilaFechas (int tamanioMaximo) {
		this.elementos = new Date[tamanioMaximo];
		this.tope = -1;
	}

	public boolean vacia ( ) {
		return (this.tope == -1);
	}
	
	private boolean completa( ) {
		return (tope == elementos.length-1);
	}
	
	public void agregar (Date nuevoElemento) {
		if (completa( ))
			throw new UnsupportedOperationException( );
		tope++;
		elementos[tope] = nuevoElemento;
	}

	public Date extraer ( ) {
		if (vacia( ))
			throw new java.util.NoSuchElementException( );
		Date resultado = elementos[tope];
		elementos[tope] = null;
		tope--;
		return resultado;
	}
}
