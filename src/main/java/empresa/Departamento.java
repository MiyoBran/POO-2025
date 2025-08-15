package empresa;

/**
 * Represents a department within a company, identified by a code and a name.
 */
public class Departamento {
	
	private int codigo;
	private String nombre;
	
	public Departamento(int codigo, String nombre){
		
		this.codigo = codigo;
		this.nombre = nombre;
	}
			
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString(){
		
		return nombre;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Departamento other = (Departamento) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}
