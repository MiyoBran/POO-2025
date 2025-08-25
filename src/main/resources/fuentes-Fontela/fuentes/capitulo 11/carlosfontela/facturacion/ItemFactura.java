package carlosfontela.facturacion;

public class ItemFactura {

	private int codigo;
	private String descripcion;
	private long precio;
	private int cantidad;
	
	public ItemFactura (int codigo, String descripcion, long precio, int cantidad) 	{
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public int getCodigo ( ) {
		return codigo;
	}
	
	public String getDescripcion ( ) {
		return descripcion;
	}
	
	public long getPrecio ( ) {
		return precio;
	}
	
	public int getCantidad ( ) {
		return cantidad;
	}

	public long getMontoItem ( ) {
			return precio * cantidad;
	}
}
