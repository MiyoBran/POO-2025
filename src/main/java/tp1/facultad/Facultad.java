package tp1.facultad;

import java.util.ArrayList;
import java.util.List;

public class Facultad {
  private final String nombre;
  private final String ubicacion;
  private final List<Profesor> profesores;
  private final List<Alumno> alumnos;
  private final List<Materia> materias;

  public Facultad(String nombre, String direccion) {
    this.nombre = nombre;
    this.ubicacion = direccion;
    this.profesores = new ArrayList<>();
    this.alumnos = new ArrayList<>();
    this.materias = new ArrayList<>();
  }

  public String getNombre() {
    return nombre;
  }



  @Override
  public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Facultad{")
        .append("nombre='").append(nombre).append('\'')
        .append(", ubicacion='").append(ubicacion).append('\'')
        .append(", cantidadProfesores=").append(profesores.size())
        .append(", cantidadAlumnos=").append(alumnos.size())
        .append(", cantidadMaterias=").append(materias.size())
        .append("}\n");

      sb.append("\t---- Materias ----\n");
      for (Materia m : materias) {
          sb.append(m).append('\n');
      }

      sb.append("\t---- Profesores ----\n");
      for (Profesor p : profesores) {
          sb.append(p).append('\n');
      }

      sb.append("\t---- Alumnos ----\n");
      for (Alumno a : alumnos) {
          sb.append(a).append('\n');
      }

      return sb.toString();
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
    Profesor profesor = new Profesor(legajo, nombre, apellido);
    verificarProfesor(profesor);
    if (materia != null) {
      try {
        profesor.agregarMateria(materia);
      } catch (MateriaRepetidaException e) {
        // No debería ocurrir en este contexto
      }
    }
    this.profesores.add(profesor);
    return profesor;
  }

  // Overload used by tests (includes contacto/domicilio info) - extra params are ignored here but preserved
  public Alumno agregarAlumno(int legajo, String nombre, String apellido,
                              String domicilio, String ciudad, String telefono, String email) throws AlumnoRepetidoException {
    Alumno alumno = new Alumno(legajo, nombre, apellido, domicilio, ciudad, telefono, email);
    if (alumnos.contains(alumno)) {
      throw new AlumnoRepetidoException();
    }
    this.alumnos.add(alumno);
    return alumno;
  }

  // Overload used by tests for profesor (includes contacto/domicilio info) - extra params are ignored here but preserved
  public Profesor agregarProfesor(int legajo, String nombre, String apellido, Materia materia,
                                  String domicilio, String ciudad, String telefono, String email) throws ProfesorRepetidoException {
    Profesor profesor = new Profesor(legajo, nombre, apellido, domicilio, ciudad, telefono, email);
    verificarProfesor(profesor);
    if (materia != null) {
      try {
        profesor.agregarMateria(materia);
      } catch (MateriaRepetidaException e) {
        // No debería ocurrir en este contexto
      }
    }
    this.profesores.add(profesor);
    return profesor;
  }

  private void verificarProfesor(Profesor profesor) {
    if (profesores.contains(profesor)) {
      throw new ProfesorRepetidoException();
    }
  }

  /**
   * Devuelve la lista de materias que dicta un profesor (según lista interna del profesor).
   *
   * @param profesor Profesor a consultar
   * @return Lista de materias que dicta el profesor, o lista vacía si no existe
   */
  public List<Materia> materiasPorProfesor(Profesor profesor) {
    if (profesor == null) return new ArrayList<>();
    return profesor.getMaterias();
  }

  /**
   * Devuelve la lista de alumnos que cursan una materia dada.
   *
   * @param materia Materia a consultar
   * @return Lista de alumnos inscriptos en la materia
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
   *
   * @param materia Materia a consultar
   * @return Cantidad de alumnos inscriptos
   */
  public int cantidadAlumnosPorMateria(Materia materia) {
    return alumnosPorMateria(materia).size();
  }

}
