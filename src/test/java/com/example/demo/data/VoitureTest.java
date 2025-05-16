package com.example.demo.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoitureTest {

    private Voiture voiture;

    @BeforeEach
    void initialiserVoiture() {
        voiture = new Voiture(); //initialisation pour chaque test
    }

    @Test
    void creerVoitureRenault() {
        voiture.setMarque("Renault");
        voiture.setPrix(12000);

        assertEquals("Renault", voiture.getMarque());
        assertEquals(12000, voiture.getPrix());
    }

    @Test
    void creerVoitureAudi() {
        voiture.setMarque("Audi");
        voiture.setPrix(22000);

        assertEquals("Audi", voiture.getMarque());
        assertEquals(22000, voiture.getPrix());
    }

    @Test
    void modifierIdVoiture() {
        voiture.setId(10);
        assertEquals(10, voiture.getId());
    }
}
