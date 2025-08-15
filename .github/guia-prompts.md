# Guía práctica de prompts y comparativa de asistentes de IA

> Para descargar: copia este contenido y guárdalo como archivo .md. Luego puedes convertirlo a PDF o DOCX desde tu editor (VS Code, Obsidian o cualquier conversor de Markdown).

---

## Resumen ejecutivo

- **Propósito:** Ofrecer una guía accionable de instrucciones básicas para interactuar con LLMs, técnicas de prompt engineering, y una comparativa útil de Microsoft Copilot, ChatGPT, Claude, Gemini y GitHub Copilot (gratis vs pro).
- **Qué te llevas:** Plantillas listas para usar, recomendaciones por tipo de tarea, checklist de calidad y errores comunes a evitar.
- **Idea clave:** La calidad del resultado depende del contexto, estructura y límites que des al modelo. Elige el asistente según la tarea, no por preferencia general.

---

## Instrucciones básicas del curso, interpretadas y potenciadas

### Explica
- **Objetivo:** Desarrollar un concepto o proceso con claridad y ejemplos.
- **Cuándo usarla:** Para comprender temas complejos, teorías o tecnologías.
- **Cómo potenciarla:** Define audiencia, profundidad, formato y límites; pide analogías y contraejemplos.

### Describe
- **Objetivo:** Detallar rasgos visuales, funcionales o conceptuales de algo.
- **Cuándo usarla:** Para “pintar” un sistema, flujo o escenario sin verlo.
- **Cómo potenciarla:** Pide dimensiones específicas, añade un contraejemplo y solicita salida en bullets con ejemplo breve.

### Resume
- **Objetivo:** Condensar conservando ideas clave y matices importantes.
- **Cuándo usarla:** Con textos largos, papers, transcripciones o informes.
- **Cómo potenciarla:** Fija longitud, marco (p. ej., problema–método–resultados–limitaciones) y extrae 3 insights accionables.

### Elabora
- **Objetivo:** Generar contenido original (artículos, posts, notas técnicas).
- **Cuándo usarla:** Cuando tienes briefing, audiencia y objetivo claros.
- **Cómo potenciarla:** Indica estructura, tono, “no-goes” y pide verificación de datos/limites.

### Compara
- **Objetivo:** Destacar similitudes/diferencias con criterios explícitos.
- **Cuándo usarla:** Para elegir herramientas, marcos o estrategias.
- **Cómo potenciarla:** Define criterios, solicita tabla y un veredicto breve contextualizado.

### Genera una idea
- **Objetivo:** Producir opciones creativas bajo restricciones reales.
- **Cuándo usarla:** En brainstorming con recursos, tiempo y alcance concretos.
- **Cómo potenciarla:** Especifica cantidad, diversidad, filtros de viabilidad y señalización de ideas top.

### Lista
- **Objetivo:** Enumerar elementos clave de forma concisa y escaneable.
- **Cuándo usarla:** Para beneficios, riesgos, ejemplos o pasos rápidos.
- **Cómo potenciarla:** Ordena por impacto, etiqueta cada bullet y limita a una línea por ítem.

### Diseña
- **Objetivo:** Crear un plan, blueprint o roadmap accionable.
- **Cuándo usarla:** Para proyectos, cursos, campañas o investigaciones.
- **Cómo potenciarla:** Pide hitos, responsables, riesgos, métricas, supuestos y criterios de éxito.

### Interpreta
- **Objetivo:** Explicar el sentido de datos/textos/comportamientos.
- **Cuándo usarla:** En análisis de resultados, ambigüedades o lecturas críticas.
- **Cómo potenciarla:** Solicita hipótesis alternativas, evidencia pro/contra y próximos pasos de validación.

### Actúa como
- **Objetivo:** Adoptar una perspectiva experta o de rol específico.
- **Cuándo usarla:** Para guías técnicas, revisiones o estilos de comunicación.
- **Cómo potenciarla:** Define rol, estilo, límites y protocolo de pedir aclaraciones si faltan datos.

### Traduce
- **Objetivo:** Cambiar idioma conservando intención y formato.
- **Cuándo usarla:** Con textos técnicos, documentación o código comentado.
- **Cómo potenciarla:** Indica registro, dominio, preservación de formato y señalización de ambigüedades.

### Justifica
- **Objetivo:** Defender una decisión o estrategia con argumentos sólidos.
- **Cuándo usarla:** En propuestas, debates o evaluaciones de inversión.
- **Cómo potenciarla:** Usa marco costo–beneficio–riesgos–alternativas, añade sensibilidad y objeciones previstas.

---

## Técnicas y trucos de prompt engineering

