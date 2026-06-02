package com.example.demo.data;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    private static Voiture voiture;
    private static Voiture voiture_avec_attribut;
    
    @BeforeAll 
    static void initAll(){
	voiture = new Voiture();
	voiture_avec_attribut = new Voiture("Toyota",15000);	
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
	assertThat(voiture_avec_attribut.getMarque(),not("Renault"));
	assertThat(voiture_avec_attribut.getPrix(),not(8545646));
    }



}
