package tp01.gui.ej4;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
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
    private MiLinea[] lineas;
    /**
     * Arreglo de óvalos a dibujar.
     */
    private MiOvalo[] ovalos;
    /**
     * Arreglo de rectángulos a dibujar.
     */
    private MiRectangulo[] rectangulos;
    /**
     * Barra de estado que muestra la cantidad de figuras.
     */
    private JLabel barraEstado;
    /**
     * Dimensiones fijas de la ventana.
     */
    private static final int ANCHO_PANTALLA = 800;
    private static final int ALTO_PANTALLA = 600;
    /**
     * Cantidad mínima y máxima de figuras por tipo.
     */
    private static final int MIN_FIGURAS = 5;
    private static final int MAX_FIGURAS = 10;

    /**
     * Constructor: inicializa la ventana, genera las figuras y configura la barra de estado.
     */
    public Dibujo() {
        this.barraEstado = new JLabel();
        this.setSize(ANCHO_PANTALLA, ALTO_PANTALLA);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(barraEstado, BorderLayout.SOUTH);
        cargarFiguras();
        this.add(cargarPanel(), BorderLayout.CENTER);
        this.setVisible(true);
    }

    /**
     * Genera arreglos de figuras aleatorias (líneas, óvalos y rectángulos) y actualiza la barra de estado.
     * Las figuras se generan una sola vez y se mantienen fijas durante la vida de la ventana.
     */
    private void cargarFiguras() {
        Random rand = new Random();

        // Crear de 5 a 10 líneas
        int numLineas = rand.nextInt(MIN_FIGURAS, MAX_FIGURAS + 1);
        lineas = new MiLinea[numLineas];
        for (int i = 0; i < numLineas; i++) {
            int x1 = rand.nextInt(ANCHO_PANTALLA/2);
            int y1 = rand.nextInt(ALTO_PANTALLA/2);
            int x2 = rand.nextInt(ANCHO_PANTALLA/2);
            int y2 = rand.nextInt(ALTO_PANTALLA/2);
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            lineas[i] = new MiLinea(x1, y1, x2, y2, color);
        }

        // Crear de 5 a 10 óvalos
        int numOvalos = rand.nextInt(MIN_FIGURAS, MAX_FIGURAS + 1);
        ovalos = new MiOvalo[numOvalos];
        for (int i = 0; i < numOvalos; i++) {
            int x = rand.nextInt(ANCHO_PANTALLA/2);
            int y = rand.nextInt(ALTO_PANTALLA/2);
            int ancho = rand.nextInt(ANCHO_PANTALLA/2);
            int alto = rand.nextInt(ALTO_PANTALLA/2);
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            boolean relleno = rand.nextBoolean();
            ovalos[i] = new MiOvalo(x, y, ancho, alto, color, relleno);
        }

        // Crear de 5 a 10 rectángulos
        int numRectangulos = rand.nextInt(MIN_FIGURAS, MAX_FIGURAS + 1);
        rectangulos = new MiRectangulo[numRectangulos];
        for (int i = 0; i < numRectangulos; i++) {
            int x = rand.nextInt(ANCHO_PANTALLA/2);
            int y = rand.nextInt(ALTO_PANTALLA/2);
            int ancho = rand.nextInt(ANCHO_PANTALLA/2);
            int alto = rand.nextInt(ALTO_PANTALLA/2);
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            boolean relleno = rand.nextBoolean();
            rectangulos[i] = new MiRectangulo(x, y, ancho, alto, color, relleno);
        }

        // Actualizar la barra de estado con la cantidad de figuras generadas
        barraEstado.setText("Líneas: " + numLineas + ", Ovalos: " + numOvalos + ", Rectángulos: " + numRectangulos);
    }

    /**
     * Crea y retorna un panel personalizado que dibuja las figuras almacenadas.
     * El método paintComponent solo recorre y dibuja los arreglos, sin regenerar figuras.
     * @return JPanel personalizado para el dibujo.
     */
    private JPanel cargarPanel() {
      return new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g); // Limpia la pantalla

          // Dibujar todas las líneas
          for (MiLinea linea : lineas) {
            linea.dibujar(g);
          }

          // Dibujar todos los óvalos
          for (MiOvalo ovalo : ovalos) {
            ovalo.dibujar(g);
          }

          // Dibujar todos los rectángulos
          for (MiRectangulo rectangulo : rectangulos) {
            rectangulo.dibujar(g);
          }
        }
      };
    }

}
