package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;


@SpringBootTest
public class StatistiqueTests {

    private StatistiqueImpl statistiqueImpl;
	
    @BeforeAll
    static void initAll(){
    statistiqueImpl = new StatistiqueImpl();
    Voiture voiture = new Voiture("Toyota",15000F);
    statistiqueImpl.ajouter(voiture); 
    }

    @Test
    @DisplayName("Tout ce passe bien")
    void correctTest(){
	    assertEquals(new Echantillon(1,1500F),satistiqueImpl.prixMoyen());

    }


}
