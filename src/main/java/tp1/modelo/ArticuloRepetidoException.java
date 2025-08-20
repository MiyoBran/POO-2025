package tp1.modelo;

public class ArticuloRepetidoException extends RuntimeException {
    public ArticuloRepetidoException() {
        super("El articulo ya existe");
    }
}