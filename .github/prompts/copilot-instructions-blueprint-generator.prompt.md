# Copilot Instructions Blueprint Generator — Java / POO

---
description: 'Blueprint generator adapted for Java/POO: produce a copilot-instructions.md tailored to Java 21, Maven, and the POO structure used in this repository.'
mode: 'agent'
---

# Copilot Instructions Blueprint Generator — Java / POO

Config vars:
${ARCHITECTURE_STYLE="Layered|Monolithic|Domain-Driven|Layered"}
${CODE_QUALITY_FOCUS="Maintainability|Security|Testability|All"}
${DOCUMENTATION_LEVEL="Standard|Comprehensive"}
${TESTING_REQUIREMENTS="Unit|Integration|All"}

Produce a `copilot-instructions.md` focused on Java projects using Maven and object-oriented designs. Follow the original blueprint but:
- Detect Java version from `pom.xml` and restrict suggestions accordingly (use features compatible with Java 21 if detected).
- Prefer patterns already present in the codebase (packages `facultad`, `empresa`, `modelo`, `poo`, etc.).
- Include instructions for exception handling, serialization safety (avoid insecure Java deserialization), and JUnit 5 testing style.
- Reference `.github/prompts/` as canonical guidance for agents.

Output: a ready-to-add `copilot-instructions.md` content block and a short changelog of which patterns from the codebase were used to derive the guidance.
