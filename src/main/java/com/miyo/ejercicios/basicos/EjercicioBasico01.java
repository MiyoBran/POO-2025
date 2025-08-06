package com.miyo.ejercicios.basicos;

/**
 * Ejercicio básico de ejemplo - Clase Persona
 * Demuestra conceptos básicos de POO: clase, atributos, constructor y métodos
 */
public class EjercicioBasico01 {
    
    /**
     * Clase Persona que representa a una persona con nombre y edad
     */
    public static class Persona {
        private String nombre;
        private int edad;
        
        /**
         * Constructor de la clase Persona
         * @param nombre El nombre de la persona
         * @param edad La edad de la persona
         */
        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }
        
        /**
         * Getter para el nombre
         * @return El nombre de la persona
         */
        public String getNombre() {
            return nombre;
        }
        
        /**
         * Setter para el nombre
         * @param nombre El nuevo nombre
         */
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        
        /**
         * Getter para la edad
         * @return La edad de la persona
         */
        public int getEdad() {
            return edad;
        }
        
        /**
         * Setter para la edad
         * @param edad La nueva edad
         */
        public void setEdad(int edad) {
            if (edad >= 0) {
                this.edad = edad;
            }
        }
        
        /**
         * Método para mostrar información de la persona
         * @return String con la información
         */
        public String mostrarInfo() {
            return "Persona: " + nombre + ", Edad: " + edad + " años";
        }
        
        /**
         * Método para determinar si es mayor de edad
         * @return true si es mayor de edad, false en caso contrario
         */
        public boolean esMayorDeEdad() {
            return edad >= 18;
        }
    }
    
    /**
     * Método principal para ejecutar el ejercicio
     */
    public void ejecutar() {
        System.out.println("=== Ejercicio Básico 01: Clase Persona ===");
        
        // Crear instancias de Persona
        Persona persona1 = new Persona("Juan", 25);
        Persona persona2 = new Persona("Ana", 17);
        
        // Mostrar información
        System.out.println(persona1.mostrarInfo());
        System.out.println("¿Es mayor de edad? " + persona1.esMayorDeEdad());
        
        System.out.println(persona2.mostrarInfo());
        System.out.println("¿Es mayor de edad? " + persona2.esMayorDeEdad());
        
        // Modificar datos usando setters
        persona2.setEdad(20);
        System.out.println("\nDespués de modificar la edad:");
        System.out.println(persona2.mostrarInfo());
        System.out.println("¿Es mayor de edad? " + persona2.esMayorDeEdad());
    }
    
    /**
     * Método main para ejecutar directamente este ejercicio
     */
    public static void main(String[] args) {
        new EjercicioBasico01().ejecutar();
    }
}
