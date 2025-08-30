package tp3.ej1.cuentasBancarias;

public class ClienteMaxCuentasException extends RuntimeException {
    public ClienteMaxCuentasException() {
        super("El cliente ya tiene la cantidad maxima de cuentas");
    }
}
