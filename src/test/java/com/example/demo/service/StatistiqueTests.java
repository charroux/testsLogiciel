package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class StatistiqueTests {

    @Test
    public void testPrrixMoyen() {
        StatistiqueImpl statistique = new StatistiqueImpl();

        Voiture voiture1 = new Voiture("Toyota", 5000);
        statistique.ajouter(voiture1);

        Voiture voiture2 = new Voiture("Honda",  7000);
        statistique.ajouter(voiture2);

        Echantillon echantillon = statistique.prixMoyen();
        assertEquals(6000, echantillon.getPrixMoyen());
    }
    

}
