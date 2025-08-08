package empresa;

import empresa.Departamento;
import empresa.Empleado;
import empresa.Empresa;

public class PruebaEmpresa {

	public static void main(String[] args) {

		Empresa arcor = new Empresa("Arcor", "Arroyito Cordoba");

		// agregando departamentos y empleados a la empresa

		Departamento gerencia = arcor.agregarDepartamento(1, "Gerencia");
		Departamento ventas = arcor.agregarDepartamento(2, "Ventas");
		Departamento produccion = arcor.agregarDepartamento(3, "Produccion");
		
		// agregando empleados a los departamentos, con formato "ID, Nombre, Supervisor, Departamento"
		Empleado gerente = arcor.agregarEmpleado(1, "Juan Perez", null, gerencia);
		Empleado secretaria2= arcor.agregarEmpleado(2, "Silvia Perez", gerente, gerencia);
		Empleado supervisorVentas = arcor.agregarEmpleado(3, "Ignacio Ramirez", gerente, ventas);
		Empleado operarioVentas = arcor.agregarEmpleado(4, "Ruben Aguirre", supervisorVentas, ventas);
		Empleado supervisorProd = arcor.agregarEmpleado(5, "Carlos Villagran", gerente, produccion);
		Empleado operarioProd = arcor.agregarEmpleado(6, "Maria Fernandez", supervisorProd, produccion);

		// mostrar empleados de un departamento
		Departamento d = gerencia;
		System.out.println("Empleados del departamento " + d + ": ");
		for (Empleado emp : arcor.empleadoPorDepartamento(d))
			System.out.println(emp);

		// cantidad de empleados en un departamento
		System.out.println();
		System.out.println(
				"Cantidad de empleados en el departamento " + d + ": " + arcor.empleadoPorDepartamento(d).size());

		// supervisor de un empleado
		System.out.println();
		System.out.println("supervisor de secretaria: " + arcor.supervisor(secretaria2));

		// supervisores jerarquia empleado
		System.out.println();
		System.out.println("Jerarquia de operario Produccion");
		for (Empleado emp : arcor.supervisoresJerarquia(operarioProd))
			System.out.println(emp);

		// empleados a cargo 
		System.out.println();
		System.out.println("Empleados a cargo de supervisor Ventas");
		for (Empleado emp : arcor.empleadosCargo(supervisorVentas))
			System.out.println(emp);

		System.exit(0);

	}

}
