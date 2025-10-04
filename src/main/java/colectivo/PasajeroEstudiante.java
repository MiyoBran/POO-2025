package colectivo;

public class PasajeroEstudiante extends Pasajero {
	private static double porcDescuentoEstudiante = 50.0;
	
	public PasajeroEstudiante(int id) {
		super(id);
	}

	@Override
	public double calcularPasaje(double tarifa) {
		return tarifa * (1 - porcDescuentoEstudiante / 100);
	}
	
	public static void setPorcDescuentoEstudiante(double nuevoPorc) {
		porcDescuentoEstudiante = nuevoPorc;
	}
	public static double getPorcDescuentoEstudiante() {
	    return porcDescuentoEstudiante;
	}

    @Override
    public String toString() {
        return "EST_" + id;
    }

}