- **Contexto explícito:** Define organización, audiencia, objetivo, restricciones y éxito medible; reduce ambigüedad.
- **Rol–Tarea–Formato–Métrica:** Asigna rol, describe tarea, exige formato de salida y límite de extensión/tiempo.
- **Delimitadores de datos:** Encierra entradas largas entre —BEGIN—/—END— para evitar mezclas y pérdidas de contexto.
- **Few‑shot efectivo:** Incluye 1–3 ejemplos de entrada/salida representativos para fijar estilo y criterio de corrección.
- **Descomposición en pasos:** Pide plan, solución y verificación separadas; mejora precisión y control de errores.
- **Auto‑chequeo:** Obliga a validar contra requisitos; si falta algo, que reintente con correcciones explícitas.
- **Formatos estructurados:** Solicita JSON/CSV cuando vayas a parsear o reutilizar automáticamente.
- **Control de estilo:** Define tono, densidad de información y prohibiciones (sin clichés, sin redundancias).
- **Incertidumbre honesta:** Pide nivel de confianza y supuestos críticos para evaluar riesgos.
- **Iteración rápida:** Alterna prompts breves con feedback concreto; mejora más que un prompt largo y difuso.
- **Multimodal cuando aplique:** Si la herramienta lo permite, combina texto con imágenes/archivos para dar contexto.

---

## Comparativa y recomendaciones por tarea

### Visión general de asistentes

| Asistente | Fortalezas | Mejor para | Limitaciones | Integraciones |
|---|---|---|---|---|
| Microsoft Copilot | Buen resumen y productividad en M365 | Word, Excel, PowerPoint, Outlook; flujos corporativos | Menos control creativo fino fuera del ecosistema | Windows, Edge, Microsoft 365 |
| ChatGPT | Versátil, creativo, buen control de estilo | Redacción, ideación, tutoría técnica general | Puede ser verboso si no se acota | GPTs personalizados, plugins del ecosistema |
| Claude | Contextos largos y lectura precisa | Resumen/análisis de documentos extensos | Conservador en temas sensibles | Integraciones con apps de lectura/archivos |
| Gemini | Multimodalidad ágil y ecosistema Google | Investigación práctica con Docs/Drive | Resultados disparejos en código | Google Workspace (Docs, Gmail, Drive) |
| GitHub Copilot | Sugerencias en IDE y patrones idiomáticos | Programación diaria, refactor, tests | Fuera del IDE aporta menos | VS Code, JetBrains, repositorios |

#### Diferencias entre versiones gratuitas y de pago

| Proveedor | Gratis | Pro/Advanced | Cuándo subir |
|---|---|---|---|
| Microsoft Copilot | Acceso general y funciones básicas | Prioridad de modelo e integración avanzada en M365 | Si automatizas documentos/correos/datos a diario |
| ChatGPT | Q&A y redacción corta útiles | Modelos superiores, más contexto, GPTs personalizados | Si haces contenido largo o flujos con archivos |
| Claude | Buenas respuestas con límites de tamaño | Modelos potentes y contextos muy largos | Si resumes/analizas documentos extensos |
| Gemini | Multimodal básico y conexión Google | Modelos más fuertes y contextos amplios | Si dependes de Drive/Docs/Gmail y archivos grandes |
| GitHub Copilot | Opciones gratis para estudiantes/OSS | Chat en IDE, políticas y seguridad avanzadas | Si programas a diario o en equipo |

> Fuentes no incluidas intencionalmente para mantener el documento portable; verifica ofertas y límites actuales en cada proveedor antes de decidir.

#### Recomendaciones por tipo de tarea

- **Redacción creativa y tono consistente:** ChatGPT Pro.  
  - **Motivo:** **Estilo flexible**, **GPTs personalizados**, **control de formato**.
- **Análisis y resumen de documentos largos:** Claude Pro.  
  - **Motivo:** **Contexto extenso**, **razonamiento con matices**, **síntesis fiel**.
- **Productividad con Microsoft 365:** Copilot Pro.  
  - **Motivo:** **Integración nativa** en Word/Excel/PowerPoint/Outlook y **automatización**.
- **Investigación práctica con archivos en Drive/Docs:** Gemini Advanced.  
  - **Motivo:** **Multimodal** + **Workspace**.
- **Programación en el IDE:** GitHub Copilot (Individual/Business).  
  - **Motivo:** **Sugerencias en tiempo real**, **chat contextual del repo**.
- **Tutoría técnica paso a paso y ejercicios:** ChatGPT Pro o Claude Pro.  
  - **Motivo:** **Explicaciones graduadas** y **verificación**.
- **Tablas y análisis rápidos en hojas de cálculo:** Copilot Pro (Excel) o Gemini Advanced (Sheets).  
  - **Motivo:** **Fórmulas guiadas** y **manipulación en contexto**.
- **Traducción técnica preservando formato:** ChatGPT Pro o Claude Pro.  
  - **