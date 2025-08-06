package com.miyo.ejercicios.basicos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para el EjercicioBasico01 - Clase Persona
 */
public class EjercicioBasico01Test {
    
    private EjercicioBasico01.Persona persona;
    
    @BeforeEach
    void setUp() {
        persona = new EjercicioBasico01.Persona("Juan", 25);
    }
    
    @Test
    void testConstructor() {
        assertEquals("Juan", persona.getNombre());
        assertEquals(25, persona.getEdad());
    }
    
    @Test
    void testSetNombre() {
        persona.setNombre("Carlos");
        assertEquals("Carlos", persona.getNombre());
    }
    
    @Test
    void testSetEdadValida() {
        persona.setEdad(30);
        assertEquals(30, persona.getEdad());
    }
    
    @Test
    void testSetEdadInvalida() {
        persona.setEdad(-5);
        assertEquals(25, persona.getEdad()); // No debe cambiar
    }
    
    @Test
    void testMostrarInfo() {
        String expected = "Persona: Juan, Edad: 25 años";
        assertEquals(expected, persona.mostrarInfo());
    }
    
    @Test
    void testEsMayorDeEdadTrue() {
        assertTrue(persona.esMayorDeEdad());
    }
    
    @Test
    void testEsMayorDeEdadFalse() {
        persona.setEdad(16);
        assertFalse(persona.esMayorDeEdad());
    }
    
    @Test
    void testEsMayorDeEdadLimite() {
        persona.setEdad(18);
        assertTrue(persona.esMayorDeEdad());
    }
}
