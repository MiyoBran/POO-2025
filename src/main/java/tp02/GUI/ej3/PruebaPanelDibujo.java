package tp02.GUI.ej3;

import javax.swing.*;
import java.awt.*;

public class PruebaPanelDibujo {
  public static void main(String[] args) {
    // Crear figuras simples
    Punto centro1 = new Punto(100, 100);
    Elipse elipse1 = new Elipse(50, 30, centro1, 0, false, Color.RED);
    elipse1.setColor(Color.RED);

    // Elipse con ambos radios iguales = circulo
    Punto centro2 = new Punto(250, 100);
    Elipse elipse2 = new Elipse(40, 40, centro2, 0, true, Color.BLUE);
    elipse2.setColor(Color.BLUE);

    // Triangulo
    Punto[] verticesTriangulo = {
      new Punto(150, 200),
      new Punto(200, 250),
      new Punto(100, 250)
    };
    Poligono triangulo = new Poligono(verticesTriangulo);
    triangulo.setColor(Color.GREEN);

    // rectangulo sin relleno
    Punto[] verticesRectangulo = {
      new Punto(170, 150), // inf izq
      new Punto(270, 150), // inf der
      new Punto(270, 200), // sup der
      new Punto(170, 200)  // sup izq
    };
    Poligono rectangulo = new Poligono(verticesRectangulo);
    rectangulo.setColor(Color.ORANGE);
    rectangulo.setRelleno(true);

    // Pentagono con relleno
    Punto[] verticesPentagono = {
      new Punto(220, 200),
      new Punto(320, 200),
      new Punto(320, 250),
      new Punto(220, 250),
      new Punto(200, 250)
    };
    Poligono pentagono = new Poligono(verticesPentagono,Color.CYAN, false);


        // Figura compuesta: elipse1 + triangulo
    Figura[] componentesCompuesta = {rectangulo, pentagono};
    FiguraCompuesta compuesta = new FiguraCompuesta(componentesCompuesta);
    compuesta.setColor(Color.MAGENTA);

    // Lista de figuras a mostrar
    Figura[] figuras = {elipse1, elipse2, triangulo, compuesta};

    // Crear y mostrar el panel
    JFrame frame = new JFrame("Panel de Dibujo - Prueba Figuras");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.add(new PanelDibujo(figuras));
    frame.setVisible(true);
  }
}

