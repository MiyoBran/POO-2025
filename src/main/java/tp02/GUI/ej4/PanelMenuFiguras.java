package tp02.GUI.ej4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Panel de menú inferior con 7 botones para controlar las figuras.
 */
public class PanelMenuFiguras extends JPanel {
    public JButton btnFigura;
    public JButton btnColor;
    public JButton btnPaso;
    public JButton btnIzquierda;
    public JButton btnArriba;
    public JButton btnAbajo;
    public JButton btnDerecha;

    public interface MenuListener {
        void onSeleccionarFigura();
        void onCambiarColor();
        void onCambiarPaso();
        void onMoverIzquierda();
        void onMoverArriba();
        void onMoverAbajo();
        void onMoverDerecha();
    }

    private MenuListener listener;

    public void setMenuListener(MenuListener listener) {
        this.listener = listener;
    }

    public PanelMenuFiguras() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        btnFigura = new JButton("Figura");
        btnColor = new JButton("Color");
        btnPaso = new JButton("Paso");
        btnIzquierda = new JButton("Izquierda");
        btnArriba = new JButton("Arriba");
        btnAbajo = new JButton("Abajo");
        btnDerecha = new JButton("Derecha");

        add(btnFigura);
        add(btnColor);
        add(btnPaso);
        add(btnIzquierda);
        add(btnArriba);
        add(btnAbajo);
        add(btnDerecha);

        btnFigura.addActionListener(e -> { if (listener != null) listener.onSeleccionarFigura(); });
        btnColor.addActionListener(e -> { if (listener != null) listener.onCambiarColor(); });
        btnPaso.addActionListener(e -> { if (listener != null) listener.onCambiarPaso(); });
        btnIzquierda.addActionListener(e -> { if (listener != null) listener.onMoverIzquierda(); });
        btnArriba.addActionListener(e -> { if (listener != null) listener.onMoverArriba(); });
        btnAbajo.addActionListener(e -> { if (listener != null) listener.onMoverAbajo(); });
        btnDerecha.addActionListener(e -> { if (listener != null) listener.onMoverDerecha(); });
    }
}
