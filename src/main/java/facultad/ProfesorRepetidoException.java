package facultad;

public class ProfesorRepetidoException extends RuntimeException {
    public ProfesorRepetidoException() {
        super("Profesor ya existente");
    }
}
