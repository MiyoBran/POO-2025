package tp1.empresa;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una tp1.empresa que gestiona empleados y departamentos.
 * Permite agregar empleados y departamentos, y consultar relaciones entre ellos.
 */
public class Empresa {
	private String nombre;
	private String direccion;
	private List<Empleado> empleados;
	private List<Departamento> departamentos;

	public Empresa(String nombre, String direccion) {

		this.nombre = nombre;
		this.direccion = direccion;
		empleados = new ArrayList<Empleado>();
		departamentos = new ArrayList<Departamento>();

	}

	public Empleado agregarEmpleado(int legajo, String nombre, Empleado supervisor, Departamento departamento) {
		Empleado empleado = new Empleado(legajo, nombre, supervisor, departamento);
		empleados.add(empleado);
		return empleado;
	}

	public Departamento agregarDepartamento(int codigo, String nombre) {
		Departamento departamento = new Departamento(codigo, nombre);
		departamentos.add(departamento);
		return departamento;
	}

	public List<Empleado> empleadoPorDepartamento(Departamento departamento) {
		List<Empleado> empDep = new ArrayList<Empleado>();
		for (Empleado emp : empleados) {			
			if (emp.getDepartamento().equals(departamento))
				empDep.add(emp);
		}
		return empDep;
	}

	public Empleado supervisor(Empleado empleado) {
		return empleado.getSupervisor();
	}

	public List<Empleado> empleadosCargo(Empleado empleado) {
		List<Empleado> empsCargo = new ArrayList<Empleado>();

		for (Empleado emp : empleados)
			if (emp.getSupervisor() != null
					&& emp.getSupervisor().equals(empleado))
				empsCargo.add(emp);

		return empsCargo;
	}

	public List<Empleado> supervisoresJerarquia(Empleado empleado) {

		List<Empleado> jerarquia = new ArrayList<Empleado>();
		Empleado emp = this.supervisor(empleado);

		while (emp != null) {
			jerarquia.add(emp);
			emp = this.supervisor(emp);
		}

		return jerarquia;
	}
	
}
