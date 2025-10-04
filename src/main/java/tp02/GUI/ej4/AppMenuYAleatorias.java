package tp02.GUI.ej4;

import tp02.GUI.ej3.Figura;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

public class AppMenuYAleatorias {
  public static void main(String[] args) {

    Figura[] figuras;

    // Obtener las dimensiones de la pantalla.
    Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int ancho = (int) dim.getWidth();
    int alto = (int) dim.getHeight();


    // Solicitar la cantidad de figuras a crear
    int cantidadFiguras = solicitarCantidadFiguras();
    // Crear las figuras aleatorias
    figuras = FiguraFactory.crearFigurasAleatorias(cantidadFiguras, ancho, alto);

    // Crear y mostrar el panel
    JFrame frame = new JFrame("Panel de Dibujo Con Menu - Prueba Figuras");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(ancho, alto);
    frame.add(new PanelDibujoMenu(figuras));
    frame.setVisible(true);
  }
  
  // Metodo para solicitar la cantidad de figuras a crear.
  public static int solicitarCantidadFiguras() {
      int numFiguras = 0;
      boolean valido = false;
      while (!valido) {
          try {
              String input = JOptionPane.showInputDialog(null, "Cantidad de figuras (mayor a 0)", "Figuras", JOptionPane.QUESTION_MESSAGE);
              if (input == null) {
                  // User cancelled dialog
                  JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                  return 0;
              }
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
}
