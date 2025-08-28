package tp02.GUI.ej4;

import tp02.GUI.ej3.Figura;

import java.awt.*;
import javax.swing.*;

/**
 * Programa de prueba que despliega un panel. En el constructor del mismo
 * recibir una lista de figuras
 * */
public class PanelDibujoMenu extends JPanel {


  private final Figura[] figuras;
  private final JPanel panelDibujo;
  private int figuraSeleccionada = -1; // -1: ninguna, 0: todas, >0: índice-1
  private int paso = 10;
  private Color colorActual = Color.BLACK;

  /**
   * Constructor que recibe una lista de figuras a dibujar
   */
  public PanelDibujoMenu(Figura[] figuras) {
    super();
    this.figuras = figuras;
    setLayout(new BorderLayout());

    // Crear y agregar el panel de dibujo principal
    panelDibujo = crearPanelDibujo();
    add(panelDibujo, BorderLayout.CENTER);

    // Crear y agregar el panel de menú
    JPanel panelMenu = crearPanelMenu();
    add(panelMenu, BorderLayout.SOUTH);
  }

  /**
   * Crea el panel principal donde se dibujarán las figuras
   */
  private JPanel crearPanelDibujo() {
    JPanel panel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (figuras != null) {
          for (Figura figura : figuras) {
            figura.dibujar(g);
          }
        }
      }
    };

    // Configuración del panel de dibujo
    panel.setBackground(Color.WHITE);
    panel.setPreferredSize(new Dimension(getWidth(), getHeight()));

    return panel;
  }

  /**
   * Crea el panel con los botones del menú
   */
  private JPanel crearPanelMenu() {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.CENTER));

    // Crear botones
    // Botones del menú
    JButton btnFigura = new JButton("Figura");
    JButton btnColor = new JButton("Color");
    JButton btnPaso = new JButton("Paso");
    JButton btnIzquierda = new JButton("Izquierda");
    JButton btnDerecha = new JButton("Derecha");
    JButton btnArriba = new JButton("Arriba");
    JButton btnAbajo = new JButton("Abajo");


    // Agregar botones al panel
    panel.add(btnFigura);
    panel.add(btnColor);
    panel.add(btnPaso);
    panel.add(btnIzquierda);
    panel.add(btnDerecha);
    panel.add(btnArriba);
    panel.add(btnAbajo);


    // Configurar listeners de los botones
    btnFigura.addActionListener(e -> seleccionarFigura());
    btnColor.addActionListener(e -> cambiarColor());
    btnPaso.addActionListener(e -> cambiarPaso());
    btnIzquierda.addActionListener(e -> moverIzquierda());
    btnArriba.addActionListener(e -> moverArriba());
    btnAbajo.addActionListener(e -> moverAbajo());
    btnDerecha.addActionListener(e -> moverDerecha());

    return panel;
  }

  // Métodos de cada acción del menú

  private void seleccionarFigura() {
    String input = JOptionPane.showInputDialog(this,
        "Ingrese el número de figura (0 para todas):",
        "Seleccionar Figura",
        JOptionPane.QUESTION_MESSAGE);
    if (input != null) {
      try {
        int idx = Integer.parseInt(input);
        if (idx < 0 || idx > figuras.length) {
          JOptionPane.showMessageDialog(this,
              "Número fuera de rango.",
              "Error",
              JOptionPane.ERROR_MESSAGE);
        } else {
          figuraSeleccionada = idx;
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
            "Debe ingresar un número válido.",
            "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  private void cambiarColor() {
    Color nuevoColor = JColorChooser.showDialog(this, "Seleccione un color", colorActual);
    if (nuevoColor != null) {
      colorActual = nuevoColor;
      aplicarColor();
      panelDibujo.repaint(); // Solo repinta el panel de dibujo
    }
  }

  private void cambiarPaso() {
    String input = JOptionPane.showInputDialog(this,
        "Ingrese el paso (píxeles):",
        String.valueOf(paso));
    if (input != null) {
      try {
        int nuevoPaso = Integer.parseInt(input);
        if (nuevoPaso <= 0) {
          JOptionPane.showMessageDialog(this,
              "El paso debe ser mayor a 0.",
              "Error",
              JOptionPane.ERROR_MESSAGE);
        } else {
          paso = nuevoPaso;
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
            "Debe ingresar un número válido.",
            "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  private void moverIzquierda() {
    moverFiguras(-paso, 0);
  }

  private void moverArriba() {
    moverFiguras(0, -paso);
  }

  private void moverAbajo() {
    moverFiguras(0, paso);
  }

  private void moverDerecha() {
    moverFiguras(paso, 0);
  }

  /**
   * Mueve las figuras seleccionadas según el desplazamiento especificado
   */
  private void moverFiguras(int dx, int dy) {
    if (figuraSeleccionada == 0) {
      // Mover todas las figuras
      for (Figura f : figuras) {
        f.trasladar(dx, dy);
      }
    } else if (figuraSeleccionada > 0 && figuraSeleccionada <= figuras.length) {
      // Mover figura específica
      figuras[figuraSeleccionada - 1].trasladar(dx, dy);
    }
    panelDibujo.repaint(); // Solo repinta el panel de dibujo
  }

  /**
   * Aplica el color actual a las figuras seleccionadas
   */
  private void aplicarColor() {
    if (figuraSeleccionada == 0) {
      // Aplicar color a todas las figuras
      for (Figura f : figuras) {
        f.setColor(colorActual);
      }
    } else if (figuraSeleccionada > 0 && figuraSeleccionada <= figuras.length) {
      // Aplicar color a figura específica
      figuras[figuraSeleccionada - 1].setColor(colorActual);
    }
  }
}
