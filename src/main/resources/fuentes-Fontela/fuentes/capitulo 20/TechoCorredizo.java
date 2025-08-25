public class TechoCorredizo extends DecoradorOpcionales {
	private double costo = 1500.0;

	public TechoCorredizo (Auto comp) {
		super(comp);
	}

	public double costoTotal( ) {
		return getBasico( ).costoTotal( ) + costo;
	}

	public String descripcion( ) {
		return getBasico( ).descripcion( ) + " con techo corredizo";
	}
}

