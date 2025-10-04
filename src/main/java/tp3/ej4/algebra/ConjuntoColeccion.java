package tp3.ej4.algebra;

import java.util.HashMap;
import java.util.HashSet;


public class ConjuntoColeccion extends BaseConjunto {

  private final HashMap<Integer, Boolean> map;
  private final int base;

  public ConjuntoColeccion(int base) {
    if (base > 0 && base < 65) {
      this.base = base;
    } else {
      this.base = 64;
    }
    map = new HashMap<>();
    this.vaciar();
  }

  @Override
  public int getBase() {
    return base;
  }

  @Override
  public boolean pertenece(int x) {
    // si solo uso get, puede lanzar una excepcion NullPointerException
    return map.getOrDefault(x, false);
  }

  @Override
  public boolean vacio() {
    return !(map.containsValue(true));
    // Version alternativa sin usar containsValue
  //    for (boolean valor : map.values()) {
  //      if (valor) return false;
  //    }
  //    return true;
  }

  @Override
  public void vaciar() {
    for (int i = 0; i < base; i++) {
      this.map.put(i, false);
    }
  }

  @Override
  public void agregarElemento(int x) {
    if (x >= 0 && x < base) {
      this.map.put(x, true);
    }
  }

  @Override
  public void sacarElemento(int x) {
    if (x >= 0 && x < base) {
      this.map.put(x, false);
    }
  }

  @Override
  public int cardinalidad() {
    int cantidad = 0;
    for (boolean valor : map.values()) {
      if (valor) cantidad++;
    }
    return cantidad;
  }
}
