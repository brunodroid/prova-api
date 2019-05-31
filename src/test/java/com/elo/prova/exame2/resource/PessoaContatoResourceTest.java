package com.elo.prova.exame2.resource;

import com.elo.prova.exame2.model.PessoaContatoModel;
import com.elo.prova.exame2.utils.ObjHelper;
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

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PessoaContatoResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listarPessoaContatosTest() throws Exception {

        mockMvc.perform(get("/pessoas/1/contatos")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(2)))
                .andExpect(jsonPath("content[*].id", hasItem(1)))
                .andExpect(jsonPath("content[*].nome", hasItem("Renato")));
    }

    @Test
    public void getPessoaContatoTest() throws Exception {

        mockMvc.perform(get("/pessoas/1/contatos/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("nome", is("Renato")));
    }

    @Test
    public void addPessoaContato() throws Exception {

        PessoaContatoModel pessoaContatoModel = new PessoaContatoModel();
        pessoaContatoModel.setNome("Airton");

        String contatoJson = ObjHelper.objToJsonString(pessoaContatoModel);

        mockMvc.perform(post("/pessoas/1/contatos/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(contatoJson)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id", is(4)))
                .andExpect(jsonPath("nome", is("Airton")));
    }

    @Test
    public void updatePessoaContato() throws Exception {

        PessoaContatoModel pessoaContatoModel = new PessoaContatoModel();
        pessoaContatoModel.setNome("Rayssa");

        String contatoJson = ObjHelper.objToJsonString(pessoaContatoModel);

        mockMvc.perform(put("/pessoas/2/contatos/update/3")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(contatoJson)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(3)))
                .andExpect(jsonPath("nome", is("Rayssa")));
    }

    @Test
    public void deletePessoaContato() throws Exception {

        mockMvc.perform(delete("/pessoas/2/contatos/delete/3"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNoContent());
    }
}