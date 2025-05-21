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
    public void getStatistiques() throws Exception {
        doNothing().when(statistiqueImpl).ajouter(new Voiture("Mclaren F1 GTR", 20_000_000));
        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(1,20_000_000));
        mockMvc.perform(get("/statistique"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value("1"))
                .andExpect(jsonPath("$.prixMoyen").value(20_000_000))
                .andReturn();
    }

    @Test
    public void testCreerVoiture() throws Exception {
        mockMvc.perform(post("/voiture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"marque\": \"Opel\", \"prix\" : 1000000 }")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetStatistiquesWithoutCar() throws Exception {
        when(statistiqueImpl.prixMoyen()).thenThrow(new ArithmeticException());
        mockMvc.perform(get("/statistique"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();
    }
}
