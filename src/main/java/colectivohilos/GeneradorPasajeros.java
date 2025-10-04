package colectivohilos;

import java.util.List;
import java.util.Random;

public class GeneradorPasajeros implements Runnable {
    private final Linea linea;
    private final boolean esEstudiante;
    private final int totalAGenerar;
    private int idInicial; // Para contar los IDs de los pasajeros
    private final Random random = new Random();
    
    // Constantes de tiempo de llegada, ahora como atributos
    private final int tiempoMinimoLlegada;
    private final int tiempoMaximoLlegada;

    /**
     * Constructor.
     * @param linea La línea con las paradas.
     * @param esEstudiante true si debe generar Estudiantes, false para Comunes.
     * @param totalAGenerar Cuántos pasajeros debe crear este hilo.
     * @param idInicial El número de ID con el que empieza a contar.
     * @param tiempoMin El tiempo mínimo de espera entre llegadas.
     * @param tiempoMax El tiempo máximo de espera entre llegadas.
     */
    public GeneradorPasajeros(Linea linea, boolean esEstudiante, int totalAGenerar, int idInicial, int tiempoMin, int tiempoMax) {
        this.linea = linea;
        this.esEstudiante = esEstudiante;
        this.totalAGenerar = totalAGenerar;
        this.idInicial = idInicial;
        this.tiempoMinimoLlegada = tiempoMin;
        this.tiempoMaximoLlegada = tiempoMax;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < totalAGenerar; i++) {
                // 1. Simula el tiempo de llegada
                int tiempoEspera = random.nextInt(tiempoMaximoLlegada - tiempoMinimoLlegada + 1) + tiempoMinimoLlegada;
                Thread.sleep(tiempoEspera);

                // 2. Crea el pasajero correspondiente
                Pasajero nuevoPasajero = crearPasajero();
                
                // 3. Elige una parada al azar y lo agrega a su cola
                List<Parada> paradasDisponibles = linea.getParadas();
                Parada paradaAleatoria = paradasDisponibles.get(random.nextInt(paradasDisponibles.size()));
                
                paradaAleatoria.agregarPasajeroALaEspera(nuevoPasajero);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String tipo = esEstudiante ? "Estudiantes" : "Comunes";
        System.out.println("--> Generador de " + tipo + " ha finalizado su tarea.");
    }

    private Pasajero crearPasajero() {
        int nuevoId = this.idInicial++; 
        
        if (this.esEstudiante) {
            return new PasajeroEstudiante(nuevoId);
        } else {
            boolean esFrecuente = random.nextBoolean(); // 50% de probabilidad
            return new PasajeroComun(nuevoId, esFrecuente);
        }
    }
}