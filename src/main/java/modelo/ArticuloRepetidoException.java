package modelo;

/**
 * Excepción lanzada cuando se intenta agregar un artículo repetido a una factura.
 */
public class ArticuloRepetidoException extends RuntimeException {

    /**
     * Crea una nueva excepción con el mensaje especificado.
     * @param mensaje Descripción de la excepción
     */
    public ArticuloRepetidoException(String mensaje) {
        super(mensaje);
    }
}