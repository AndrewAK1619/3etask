package com.example.etask.calculator;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldAddAndReturnJsonWithValueEqual20_0() throws Exception {
        mockMvc.perform(post("/api/calculator/add/10/10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value("20.0"));
    }

    @Test
    void shouldAddAndReturnJsonWithValueEqual0() throws Exception {
        mockMvc.perform(post("/api/calculator/add/-10.2/10.2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value("0.0"));
    }

    @Test
    void shouldAddAndReturnJsonWithValueEqual444_48() throws Exception {
        mockMvc.perform(post("/api/calculator/add/210.28/220.2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value("430.48"));
    }

    @Test
    void shouldDivideAndReturnJsonWithValueEqual20_0() throws Exception {
        mockMvc.perform(get("/api/calculator/div/10/10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value("1.0"));
    }

    @Test
    void shouldDivideAndReturnJsonWithValueEqual() throws Exception {
        mockMvc.perform(get("/api/calculator/div/-12/10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value("-1.2"));
    }

    @Test
    void shouldNotDivideBy0() throws Exception {
        mockMvc.perform(get("/api/calculator/div/10/0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("/ by zero"));
    }
}
