// PrologoMetodo.java

package carlosfontela.anotaciones;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target (ElementType.METHOD)
public @interface PrologoMetodo {

	String autor( );
	String fechaUltimaModificacion( );
	int version( ) default 1;

}
