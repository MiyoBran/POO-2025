package com.miyo.ejercicios.tp1.ferreteria;

/*## 🧩 Ejercicio 2 – Ferretería: stock y ventas

Una ferretería necesita administrar su stock y ventas.

Crear las siguientes clases:

- `Articulo`  
  - código  
  - descripción  
  - precio  
  - cantidad  

- `Factura`  
  - número  
  - fecha de venta  

- `ItemFactura`  
  - artículo vendido  
  - cantidad  
  - precio  

> ⚠️ Una factura debe tener al menos **un artículo vendido**.

- `Negocio` que gestiona artículos y facturas.

### 🚨 Excepciones

- `ArticuloRepetidoException`: al cargar un ítem con artículo repetido en una factura.
- `StockInsuficienteException`: cuando la cantidad a vender supera el stock disponible.

### 🧪 Métodos en la clase `Negocio`

```java
/**
 * Cambia en un porcentaje el precio de todos los artículos del stock
 *  
 * @param porcCambio: porcentaje de cambio de precio 
 */
// public void cambiarPrecio(double porcCambio)

/**
 * Retorna el valor total del stock multiplicando la cantidad existente por el precio
 * 
 * @return stock valorizado
 */
// public double stockValorizado()
