package colectivo;

import java.util.ArrayList;
import java.util.List;


public class Linea {
	
	private int id;
	private String recorrido;
	private int tiempoViaje;
	private int tiempoParada;
	private double tarifa;	
	private List<Parada> paradas;
	
	// Constructor
	public Linea(int id, String recorrido, int tiempoViaje, int tiempoParada,double tarifa , Parada paradaInicial) {
	
		this.id = id;
		this.recorrido = recorrido;
		this.tiempoViaje = tiempoViaje;
		this.tiempoParada = tiempoParada;
		this.tarifa = tarifa;      
		
        this.paradas = new ArrayList<>(); 
        if (paradaInicial != null) {
            this.paradas.add(paradaInicial); // 2. Añadimos la parada que nos pasaron.
        }
	}
	
	public void agregarParada(Parada parada) {
		paradas.add(parada);
	}
	
	// --- Getters ---
    public int getId() {
        return id;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public double getTarifa() {
        return tarifa;
    }

    public List<Parada> getParadas() {
        // Devolvemos una copia para proteger la lista original (encapsulamiento)
        return new ArrayList<>(paradas);
    }
    
    // --- equals() y toString() ---
    @Override
    public String toString() {
        return "Linea [id=" + id + ", recorrido=" + recorrido + ", tarifa=" + tarifa + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Linea otra = (Linea) obj;
        return id == otra.id;
    }

}
