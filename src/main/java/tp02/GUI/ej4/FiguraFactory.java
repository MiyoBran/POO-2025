package tp02.GUI.ej4;

import tp02.GUI.ej3.Figura;
import tp02.GUI.ej3.Elipse;
import tp02.GUI.ej3.Punto;
import tp02.GUI.ej3.Poligono;
import tp02.GUI.ej3.FiguraCompuesta;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FiguraFactory {

  /// Minimo y maximo radio para las elipses
  private static final int RADIO_MIN = 20;
  private static final int RADIO_MAX = 100;
  /// Maxima cantidad de colores RGB
  private static final int COLOR_MAX = 256;
  /// Minimo y maximo cantidad de vertices para los poligonos
  private static final int VERTICES_MIN = 3;
  private static final int VERTICES_MAX = 6;
  /// Minimo y maximo cantidad de componentes para las figuras compuestas
  private static final int COMPONENTES_MIN = 2;
  private static final int COMPONENTES_MAX = 3;

  /// Porcentaje de margen para las figuras
  private static final double PORCENTAJE_MARGEN = 0.05; // 5% de margen
  
  // New constants for magic numbers
  private static final int TIPO_ELIPSE = 0;
  private static final int TIPO_POLIGONO = 1;
  private static final int TIPO_COMPUESTA = 2;
  private static final int CANTIDAD_TIPOS_FIGURA = 3;
  
  // Random instance
  private static final Random rand = new Random();


  public static Figura[] crearFigurasAleatorias(int cantidadFiguras, int ancho, int alto) {
      Figura[] figuras = new Figura[cantidadFiguras];

      for (int i = 0; i < cantidadFiguras; i++) {
          int tipoFigura = rand.nextInt(CANTIDAD_TIPOS_FIGURA);

          switch (tipoFigura) {
              case TIPO_ELIPSE:
                  figuras[i] = crearElipseAleatoria(ancho, alto);
                  break;
              case TIPO_POLIGONO:
                  figuras[i] = crearPoligonoAleatorio(ancho, alto);
                  break;
              case TIPO_COMPUESTA:
                  int numComponentes = rand.nextInt(COMPONENTES_MIN, COMPONENTES_MAX + 1);
                  Figura[] componentes = new Figura[numComponentes];
                  for (int k = 0; k < numComponentes; k++) {
                      if (rand.nextBoolean()) {
                          componentes[k] = crearElipseAleatoria(ancho, alto);
                      } else {
                          componentes[k] = crearPoligonoAleatorio(ancho, alto);
                      }
                  }
                  figuras[i] = new FiguraCompuesta(componentes);
                  break;
              default:
                  throw new IllegalStateException("Tipo de figura desconocido: " + tipoFigura);
          }
      }
      return figuras;
  }

  public static Figura crearElipseAleatoria(int ancho, int alto) {
    if (ancho <= 0 || alto <= 0) {
      throw new IllegalArgumentException("El ancho y el alto deben ser mayores a 0.");
    }
    
    int margenAncho = (int) (ancho * PORCENTAJE_MARGEN);
    int margenAlto = (int) (alto * PORCENTAJE_MARGEN);

    // RadioX y RadioY entre 20 y 100 (son el radio en x e y)
    int radioX = rand.nextInt(RADIO_MIN, RADIO_MAX);
    int radioY = rand.nextInt(RADIO_MIN, RADIO_MAX);

    // Asegurar que el centro permita que la elipse quepa en el área, restando el margen. Falta Validacion.
    // TODO: Validar que (radioX + margenAncho) < (ancho - radioX - margenAncho) y (radioY + margenAlto) < (alto - radioY - margenAlto)
    int xCentro = rand.nextInt((int) (radioX + margenAncho), (int) (ancho - radioX - margenAncho));
    int yCentro = rand.nextInt((int) (radioY + margenAlto), (int) (alto - radioY - margenAlto));

    // Nuevas propiedades
    boolean esRelleno = generarBooleanAleatorio();
    Color colorElipse = generarColorAleatorio();
    // Crear la elipse y asignarla al array
    return new Elipse(radioX, radioY, new Punto(xCentro, yCentro), 0, esRelleno, colorElipse);
  }

  
  public static Figura crearPoligonoAleatorio(int ancho, int alto) {
    if (ancho <= 0 || alto <= 0) {
      throw new IllegalArgumentException("El ancho y el alto deben ser mayores a 0.");
    }

    int margenAncho = (int) (ancho * PORCENTAJE_MARGEN);
    int margenAlto = (int) (alto * PORCENTAJE_MARGEN);

    int numVertices = rand.nextInt(VERTICES_MIN, VERTICES_MAX); // Entre 3 y 7 vertices
    Punto[] vertices = new Punto[numVertices];
    for (int j = 0; j < numVertices; j++) {
      int xVertice = rand.nextInt(margenAncho, (int) (ancho - margenAncho));
      int yVertice = rand.nextInt(margenAlto, (int) (alto - margenAlto));
      vertices[j] = new Punto(xVertice, yVertice);
    }
    
    boolean esRelleno = generarBooleanAleatorio();
    Color colorPoligono = generarColorAleatorio();
    return new Poligono(vertices, colorPoligono, esRelleno);
  }
  
  // Helper: generate random color
  private static Color generarColorAleatorio() {
      return new Color(rand.nextInt(COLOR_MAX), rand.nextInt(COLOR_MAX), rand.nextInt(COLOR_MAX));
  }

  // Helper: generate random boolean
  private static boolean generarBooleanAleatorio() {
      return rand.nextBoolean();
  }
  
}
