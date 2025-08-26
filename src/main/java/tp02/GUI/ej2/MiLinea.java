package tp02.GUI.ej2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

/**
 * Clase que representa una línea en el plano, definida por un punto inicial (x1, y1)
 * heredado de MiFigura y un punto final (x2, y2), junto con un color.
 * <p>
 * Permite crear líneas con valores por defecto (en el origen y color negro) o
 * con valores personalizados para las coordenadas y el color.
 * </p>
 */
public class MiLinea extends MiFigura {
    /** Coordenada X del punto final. */
    private int x2;
    /** Coordenada Y del punto final. */
    private int y2;

    /**
     * Constructor sin argumentos.
     * <p>
     * Inicializa la línea en el origen (0,0)-(0,0) y color negro.
     * Utiliza el constructor por defecto de la superclase MiFigura.
     * </p>
     */
    public MiLinea() {
        super();
        this.x2 = 0;
        this.y2 = 0;
    }

    /**
     * Constructor que permite especificar las coordenadas y el color de la línea.
     * <p>
     * El punto inicial (x1, y1) y el color se pasan a la superclase MiFigura.
     * El punto final (x2, y2) se asigna en esta clase.
     * </p>
     * @param x1 coordenada X del punto inicial
     * @param y1 coordenada Y del punto inicial
     * @param x2 coordenada X del punto final
     * @param y2 coordenada Y del punto final
     * @param color color de la línea
     */
    public MiLinea(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, color);
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    /**
     * Dibuja la línea en el contexto gráfico dado.
     * @param g contexto gráfico
     */
    @Override
    public void dibujar(Graphics g) {
        g.setColor(super.getColor());
        g.drawLine(super.getX1(), super.getY1(), x2, y2);
    }

    /**
     * Compara igualdad por valor de x1, y1, color (heredados) y x2, y2 (propios).
     * @param o objeto a comparar
     * @return true si es del mismo tipo y tiene los mismos valores en todos los campos relevantes
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MiLinea miLinea)) return false;
        if (!super.equals(o)) return false;
        return x2 == miLinea.x2 && y2 == miLinea.y2;
    }

    /**
     * Calcula el hashCode en base a los campos heredados y x2, y2.
     * @return hashCode consistente con equals
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), x2, y2);
    }

    @Override
    public String toString() {
        return "MiLinea{" +
                "x1=" + super.getX1() +
                ", y1=" + super.getY1() +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", color=" + super.getColor() +
                '}';
    }
}
