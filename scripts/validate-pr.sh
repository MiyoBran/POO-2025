#!/usr/bin/env bash
set -euo pipefail

echo "== validate-pr: quick checks =="
# Maven build (if available)
if command -v mvn >/dev/null 2>&1; then
  echo "Running mvn test..."
  mvn -B -DskipTests=false test
else
  echo "mvn not found in PATH — skipping Maven build."
fi

# Markdown lint (if npx available)
if command -v npx >/dev/null 2>&1; then
  echo "Running markdownlint-cli2 on .github/ and project markdown files..."
  npx markdownlint-cli2 -f ".github/**/*.md" || true
else
  echo "npx not found — skipping markdown lint. To enable: install Node.js and run 'npx markdownlint-cli2 -f .github/**/*.md'"
fi

echo "== validate-pr: done =="
