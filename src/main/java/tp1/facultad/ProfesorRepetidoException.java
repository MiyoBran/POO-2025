package tp1.facultad;

public class ProfesorRepetidoException extends RuntimeException {
    public ProfesorRepetidoException() {
        super("Profesor ya existente");
    }
}
