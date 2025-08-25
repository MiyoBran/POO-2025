package carlosfontela.algebra;

public class Matriz {
	
	private int cantidadFilas;
	private int cantidadColumnas;
	private double [ ][ ] datos;
	
	public Matriz (int cantidadFilas, int cantidadColumnas) {
		if (cantidadFilas > 0 && cantidadColumnas > 0) {
			this.cantidadFilas = cantidadFilas;
			this.cantidadColumnas = cantidadColumnas;
			datos = new double [cantidadFilas][cantidadColumnas];
		}
		else throw new IndexOutOfBoundsException ( );
	}
		
	public double getElemento (int f, int c) {
			if (f >= 0 && c >= 0 && f < cantidadFilas && c < cantidadColumnas)
				return datos [f][c];
			else throw new IndexOutOfBoundsException ( );
	}
	
	public void setElemento (double valor, int f, int c) {
			if (f >= 0 && c >= 0 && f < cantidadFilas && c < cantidadColumnas)
				datos [f][c] = valor;
			else throw new IndexOutOfBoundsException ( );
	}
		
	public int getCantidadFilas ( ) {
			return cantidadFilas;
	}
	
	public int getCantidadColumnas ( ) {
			return cantidadColumnas;
	}

	// establece la igualdad entre números reales con una tolerancia
	private static boolean iguales (double x, double y) {
		if (Math.abs(x-y) < 1E-4)
			return true;
		else return false;
	}
	
	public boolean equals (Object otra) {
		if (otra instanceof Matriz) {
			Matriz otraMatriz = (Matriz)otra;
			if (this.cantidadColumnas == otraMatriz.cantidadColumnas &&
					this.cantidadFilas == otraMatriz.cantidadFilas) {
				for (int f = 0; f < cantidadFilas; f++)
					for (int c = 0; c < cantidadColumnas; c++)
						if ( !iguales (this.datos[f][c] , otraMatriz.datos[f][c]) )
							return false;
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	public Matriz producto (Matriz otra) {
		if ( this.cantidadColumnas == otra.cantidadFilas ) {
			Matriz resultado = new Matriz ( this.cantidadFilas, otra.cantidadColumnas );
			CalculoFila [ ] cFila = new CalculoFila [this.cantidadColumnas]; 
			for (int i = 0; i < this.cantidadFilas; i++) {
				cFila [i] = new CalculoFila (otra, resultado, i);
				cFila[i].start();
			}
			try {
				for (int i = 0; i < this.cantidadFilas; i++)
					cFila[i].join();
			} catch (InterruptedException e) {
				// no puede ocurrir
			}
			return resultado;
		}
		else throw new IllegalArgumentException( );
	}

	private void calculoElemento (Matriz otra, Matriz resultado, int i, int j) {
		resultado.datos [i][j] = 0;
		for (int k = 0; k < this.cantidadColumnas; k++)
			resultado.datos [i][j] += this.datos [i][k] * otra.datos [k][j];
	}
	
	// muchos más métodos ...

	private class CalculoFila extends Thread {
		private Matriz otra;
		private Matriz resultado;
		private int fila;
		private CalculoFila (Matriz otra, Matriz resultado, int fila) {
			this.otra = otra;
			this.resultado = resultado;
			this.fila = fila;
		}
		public void run ( ) {
			for (int j = 0; j < otra.cantidadColumnas; j++)
				calculoElemento(otra, resultado, fila, j);
		}
	}
	
}
