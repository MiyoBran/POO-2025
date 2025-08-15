package modelo;


public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException() {
        super("No hay suficiente stock");
    }
}