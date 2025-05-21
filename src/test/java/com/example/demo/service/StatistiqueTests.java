package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StatistiqueTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Test
    public void testAjouterNouvelleVoiture() {
        Voiture voiture = new Voiture("Skoda", 22_000);

        statistiqueImpl.ajouter(voiture);
        verify(statistiqueImpl, times(1)).ajouter(voiture);
    }
	// test
    @Test
    public void testPrixMoyenReel() {
        Voiture voiture1 = new Voiture("Toyota", 15_000);
        Voiture voiture2 = new Voiture("Lexus", 45_000);

        Statistique statistique = new StatistiqueImpl();

        statistique.ajouter(voiture1);
        statistique.ajouter(voiture2);

        Echantillon echantillon = statistique.prixMoyen();

        assertEquals(2, echantillon.getNombreDeVoitures());
        assertEquals(30_000, echantillon.getPrixMoyen());
    }

    @Test
    void testGetPrixSimple(){
        Voiture voiture = new Voiture("Fiat", 9_500);
        assertEquals(9_500, voiture.getPrix());
    }

    @Test
    void testPrixMoyenAvecMock(){
        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(3, 12_000));

        Voiture voiture1 = new Voiture("Dacia", 10_000);
        Voiture voiture2 = new Voiture("Mazda", 12_000);
        Voiture voiture3 = new Voiture("Suzuki", 14_000);

        statistiqueImpl.ajouter(voiture1);
        statistiqueImpl.ajouter(voiture2);
        statistiqueImpl.ajouter(voiture3);

        assertEquals(12_000, statistiqueImpl.prixMoyen().prixMoyen);
    }
}
