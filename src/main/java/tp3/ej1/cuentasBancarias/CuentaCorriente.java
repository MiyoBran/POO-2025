package tp3.ej1.cuentasBancarias;


public class CuentaCorriente extends CuentaBancaria {

  private double descubierto;
  public static double comisionCC = 0;

  public CuentaCorriente(int numero, Cliente titular, double descubierto) {
    super(numero, titular);
    this.descubierto = descubierto;
  }

  public CuentaCorriente(int numero, Cliente titular) {
    super(numero, titular);
    this.descubierto = 0;
  }

  @Override
  public void extraer(double monto) throws SaldoInsuficienteException {
    if (monto > saldoDisponible())
      throw new SaldoInsuficienteException("Saldo: " + getSaldo());

    super.setSaldo(getSaldo() - monto);
  }

  // getters y setter para comisionCC
  public static double getComisionCc() {
    return comisionCC;
  }
  public static void setComisionCC(double valor) {
    comisionCC = valor;
  }

  @Override
  public double saldoDisponible() {
    return getSaldo() + descubierto;
  }

  public double getDescubierto() {
    return descubierto;
  }

  public void setDescubierto(double valor) {
    descubierto = valor;
  }

  @Override
  public double obtenerComision() {
    return getComisionCc();
  }

}
