// BaseConjunto.java
package carlosfontela.algebra;

public abstract class BaseConjunto implements Conjunto {
	
	public Conjunto union (Conjunto b) {
		int baseNuevo = Math.max (this.getBase( ), b.getBase( ));
		Conjunto c = new ConjuntoArreglo (baseNuevo);
		if (this.getBase( ) > b.getBase( )) {
			int x = 0;
			// recorremos ambos conjuntos hasta que termine el más corto (b)
			while (x < b.getBase( )) {
				if (this.pertenece(x) || b.pertenece(x)) 
					c.agregarElemento(x);
				x++;
			}
			// recorremos el más largo (a) hasta que termine
			while (x < this.getBase( )) {
				if (this.pertenece(x))
					c.agregarElemento(x);
				x++;
			}
		}
		else {	// el b es más largo que el a
			int x = 0;
			// recorremos ambos conjuntos hasta que termine el más corto (a)
			while (x < this.getBase( )) {
				if (this.pertenece(x) || b.pertenece(x))
					c.agregarElemento(x);
				x++;
			}
			// recorremos el más largo (b) hasta que termine
			while (x < b.getBase( )) {
				if (b.pertenece(x))
					c.agregarElemento(x);
				x++;
			}
		}
		return c;
	}

	public Conjunto interseccion (Conjunto b) {
		int baseNuevo = Math.max (this.getBase( ), b.getBase( ));
		Conjunto c = new ConjuntoArreglo (baseNuevo);
		int x = 0;
		// recorremos ambos conjuntos hasta que termine el más corto
		while (x < Math.min(this.getBase( ),b.getBase( ))) {
			if (this.pertenece(x) && b.pertenece(x)) 
				c.agregarElemento(x);
			x++;
		}
		return c;
	}

	public Conjunto diferencia (Conjunto b) {
		int baseNuevo = Math.max (this.getBase( ), b.getBase( ));
		Conjunto c = new ConjuntoArreglo (baseNuevo);
		if (this.getBase( ) > b.getBase( )) {
			int x = 0;
			// recorremos ambos conjuntos hasta que termine el más corto (b)
			while (x < b.getBase( )) {
				if (this.pertenece(x) && !b.pertenece(x)) 
					c.agregarElemento(x);
				x++;
			}
			// recorremos el más largo (a) hasta que termine
			while (x < this.getBase( )) {
				if (this.pertenece(x))
					c.agregarElemento(x);
				x++;
			}
		}
		else {	// el b es más largo que el a
			int x = 0;
			// recorremos ambos conjuntos hasta que termine el más corto (a)
			while (x < this.getBase( )) {
				if (this.pertenece(x) && !b.pertenece(x))
					c.agregarElemento(x);
				x++;
			}
			// recorremos el más largo (b) hasta que termine
			while (x < b.getBase( )) {
				if (b.pertenece(x))
					c.agregarElemento(x);
				x++;
			}
		}
		return c;
	}

	public boolean incluido (Conjunto b) {
		boolean incluido = true;
		for (int x = 0; x < this.getBase( ); x++)
			if (this.pertenece(x) && !b.pertenece(x))
				incluido = false;
		return incluido;
	}

	public boolean igual (Conjunto b) {
		boolean iguales = true;
		if (this.getBase( ) != b.getBase( ))
			iguales = false;
		else {
			for (int x = 0; x < this.getBase( ); x++)
				if (this.pertenece(x) != b.pertenece(x)) {
					iguales = false;
					break;
				}
		}
		return iguales;
	}
}
