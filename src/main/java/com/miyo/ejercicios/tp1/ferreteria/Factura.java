package com.miyo.ejercicios.tp1.ferreteria;

public class Factura {
    private int numero;
    private String fechaVenta;

    public Factura(int numero, String fechaVenta) {
        this.numero = numero;
        this.fechaVenta = fechaVenta;
    }

    public int getNumero() {
        return numero;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    // Clase interna ItemFactura
    public static class ItemFactura {
        private String articuloVendido;
        private int cantidad;
        private double precio;

        public ItemFactura(String articuloVendido, int cantidad, double precio) {
            this.articuloVendido = articuloVendido;
            this.cantidad = cantidad;
            this.precio = precio;
        }

        public String getArticuloVendido() {
            return articuloVendido;
        }

        public int getCantidad() {
            return cantidad;
        }

        public double getPrecio() {
            return precio;
        }
    }
}