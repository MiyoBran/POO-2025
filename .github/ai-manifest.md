
# AI Manifest — POO-2025

Este archivo es el punto de entrada canónico para agentes automáticos (Copilot, LLMs, bots CI) que necesiten contexto y guía sobre cómo usar los archivos dentro de `.github/`.

Propósito rápido:

- Centralizar prioridades y fuentes de verdad.
- Evitar ambigüedades entre archivos similares.
- Proveer plantillas y un flujo de trabajo mínimo para CI/PRs/Issues.

Archivo de referencia (orden de prioridad):

1. `buenas-practicas-POO.instructions.md` — INSTRUCCIONES DE CÁTEDRA (NO MODIFICAR)
2. `ai-manifest.md` — ESTE ARCHIVO (entrada principal para agentes)
3. `copilot-instructions.md` — Contexto del proyecto y convenciones
4. `prompts/java.instructions.md`, `prompts/java-docs.prompt.md`, `prompts/java-junit.prompt.md`, `prompts/markdown.instructions.md` — guías de estilo y pruebas

Directrices para agentes AI:

- Leer `buenas-practicas-POO.instructions.md` primero y respetar su contenido; no escribir ni sobrescribirlo.
- Usar `ai-manifest.md` como índice y `copilot-instructions.md` para contexto adicional.
- Para cambios automáticos en código, crear PRs usando la plantilla `PULL_REQUEST_TEMPLATE.md`.
- Si se generan issues, usar los campos de `ISSUE_TEMPLATE/`.

No modificar:

- `buenas-practicas-POO.instructions.md` (archivo de la cátedra).

Para humanos:

- Si añades o mueves archivos de instrucción, actualiza `ai-manifest.md`.

---

Última actualización: 2025-08-15

## Notas de uso (cuándo usar cada guía)

Estas notas ayudan a los agentes a seleccionar la guía más apropiada para la tarea en curso:

- `prompts/java.instructions.md` — Usar cuando se hagan cambios estructurales o de estilo en código Java (refactorings, diseño de clases, recomendaciones de patrones y prevención de code smells). Ideal para PRs que afectan arquitectura o convenios de proyecto.
- `prompts/java-docs.prompt.md` — Usar al generar o revisar JavaDoc para clases, métodos o paquetes. Indicada para tareas de documentación automática o revisión de calidad de comentarios.
- `prompts/java-junit.prompt.md` — Usar cuando se creen o revisen pruebas unitarias (JUnit 5), incluidas pruebas parametrizadas, organización de tests y mejores prácticas de aserciones/mocking.
- `prompts/markdown.instructions.md` — Usar al crear o validar contenidos Markdown (README, guías, posts). Esta guía define front-matter, niveles de encabezado y reglas de formato que deben cumplirse antes de publicar.

- `prompts/copilot-instructions-blueprint-generator.prompt.md` — Plantilla para generar `copilot-instructions.md` adaptadas a Java/POO.
- `prompts/prompt-builder.prompt.md` — Generador interactivo de prompts y plantillas (adaptado a Java/POO).
- `prompts/prompt-engineer.chatmode.md` — Chatmode para analizar y mejorar prompts.
- `prompts/task-planner.chatmode.md` — Chatmode para planificación basada en investigación.
- `prompts/blueprint-mode.chatmode.md` — Chatmode para especificación y arquitectura.

## Nota sobre copias en `src/main/resources`

Algunos archivos de guía y prompts existen también en `src/main/resources/` como copias históricas o para empaquetado. Esas copias NO son canónicas. Agentes automáticos y revisores humanos deben preferir siempre las versiones bajo `.github/prompts/` o los archivos listados en la sección "Archivo de referencia" arriba.

Reglas rápidas:

- Leer y usar archivos en `.github/prompts/` como fuente de verdad.

- Ignorar los archivos homónimos que aparezcan en `src/main/resources/` salvo que un humano indique explícitamente lo contrario.

- Si se desea convertir una copia histórica en la versión canónica, moverla a `.github/prompts/` y actualizar este `ai-manifest.md`.

