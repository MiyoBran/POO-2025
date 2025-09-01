package tp02.GUI.ej4;

import tp02.GUI.ej3.Figura;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class AppMenuYAleatorias {
  public static void main(String[] args) {


    private final Figura[] figuras;
    private final JPanel panelDibujo;
    private int figuraSeleccionada = -1; // -1: ninguna, 0: todas, >0: índice-1
    private int paso = 10;
    private Color colorActual = Color.BLACK;

    // Obtener las dimensiones de la pantalla
    Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int ancho = (int) dim.getWidth();
    int alto = (int) dim.getHeight();


    // Solicitar la cantidad de figuras a crear
    int cantidadFiguras = CrearFigurasAleatoria.solicitarCantidadFiguras();
    // Crear las figuras aleatorias
    figuras = CrearFigurasAleatoria.crearFigurasAleatorias(cantidadFiguras, ancho, alto);

    // Crear y mostrar el panel
    JFrame frame = new JFrame("Panel de Dibujo Con Menu - Prueba Figuras");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(alto, ancho);
//    frame.add(new PanelDibujoMenu(figuras));
    frame.setVisible(true);
  }
}
