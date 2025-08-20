package tp1.facultad;

public class AlumnoRepetidoException extends RuntimeException {

    public AlumnoRepetidoException() {
        super("Alumno ya existente");
    }
}
