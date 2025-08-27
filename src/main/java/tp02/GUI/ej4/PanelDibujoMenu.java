package tp02.GUI.ej4;

import tp02.GUI.ej3.Figura;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import java.awt.Color;

/**
 * Programa de prueba que despliega un panel. En el constructor del mismo
 * recibir una lista de figuras
 * */
public class PanelDibujoMenu extends JPanel implements PanelMenuFiguras.MenuListener {
  private Figura[] figuras;
  private PanelMenuFiguras panelMenu;
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

    panelMenu = new PanelMenuFiguras();
    panelMenu.setMenuListener(this);
    add(panelMenu, BorderLayout.SOUTH);
  }

  @Override
  public void onSeleccionarFigura() {
    String input = JOptionPane.showInputDialog(this, "Ingrese el número de figura (0 para todas):", "Seleccionar Figura", JOptionPane.QUESTION_MESSAGE);
    if (input != null) {
      try {
        int idx = Integer.parseInt(input);
        if (idx < 0 || idx > figuras.length) {
          JOptionPane.showMessageDialog(this, "Número fuera de rango.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          figuraSeleccionada = idx;
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Debe ingresar un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  @Override
  public void onCambiarColor() {
    Color nuevoColor = JColorChooser.showDialog(this, "Seleccione un color", colorActual);
    if (nuevoColor != null) {
      colorActual = nuevoColor;
      aplicarColor();
      repaint();
    }
  }

  @Override
  public void onCambiarPaso() {
    String input = JOptionPane.showInputDialog(this, "Ingrese el paso (píxeles):", paso);
    if (input != null) {
      try {
        int nuevoPaso = Integer.parseInt(input);
        if (nuevoPaso <= 0) {
          JOptionPane.showMessageDialog(this, "El paso debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          paso = nuevoPaso;
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Debe ingresar un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  @Override
  public void onMoverIzquierda() {
    moverFiguras(-paso, 0);
  }

  @Override
  public void onMoverArriba() {
    moverFiguras(0, -paso);
  }

  @Override
  public void onMoverAbajo() {
    moverFiguras(0, paso);
  }

  @Override
  public void onMoverDerecha() {
    moverFiguras(paso, 0);
  }

  private void moverFiguras(int dx, int dy) {
    if (figuraSeleccionada == 0) {
      for (Figura f : figuras) {
        f.trasladar(dx, dy);
      }
    } else if (figuraSeleccionada > 0 && figuraSeleccionada <= figuras.length) {
      figuras[figuraSeleccionada - 1].trasladar(dx, dy);
    }
    repaint();
  }

  private void aplicarColor() {
    if (figuraSeleccionada == 0) {
      for (Figura f : figuras) {
        f.setColor(colorActual);
      }
    } else if (figuraSeleccionada > 0 && figuraSeleccionada <= figuras.length) {
      figuras[figuraSeleccionada - 1].setColor(colorActual);
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (figuras != null) {
      for (Figura figura : figuras) {
        figura.dibujar(g);
      }
    }
  }
}
