package colectivohilos;

import java.util.ArrayList;
import java.util.List;

public class Colectivo implements Runnable {
    // Atributos
    private final int id;
    private final Linea linea;
    private final int capacidadPasajeros;
    private final List<Pasajero> pasajerosAbordo;
    
    // Tiempo entre el comienzo de llegada de pasajeros a las paradas y la salida
    // del primer colectivo
    private static final int TIEMPO_INICIO_SALIDA = 3000;
    // Frecuencia de salida de cada colectivo
    private static final int FRECUENCIA = 8000;


	// Constructor
    public Colectivo(int id, Linea linea, int capacidadPasajeros) {
        this.id = id;
        this.linea = linea;
        this.capacidadPasajeros = capacidadPasajeros;
        this.pasajerosAbordo = new ArrayList<>();
    }

    public void agregarPasajero(Pasajero pasajero) {
        if (this.pasajerosAbordo.size() < this.capacidadPasajeros) {
            this.pasajerosAbordo.add(pasajero);
        } else {
            System.out.println("El colectivo está lleno, no se puede agregar al pasajero " + pasajero.getId());
        }
    }

    public double ingresoPasajes() {
        double total = 0.0;
        double tarifaBase = this.linea.getTarifa();

        for (Pasajero pasajero : this.pasajerosAbordo) {
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

    // --- LÓGICA DE RUNNABLE ---
    @Override
    public void run() {
        try {
        	// Espera para la salida del primer colectivo
			// y luego cada colectivo sale con una frecuencia determinada
			// para evitar que todos salgan al mismo tiempo
			// (simulando una frecuencia real de colectivos)
			Thread.sleep(TIEMPO_INICIO_SALIDA + (id - 1) * FRECUENCIA);
        	
            System.out.println("Colectivo " + id + " inicia su recorrido.");
            
 
            recorrerParadas();
            realizarViajePrincipal();
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Colectivo " + id + " ha finalizado su servicio.");
        }
    }

    private void recorrerParadas() throws InterruptedException {
    
        for (Parada parada : linea.getParadas()) {

            Thread.sleep(linea.getTiempoParada());
            
       
            System.out.println("Colectivo: " + id + " Parada: " + parada.getId());
            
            // Recoger pasajeros
            List<Pasajero> subenEnEstaParada = new ArrayList<>();
            while (pasajerosAbordo.size() < capacidadPasajeros) {
                Pasajero proximoPasajero = parada.tomarProximoPasajero();
                if (proximoPasajero != null) {
                    pasajerosAbordo.add(proximoPasajero);
                    subenEnEstaParada.add(proximoPasajero);
                } else {
                    break; 
                }
            }
            
            System.out.println("Suben: " + subenEnEstaParada);
        }
    }

    private void realizarViajePrincipal() throws InterruptedException {
        System.out.println("===> Inicia viaje colectivo: " + id);
        
        Thread.sleep(linea.getTiempoViaje());
        

        System.out.println("===> Finaliza viaje colectivo: " + id);
        System.out.println("Total Ingreso Pasajes: $" + ingresoPasajes());
        System.out.println("Bajan: " + pasajerosAbordo);
        
      
        pasajerosAbordo.clear();
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