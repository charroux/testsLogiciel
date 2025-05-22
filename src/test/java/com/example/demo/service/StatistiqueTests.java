package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;


import static org.mockito.Mockito.*;


@SpringBootTest
public class StatistiqueTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;
    @Mock
    private Voiture voiture1;
    @Mock
    private Voiture voiture2;
    @Mock
    private Voiture voiture3;

    @Mock
    private ArrayList<Voiture> ListVoiture;

    @Test
    @BeforeEach
    public void CreationVoiture(){

        MockitoAnnotations.initMocks(this);

        voiture1 = new Voiture("Renault",2000);
        voiture2 = new Voiture("Mercedes", 2000);
        voiture3 = new Voiture("Pegot",2000);

        ListVoiture = new ArrayList<Voiture>();

    }

    @Test
    public Echantillon testPrixMoyen() throws ArithmeticException {
        statistiqueImpl.ajouter(voiture1);
        statistiqueImpl.ajouter(voiture2);
        statistiqueImpl.ajouter(voiture3);

        Echantillon echantillon = statistiqueImpl.prixMoyen();

        assertNotNull(echantillon);
        assertEquals(3, echantillon.getNombreDeVoitures());
        assertEquals(6000, echantillon.getPrixMoyen());

        return echantillon;
    }

}

