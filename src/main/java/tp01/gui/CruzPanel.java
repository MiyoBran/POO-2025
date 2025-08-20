package tp01.gui;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Panel que dibuja dos líneas (vertical y horizontal) centradas, dividiendo el panel en 4 cuadrados.
 */
public class CruzPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        int cx = w / 2;
        int cy = h / 2;
        g.setColor(Color.RED);
        // Línea vertical centrada
        g.drawLine(cx, 0, cx, h);
        // Línea horizontal centrada
        g.drawLine(0, cy, w, cy);
    }
}
