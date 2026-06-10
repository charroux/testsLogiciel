package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StatistiqueTests {

    @Test
    void testStatistique() {
        StatistiqueImpl statistique = new StatistiqueImpl();
        Voiture v1 = new Voiture("Ferrari", 3000);
        Voiture v2 = new Voiture("Porsche", 3000);
        statistique.ajouter(v1);
        statistique.ajouter(v2);
        Echantillon echantillon = statistique.prixMoyen();
        assertEquals(3000, echantillon.getPrixMoyen());
        assertEquals(2, echantillon.getNombreDeVoitures());
    }

}
