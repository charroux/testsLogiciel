package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VoitureTest {

    @Test
    void testConstructeurParDefaut() {
        Voiture v = new Voiture();
        assertNull(v.getMarque());
        assertEquals(0, v.getPrix());
        assertEquals(0, v.getId());
    }

    @Test
    void testConstructeurParametre() {
        Voiture v = new Voiture("Peugeot", 25000);
        assertEquals("Peugeot", v.getMarque());
        assertEquals(25000, v.getPrix());
        assertEquals(0, v.getId());
    }

    @Test
    void testSetEtGetMarque() {
        Voiture v = new Voiture();
        v.setMarque("Citroën");
        assertEquals("Citroën", v.getMarque());
    }

    @Test
    void testSetEtGetPrix() {
        Voiture v = new Voiture();
        v.setPrix(15000);
        assertEquals(15000, v.getPrix());
        v.setPrix(0);
        assertEquals(0, v.getPrix());
        v.setPrix(-1000);
        assertEquals(-1000, v.getPrix());
    }

    @Test
    void testSetEtGetId() {
        Voiture v = new Voiture();
        v.setId(42);
        assertEquals(42, v.getId());
    }

    @Test
    void testToString() {
        Voiture v = new Voiture("BMW", 80000);
        v.setId(10);
        String expected = "Car{marque='BMW', prix=80000, id=10}";
        assertEquals(expected, v.toString());
    }
}