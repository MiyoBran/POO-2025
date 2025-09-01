package tp02.GUI.ej4;

import tp02.GUI.ej3.Figura;
import tp02.GUI.ej3.Elipse;
import tp02.GUI.ej3.Punto;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CrearFigurasAleatoria {

  // Minimo y maximo radio para las elipses
  private static final int RADIO_MIN = 20;
  private static final int RADIO_MAX = 100;
  // Maxima cantidad de colores RGB
  private static final int COLOR_MAX = 256;
  // Minimo y maximo cantidad de vertices para los poligonos
  private static final int VERTICES_MIN = 3;
  private static final int VERTICES_MAX = 11;
  // Minimo y maximo cantidad de componentes para las figuras compuestas
  private static final int COMPONENTES_MIN = 2;
  private static final int COMPONENTES_MAX = 4;


  // Metodo para solicitar la cantidad de figuras a crear.
  public static int solicitarCantidadFiguras() {
    int numFiguras = 0;
    boolean valido = false;
    while (!valido) {
      try {
        String input = JOptionPane.showInputDialog(null, "Cantidad de figuras (mayor a 0)", "Figuras", JOptionPane.QUESTION_MESSAGE);
        numFiguras = Integer.parseInt(input);
        if (numFiguras > 0) {
          valido = true;
        } else {
          JOptionPane.showMessageDialog(null, "Debe ingresar un número mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
    return numFiguras;
  }


  public static Figura[] crearFigurasAleatorias(int cantidadFiguras, int ancho, int alto) {
    Figura[] figuras = new Figura[cantidadFiguras];
    Random rand = new Random();

    for (int i = 0; i < cantidadFiguras; i++) {
      // Decidir aleatoriamente el tipo de figura: 0-Elipse, 1-Poligono, 2-FiguraCompuesta
      int tipoFigura = rand.nextInt(3);

      switch (tipoFigura) {
        case 0: // Elipse
          // RadioX y RadioY entre 20 y 100 (son el radio en x e y)
          int radioX = rand.nextInt(RADIO_MIN, RADIO_MAX);
          int radioY = rand.nextInt(RADIO_MIN, RADIO_MAX);
          // Asegurar que el centro permita que la elipse quepa en el área
          int xCentro = rand.nextInt(radioX, ancho - radioX);
          int yCentro = rand.nextInt(radioY, alto - radioY);
          // Nuevas propiedades
          boolean esRelleno = rand.nextBoolean();
          Color colorElipse = new Color(rand.nextInt(COLOR_MAX), rand.nextInt(COLOR_MAX), rand.nextInt(COLOR_MAX));
          // Crear la elipse y asignarla al array
          figuras[i]  = new Elipse(radioX, radioY, new Punto(xCentro, yCentro), 0, esRelleno, colorElipse);
          break;

        case 1: // Poligono
          int numVertices = rand.nextInt(VERTICES_MIN, VERTICES_MAX); // Entre 3 y 7 vertices
          Punto[] vertices = new Punto[numVertices];
          for (int j = 0; j < numVertices; j++) {
            int xVertice = rand.nextInt(0, ancho);
            int yVertice = rand.nextInt(0, alto);
            vertices[j] = new Punto(xVertice, yVertice);
          }
          Color colorPoligono = new Color(rand.nextInt(COLOR_MAX), rand.nextInt(COLOR_MAX), rand.nextInt(COLOR_MAX));
          boolean relleno = rand.nextBoolean();
          figuras[i] = new Poligono(vertices, colorPoligono, relleno);
          break;

        case 2: // FiguraCompuesta
          int numComponentes = rand.nextInt(2, 5); // Entre 2 y 4 componentes
          Figura[] componentes = new Figura[numComponentes];
          for (int k = 0; k < numComponentes; k++) {
            // Crear componentes simples (Elipse o Poligono)
            if (rand.nextBoolean()) { // Elipse
              int rX = rand.nextInt(20, 100);
              int rY = rand.nextInt(20, 100);
              int xC = rand.nextInt(rX, ancho - rX);
              int yC = rand.nextInt(rY, alto - rY);
              boolean esCirc = rand.nextBoolean();
              Color cElipse = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
              componentes[k] = new tp02.GUI.ej3.Elipse(rX, rY, new tp02.GUI.ej3.Punto(xC, y
  }
}
