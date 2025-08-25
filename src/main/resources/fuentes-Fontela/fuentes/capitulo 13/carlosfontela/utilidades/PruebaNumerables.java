package carlosfontela.utilidades;

public class PruebaNumerables {

	public static void main(String [ ] p) {
		Numerable dm1 = new FechaDC (11, 12, 2009);
		Numerable dm2 = new FechaDC (24, 5, 2009);
		Numerable ds1 = new DiaSemana(2);
		Numerable ds2 = new DiaSemana(5);
		
		System.out.println (UtilidadesNumerables.mayor (dm1, ds1));
		System.out.println (UtilidadesNumerables.suma (dm1, ds1));
		
		Numerable[ ] v = new Numerable[4];
		v[0] = dm1;
		v[1] = dm2;
		v[2] = ds1;
		v[3] = ds2;
		UtilidadesNumerables.ordenar(v);
		
		System.out.println (v[0].ToInt( ));
		System.out.println (v[1].ToInt( ));
		System.out.println (v[2].ToInt( ));
		System.out.println (v[3].ToInt( ));
	}
}
