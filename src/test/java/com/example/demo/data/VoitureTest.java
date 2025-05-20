package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    private final Voiture v1 = new Voiture();

    @Test
    void creerVoiture(){

        v1.setId(204);
        v1.setMarque("Maza");
        v1.setPrix(600000);

        assertEquals(204, v1.getId());
        assertEquals("Maza", v1.getMarque());
        assertEquals(600000, v1.getPrix());

    }

}
