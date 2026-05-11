package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StatistiqueTests {

    @Test
    void ajouterEtCalculerPrixMoyen() {
        StatistiqueImpl statistiqueImpl = new StatistiqueImpl();

        statistiqueImpl.ajouter(new Voiture("Renault", 12000));
        statistiqueImpl.ajouter(new Voiture("Peugeot", 18000));
        statistiqueImpl.ajouter(new Voiture("Toyota", 15000));

        Echantillon echantillon = statistiqueImpl.prixMoyen();

        assertEquals(3, echantillon.getNombreDeVoitures());
        assertEquals(15000, echantillon.getPrixMoyen());
    }

    @Test
    void prixMoyenSansVoitureDeclencheUneException() {
        StatistiqueImpl statistiqueImpl = new StatistiqueImpl();

        assertThrows(ArithmeticException.class, statistiqueImpl::prixMoyen);
    }

}
