package com.elo.prova.utils;

import com.elo.prova.exame2.model.PessoaModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObjHelperTest {

    @Test
    public void objToJsonString() throws Exception {

        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setNome("Renato");

        String pessoaJson = ObjHelper.objToJsonString(pessoaModel);

        assertEquals(pessoaJson,
                "{\"id\":null,\"nome\":\"Renato\",\"rg\":null,\"dataNascimento\":null,\"pessoaContatos\":null}");
    }

    @Test
    public void normalizarString() {
        String stringNormalizada = ObjHelper.normalizarString("Ação");

        assertEquals("ACAO", stringNormalizada);
    }
}