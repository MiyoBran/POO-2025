package carlosfontela.pruebas;

import carlosfontela.inmobiliarias.*;

public class PruebaInmobiliarias {

	public static void main (String[ ] p) {

		// creación de objetos de prueba
		Cliente ana = new Cliente ("Ana", "02944523698", "ana@suempresa.com.ar");
		Cliente joaquin = new Cliente ("Joaquín", "02234797152", "joaquin@mdp.com.ar");
		Cliente clara = new Cliente ("Clara", "01145642315", "clara@fi.uba.ar");
		Inmueble membrillar = new Terreno("Membrillar 255", 85.3, 4, 82000, true);
		Inmueble boyaca = new Casa ("Boyacá 1244", 144.3, 5, 124300, true, true, false, 253);
		Inmueble artigas = new Departamento ("Artigas 1366", 95.2, 3, 93700, false, true);
		Inmueble neuquen = new Departamento ("Neuquén 3455", 129.4, 5, 128400, true, true);
		Inmobiliaria sucasa = new Inmobiliaria ("Su casa");
		Inmobiliaria flores = new Inmobiliaria ("Flores");

		// impresión básica
		boyaca.imprimirDatos( );
		artigas.imprimirDatos( );
		membrillar.imprimirDatos( );
		System.out.println( );

		// carga de inmobiliarias
		sucasa.agregarInmueble(membrillar);
		sucasa.agregarInmueble(neuquen);
		flores.agregarInmueble(boyaca);
		flores.agregarInmueble(artigas);

		// carga de interesados
		membrillar.anotarInteresado(ana);
		artigas.anotarInteresado(ana);
		boyaca.anotarInteresado(joaquin);
		neuquen.anotarInteresado(joaquin);
		boyaca.anotarInteresado(clara);

		// impresión inmuebles e interesados
		sucasa.imprimirDatos( );
		flores.imprimirDatos( );

		// movimientos
		artigas.setPrecio(92500);
		artigas.reservar( );
		artigas.vender( );
		neuquen.eliminarInteresado(joaquin);
		neuquen.eliminarInteresado(ana);

		// impresión inmuebles e interesados
		sucasa.imprimirDatos( );
		flores.imprimirDatos( );
	}
}
