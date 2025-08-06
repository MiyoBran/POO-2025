# ✅ Lista de Buenas Prácticas – POO

## 📌 Verificar

### 🧩 Diagrama de clases
- Antes de desarrollar el código, desarrollar el diagrama. Sirve para entender el problema y diseñar la solución.
- Detallar nombre de **atributos**, tipos y alcance (salvo excepciones, siempre `private`).
- Detallar nombre de **métodos**, parámetros, tipo de objeto de retorno y alcance.
- Detallar **relaciones** (agregación, composición). Nombre de las relaciones y cardinalidad. Si es una colección (array, lista, etc.), utilizar un nombre en plural.
- Detallar **dirección de las relaciones**, indicada con la flecha.
- Evitar utilizar **relaciones dobles**. Solo considerar utilizarlas donde realmente sean necesarias.
- Los nombres y alcances se deben **reflejar en el código**.
- Si al desarrollar el código encontramos que faltan atributos, métodos o relaciones, **agregarlos en el diagrama**. → *Proceso iterativo*.

---

## 🎨 Estilo

- Escribir **un atributo por línea**.
- Usar solo **caracteres del alfabeto inglés** en el código (nombre de clases, métodos, argumentos, atributos, etc.).  
  ⚠️ No usar `ñ`, vocales acentuadas ni caracteres especiales.
- Evitar **mezclar palabras en inglés y español** en nombres de clases, métodos, atributos o variables.
- Utilizar estilo **CamelCase** en los nombres que llevan más de una palabra.
- **Eliminar líneas comentadas** que ya no se usen.
- **Eliminar salidas por pantalla** (`System.out.println`) utilizadas para depuración.

---

## 👨‍💻 Programación

- Utilizar **paquetes** para agrupar clases por su funcionalidad (`modelo`, `test`, `gui`, etc.).  
  📌 Los nombres de los paquetes se escriben en **minúsculas**.
  
- Para **manejo de listas**, se recomienda usar implementaciones de la interfaz `List` (`ArrayList`, `LinkedList`, etc.) en lugar de arreglos simples para evitar errores con el índice.

- Implementar el método `equals()` seleccionando uno o más atributos que identifiquen de forma única al objeto.  
  ❌ Evitar el uso de `==` para comparar objetos.  
  🔍 Recordar que métodos como `contains()` o `indexOf()` de una lista dependen de `equals()`.

- Sobrescribir el método `toString()`, aunque no se use directamente.

- Crear **getters y setters** para atributos `private` cuando sea apropiado.

- ❌ No crear métodos `get/set` para colecciones.  
  ✔️ La clase debe proveer métodos específicos para acceder o modificar (ej. `add`, `remove`).  
  📋 Si es necesario, se puede ofrecer **una copia** de la colección.

- Verificar primero las **condiciones de error**.  
  ⚠️ Si no es posible tratarlas, lanzar una excepción.

- Las **clases internas** se colocan al final de la clase que las contiene y deben ser `private`.

- Usar **herencia solo si es necesaria**.  
  Relación `es-un/a`.  
  Ej:  
  - `Triángulo` es-una `Figura`  
  - `CajaAhorro` es-una `Cuenta`

- No utilizar **números mágicos**.  
  Usar **constantes** con `final`, en mayúsculas:  
  ```java
  private final int MAX_VALUE = 999;
