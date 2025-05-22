package com.example.demo.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoitureTest{

    private Voiture voiture;
    /** L'annotation BeforeEach permet d'initialser
     *
     */
    /**une voiture commune pour chaque test*/
    @BeforeEach
    void initialiserVoiture(){
        voiture = new Voiture(); /** initialisation pour chaque test */
    }
    /**Annotaion de test*/
    @Test
    void TestVoitureRenault(){
        /** On enregistre ces première valeurs au newVoiture() vide*/
        voiture.setMarque("Renault");
        voiture.setPrix(12000);

        /** On vérifie si les valeurs sont ceux enregistrés*/
        assertEquals("Renault", voiture.getMarque());
        assertEquals(12000, voiture.getPrix());
    }

    @Test
    void TestVoitureAudi(){

        /** On modifie setMarque et SetPrix - Enregistrement */
        voiture.setMarque("Audi");
        voiture.setPrix(22000);

        /** On vérifie si les valeurs sont ceux enregistrés encore */
        assertEquals("Audi", voiture.getMarque());
        assertEquals(22000, voiture.getPrix());
    }

    @Test
    /**On va tester si le test assertEquals marche pour le champ id*/
    void modifierIdVoiture(){
        voiture.setId(10);
        assertEquals(10, voiture.getId());
    }
}
/**Test finito*/
