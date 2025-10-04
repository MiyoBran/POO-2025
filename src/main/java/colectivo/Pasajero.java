package colectivo;

public abstract class Pasajero {
    protected final int id;

    public Pasajero(int id) {
        this.id = id;
    }

    public abstract double calcularPasaje(double tarifaBase);
    
    public int getId() {
        return id;
    }

    @Override
    public abstract String toString();
    
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Pasajero otro = (Pasajero) obj;
	    return id == otro.id;
	}

}
