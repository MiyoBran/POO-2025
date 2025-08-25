package tp01.gui.ej3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;

/**
 * Panel que dibuja 10 figuras rellenas (rectángulos u óvalos) con
 * colores, posiciones y tamaños aleatorios. Al redimensionar la
 * ventana, se repintan nuevas figuras ajustadas al tamaño actual.
 */
public class FigurasRandomPanel extends JPanel {

    /**
     * Constructor: agrega un listener para repintar cuando el componente
     * cambie de tamaño, garantizando que las figuras se redibujen.
     */
    FigurasRandomPanel() {

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Ante cualquier cambio de tamaño, forzar un repintado
                repaint();
            }
        });
    }

    /**
     * Dibuja 10 figuras rellenas aleatorias. En cada iteración:
     * - Elige si dibujar un rectángulo u óvalo
     * - Genera un color aleatorio
     * - Calcula posiciones y dimensiones en función del tamaño del panel
     *   (anchos/altos limitados a la mitad del panel)
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpia el panel antes de dibujar

        // Generador de números aleatorios para colores, tamaños y posiciones
        Random rand = new Random();

        // Medidas actuales del panel, base para posiciones y límites
        int width = getWidth();
        int height = getHeight();

        // Dibujar exactamente 10 figuras
        for (int i = 0; i < 10; i++) {
            // 1) Color aleatorio (RGB de 0 a 255)
            int r = rand.nextInt(256);
            int gColor = rand.nextInt(256);
            int b = rand.nextInt(256);
            Color randomColor = new Color(r, gColor, b);
            g.setColor(randomColor);

            // 2) Dimensiones aleatorias, limitadas a la mitad del ancho/alto
            int shapeWidth = rand.nextInt(width / 2);
            int shapeHeight = rand.nextInt(height / 2);

            // 3) Posiciones aleatorias que mantengan la figura dentro del panel
            int x = rand.nextInt(width - shapeWidth);
            int y = rand.nextInt(height - shapeHeight);

            // 4) Elegir aleatoriamente entre rectángulo u óvalo relleno
            if (rand.nextBoolean()) {
                g.fillRect(x, y, shapeWidth, shapeHeight);
            } else {
                g.fillOval(x, y, shapeWidth, shapeHeight);
            }
        }
    }

    /**
     * Crea un JFrame básico y centra la ventana en la pantalla.
     * @return frame configurado con el panel de figuras.
     */
    public static JFrame crearFrame() {
        JFrame frame = new JFrame("");
        frame.add(new FigurasRandomPanel());
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        return frame;
    }

    /**
     * Punto de entrada para ejecutar el ejemplo de forma independiente.
     */
    public static void main(String[] args) {
        JFrame frame = crearFrame();
        frame.setVisible(true);
    }
}
