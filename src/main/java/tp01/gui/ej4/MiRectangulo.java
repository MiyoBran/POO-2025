package tp01.gui.ej4;

import java.awt.Graphics;
import java.awt.Color;
import java.util.Objects;

/**
 * Representa un rectángulo con posición, tamaño, color y si es relleno o no.
 * Utilizado para el dibujo de rectángulos aleatorios en el ejercicio 4.
 */
public class MiRectangulo {
    /** Coordenada X de la esquina superior izquierda. */
    private int x;
    /** Coordenada Y de la esquina superior izquierda. */
    private int y;
    /** Ancho del rectángulo. */
    private int ancho;
    /** Alto del rectángulo. */
    private int alto;
    /** Color del rectángulo. */
    private Color color;
    /** Indica si el rectángulo es relleno o solo contorno. */
    private boolean relleno;

    /**
     * Constructor del rectángulo.
     * @param x coordenada X
     * @param y coordenada Y
     * @param ancho ancho del rectángulo
     * @param alto alto del rectángulo
     * @param color color del rectángulo
     * @param relleno true si es relleno, false si es solo contorno
     */
    public MiRectangulo(int x, int y, int ancho, int alto, Color color, boolean relleno) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
        this.relleno = relleno;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
        if (!(o instanceof MiRectangulo that)) return false;
        return x == that.x && y == that.y && ancho == that.ancho && alto == that.alto && relleno == that.relleno && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, ancho, alto, color, relleno);
    }

    @Override
    public String toString() {
        return "MiRectangulo{" +
                "x=" + x +
                ", y=" + y +
                ", ancho=" + ancho +
                ", alto=" + alto +
                ", color=" + color +
                ", relleno=" + relleno +
                '}';
    }

    /**
     * Dibuja el rectángulo en el contexto gráfico dado.
     * @param g contexto gráfico
     */
    public void dibujar(Graphics g) {
        g.setColor(color);
        if (relleno) {
            g.fillRect(x, y, ancho, alto);
        } else {
            g.drawRect(x, y, ancho, alto);
        }
    }

}
