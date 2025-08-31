// BaseConjunto.java
package tp3.ej4.algebra;

public abstract class BaseConjunto implements Conjunto {

  public Conjunto union(Conjunto b) {
    int baseNuevo = Math.max(this.getBase(), b.getBase());
    Conjunto c = new ConjuntoArreglo(baseNuevo);
    if (this.getBase() > b.getBase()) {
      int x = 0;
      // recorremos ambos conjuntos hasta que termine el m�s corto (b)
      while (x < b.getBase()) {
        if (this.pertenece(x) || b.pertenece(x))
          c.agregarElemento(x);
        x++;
      }
      // recorremos el m�s largo (a) hasta que termine
      while (x < this.getBase()) {
        if (this.pertenece(x))
          c.agregarElemento(x);
        x++;
      }
    } else {  // el b es m�s largo que el a
      int x = 0;
      // recorremos ambos conjuntos hasta que termine el m�s corto (a)
      while (x < this.getBase()) {
        if (this.pertenece(x) || b.pertenece(x))
          c.agregarElemento(x);
        x++;
      }
      // recorremos el m�s largo (b) hasta que termine
      while (x < b.getBase()) {
        if (b.pertenece(x))
          c.agregarElemento(x);
        x++;
      }
    }
    return c;
  }

  public Conjunto interseccion(Conjunto b) {
    int baseNuevo = Math.max(this.getBase(), b.getBase());
    Conjunto c = new ConjuntoArreglo(baseNuevo);
    int x = 0;
    // recorremos ambos conjuntos hasta que termine el m�s corto
    while (x < Math.min(this.getBase(), b.getBase())) {
      if (this.pertenece(x) && b.pertenece(x))
        c.agregarElemento(x);
      x++;
    }
    return c;
  }

  /* La diferencia clásica debe devolver los elementos que están en this pero no en b.*/
  public Conjunto diferencia(Conjunto b) {
       Conjunto c = this.clonar();
    for (int i = 0; i < c.getBase(); i++) {
      if (this.pertenece(i) && b.pertenece(i)) {
        c.sacarElemento(i);
      }
    }
    return c;
  }

  public boolean incluido(Conjunto b) {
    boolean incluido = true;
    for (int x = 0; x < this.getBase(); x++)
      if (this.pertenece(x) && !b.pertenece(x))
        incluido = false;
    return incluido;
  }

  @Override
  public boolean igual(Conjunto b) {
    int baseMax = Math.max(this.getBase(), b.getBase());
    for (int x = 0; x < baseMax; x++) {
      if (this.pertenece(x) != b.pertenece(x)) {
        return false;
      }
    }
    return true;
  }


  // imprimir todos los elementos de un conjunto dado
  @Override
  public String toString() {
    if (this.vacio()) {
      return "Conjunto Vacio!";
    }
    StringBuilder sb = new StringBuilder();
    for (int x = 0; x < this.getBase(); x++) {
      if (this.pertenece(x)) {
        sb.append(x).append(" ");
      }
    }
    return sb.toString().trim();
  }

  // diferencia simétrica (elementos que están en A o en B, pero no en ambos).
  public Conjunto diferenciaSimetrica(Conjunto b) {
    int baseMax = Math.max(this.getBase(), b.getBase());
    Conjunto c = new ConjuntoArreglo(baseMax);
    for (int i = 0; i < baseMax; i++) {
      if (this.pertenece(i) != b.pertenece(i)) {
        c.agregarElemento(i);
      }
    }
    return c;
  }

  // Metodo para crear una copia "segura"
  public Conjunto clonar() {
    Conjunto copia = new ConjuntoArreglo(this.getBase());
    for (int i = 0; i < this.getBase(); i++) {
      if (this.pertenece(i)) {
        copia.agregarElemento(i);
      }
    }
    return copia;
  }

}
