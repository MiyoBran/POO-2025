package colectivohilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// ModificadoPorAgente: 2025-10-03 | Autor: AgenteCopilot | Motivo: Unificar simulador en paquete colectivohilos
public class Simulacion {

    // --- Parámetros de la Simulación ---
    private static final double TARIFA_BASE = 5400.0;
    
    // --- Parámetros de la Línea y el Viaje ---
    private static final int MAX_PARADAS = 5;
    private static final int TIEMPO_ENTRE_PARADAS = 200;  // milisegundos
    private static final int TIEMPO_VIAJE = 3000;          // milisegundos

    // --- Parámetros de los Pasajeros ---
    private static final int TOTAL_PASAJEROS = 160;
    private static final int TIEMPO_MINIMO_LLEGADA = 100;
    private static final int TIEMPO_MAXIMO_LLEGADA = 300;

    // --- Parámetros de los Colectivos ---
    private static final int TOTAL_COLECTIVOS = 2;
    private static final int CAPACIDAD_COLECTIVO = 30;

    public static void main(String[] args) {
        System.out.println("--- INICIANDO SIMULACIÓN DE COLECTIVOS ---");

        ExecutorService executor = Executors.newCachedThreadPool();

        // 1. Crear recursos compartidos (Línea y Paradas)
        Parada paradaInicial = new Parada(1, "Terminal");
        Linea linea = new Linea(1, "Madryn-Trelew", TIEMPO_VIAJE, TIEMPO_ENTRE_PARADAS, TARIFA_BASE, paradaInicial);

        // Agregar el resto de las paradas
        for (int i = 2; i <= MAX_PARADAS; i++) {
            linea.agregarParada(new Parada(i, "Parada " + i));
        }

        // 2. Iniciar generadores de pasajeros (PRODUCTORES)
        int pasajerosEstudiantes = TOTAL_PASAJEROS / 2;
        int pasajerosComunes = TOTAL_PASAJEROS - pasajerosEstudiantes;

        executor.execute(new GeneradorPasajeros(linea, true, pasajerosEstudiantes, 1, TIEMPO_MINIMO_LLEGADA, TIEMPO_MAXIMO_LLEGADA));
        executor.execute(new GeneradorPasajeros(linea, false, pasajerosComunes, pasajerosEstudiantes + 1, TIEMPO_MINIMO_LLEGADA, TIEMPO_MAXIMO_LLEGADA));

        // 3. Iniciar colectivos (CONSUMIDORES)
        for (int i = 1; i <= TOTAL_COLECTIVOS; i++) {
            executor.execute(new Colectivo(i, linea, CAPACIDAD_COLECTIVO));
        }

        // 4. Cerrar executor y esperar terminación
        executor.shutdown();

        try {
            // Esperar hasta 2 minutos a que todas las tareas terminen
            boolean tareasTerminaron = executor.awaitTermination(2, TimeUnit.MINUTES);

            if (tareasTerminaron) {
                System.out.println("\n--- REPORTE FINAL DE PASAJEROS EN PARADAS ---");
                for (Parada parada : linea.getParadas()) {
                    System.out.println("Pasajeros esperando en la parada: " + parada.getId());
                    System.out.println(parada.getPasajerosEsperando());
                }
            } else {
                System.out.println("Las tareas no terminaron en el tiempo esperado.");
            }

        } catch (InterruptedException e) {
            System.out.println("Hubo una interrupción mientras esperaba a que terminaran las tareas.");
            Thread.currentThread().interrupt();
        }
    }
}
