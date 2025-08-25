// PruebaPersistenciaCuentasClientes.java

package carlosfontela.persistencia;

import junit.framework.TestCase;
import carlosfontela.cuentas.*;

public class PruebaPersistenciaCuentasClientes extends TestCase {
	
	private CuentaBancaria cajaAhorroJuan;
	private CuentaBancaria cuentaCorrienteInes;
	private CuentaBancaria cajaAhorroInes;
	private CuentaBancaria cuentaCorrienteLunaNueva;
	private Cliente juan;
	private Cliente ines;
	private Cliente lunaNueva;

	private Cliente juan2;
	private Cliente ines2;
	private Cliente lunaNueva2;

	private CuentaBancaria cajaAhorroJuan2;
	private CuentaBancaria cajaAhorroInes2;
	private CuentaBancaria cuentaCorrienteInes2;
	private CuentaBancaria cuentaCorrienteLunaNueva2;

	private Persistor pcc1 = new Persistor ("CC1.dat");
	private Persistor pcc2 = new Persistor ("CC2.dat");
	private Persistor pca1 = new Persistor ("CA1.dat");
	private Persistor pca2 = new Persistor ("CA2.dat");
	private Persistor pJuan = new Persistor ("Juan.dat");
	private Persistor pInes = new Persistor ("Ines.dat");
	private Persistor pLunaNueva = new Persistor ("LunaNueva.dat");

	protected void setUp( ) throws Exception {
		super.setUp( );
		juan = new Persona ("Juan", "Pérez", 5122122, "Lima", 444, "Belgrano", "Venezuela",
 							"C1000AAA", "01140101010", "juan@perez.com.ar");
		ines = new Persona ("Inés", "García", 4011011, "Cerrito", 1111, "Santa Fe", "Arenales",
 							"C1111ZZZ", "01140001111", "ines@garcia.com.ar");
		lunaNueva = new Empresa ("Luna Nueva S.A.", "1701234562", "Freire", 8888, "Dorrego",
 			"Concepción Arenal", "C0000YYY", "01199991000", "info@lunanueva.com.ar");

		cajaAhorroJuan = new CajaAhorro (1234, juan);
		cajaAhorroInes = new CajaAhorro (5678, ines);
		cuentaCorrienteInes = new CuentaCorriente (9012, ines, 0);
		cuentaCorrienteLunaNueva = new CuentaCorriente (3456, lunaNueva, 2000);

		pJuan.guardar (juan);
		pInes.guardar (ines);
		pLunaNueva.guardar (lunaNueva);

		pca1.guardar (cajaAhorroJuan);
		pca2.guardar (cajaAhorroInes);
		pcc1.guardar (cuentaCorrienteInes);
		pcc2.guardar (cuentaCorrienteLunaNueva);

		juan2 = (Cliente)pJuan.recuperar( );
		ines2 = (Cliente)pInes.recuperar( );
		lunaNueva2 = (Cliente)pLunaNueva.recuperar( );

		cajaAhorroJuan2 = (CuentaBancaria)pca1.recuperar( );
		cajaAhorroInes2 = (CuentaBancaria)pca2.recuperar( );
		cuentaCorrienteInes2 = (CuentaBancaria)pcc1.recuperar( );
		cuentaCorrienteLunaNueva2 = (CuentaBancaria)pcc2.recuperar( );
	}

	private boolean equals (Cliente c1, Cliente c2) {
		boolean equalsCliente = 
			c1.getEmail( ).equals(c2.getEmail( )) &&
			c1.getCantidadCuentas( ) == c2.getCantidadCuentas( ) &&
			c1.getDireccion( ).equals(c2.getDireccion( ));
		if (c1 instanceof Persona) {
			Persona p1 = (Persona)c1; Persona p2 = (Persona)c2;  
			return (
				equalsCliente &&
				p1.getNombre( ).equals(p2.getNombre( )) &&
				p1.getApellido( ).equals(p2.getApellido( )) &&
				p1.getDni( ) == p2.getDni( )
			);
		}
		else {
			Empresa e1 = (Empresa)c1; Empresa e2 = (Empresa)c2;
			return (
					equalsCliente &&
					e1.getRazonSocial( ).equals(e2.getRazonSocial( )) &&
					e1.getCuit( ).equals(e2.getCuit( ))
				);
		}
	}

	private boolean equals (CuentaBancaria c1, CuentaBancaria c2) {
		boolean equalsCuenta = 
			c1.getNumero( ) == c2.getNumero( ) &&
			c1.getSaldo( ) == c2.getSaldo( );
		if (c1 instanceof CuentaCorriente) {
			CuentaCorriente cc1 = (CuentaCorriente)c1;
			CuentaCorriente cc2 = (CuentaCorriente)c2;  
			return (
				equalsCuenta &&
				cc1.getDescubierto( ) == cc2.getDescubierto( )
			);
		}
		else {
			CajaAhorro ca1 = (CajaAhorro)c1;
			CajaAhorro ca2 = (CajaAhorro)c2;
			return (
					equalsCuenta &&
					ca1.getInteresesGanados( ) == ca2.getInteresesGanados( )
				);
		}
	}
	
	public void testJuan( ) {
		assertTrue (equals (juan, juan2));
		for (int i = 0; i < juan.getCantidadCuentas( ); i++)
			assertTrue (equals (juan.getCuentas( )[i], juan2.getCuentas( )[i]));
	}
	
	public void testInes( ) {
		assertTrue (equals (ines, ines2));
		for (int i = 0; i < ines.getCantidadCuentas( ); i++)
			assertTrue (equals (ines.getCuentas( )[i], ines2.getCuentas( )[i]));
		// Inés es el mismo cliente en su caja de ahorro y su cuenta corriente:
		assertTrue (
			cajaAhorroInes.getTitular( ) == cuentaCorrienteInes.getTitular( ));
		// pero esto no se ve después de hidratar:
		assertFalse (
			cajaAhorroInes2.getTitular( ) == cuentaCorrienteInes2.getTitular( ));
	}
	
	public void testLunaNueva( ) {
		assertTrue (equals (lunaNueva, lunaNueva2));
		assertFalse (lunaNueva.getDireccion( ) == lunaNueva2.getDireccion( ));
		assertTrue (lunaNueva.getDireccion( ).equals(lunaNueva2.getDireccion( )));
		for (int i = 0; i < lunaNueva.getCantidadCuentas( ); i++)
			assertTrue (
				equals (lunaNueva.getCuentas( )[i], lunaNueva2.getCuentas( )[i]));
	}

	public void testCajaAhorroJuan( ) {
		assertTrue (equals (cajaAhorroJuan, cajaAhorroJuan2));
		assertTrue (
			equals (cajaAhorroJuan.getTitular( ), cajaAhorroJuan2.getTitular( )));
	}

	public void testCajaAhorroInes( ) {
		assertTrue (equals (cajaAhorroInes, cajaAhorroInes2));
		assertTrue (
			equals (cajaAhorroInes.getTitular( ), cajaAhorroInes2.getTitular( )));
	}

	public void testCuentaCorrienteInes( ) {
		assertTrue (equals (cuentaCorrienteInes, cuentaCorrienteInes2));
		assertTrue (
			equals (cuentaCorrienteInes.getTitular( ), cuentaCorrienteInes2.getTitular( )));
	}

	public void testCuentaCorrienteLunaNueva( ) {
		assertTrue (equals (cuentaCorrienteLunaNueva, cuentaCorrienteLunaNueva2));
		assertTrue (equals (
			cuentaCorrienteLunaNueva.getTitular( ), cuentaCorrienteLunaNueva2.getTitular( )));
	}
}
