package tp2.ej5.cuentasBancarias;

public class ClienteMaxCuentasException extends RuntimeException {
    public ClienteMaxCuentasException() {
        super("El cliente ya tiene la cantidad maxima de cuentas");
    }
}
