package tp01.GUI;

import javax.swing.JFrame;

/**
 * Ventana principal que muestra un panel con una cruz centrada.
 */
public class VentanaCruz extends JFrame {
    public VentanaCruz() {
        setTitle("Cruz centrada");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new CruzPanel());
        setVisible(true);
    }
}