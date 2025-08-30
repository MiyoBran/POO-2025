package carlosfontela.pruebas;

import carlosfontela.algebra.Matriz;
import org.junit.*;
import org.junit.Assert;

public class PruebaProductoMatrices {

	Matriz A = new Matriz (2, 2);
	Matriz B = new Matriz (2, 2);
	
	@Before
	public void inicializacion ( ){
		A.setElemento(1, 0, 0);
		A.setElemento(2, 0, 1);
		A.setElemento(3, 1, 0);
		A.setElemento(4, 1, 1);
		B.setElemento(5, 0, 0);
		B.setElemento(6, 0, 1);
		B.setElemento(7, 1, 0);
		B.setElemento(8, 1, 1);
	}

	@Test
	public void pruebaProducto ( ) {
		Matriz Resultado = A.producto(B);
		Matriz Esperada = new Matriz (2, 2);
		Esperada.setElemento (19, 0, 0);
		Esperada.setElemento (22, 0, 1);
		Esperada.setElemento (43, 1, 0);
		Esperada.setElemento (50, 1, 1);
		Assert.assertEquals (Esperada, Resultado);
	}
}
