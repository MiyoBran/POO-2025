package tp1.empresa;

/**
 * Representa un empleado dentro de la tp1.empresa, incluyendo su legajo, nombre,
 * supervisor y departamento.
 */
public class Empleado {
	
	private int legajo;
	private String nombre;
	private Empleado supervisor;
	private Departamento departamento;

	public Empleado(int legajo, String nombre, Empleado supervisor, Departamento departamento){
		
		this.legajo = legajo;
		this.nombre = nombre;
		this.supervisor = supervisor;
		this.departamento = departamento;
		
	}
	
	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Empleado getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Empleado supervisor) {
		this.supervisor = supervisor;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [legajo=" + legajo + ", nombre=" + nombre
				+ ", departamento=" + departamento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + legajo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (legajo != other.legajo)
			return false;
		return true;
	}

	
}
