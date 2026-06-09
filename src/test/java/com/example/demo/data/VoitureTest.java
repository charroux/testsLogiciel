package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    @Test
    public void creerVoiture(){
        Voiture voiture = new Voiture("Toyota", 10000);
        assertEquals(voiture.getMarque(), "Toyota", "Marque Ok");
        assertEquals(voiture.getPrix(), 10000, "Prix Ok");

        voiture.setId(13);
        assertEquals(voiture.getId(), 13, "Id Ok");

        voiture.toString();
    
    }

}