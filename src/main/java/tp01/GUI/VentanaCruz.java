package tp01.GUI;

import javax.swing.JFrame;

/**
 * Ventana principal que contiene el panel con la cruz centrada.
 */
public class VentanaCruz extends JFrame {
    public VentanaCruz() {
        setTitle("Cruz centrada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); // Centra la ventana en pantalla
        add(new CruzPanel());
        setVisible(true);
    }
}

