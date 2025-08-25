package carlosfontela.pruebas;

import carlosfontela.simulacion.Microondas;

public class PruebaMicroondas {

	// programa principal:
	public static void main (String [ ] p) {
		Microondas horno = new Microondas( );
		horno.setTiempoEnSeg(120);
		horno.setPotenciaEnWatt(700);
		System.out.println ("Andando: " + horno.estaAndando( ) );
		horno.inicioCoccion( );
		System.out.println ("Andando: " + horno.estaAndando( ) );
		System.out.println ("TiempoEnSeg de cocci�n: " + horno.verTiempoRestanteEnSeg( ) );
		System.out.println ("PotenciaEnWatt de cocci�n: " + horno.getPotenciaEnWatt());
		System.out.println ("TiempoEnSeg restante: " + horno.verTiempoRestanteEnSeg( ) );
		horno.detenerCoccion( );
		System.out.println ("Andando: " + horno.estaAndando( ) );
		System.out.println ("TiempoEnSeg restante: " + horno.verTiempoRestanteEnSeg( ) );
	}

}
