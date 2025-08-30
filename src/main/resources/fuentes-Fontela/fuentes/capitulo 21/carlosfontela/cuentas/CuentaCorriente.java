package carlosfontela.cuentas;

public class CuentaCorriente extends CuentaBancaria implements Cloneable, java.io.Serializable {

	private double descubierto;
	
	public CuentaCorriente (int numero, Cliente titular, double descubierto) {
		super (numero, titular);
		this.descubierto = descubierto;
	}

	public CuentaCorriente (int numero, Cliente titular) {
		super (numero, titular);
		this.descubierto = 0;
	}

	public boolean extraer (double monto) {
		if (monto > getSaldo() + descubierto)
			return false;
		else {
			setSaldo ( getSaldo() - monto );
			return true;
		}
	}

	public double getDescubierto ( ) {
			return descubierto;
	}
	
	public void setDescubierto (double valor) {
			descubierto = valor;
	}

	public Object clone( ) {
		Object copia = null;
		try {
			copia = (CuentaCorriente)super.clone( );
		} catch (CloneNotSupportedException e) {}
		return copia;
	}
}
