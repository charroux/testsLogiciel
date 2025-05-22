package com.example.demo.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoitureTest{

    private Voiture voiture;

    @BeforeEach
    void initialiserVoiture(){
        voiture = new Voiture(); //initialisation pour chaque test
    }

    @Test
    void TestVoitureRenault(){
        voiture.setMarque("Renault");
        voiture.setPrix(12000);

        assertEquals("Renault", voiture.getMarque()); //test equals avec la marque
        assertEquals(12000, voiture.getPrix());
    }

    @Test
    void TestVoitureAudi(){
        voiture.setMarque("Audi"); //2eme test
        voiture.setPrix(22000);

        assertEquals("Audi", voiture.getMarque());
        assertEquals(22000, voiture.getPrix());
    }

    @Test
    void modifierIdVoiture(){
        voiture.setId(10);
        assertEquals(10, voiture.getId());
    }
}
