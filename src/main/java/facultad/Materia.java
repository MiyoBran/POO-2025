package facultad;

import exceptions.MateriaRepetidaException;
import java.util.Objects;

public class Materia {
    private int codigo;
    private String nombre;
    private java.util.List<Materia> correlativas;

    public Materia(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    this.correlativas = new java.util.ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
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
        return "Materia{" +
                "codigo=" + codigo +
                ", nombre=" + nombre +
                '}';
    }

    public Materia agregarCorrelativa(Materia materia) throws MateriaRepetidaException {
        if (this.correlativas.contains(materia)) {
            throw new MateriaRepetidaException();
        }
        this.correlativas.add(materia);
        return materia;
    }
}
