package com.elo.prova.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.Normalizer;

public class ObjHelper {

    private ObjHelper() { }

    public static String objToJsonString(Object object) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer();

        return objectWriter.writeValueAsString(object);
    }

    public static String normalizarString(String palavra) {
        return Normalizer.normalize(palavra, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toUpperCase();
    }
}
