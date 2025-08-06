# Copilot Instructions - POO-2025

## 📋 Información del Proyecto

**Nombre**: POO-2025  
**Tipo**: Proyecto académico de Programación Orientada a Objetos en Java  
**Estructura**: Proyecto Maven  
**Autor**: Miyo  
**Repositorio**: https://github.com/MiyoBran/POO-2025  

## 🎯 Propósito

Este proyecto contiene ejercicios de POO en Java organizados por temática. Los ejercicios actuales son **ejemplos de demostración** que serán **actualizados progresivamente** a medida que se agreguen los **Trabajos Prácticos (TPs)** oficiales del curso.

## 📁 Estructura del Proyecto

```
POO-2025/
├── src/main/java/com/miyo/
│   ├── Main.java                    # Clase principal del proyecto
│   └── ejercicios/
│       ├── basicos/                 # Conceptos fundamentales de POO
│       ├── herencia/                # Herencia y superclases
│       ├── polimorfismo/            # Sobrecarga y sobrescritura
│       ├── abstraccion/             # Clases abstractas e interfaces
│       └── encapsulacion/           # Modificadores de acceso
└── src/test/java/com/miyo/ejercicios/  # Tests unitarios correspondientes
```

## 🛠️ Configuración Técnica

- **Java**: 17+
- **Build Tool**: Maven 3.6+
- **Testing**: JUnit 5
- **IDE**: Compatible con VS Code, Eclipse, IntelliJ IDEA
- **Plataformas**: Windows y Linux

## 📝 Convenciones de Código

### Nomenclatura
- **Clases de ejercicios**: `EjercicioTipo##.java` (ej: `EjercicioBasico01.java`)
- **Clases de test**: `EjercicioTipo##Test.java` (ej: `EjercicioBasico01Test.java`)
- **Clases internas**: `PascalCase` (ej: `Persona`, `CuentaBancaria`)
- **Métodos**: `camelCase` (ej: `mostrarInfo`, `calcularArea`)
- **Paquetes**: `lowercase` (ej: `basicos`, `herencia`)

### Estructura de Ejercicios
Cada ejercicio debe seguir esta plantilla:

```java
package com.miyo.ejercicios.[categoria];

/**
 * [Descripción del ejercicio y conceptos que demuestra]
 */
public class Ejercicio[Categoria]## {
    
    /**
     * [Clases internas según el ejercicio]
     */
    public static class [NombreClase] {
        // Implementación
    }
    
    /**
     * Método principal para ejecutar el ejercicio
     */
    public void ejecutar() {
        System.out.println("=== [Título del Ejercicio] ===");
        // Demostración del ejercicio
    }
    
    /**
     * Método main para ejecutar directamente este ejercicio
     */
    public static void main(String[] args) {
        new Ejercicio[Categoria]##().ejecutar();
    }
}
```

### Tests Unitarios
- Usar JUnit 5 con anotaciones `@Test`, `@BeforeEach`, etc.
- Nombrar tests descriptivamente: `testMethodName_Condition_ExpectedResult`
- Ubicar en el mismo paquete que la clase bajo test
- Incluir tests para casos límite y validaciones

## 🎓 Categorías de Ejercicios

### 1. Básicos (`basicos/`)
- **Conceptos**: Clases, objetos, constructores, métodos, getters/setters
- **Ejemplos actuales**: `EjercicioBasico01` (Clase Persona)
- **Estado**: Ejemplo de demostración - será actualizado con TPs

### 2. Herencia (`herencia/`)
- **Conceptos**: Herencia, superclases, subclases, `super`, `extends`
- **Estado**: Pendiente - se agregará con TPs correspondientes

### 3. Polimorfismo (`polimorfismo/`)
- **Conceptos**: Sobrecarga, sobrescritura, `@Override`, interfaces
- **Estado**: Pendiente - se agregará con TPs correspondientes

### 4. Abstracción (`abstraccion/`)
- **Conceptos**: Clases abstractas, interfaces, métodos abstractos
- **Estado**: Pendiente - se agregará con TPs correspondientes

### 5. Encapsulación (`encapsulacion/`)
- **Conceptos**: Modificadores de acceso, validaciones, principio de responsabilidad única
- **Estado**: Pendiente - se agregará con TPs correspondientes

## 🚀 Comandos Maven Importantes

```bash
# Compilar proyecto
mvn compile

# Ejecutar tests
mvn test

# Ejecutar aplicación principal
mvn exec:java

# Limpiar y compilar
mvn clean compile

# Empaquetar JAR
mvn package
```

## 📚 Contexto para Copilot

### ⚠️ JERARQUÍA DE INSTRUCCIONES (ORDEN DE PRIORIDAD)

1. **🎓 INSTRUCCIONES DE CÁTEDRA** (`.github/buenas-practicas-POO.instructions.md`)
   - **MÁXIMA PRIORIDAD** - Instrucciones oficiales del curso
   - **NO MODIFICAR** - Este archivo contiene lineamientos de la cátedra
   - **PREVALECE** sobre cualquier otra instrucción en caso de conflicto

2. **📝 BUENAS PRÁCTICAS DE DESARROLLO**
   - `.github/java.instructions.md` - Estándares para código Java
   - `.github/java-docs.prompt.md` - Convenciones para JavaDoc  
   - `.github/java-junit.prompt.md` - Estándares para tests JUnit
   - `.github/markdown.instructions.md` - Formato para archivos Markdown

3. **🏗️ INSTRUCCIONES DEL PROYECTO**
   - `.github/copilot-instructions.md` - Contexto y estructura del proyecto POO-2025

### Al trabajar en este proyecto:

1. **Consultar SIEMPRE** las instrucciones de cátedra primero
2. **Mantener consistencia** con las convenciones establecidas
3. **Documentar código** usando JavaDoc apropiadamente
4. **Crear tests** para cada nuevo ejercicio implementado
5. **Seguir estructura Maven** estándar
6. **Organizar por temática** según las categorías definidas
7. **NO MODIFICAR** archivos de instrucciones de cátedra

### Al crear nuevos ejercicios:

1. **Verificar requisitos** en instrucciones de cátedra
2. **Identificar la categoría** POO correspondiente
3. **Usar numeración secuencial** dentro de cada categoría
4. **Incluir documentación** clara de conceptos demostrados
5. **Implementar método `ejecutar()`** para demostración
6. **Agregar tests unitarios** completos
7. **Actualizar README** si es necesario

### Al actualizar con TPs:

1. **Seguir especificaciones** de la cátedra estrictamente
2. **Reemplazar ejemplos** con ejercicios oficiales del curso
3. **Mantener estructura** y convenciones existentes
4. **Actualizar documentación** según nuevos requisitos
5. **Verificar compatibilidad** con IDEs y plataformas
6. **Ejecutar tests** para asegurar funcionalidad

## 🔄 Estado Actual del Proyecto

- ✅ **Estructura Maven**: Configurada y funcional
- ✅ **Ejemplo básico**: `EjercicioBasico01` implementado y testeado
- ✅ **Documentación**: README completo y actualizado
- ✅ **Repositorio**: Publicado en GitHub con branch `main`
- 🔄 **Ejercicios**: Pendientes de actualización con TPs oficiales

## 💡 Notas Importantes

- Los ejercicios actuales son **ejemplos temporales**
- Se irán **reemplazando** con los TPs del curso
- Mantener **compatibilidad multiplataforma** (Windows/Linux)
- Asegurar **compatibilidad multi-IDE** (VS Code/Eclipse/IntelliJ)
- Priorizar **claridad educativa** sobre optimización

---

*Última actualización: 6 de agosto de 2025*
