package tp02.GUI.ej1;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Ventana principal que genera y muestra figuras aleatorias (líneas, óvalos y rectángulos)
 * en un panel, y actualiza una barra de estado con la cantidad de cada tipo de figura.
 * Cumple la consigna del ejercicio 4 del TP.
 */
public class Dibujo extends JFrame {
  /**
   * Arreglo de líneas a dibujar.
   */
  private MiFigura[] figuras;
  /**
   * Barra de estado que muestra la cantidad de figuras.
   */
  private final JLabel barraEstado;
  /**
   * Dimensiones fijas de la ventana.
   */
  private static final int ANCHO_PANTALLA = 800;
  private static final int ALTO_PANTALLA = 600;

  // Variables para la cantidad de cada tipo de figura
  private int numLineas;
  private int numOvalos;
  private int numRectangulos;

  /**
   * Constructor: inicializa la ventana, genera las figuras y configura la barra de estado.
   * @param cantidadFiguras cantidad de figuras a generar (debe ser >= 3)
   * @throws IllegalArgumentException si cantidadFiguras < 3
   */
  public Dibujo(int cantidadFiguras) {
    if (cantidadFiguras < 3) {
      throw new IllegalArgumentException("Debe ingresar al menos 3 figuras para cumplir la consigna (mínimo 1 de cada tipo).");
    }
    this.barraEstado = new JLabel();
    this.setSize(ANCHO_PANTALLA, ALTO_PANTALLA);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.add(barraEstado, BorderLayout.SOUTH);
    cantidadFiguras(cantidadFiguras);
    cargarFiguras();
    this.add(cargarPanel(), BorderLayout.CENTER);
    // La visibilidad se controla fuera del constructor
  }

  /**
   * Solicita al usuario la cantidad de figuras a generar mediante un cuadro de diálogo.
   * @return cantidad de figuras ingresada por el usuario
   */
  public static int solicitarCantidadFiguras() {
    int numFiguras = 0;
    try {
      numFiguras = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de figuras", "Figuras", JOptionPane.QUESTION_MESSAGE));
    } catch (NumberFormatException e) {
      System.err.println("Error al cargar datos: " + e.getMessage());
      System.exit(1);
    }
    return numFiguras;
  }

  /**
   * Determina la cantidad de figuras de cada tipo (líneas, óvalos, rectángulos) de forma balanceada y aleatoria.
   * Modifica las variables numLineas, numOvalos y numRectangulos.
   * @param numFiguras cantidad total de figuras a generar
   */
  private void cantidadFiguras(int numFiguras) {
    Random rand = new Random();
    int minPorTipo = 1;
    int maxPorTipo = numFiguras / 2; // Ningún tipo puede superar la mitad
    int restantes = numFiguras - 3 * minPorTipo;

    // Líneas: mínimo 1, máximo la mitad del total
    this.numLineas = minPorTipo + rand.nextInt(Math.min(restantes + 1, maxPorTipo - minPorTipo + 1));

    // Ovalos: mínimo 1, máximo la mitad del total o lo que quede disponible
    int maxOvalos = Math.min(maxPorTipo, numFiguras - this.numLineas - minPorTipo);
    this.numOvalos = minPorTipo + rand.nextInt(Math.max(1, maxOvalos - minPorTipo + 1));

    // Rectángulos: el resto
    this.numRectangulos = numFiguras - this.numLineas - this.numOvalos;
  }

  /**
   * Genera arreglos de figuras aleatorias (líneas, óvalos y rectángulos) y actualiza la barra de estado.
   * Las figuras se generan una sola vez y se mantienen fijas durante la vida de la ventana.
   * Se garantiza que haya al menos 1 figura de cada tipo.
   */
  private void cargarFiguras() {
    int numFiguras = numLineas + numOvalos + numRectangulos;
    Random rand = new Random();
    figuras = new MiFigura[numFiguras];
    // Creamos las figuras
    for (int i = 0; i < numFiguras; i++) {
      // Propiedades generales de cualquier figura.
      int x1 = rand.nextInt(ANCHO_PANTALLA / 2);
      int y1 = rand.nextInt(ALTO_PANTALLA / 2);
      Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

      if (i < numLineas) {
        // Especificos de las lineas
        int x2 = rand.nextInt(ANCHO_PANTALLA / 2);
        int y2 = rand.nextInt(ALTO_PANTALLA / 2);
        figuras[i] = new MiLinea(x1, y1, x2, y2, color);
      } else if (i < (numLineas + numOvalos)) {
        // Especificos de los ovalos
        int ancho = rand.nextInt(ANCHO_PANTALLA / 2);
        int alto = rand.nextInt(ALTO_PANTALLA / 2);
        boolean relleno = rand.nextBoolean();
        figuras[i] = new MiOvalo(x1, y1, ancho, alto, color, relleno);
      } else {
        // Especificos de los rectangulos
        int ancho = rand.nextInt(ANCHO_PANTALLA / 2);
        int alto = rand.nextInt(ALTO_PANTALLA / 2);
        boolean relleno = rand.nextBoolean();
        figuras[i] = new MiRectangulo(x1, y1, ancho, alto, color, relleno);
      }
    }
    // Actualizar la barra de estado con la cantidad de figuras generadas
    barraEstado.setText("Líneas: " + numLineas + ", Ovalos: " + numOvalos + ", Rectángulos: " + numRectangulos);
  }

  /**
   * Crea y retorna un panel personalizado que dibuja las figuras almacenadas.
   * El metodo paintComponent solo recorre y dibuja los arreglos, sin regenerar figuras.
   *
   * @return JPanel personalizado para el dibujo.
   */
  private JPanel cargarPanel() {
    return new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpia la pantalla

        // Dibujar todas las figuras con su propio metodo.
        for (MiFigura figura : figuras) {
          figura.dibujar(g);
        }
      }
    };
  }

}
