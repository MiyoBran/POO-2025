package facultad;

import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

/**
 * Representa una materia de la facultad, con código, nombre y materias correlativas.
 */
public class Materia {
    private int codigo;
    private String nombre;
    private List<Materia> correlativas;

    /**
     * Constructor de Materia.
     * @param codigo Código de la materia
     * @param nombre Nombre de la materia
     */
    public Materia(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la lista de materias correlativas.
     */
    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    /**
     * Agrega una materia correlativa.
     * @param materia Materia a agregar como correlativa
     * @return La materia agregada
     * @throws MateriaRepetidaException Si la materia ya es correlativa
     */
    public Materia agregarCorrelativa(Materia materia) throws MateriaRepetidaException {
        if (this.correlativas.contains(materia)) {
            throw new MateriaRepetidaException();
        }
        this.correlativas.add(materia);
        return materia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Materia materia)) return false;
        return codigo == materia.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Materia{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", correlativas=[");
        for (Materia m : correlativas) {
            sb.append(m.nombre).append(", ");
        }
        if (!correlativas.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]}");
        return sb.toString();
    }
}
