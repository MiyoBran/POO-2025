package carlosfontela.pruebas;

import carlosfontela.inmobiliarias.*;

public class PruebaInmobiliarias {

	public static void main (String[ ] p) {

		// creación de objetos de prueba
		Inmueble membrillar = new Terreno ("Membrillar 255", 85.3, 4, 82000, true);
		Inmueble boyaca = new Casa ("Boyacá 1244", 144.3, 5, 124300, true, true, false, 253);
		Inmueble artigas = new Departamento ("Artigas 1366", 95.2, 3, 93700, false, true);
		Inmueble neuquen = new Departamento ("Neuquén 3455", 129.4, 5, 128400, true, true);
		Inmobiliaria flores = new Inmobiliaria ("Flores", 3, 1.5);

		// carga de inmobiliarias
		flores.agregarInmueble(membrillar);
		flores.agregarInmueble(neuquen);
		flores.agregarInmueble(boyaca);
		flores.agregarInmueble(artigas);

		// impresión inmuebles (nótese el uso de objetos Command):
		flores.imprimirDatos (new ComparadorPrecio( ));
		flores.imprimirDatos (new ComparadorSuperficie( ));
		flores.imprimirDatos (new ComparadorAlfabetico( ));
	}
}
