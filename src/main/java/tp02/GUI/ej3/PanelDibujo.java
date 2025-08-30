package tp02.GUI.ej3;

import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * Programa de prueba que despliega un panel. En el constructor del mismo
 * recibir una lista de figuras
 * */
public class PanelDibujo extends JPanel {
  private Figura[] figuras;

  /**
   * Constructor que recibe una lista de figuras a dibujar
   */
  public PanelDibujo(Figura[] figuras) {
    this.figuras = figuras;
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
