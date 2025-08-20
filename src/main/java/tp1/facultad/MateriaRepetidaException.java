package tp1.facultad;

public class MateriaRepetidaException extends RuntimeException {

    public MateriaRepetidaException() {
        super("Materia ya existente");
    }
}
