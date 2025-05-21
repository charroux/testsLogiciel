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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void statistique_test() throws Exception {
        // Changed values here
        doNothing().when(statistiqueImpl).ajouter(any(Voiture.class));
        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(5, 40000));  // 5 cars, average price 40,000

        mockMvc.perform(get("/statistique"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value(5))  // Updated to 5 cars
                .andExpect(jsonPath("$.prixMoyen").value(40000))  // Updated to 40,000
                .andReturn();
    }

    @Test
    public void voiture_test() throws Exception {
        // Changed values here
        mockMvc.perform(post("/voiture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"marque\": \"BMW\", \"prix\": 70000 }")  // Updated car model to BMW and price to 70,000
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        verify(statistiqueImpl, times(1)).ajouter(any(Voiture.class));
    }

    @Test
    public void voiture_test_exception() throws Exception {
        // Changed exception handling
        doNothing().when(statistiqueImpl).ajouter(any(Voiture.class));
        when(statistiqueImpl.prixMoyen()).thenThrow(new ArithmeticException("Erreur de calcul du prix moyen"));  // Updated exception message

        mockMvc.perform(get("/statistique"))
                .andDo(print())
                .andExpect(status().is4xxClientError())  // Client error (4xx) due to exception
                .andReturn();
    }

}
