package tp02.GUI.ej1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

/**
 * Representa un óvalo con posición, tamaño, color y si es relleno o no.
 * Utilizado para el dibujo de óvalos aleatorios en el ejercicio 4.
 */
public class MiOvalo extends MiFigura {
    // La clase "Padre" tiene X1, Y1 y Color.
    // Acá tenemos Ancho, Alto y Relleno.
    /** Ancho del óvalo. */
    private int ancho;
    /** Alto del óvalo. */
    private int alto;
    /** Indica si el óvalo es relleno o solo contorno. */
    private boolean relleno;

    // Constructor por defecto.
    public MiOvalo() {
      super(); // Llama al constructor de MiFigura (X1=0, Y1=0, Color= black)
      this.ancho = 0;
      this.alto = 0;
      this.relleno = false;
    }

    /**
     * Constructor del óvalo.
     * @see MiFigura#MiFigura(int, int, Color)
     * @param x coordenada X del óvalo
     * @param y coordenada Y del óvalo
     * @param ancho ancho del óvalo
     * @param alto alto del óvalo
     * @param color color del óvalo
     * @param relleno true si es relleno, false si es solo contorno
     */
    public MiOvalo(int x, int y, int ancho, int alto, Color color, boolean relleno) {
        super(x, y, color); // Llama al constructor de MiFigura
        this.ancho = ancho;
        this.alto = alto;
        this.relleno = relleno;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }


    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MiOvalo)) return false;
        if (!super.equals(o)) return false;
        MiOvalo miOvalo = (MiOvalo) o;
        return ancho == miOvalo.ancho
            && alto == miOvalo.alto
            && relleno == miOvalo.relleno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ancho, alto, relleno);
    }

    @Override
    public String toString() {
        return "MiOvalo{" +
                "x=" + getX1() +
                ", y=" + getY1() +
                ", ancho=" + ancho +
                ", alto=" + alto +
                ", color=" + getColor() +
                ", relleno=" + relleno +
                '}';
    }

    /**
     * Dibuja el óvalo en el contexto gráfico dado.
     * @param g contexto gráfico
     */
    @Override
    public void dibujar(Graphics g) {
        g.setColor(getColor());
        if (relleno) {
            g.fillOval(getX1(), getY1(), ancho, alto);
        } else {
            g.drawOval(getX1(), getY1(), ancho, alto);
        }
    }

}
