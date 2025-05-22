package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.StatistiqueImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetStatistiques() throws Exception {
        Echantillon echantillon = new Echantillon();
        echantillon.setPrixMoyen(15000);

        when(statistiqueImpl.prixMoyen()).thenReturn(echantillon);

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.prixMoyen").value(15000))
                .andDo(print());

        verify(statistiqueImpl, times(1)).prixMoyen();
    }

    @Test
    void testCreerVoiture() throws Exception {

        Voiture voiture = new Voiture();
        voiture.setMarque("Toyota");
        voiture.setMarque("Corolla");
        voiture.setPrix(20000);

        mockMvc.perform(post("/voiture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"marque\":\"Toyota\",\"modele\":\"Corolla\",\"prix\":20000}"))
                .andExpect(status().isOk())
                .andDo(print());

        verify(statistiqueImpl, times(1)).ajouter(any(Voiture.class));
    }
}

