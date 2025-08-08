# 🧪 Trabajo Práctico 1 – Programación Orientada a Objetos

> 📌 Nota: Para **cada ejercicio**, realizar el **diagrama de clases UML correspondiente**.

---

## 🧩 Ejercicio 1 – Administración de empleados

Una empresa necesita administrar sus empleados. Crear la clase `Empleado` que registra:

- legajo
- nombre
- supervisor (instancia de la clase `Empleado`)
- departamento (instancia de la clase `Departamento`)

Crear la clase `Departamento` que registra:

- código
- nombre

Crear la clase `Empresa` que gestiona empleados y departamentos. Incluir métodos para responder a las siguientes consultas:

- Todos los empleados que pertenecen a un departamento dado
- Dado un empleado, toda la jerarquía de supervisores
- Dado un empleado, los empleados que tiene a su cargo en forma directa

### 🧪 Programa de prueba
Registrar datos de una empresa que tiene tres departamentos: **Gerencia**, **Producción** y **Ventas**.

- La Gerencia tiene dos empleados: el gerente (sin supervisor) y su secretaria.
- Producción y Ventas dependen de Gerencia y tienen:
  - 1 supervisor
  - 1 operario

Probar los métodos de consulta implementados en la clase `Empresa`.

---

## 🧩 Ejercicio 2 – Ferretería: stock y ventas

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
public void cambiarPrecio(double porcCambio)

/**
 * Retorna el valor total del stock multiplicando la cantidad existente por el precio
 * 
 * @return stock valorizado
 */
public double stockValorizado()
