package tp4.ej5.heladeria;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Heladeria {
    public static void main(String[] args) throws InterruptedException {
        // Parameters (milliseconds used for demo; original problem uses minutes)
        int numClientes = 120;
        int cajasCount = 2;
        int atencionCount = 6;
        int colaSize = 50;
        long colaPollTimeoutMillis = 15000; // wait time before workers assume no more clients

        long arrivalMinMillis = 1000; // 1-3 minutes in spec -> 1000-3000 ms for demo
        long arrivalMaxMillis = 3000;
        long cajaMinMillis = 1000; // 1-2 minutes -> 1000-2000 ms
        long cajaMaxMillis = 2000;
        long atencionMinMillis = 2000; // 2-4 minutes -> 2000-4000 ms
        long atencionMaxMillis = 4000;

        // Queues
        Cola colaCaja = new Cola(colaSize, colaPollTimeoutMillis);
        Cola colaAtencion = new Cola(colaSize, colaPollTimeoutMillis);

        // Shared collection for attended clients ArrayBlockingQueue
        ConcurrentLinkedQueue<Cliente> atendidos = new ConcurrentLinkedQueue<>();

        // Generator
        GeneradorCliente generador = new GeneradorCliente(colaCaja, numClientes, arrivalMinMillis, arrivalMaxMillis);
        Thread genThread = new Thread(generador, "Generador");

        // Cajas
        List<Caja> cajas = new ArrayList<>();
        List<Thread> cajaThreads = new ArrayList<>();
        for (int i = 0; i < cajasCount; i++) {
            Caja caja = new Caja(colaCaja, colaAtencion, "Caja-" + (i+1), cajaMinMillis, cajaMaxMillis);
            Thread t = new Thread(caja, caja.getNombre());
            cajas.add(caja);
            cajaThreads.add(t);
        }

        // Atencion
        List<Atencion> atencions = new ArrayList<>();
        List<Thread> atencionThreads = new ArrayList<>();
        for (int i = 0; i < atencionCount; i++) {
            Atencion at = new Atencion(colaAtencion, "Atencion-" + (i+1), atendidos, atencionMinMillis, atencionMaxMillis);
            Thread t = new Thread(at, at.getNombre());
            atencions.add(at);
            atencionThreads.add(t);
        }

        // Start threads
        System.out.println("Iniciando simulación: clientes=" + numClientes + ", cajas=" + cajasCount + ", atencion=" + atencionCount);
        for (Thread t : cajaThreads) t.start();
        for (Thread t : atencionThreads) t.start();
        genThread.start();

        // Wait generator to finish
        genThread.join();
        System.out.println("Generador finalizado.");

        // Wait workers to finish
        for (Thread t : cajaThreads) t.join();
        for (Thread t : atencionThreads) t.join();

        // Print results
        System.out.println("\n=== Resultados de la simulación ===");
        int totalAtendidos = atendidos.size();
        System.out.println("Clientes generados: " + numClientes + ", clientes atendidos: " + totalAtendidos);

        System.out.println("\n-- Estadísticas por caja --");
        for (Caja c : cajas) {
            System.out.println(c.getNombre() + " - atendidos: " + c.getServedCount() + ", tiempo total de trabajo: " + c.getTotalWorkTimeMillis() + " ms");
        }

        System.out.println("\n-- Estadísticas por atención --");
        for (Atencion a : atencions) {
            System.out.println(a.getNombre() + " - atendidos: " + a.getServedCount() + ", tiempo total de trabajo: " + a.getTotalWorkTimeMillis() + " ms");
        }

        System.out.println("\n-- Detalle clientes atendidos --");
        for (Cliente cl : atendidos) {
            System.out.println("Cliente " + cl.getId() + " - tiempo total en heladería: " + (cl.getSalida() - cl.getIngreso()) + " ms");
        }

        System.out.println("Simulación finalizada.");
    }
}
