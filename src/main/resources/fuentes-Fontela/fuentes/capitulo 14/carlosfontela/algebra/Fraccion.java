package carlosfontela.algebra;

public class Fraccion {

	private int numerador;
	private int denominador;

	public Fraccion (int numerador, int denominador) {
		if (denominador == 0)
			throw new IllegalArgumentException ();
		this.numerador = numerador;
		this.denominador = denominador;
	}

	public Fraccion sumar (Fraccion y) {
		int denominador = this.denominador * y.denominador;
		int numerador = denominador / this.denominador*this.numerador +
					denominador / y.denominador*y.numerador;
		return new Fraccion(numerador, denominador);
	}

	public Fraccion restar (Fraccion y) {
		int denominador = this.denominador * y.denominador;
		int numerador = denominador / this.denominador*this.numerador -
					denominador / y.denominador*y.numerador;
		return new Fraccion(numerador, denominador);
	}

	public Fraccion multiplicar (Fraccion y) {
		int numerador = this.numerador * y.numerador;
		int denominador = this.denominador * y.denominador;
		return new Fraccion(numerador, denominador);
	}

	public Fraccion dividir (Fraccion y) {
		if (y.numerador == 0)
			throw new ArithmeticException();
		int numerador = this.numerador * y.denominador;
		int denominador = this.denominador * y.numerador;
		return new Fraccion(numerador, denominador);
	}

	public double valorReal () {
		return (numerador/denominador);
	}

	public boolean igual (Fraccion x) {
		return (this.numerador*x.denominador == this.denominador*x.numerador);
	}

	public boolean menor (Fraccion x) {
		return (this.numerador*x.denominador < this.denominador*x.numerador);
	}

	public boolean mayor (Fraccion x) {
		return (this.numerador*x.denominador > this.denominador*x.numerador);
	}
}
