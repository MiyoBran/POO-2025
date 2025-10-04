// CuentaCorriente.java
package poo.cuentas;

public class CuentaCorriente extends CuentaBancaria {

  private double descubierto;

  public CuentaCorriente(int numero, String titular, double descubierto) {
    super(numero, titular);
    this.descubierto = descubierto;
  }

  public CuentaCorriente(int numero, String titular) {
    this(numero, titular, 0);
  }

  public void extraer(double monto) throws SaldoInsuficienteException {
    if (monto > getSaldo() + descubierto)
      throw new SaldoInsuficienteException("Saldo Insuficiente en Cuenta Corriente");

    setSaldo(getSaldo() - monto);
  }

  public double getDescubierto() {
    return descubierto;
  }

  @SuppressWarnings( "unused")
  public void setDescubierto(double descubierto) {
    this.descubierto = descubierto;
  }
}
