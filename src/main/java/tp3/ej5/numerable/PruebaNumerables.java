package tp3.ej5.numerable;

public class PruebaNumerables {

	public static void main(String [ ] p) {
		Numerable dm1 = new FechaDC (11, 12, 2009); // imprime 733752
		Numerable dm2 = new FechaDC (24, 5, 2009); // imprime 733551
		Numerable ds1 = new DiaSemana(2);
		Numerable ds2 = new DiaSemana(5);

		System.out.println (UtilidadesNumerables.mayor (dm1, ds1)); // dm1 es mayor que ds1
		System.out.println (UtilidadesNumerables.suma (dm1, ds1)); // esperado 733754

		Numerable[ ] v = new Numerable[4];
		v[0] = dm1;
		v[1] = dm2;
		v[2] = ds1;
		v[3] = ds2;
		UtilidadesNumerables.ordenar(v);

    System.out.println("Vector ordenado:");
    // imprimimos ordenado
		System.out.println (v[0].toInt( ));
		System.out.println (v[1].toInt( ));
		System.out.println (v[2].toInt( ));
		System.out.println (v[3].toInt( ));
	}
}
