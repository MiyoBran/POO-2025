package facultad;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa un profesor de la facultad, con legajo, nombre, apellido, datos personales y materias que dicta.
 */
public class Profesor {
    private int legajo;
    private String nombre;
    private String apellido;
    private List<Materia> materias;
    private DatosPersonales datosPersonales;

    /**
     * Constructor básico. Inicializa datos personales vacíos.
     */
    public Profesor(int legajo, String nombre, String apellido) {
        this(legajo, nombre, apellido, "", "", "", "");
    }

    /**
     * Constructor completo.
     * @param legajo Legajo del profesor
     * @param nombre Nombre del profesor
     * @param apellido Apellido del profesor
     * @param calle Calle del domicilio
     * @param ciudad Ciudad
     * @param telefono Teléfono
     * @param mail Correo electrónico
     */
    public Profesor(int legajo, String nombre, String apellido, String calle, String ciudad, String telefono, String mail) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.materias = new ArrayList<>();
        this.datosPersonales = new DatosPersonales(calle, ciudad, telefono, mail);
    }

    /**
     * Devuelve el legajo del profesor.
     */
    public int getLegajo() {
        return legajo;
    }

    /**
     * Devuelve el nombre del profesor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el apellido del profesor.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Devuelve la lista de materias que dicta el profesor.
     */
    public List<Materia> getMaterias() {
        return materias;
    }

    /**
     * Devuelve los datos personales del profesor.
     */
    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    /**
     * Agrega una materia a la lista de materias que dicta el profesor.
     * @param materia Materia a agregar
     * @return La materia agregada
     * @throws MateriaRepetidaException Si la materia ya está en la lista
     * @throws IllegalArgumentException Si la materia es null
     */
    public Materia agregarMateria(Materia materia) throws MateriaRepetidaException {
        if (materia == null) {
            throw new IllegalArgumentException("La materia no puede ser null");
        }
        if (materias.contains(materia)) {
            throw new MateriaRepetidaException();
        }
        this.materias.add(materia);
        return materia;
    }

    /**
     * Elimina una materia de la lista de materias que dicta el profesor.
     * @param materia Materia a eliminar
     * @return true si la materia fue eliminada, false si no estaba en la lista
     */
    public boolean quitarMateria(Materia materia) {
        return materias.remove(materia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profesor profesor)) return false;
        return legajo == profesor.legajo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(legajo);
    }

    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder("Profesor{" +
                "legajo=" + legajo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", datosPersonales=" + datosPersonales +
                ", materias=[");
        for (Materia m : this.materias) {
            mensaje.append(m).append(", ");
        }
        if (!materias.isEmpty()) {
            mensaje.setLength(mensaje.length() - 2);
        }
        mensaje.append("]}");
        return mensaje.toString();
    }
}
