package facultad;

public class MateriaRepetidaException extends RuntimeException {

    public MateriaRepetidaException() {
        super("Materia ya existente");
    }
}
