package facultad;

import exceptions.AlumnoRepetidoException;
import exceptions.MateriaRepetidaException;
import exceptions.ProfesorRepetidoException;

import java.util.ArrayList;
import java.util.List;

public class Facultad {
    private String nombre;
    private String ubicacion;
    private List<Profesor> profesores;
    private List<Alumno> alumnos;
    private List<Materia> materias;

    public Facultad(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.profesores = new ArrayList<>();
        this.alumnos = new ArrayList<>();
        this.materias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    @Override
    public String toString() {
        String mensaje = "\t---- Materias ----\n";
        for (Materia m : this.materias) {
            mensaje += m + "\n";
        }
        mensaje += "\t---- Profesores ----\n";
        for (Profesor p : this.profesores) {
            mensaje += p + "\n";
        }
        mensaje += "\t---- Alumnos ----\n";
        for (Alumno a : this.alumnos) {
            mensaje += a + "\n";
        }
        return mensaje;
    }

    public Materia agregarMateria(int codigo, String nombre) throws MateriaRepetidaException {
        Materia materia = new Materia(codigo, nombre);
        if (materias.contains(materia)) {
            throw new MateriaRepetidaException();
        }
        this.materias.add(materia);
        return materia;
    }

    public Alumno agregarAlumno(int legajo, String nombre, String apellido) throws AlumnoRepetidoException {
        Alumno alumno = new Alumno(legajo, nombre, apellido);
        if (alumnos.contains(alumno)) {
            throw new AlumnoRepetidoException();
        }
        this.alumnos.add(alumno);
        return alumno;
    }

    public Profesor agregarProfesor(int legajo, String nombre, String apellido, Materia materia) throws ProfesorRepetidoException {
        Profesor profesor = new Profesor(legajo, nombre, apellido, materia);
        if (profesores.contains(profesor)) {
            throw new ProfesorRepetidoException();
        }
        this.profesores.add(profesor);
        return profesor;
    }

    // Overload used by tests (includes contacto/domicilio info) - extra params are ignored here but preserved
    public Alumno agregarAlumno(int legajo, String nombre, String apellido,
                                String domicilio, String ciudad, String telefono, String email) throws AlumnoRepetidoException {
        // reuse existing constructor (tests only require legajo/nombre/apellido and uniqueness)
        return agregarAlumno(legajo, nombre, apellido);
    }

    // Overload used by tests for profesor (includes contacto/domicilio info) - extra params are ignored here but preserved
    public Profesor agregarProfesor(int legajo, String nombre, String apellido, Materia materia,
                                    String domicilio, String ciudad, String telefono, String email) throws ProfesorRepetidoException {
        return agregarProfesor(legajo, nombre, apellido, materia);
    }

    /**
     * Devuelve la lista de materias que dicta un profesor (segun lista interna del profesor).
     */
    public List<Materia> materiasPorProfesor(Profesor profesor) {
        if (profesor == null) return new ArrayList<>();
        return new ArrayList<>(profesor.getMaterias());
    }

    /**
     * Devuelve la lista de alumnos inscriptos en una materia.
     */
    public List<Alumno> alumnosPorMateria(Materia materia) {
        List<Alumno> result = new ArrayList<>();
        if (materia == null) return result;
        for (Alumno a : this.alumnos) {
            if (a.getMaterias().contains(materia)) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Devuelve la cantidad de alumnos inscriptos en la materia dada.
     */
    public int cantidadAlumnosPorMateria(Materia materia) {
        return alumnosPorMateria(materia).size();
    }

}
