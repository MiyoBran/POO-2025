package tp02.GUI.ej2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Ventana principal que genera y muestra figuras aleatorias (líneas, óvalos y rectángulos)
 * en un panel, y actualiza una barra de estado con la cantidad de cada tipo de figura.
 * Cumple la consigna del ejercicio 4 del TP.
 */
public class DibujoFiguras extends JFrame {
  /**
   * Dimensiones fijas de la ventana.
   */
  private static final int ANCHO_PANTALLA = 800;
  private static final int ALTO_PANTALLA = 600;

  // Arreglos para almacenar las figuras generadas
  private Figura[] figuras;
  // Variables para la cantidad de cada tipo de figura
  private int numLineas;
  private int numOvalos;
  private int numRectangulos;
  // Barra de estado que muestra la cantidad de figuras.
  private final JLabel barraEstado;


  /**
   * Constructor: inicializa la ventana, genera las figuras y configura la barra de estado.
   *
   * @param cantidadFiguras cantidad de figuras a generar (debe ser >= 3)
   * @throws IllegalArgumentException si cantidadFiguras < 3
   */
  public DibujoFiguras(int cantidadFiguras) {
    this.barraEstado = new JLabel();
    this.setSize(ANCHO_PANTALLA, ALTO_PANTALLA);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.add(barraEstado, BorderLayout.SOUTH);

    cargarFiguras(cantidadFiguras);

    // La visibilidad se controla fuera del constructor
    this.add(cargarPanel(), BorderLayout.CENTER);
  }

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

  /**
   * Determina la cantidad de figuras de cada tipo (líneas, óvalos, rectángulos) de forma balanceada y aleatoria.
   * Modifica las variables numLineas, numOvalos y numRectangulos.
   *
   * @param numFiguras cantidad total de figuras a generar
   */
  private void cargarFiguras(int numFiguras) {
    Random rand = new Random();
    // Inicializar el array de figuras
    this.figuras = new Figura[numFiguras];

    for (int i = 0; i < numFiguras; i++) {
      int tipoFigura = rand.nextInt(3);
      // Propiedades generales de cualquier figura.
      int x1 = rand.nextInt(ANCHO_PANTALLA);
      int y1 = rand.nextInt(ALTO_PANTALLA);
      int x2 = rand.nextInt(ANCHO_PANTALLA);
      int y2 = rand.nextInt(ALTO_PANTALLA);
      Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

      if (tipoFigura == 0) {
        figuras[i] = new Linea(x1, y1, x2, y2, color);
        this.numLineas++;
      } else if (tipoFigura == 1) {
        this.numOvalos++;
        boolean relleno = rand.nextBoolean();
        figuras[i] = new Ovalo(x1, y1, x2, y2, color, relleno);
      } else {
        this.numRectangulos++;
        boolean relleno = rand.nextBoolean();
        figuras[i] = new Rectangulo(x1, y1, x2, y2, color, relleno);
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
        // Verificar que el array de figuras no sea null al inicio
        if (figuras != null) {
          // Dibujar todas las figuras con su propio metodo.
          for (Figura figura : figuras) {
            if (figura != null) {
              figura.dibujar(g);
            }
          } // fin for
        } // fin if
      } // fin paintComponent
    }; // fin return (new JPanel() { ...)
  }
}
