package colectivohilos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Parada {
    private int id;
    private String direccion;
    // BlockingQueue para manejar la espera de pasajeros
    private final BlockingQueue<Pasajero> pasajerosEnEspera;

    public Parada(int id, String direccion) {
        this.id = id;
        this.direccion = direccion;
        this.pasajerosEnEspera = new LinkedBlockingQueue<>();
    }

	// Método para que un pasajero se agregue a la cola de espera
    public void agregarPasajeroALaEspera(Pasajero pasajero) throws InterruptedException {
        this.pasajerosEnEspera.put(pasajero);
    }
    
    /**
     * Intenta tomar un pasajero de la cola.
     * El método poll() es no-bloqueante y thread-safe.
     * @return El próximo pasajero en la cola, o null si la cola está vacía.
     */
    public Pasajero tomarProximoPasajero() {
        return this.pasajerosEnEspera.poll();
    }
    
    

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }
    
    // Método para el reporte final
    public List<Pasajero> getPasajerosEsperando() {
        return new ArrayList<>(this.pasajerosEnEspera);
    }

    // --- equals() y toString() ---
    @Override
    public String toString() {
        return "Parada [id=" + id + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Parada otra = (Parada) obj;
        return id == otra.id;
    }
}