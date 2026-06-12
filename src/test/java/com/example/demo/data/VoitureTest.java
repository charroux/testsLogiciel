package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VoitureTest {

    @Test
    void constructeurParDefaut() {
        Voiture v = new Voiture();
        assertNull(v.getMarque());
        assertEquals(0, v.getPrix());
        assertEquals(0, v.getId());
    }

    @Test
    void constructeurAvecParametres() {
        Voiture v = new Voiture("Renault", 15000);
        assertEquals("Renault", v.getMarque());
        assertEquals(15000, v.getPrix());
    }

    @Test
    void setEtGetMarque() {
        Voiture v = new Voiture();
        v.setMarque("Peugeot");
        assertEquals("Peugeot", v.getMarque());
    }

    @Test
    void setEtGetPrix() {
        Voiture v = new Voiture();
        v.setPrix(20000);
        assertEquals(20000, v.getPrix());
    }

    @Test
    void setEtGetId() {
        Voiture v = new Voiture();
        v.setId(42);
        assertEquals(42, v.getId());
    }

    @Test
    void testToString() {
        Voiture v = new Voiture("Toyota", 25000);
        v.setId(1);
        String result = v.toString();
        assertTrue(result.contains("Toyota"));
        assertTrue(result.contains("25000"));
        assertTrue(result.contains("1"));
    }
}