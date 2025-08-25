package carlosfontela.pruebas;

import junit.framework.TestCase;
import carlosfontela.cuentas.*;

public class PruebaClonacionCuentasClientes extends TestCase {
	
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

		juan2 = (Cliente)juan.clone( );
		ines2 = (Cliente)ines.clone( );
		lunaNueva2 = (Cliente)lunaNueva.clone( );

		cajaAhorroJuan2 = (CuentaBancaria)cajaAhorroJuan.clone( );
		cajaAhorroInes2 = (CuentaBancaria)cajaAhorroInes.clone( );
		cuentaCorrienteInes2 = (CuentaBancaria)cuentaCorrienteInes.clone( );
		cuentaCorrienteLunaNueva2 = (CuentaBancaria)cuentaCorrienteLunaNueva.clone( );
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
		assertFalse (juan == juan2);
		assertTrue (equals (juan, juan2));
		assertFalse (juan.getDireccion( ) == juan2.getDireccion( ));
		assertTrue (juan.getDireccion( ).equals(juan2.getDireccion( )));
		assertFalse (juan.getCuentas( ) == juan2.getCuentas( ));
		for (int i = 0; i < juan.getCantidadCuentas( ); i++) {
			assertTrue (juan.getCuentas( )[i] == juan2.getCuentas( )[i]);
			assertTrue (equals (juan.getCuentas( )[i], juan2.getCuentas( )[i]));
		}
	}
	
	public void testInes( ) {
		assertFalse (ines == ines2);
		assertTrue (equals (ines, ines2));
		assertFalse (ines.getDireccion( ) == ines2.getDireccion( ));
		assertTrue (ines.getDireccion( ).equals(ines2.getDireccion( )));
		assertFalse (ines.getCuentas( ) == ines2.getCuentas( ));
		for (int i = 0; i < ines.getCantidadCuentas( ); i++) {
			assertTrue (ines.getCuentas( )[i] == ines2.getCuentas( )[i]);
			assertTrue (equals (ines.getCuentas( )[i], ines2.getCuentas( )[i]));
		}
	}
	
	public void testLunaNueva( ) {
		assertFalse (lunaNueva == lunaNueva2);
		assertTrue (equals (lunaNueva, lunaNueva2));
		assertFalse (lunaNueva.getDireccion( ) == lunaNueva2.getDireccion( ));
		assertTrue (lunaNueva.getDireccion( ).equals(lunaNueva2.getDireccion( )));
		assertFalse (lunaNueva.getCuentas( ) == lunaNueva2.getCuentas( ));
		for (int i = 0; i < lunaNueva.getCantidadCuentas( ); i++) {
			assertTrue (lunaNueva.getCuentas( )[i] == lunaNueva2.getCuentas( )[i]);
			assertTrue (equals (lunaNueva.getCuentas( )[i], lunaNueva2.getCuentas( )[i]));
		}
	}

	public void testCajaAhorroJuan( ) {
		assertFalse (cajaAhorroJuan == cajaAhorroJuan2);
		assertTrue (equals (cajaAhorroJuan, cajaAhorroJuan2));
		assertTrue (cajaAhorroJuan.getTitular( ) == cajaAhorroJuan2.getTitular( ));
	}

	public void testCajaAhorroInes( ) {
		assertFalse (cajaAhorroInes == cajaAhorroInes2);
		assertTrue (equals (cajaAhorroInes, cajaAhorroInes2));
		assertTrue (cajaAhorroInes.getTitular( ) == cajaAhorroInes2.getTitular( ));
	}

	public void testCuentaCorrienteInes( ) {
		assertFalse (cuentaCorrienteInes == cuentaCorrienteInes2);
		assertTrue (equals (cuentaCorrienteInes, cuentaCorrienteInes2));
		assertTrue (cuentaCorrienteInes.getTitular( ) == cuentaCorrienteInes2.getTitular( ));
	}

	public void testCuentaCorrienteLunaNueva( ) {
		assertFalse (cuentaCorrienteLunaNueva == cuentaCorrienteLunaNueva2);
		assertTrue (equals (cuentaCorrienteLunaNueva, cuentaCorrienteLunaNueva2));
		assertTrue (
			cuentaCorrienteLunaNueva.getTitular( ) == cuentaCorrienteLunaNueva2.getTitular( ));
	}

}
