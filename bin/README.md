# POO-2025 📚

Proyecto de ejercicios de **Programación Orientada a Objetos** en Java para el año 2025.

## 🛠️ Tecnologías

- **Java 17+**
- **Maven** como herramienta de construcción
- **JUnit 5** para testing
- Compatible con **VS Code**, **Eclipse** e **IntelliJ IDEA**
- Multiplataforma: **Windows** y **Linux**

## 📁 Estructura del Proyecto

```text
POO-2025/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── miyo/
│   │   │           ├── ejercicios/
│   │   │           │   ├── basicos/
│   │   │           │   ├── herencia/
│   │   │           │   ├── polimorfismo/
│   │   │           │   ├── abstraccion/
│   │   │           │   └── encapsulacion/
│   │   │           └── Main.java
│   │   └── resources/
│   └── test/
│       └── java/
│           └── com/
│               └── miyo/
│                   └── ejercicios/
├── target/          (generado por Maven)
├── pom.xml
├── README.md
└── .gitignore
```

## 🚀 Comandos Maven

### Compilar el proyecto

```bash
mvn compile
```

### Ejecutar tests

```bash
mvn test
```

### Empaquetar (generar JAR)

```bash
mvn package
```

### Limpiar archivos generados

```bash
mvn clean
```

### Ejecutar la aplicación principal

```bash
mvn exec:java -Dexec.mainClass="com.miyo.Main"
```

### Compilar y ejecutar en un solo comando

```bash
mvn compile exec:java
```

## 🔧 Configuración por IDE

### VS Code

1. Instalar la extensión **Extension Pack for Java**
2. Abrir la carpeta del proyecto
3. VS Code detectará automáticamente el proyecto Maven

### Eclipse

1. `File > Import > Existing Maven Projects`
2. Seleccionar la carpeta del proyecto
3. Eclipse importará la configuración Maven automáticamente

### IntelliJ IDEA

1. `File > Open`
2. Seleccionar el archivo `pom.xml`
3. Elegir "Open as Project"

## 📂 Organización de Ejercicios

Los ejercicios están organizados por temática:

- **`basicos/`**: Clases, objetos, constructores, métodos
- **`herencia/`**: Herencia, superclases, subclases
- **`polimorfismo/`**: Sobrecarga, sobrescritura, interfaces
- **`abstraccion/`**: Clases abstractas, interfaces
- **`encapsulacion/`**: Modificadores de acceso, getters/setters

### Convención de nombres

- Clases: `PascalCase` (ej: `EjercicioHerencia01`)
- Métodos: `camelCase` (ej: `calcularArea`)
- Paquetes: `lowercase` (ej: `basicos`, `herencia`)

## 🧪 Testing

Cada ejercicio debe incluir sus tests correspondientes en el directorio `test/`:

```java
// Ejemplo de test
@Test
void testCalcularArea() {
    Rectangulo rect = new Rectangulo(5, 3);
    assertEquals(15, rect.calcularArea());
}
```

## 🌐 Compatibilidad

Este proyecto está configurado para funcionar en:

- ✅ Windows 10/11
- ✅ Linux (Ubuntu, Fedora, etc.)
- ✅ macOS
- ✅ VS Code + Extension Pack for Java
- ✅ Eclipse IDE
- ✅ IntelliJ IDEA Community/Ultimate

## 📋 Requisitos

- **Java 17** o superior
- **Maven 3.6+**
- Tu IDE favorito

## 🎯 Objetivos de Aprendizaje

- [ ] Fundamentos de POO
- [ ] Herencia y composición
- [ ] Polimorfismo
- [ ] Abstracción
- [ ] Encapsulación
- [ ] Manejo de excepciones
- [ ] Colecciones y genéricos
- [ ] Patrones de diseño básicos

---

*Proyecto académico - 2025* 🎓
