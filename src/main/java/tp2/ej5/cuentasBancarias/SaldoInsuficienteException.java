package tp2.ej5.cuentasBancarias;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String msg) {
        super(msg);
    }
}
