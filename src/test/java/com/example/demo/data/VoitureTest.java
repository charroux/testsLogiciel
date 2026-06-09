package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class VoitureTest {
    Voiture voiture;

    @BeforeEach
    void preparerVoiture(){
        voiture = new Voiture();
    }
    
    @Test
    void testConstructeurParDefaut(){

        assertNotNull(voiture);
        assertNull(voiture.getMarque());
        assertEquals(0, voiture.getId());
        assertEquals(0, voiture.getPrix());
    }

    @Test
    void testConstructeurAvecParametres(){
        Voiture voiture2 = new Voiture("Peugeot", 4000);

        assertNotNull(voiture2);
        assertEquals("Peugeot", voiture2.getMarque());
        assertEquals(0, voiture2.getId());
        assertEquals(4000, voiture2.getPrix());
        
    }

    @Test
    void testGetAndSetId(){
        voiture.setId(1);

        assertEquals(1, voiture.getId());
    }

    @Test
    void testGetAndSetMarque(){
        voiture.setMarque("Renault");

        assertEquals("Renault", voiture.getMarque());
    }

    @Test
    void testGetAndSetPrix(){
        voiture.setPrix(10000);

        assertEquals(10000, voiture.getPrix());
    }

    @Test
    void testToString(){
        voiture.setMarque("Peugeot");
        voiture.setPrix(1000);
        voiture.setId(2);

        assertEquals(voiture.toString(), "Car{marque='Peugeot', prix=1000, id=2}");
    }

}
