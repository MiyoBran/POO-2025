package poo.cuentas;

public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(String errorMessage) {
        super(errorMessage);
    }
	
}
