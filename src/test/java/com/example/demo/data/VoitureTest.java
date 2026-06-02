package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    @BeforeAll 
    static void initAll(){
	Voiture voiture = new Voiture();
	Voiture voiture_avec_attribut = new Voiture("Toyota",15000);	
    }
	
    @Test
    @DisplayName("Initiation Working perfectly")
    void testInit(){
        voiture.setMarque("Peugeot");
	voiture.setPrix(18000);
	assertEquals("Peugeot" , voiture.getMarque());
	assertEquals(18000, voiture.getPrix());
    }

    @Test
    @DisplayName("Test Already initalize with correct attribut")
    void alreadyInit(){
	assertEquals("Toyota", voiture_avec_attribut.getMarque());
	assertEquals(15000, voiture_avec_attribut.getPrix());
    }

    @Test
    @DisplayName("Test Already initalize with uncorrected attribut")
    void FalseAttribut(){
	assertThat("Renault", not(voiture_avec_attribut.getMarque());
	assertThat(8515151, not(voiture_avec_attribut.getPrix());
    }



}
