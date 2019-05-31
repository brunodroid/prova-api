package com.elo.prova.exame2.resource;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.elo.prova.exame2.model.PessoaModel;
import com.elo.prova.utils.ObjHelper;
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
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PessoaResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listarPessoasTest() throws Exception {

        mockMvc.perform(get("/pessoas")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(2)))
                .andExpect(jsonPath("content[*].id", hasItem(1)))
                .andExpect(jsonPath("content[*].id", hasItem(2)))
                .andExpect(jsonPath("content[*].nome", hasItem("Bruno")))
                .andExpect(jsonPath("content[*].nome", hasItem("Jaqueline")));
    }

    @Test
    public void getPessoaTest() throws Exception {

        mockMvc.perform(get("/pessoas/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("nome", is("Bruno")));
    }

    @Test
    public void addPessoaTest() throws Exception {

        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setNome("Renato");

        String pessoaJson = ObjHelper.objToJsonString(pessoaModel);

        mockMvc.perform(post("/pessoas/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(pessoaJson)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id", is(3)))
                .andExpect(jsonPath("nome", is("Renato")));
    }

    @Test
    public void updatePessoaTest() throws Exception {

        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setNome("Jaque");

        String pessoaJson = ObjHelper.objToJsonString(pessoaModel);

        mockMvc.perform(put("/pessoas/update/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(pessoaJson)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(2)))
                .andExpect(jsonPath("nome", is("Jaque")));
    }

    @Test
    public void deletePessoaTest() throws Exception {

        mockMvc.perform(delete("/pessoas/delete/2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNoContent());
    }

}