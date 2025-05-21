package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture(){
        Voiture voiture = new Voiture("Porsche", 150_000);
        assertAll(
                () -> assertEquals(150_000, voiture.getPrix(), "Le prix doit être 150 000"),
                () -> assertEquals("Porsche", voiture.getMarque(), "La marque doit être Porsche")
        );
    }

    @Test
    void creerVoitureVide() {
        Voiture voiture = new Voiture();
        assertAll(
                () -> assertEquals(0, voiture.getPrix(), "Le prix doit être 0"),
                () -> assertNull(voiture.getMarque(), "La marque doit être null")
        );
    }

    @Test
    void testGetSetId(){
        Voiture voiture = new Voiture("Porsche", 150_000);
        voiture.setId(99);
        assertAll(
                () -> assertEquals(99, voiture.getId(), "L'id doit être 99"),
                () -> assertEquals(150_000, voiture.getPrix(), "Le prix doit être 150 000"),
                () -> assertEquals("Porsche", voiture.getMarque(), "La marque doit être Porsche")
        );
    }

    @Test
    void testGetSetMarque(){
        Voiture voiture = new Voiture("Porsche", 150_000);
        voiture.setMarque("Lamborghini");
        assertAll(
                () -> assertEquals(150_000, voiture.getPrix(), "Le prix doit être 150 000"),
                () -> assertEquals("Lamborghini", voiture.getMarque(), "La marque doit être Lamborghini")
        );
    }

    @Test
    void testGetSetPrix(){
        Voiture voiture = new Voiture("Porsche", 150_000);
        voiture.setPrix(180_000);
        assertAll(
                () -> assertEquals(180_000, voiture.getPrix(), "Le prix doit être 180 000"),
                () -> assertEquals("Porsche", voiture.getMarque(), "La marque doit être Porsche")
        );
    }

    @Test
    void testToString(){
        Voiture voiture = new Voiture("Porsche", 150_000);
        voiture.setId(99);
        String expected = "Car{marque='Porsche', prix=150000, id=99}";
        assertEquals(expected, voiture.toString(), "La méthode toString doit retourner la chaîne attendue");
        //comment
    }
}
