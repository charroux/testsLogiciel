package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture(){
        Voiture voiture = new Voiture("Ferrari", 5001);
        Assert.isTrue(voiture.getMarque().equals("Ferrari"), "Doit être Ferrari");
        Assert.isTrue(voiture.getPrix() == 5000, "Doit être 5000");
        // La clef primaire n'a pas été générée
        Assert.isTrue(voiture.getId() == 0, "Doit être 0");
    }

}
