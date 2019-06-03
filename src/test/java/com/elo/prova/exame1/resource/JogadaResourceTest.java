package com.elo.prova.exame1.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class JogadaResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void iniciarTest() throws Exception {

        mockMvc.perform(post("/jogos/iniciar?qtdVidas=5")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("letrasInformadas", is("")))
                .andExpect(jsonPath("qtdVidas", is(5)))
                .andExpect(jsonPath("qtdTentativas", is(0)))
                .andExpect(jsonPath("status", is("START")));
    }

    @Test
    public void tentarLetraTest() throws Exception {

        iniciarTest();

        mockMvc.perform(post("/jogos/tentar?idJogada=1&letra=E")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("letrasInformadas", is("E")))
                .andExpect(jsonPath("qtdTentativas", is(1)))
                .andExpect(jsonPath("status", is("RUNNING")));
    }

    @Test
    public void cancelarTest() throws Exception {

        iniciarTest();

        mockMvc.perform(post("/jogos/cancelar?idJogada=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("status", is("CANCELLED")));
    }
}