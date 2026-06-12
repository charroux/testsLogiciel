package com.example.demo.web;

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
    void ajouterVoiture() throws Exception {
        mockMvc.perform(post("/voiture")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"marque\":\"Renault\",\"prix\":10000}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getStatistiques() throws Exception {
        // On configure le faux service pour retourner un échantillon
        when(statistiqueImpl.prixMoyen())
                .thenReturn(new Echantillon(2, 15000));

        mockMvc.perform(get("/statistique"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value(2))
                .andExpect(jsonPath("$.prixMoyen").value(15000));
    }

    @Test
    void getStatistiquesSansVoiture() throws Exception {
        // Le faux service lance une ArithmeticException (liste vide)
        when(statistiqueImpl.prixMoyen())
                .thenThrow(new ArithmeticException());

        mockMvc.perform(get("/statistique"))
                .andDo(print())
                .andExpect(status().isNotFound()); // 404
    }
}