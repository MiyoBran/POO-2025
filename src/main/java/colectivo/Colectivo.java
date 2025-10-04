package colectivo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Colectivo {
	// Atributos
	private int id;
	private Linea linea;
	private int capacidadPasajeros;
	// Lista para almacenar los pasajeros actuales en el colectivo
	private List<Pasajero> pasajeros;

	public Colectivo(int id, Linea linea, int capacidadPasajeros) {
		this.id = id;
		this.linea = linea;
		this.capacidadPasajeros = capacidadPasajeros;
		this.pasajeros = new ArrayList<>();
	}

	public void agregarPasajero(Pasajero pasajero) {
		if (this.pasajeros.size() < this.capacidadPasajeros) {
			this.pasajeros.add(pasajero);
		} else {
			System.out.println("El colectivo está lleno, no se puede agregar al pasajero " + pasajero.getId());
		}
	}

	public double ingresoPasajes() {
		double total = 0.0;
		double tarifaBase = this.linea.getTarifa();

		for (Pasajero pasajero : this.pasajeros) {
			// Cada pasajero sabe cómo calcular su propio pasaje
			total += pasajero.calcularPasaje(tarifaBase);
		}
		return total;
	}

	// --- Getters ---
	public int getId() {
		return id;
	}

	public Linea getLinea() {
		return linea;
	}

	public int getCapacidadPasajeros() {
		return capacidadPasajeros;
	}

	// --- equals() y toString() ---
	@Override
	public String toString() {
		return "Colectivo [id=" + id + ", linea=" + linea.getRecorrido() + ", capacidad=" + capacidadPasajeros + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Colectivo otro = (Colectivo) obj;
		return id == otro.id;
	}
}