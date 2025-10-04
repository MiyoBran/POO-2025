package colectivo;

public class PasajeroComun extends Pasajero {
	private static double porcDescuentoPasajeroFrecuente= 25.0;
	private boolean pasajeroFrecuente;
	
	
    public PasajeroComun(int id, boolean esFrecuente) {
        super(id);
        this.pasajeroFrecuente = esFrecuente;
    }

    @Override
    public double calcularPasaje(double tarifaBase) {
        if (pasajeroFrecuente) {
            return tarifaBase * (1 - porcDescuentoPasajeroFrecuente / 100);
        }
        return tarifaBase;
    }

    @Override
    public String toString() {
        return (pasajeroFrecuente ? "PCF_" : "PC_") + super.getId();
    }
	

}
