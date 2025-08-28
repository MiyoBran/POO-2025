package tp02.GUI.ej2;

import java.awt.Color;
import java.awt.Graphics;

public class Linea extends Figura {

    // Constructor sin argumentos, crea un punto en (0,0) de colo negro
    public Linea() {
        super();
    }

    // Linea definida por dos puntos (x1,y1) y (x2,y2) y un color
    public Linea(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2 , y2 ,color);
    }

    // Dibuja la linea en el contexto grafico dado
    @Override
    public void dibujar(Graphics g) {
        g.setColor(super.getColor());
        g.drawLine(super.getX1(), super.getY1(), super.getX2(), super.getY2());
    }
}
