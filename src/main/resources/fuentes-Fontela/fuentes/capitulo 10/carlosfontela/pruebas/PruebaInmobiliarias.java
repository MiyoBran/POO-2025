package carlosfontela.pruebas;

import carlosfontela.inmobiliarias.*;

public class PruebaInmobiliarias {

	public static void main (String [ ] p) {

		// creación de objetos de prueba
		carlosfontela.inmobiliarias.Cliente ana = new carlosfontela.inmobiliarias.Cliente ("Ana", "02944523698", "ana@suempresa.com.ar");
		carlosfontela.inmobiliarias.Cliente joaquin = new carlosfontela.inmobiliarias.Cliente ("Joaquín", "02234797152", "joaquin@mdp.com.ar");
		carlosfontela.inmobiliarias.Cliente clara = new carlosfontela.inmobiliarias.Cliente ("Clara", "01145642315", "clara@fi.uba.ar");
		Inmueble membrillar = new Inmueble ("Membrillar 255", 85.3, 4, 82000);
		Inmueble boyaca = new Inmueble ("Boyacá 1244", 144.3, 5, 124300);
		Inmueble artigas = new Inmueble ("Artigas 1366", 95.2, 3, 93700);
		Inmueble neuquen = new Inmueble ("Neuquén 3455", 129.4 ,5 , 128400);
		Inmobiliaria sucasa = new Inmobiliaria ("Su casa");
		Inmobiliaria flores = new Inmobiliaria ("Flores");

		// impresión básica
		boyaca.imprimirDatos( );
		System.out.println( );

		// carga de inmobiliarias
		sucasa.agregarInmueble (membrillar);
		sucasa.agregarInmueble (neuquen);
		flores.agregarInmueble (boyaca);
		flores.agregarInmueble (artigas);

		// carga de interesados
		membrillar.anotarInteresado (ana);
		artigas.anotarInteresado (ana);
		boyaca.anotarInteresado (joaquin);
		neuquen.anotarInteresado (joaquin);
		boyaca.anotarInteresado (clara);

		// impresión inmuebles e interesados
		sucasa.imprimirDatos( );
		flores.imprimirDatos( );

		// movimientos
		artigas.setPrecio (92500);
		artigas.reservar( );
		artigas.vender( );
		neuquen.eliminarInteresado (joaquin);
		neuquen.eliminarInteresado (ana);

		// impresión inmuebles e interesados
		sucasa.imprimirDatos( );
		flores.imprimirDatos( );
	}
}
