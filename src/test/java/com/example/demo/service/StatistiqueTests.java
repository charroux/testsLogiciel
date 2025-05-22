package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatistiqueTests {

    // Test du calcul du prix moyen avec plusieurs voitures
    @Test
    public void testPrixMoyenAvecPlusieursVoitures() {
        StatistiqueImpl statistique = new StatistiqueImpl();

        // Ajout de 3 voitures avec des prix différents
        statistique.ajouter(new Voiture("Peugeot", 10000));
        statistique.ajouter(new Voiture("Renault", 20000));
        statistique.ajouter(new Voiture("Citroen", 30000));

        // Calcul du prix moyen
        Echantillon echantillon = statistique.prixMoyen();

        // Vérifie que le nombre de voitures est correct
        assertEquals(3, echantillon.getNombreDeVoitures());

        // Vérifie que le prix moyen est correctement calculé : (10000+20000+30000)/3 = 20000
        assertEquals(20000, echantillon.getPrixMoyen());
    }

    // Test du calcul du prix moyen avec une seule voiture
    @Test
    public void testPrixMoyenAvecUneVoiture() {
        StatistiqueImpl statistique = new StatistiqueImpl();

        // Ajout d'une voiture
        statistique.ajouter(new Voiture("Tesla", 50000));

        // Calcul du prix moyen
        Echantillon echantillon = statistique.prixMoyen();

        // Vérifie qu'une seule voiture est comptée
        assertEquals(1, echantillon.getNombreDeVoitures());

        // Vérifie que le prix moyen est égal au prix de cette seule voiture
        assertEquals(50000, echantillon.getPrixMoyen());
    }

    // Test du cas où aucune voiture n’est ajoutée
    @Test
    public void testPrixMoyenAvecAucuneVoiture() {
        StatistiqueImpl statistique = new StatistiqueImpl();

        // Vérifie que le calcul du prix moyen sans voiture déclenche une ArithmeticException
        assertThrows(ArithmeticException.class, statistique::prixMoyen);
    }
}
