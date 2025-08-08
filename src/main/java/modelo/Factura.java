package modelo;

import java.time.LocalDate;
import java.util.List;

public class Factura {
    private int numero;
    private LocalDate fechaVenta;
    private List<ItemFactura> items;
    
    
    // Constructor de la clase Factura, solo se puede crear una factura con un artículo y una cantidad
    // Si se desea agregar más artículos, se debe usar el método agregarItem
    public Factura(int numero, LocalDate fechaVenta, Articulo item, int cantidad) {
        this.numero = numero;
        this.fechaVenta = fechaVenta;
        this.items = new java.util.LinkedList<>();
        agregarItem(item, cantidad);
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    // Clase interna ItemFactura
    private class ItemFactura {
        private Articulo articuloVendido;
        private int cantidad;
        private double precio;

        public ItemFactura(Articulo articuloVendido, int cantidad, double precio) {
            this.articuloVendido = articuloVendido;
            this.cantidad = cantidad;
            this.precio = precio;
        }

        public Articulo getArticuloVendido() {
            return articuloVendido;
        }

        public int getCantidad() {
            return cantidad;
        }

        public double getPrecio() {
            return precio;
        }
    }

    /**
     * Agrega un artículo a la factura con la cantidad indicada.
     * si el articulo ya existe, se lanza una excepción ArticuloRepetidoException.
     * @param articulo Artículo a agregar
     * @param cantidad Cantidad vendida
     * @throws IllegalArgumentException si el artículo es null o la cantidad no es válida
     * @throws ArticuloRepetidoException si el artículo ya está en la factura
     */
    public void agregarItem(Articulo articulo, int cantidad) {
        if (articulo == null) {
            throw new IllegalArgumentException("El artículo no puede ser null");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
        // Verificar si el artículo ya existe en la factura
        for (ItemFactura item : items) {
            if (item.getArticuloVendido().equals(articulo)) {
                throw new ArticuloRepetidoException("El artículo ya está en la factura");
            }
        }
        
        // Verificar si hay suficiente stock
        // Verificar y descontar stock antes de agregar el ítem
        articulo.descontarStock(cantidad);
        ItemFactura itemFactura = new ItemFactura(articulo, cantidad, articulo.getPrecio());
        items.add(itemFactura);
    }

	public Double importeTotal() {
		// TODO Auto-generated method stub
		double total = 0.0;
		for (ItemFactura item : items) {
			total += item.getPrecio() * item.getCantidad();
		}
		return total;
	}
}