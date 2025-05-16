package com.example.demo.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    Voiture v1;

    @BeforeEach
    void CreationVoiture(){
        this.v1 = new Voiture("Audi",15000);
    }
    @Test
    void creerVoiture(){
        assertEquals(1,1);
    }

    @Test
    void  TestVoiture(){

        assertEquals("Audi",v1.getMarque());
        assertEquals(15000,v1.getPrix());
        assertEquals(0,v1.getId());

        String expectedToString = "Car{marque='Audi', prix=15000, id=0}";
        assertEquals(expectedToString, v1.toString());

        v1.setId(1);
        v1.setMarque("Renault");
        v1.setPrix(10000);

        assertEquals(1,v1.getId());
        assertEquals("Renault",v1.getMarque());
        assertEquals(10000,v1.getPrix());

    }
}
