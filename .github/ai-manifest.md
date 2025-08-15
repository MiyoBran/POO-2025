
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
4. `java.instructions.md`, `java-docs.prompt.md`, `java-junit.prompt.md`, `markdown.instructions.md` — guías de estilo y pruebas

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
