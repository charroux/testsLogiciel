package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StatistiqueImplTest {

    Statistique statistique;

    @BeforeEach
    void setUp() {
        statistique = new StatistiqueImpl();
    }

    @Test
    void prixMoyenUneVoiture() throws ArithmeticException {
        Voiture v = new Voiture("Renault", 10000);
        statistique.ajouter(v);

        Echantillon e = statistique.prixMoyen();

        assertEquals(1, e.getNombreDeVoitures());
        assertEquals(10000, e.getPrixMoyen());
    }

    @Test
    void prixMoyenPlusieursVoitures() throws ArithmeticException {
        statistique.ajouter(new Voiture("Renault", 10000));
        statistique.ajouter(new Voiture("Peugeot", 20000));
        statistique.ajouter(new Voiture("Toyota", 30000));

        Echantillon e = statistique.prixMoyen();

        assertEquals(3, e.getNombreDeVoitures());
        assertEquals(20000, e.getPrixMoyen()); // (10000+20000+30000)/3
    }

    @Test
    void prixMoyenSansVoiture() {
        assertThrows(ArithmeticException.class, () -> {
            statistique.prixMoyen();
        });
    }
}