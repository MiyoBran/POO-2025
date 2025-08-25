package tp02.GUI.ej1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

/**
 * Clase que representa un rectángulo en el plano, definido por un punto de inicio (x1, y1)
 * heredado de MiFigura, un ancho, un alto y un color. Permite especificar si es relleno o solo contorno.
 * <p>
 * Permite crear rectángulos con valores por defecto (en el origen, tamaño 0 y color negro) o
 * con valores personalizados para las coordenadas, tamaño y color.
 * </p>
 */
public class MiRectangulo extends MiFigura {
    /** Ancho del rectángulo. */
    private int ancho;
    /** Alto del rectángulo. */
    private int alto;
    /** Indica si el rectángulo es relleno o solo contorno. */
    private boolean relleno;

    /**
     * Constructor sin argumentos.
     * <p>
     * Inicializa el rectángulo en el origen (0,0), tamaño 0 y color negro, no relleno.
     * Utiliza el constructor por defecto de la superclase MiFigura.
     * </p>
     */
    public MiRectangulo() {
        super();
        this.ancho = 0;
        this.alto = 0;
        this.relleno = false;
    }

    /**
     * Constructor que permite especificar las coordenadas, tamaño, color y si es relleno.
     * <p>
     * El punto inicial (x, y) y el color se pasan a la superclase MiFigura.
     * </p>
     * @see MiFigura#MiFigura(int, int, Color)
     * @param x coordenada X del punto inicial
     * @param y coordenada Y del punto inicial
     * @param ancho ancho del rectángulo
     * @param alto alto del rectángulo
     * @param color color del rectángulo
     * @param relleno true si es relleno, false si es solo contorno
     */
    public MiRectangulo(int x, int y, int ancho, int alto, Color color, boolean relleno) {
        super(x, y, color);
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

    /**
     * Dibuja el rectángulo en el contexto gráfico dado.
     * @param g contexto gráfico
     */
    @Override
    public void dibujar(Graphics g) {
        g.setColor(super.getColor());
        if (relleno) {
            g.fillRect(super.getX1(), super.getY1(), ancho, alto);
        } else {
            g.drawRect(super.getX1(), super.getY1(), ancho, alto);
        }
    }

    /**
     * Compara igualdad por valor de x1, y1, color (heredados) y ancho, alto, relleno (propios).
     * @param o objeto a comparar
     * @return true si es del mismo tipo y tiene los mismos valores en todos los campos relevantes
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MiRectangulo)) return false;
        if (!super.equals(o)) return false;
        MiRectangulo that = (MiRectangulo) o;
        return ancho == that.ancho && alto == that.alto && relleno == that.relleno;
    }

    /**
     * Calcula el hashCode en base a los campos heredados y ancho, alto, relleno.
     * @return hashCode consistente con equals
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ancho, alto, relleno);
    }

    @Override
    public String toString() {
        return "MiRectangulo{" +
                "x=" + super.getX1() +
                ", y=" + super.getY1() +
                ", ancho=" + ancho +
                ", alto=" + alto +
                ", color=" + super.getColor() +
                ", relleno=" + relleno +
                '}';
    }
}
