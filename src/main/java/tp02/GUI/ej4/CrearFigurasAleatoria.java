package tp02.GUI.ej4;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CrearFigurasAleatoria {



  // Metodo para solicitar la cantidad de figuras a crear.
  public static int solicitarCantidadFiguras() {
    int numFiguras = 0;
    boolean valido = false;
    while (!valido) {
      try {
        String input = JOptionPane.showInputDialog(null, "Cantidad de figuras (mayor a 0)", "Figuras", JOptionPane.QUESTION_MESSAGE);
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
