package com.miyo.ejercicios.tp1.ferreteria;

import java.time.LocalDate;

public class Factura {
    private int numero;
    private LocalDate fechaVenta;

    public Factura(int numero, LocalDate fechaVenta) {
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
}