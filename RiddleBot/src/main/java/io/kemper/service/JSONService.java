package io.kemper.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONService {

    public static String marshall(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String body = null;
        try {
            body = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return body;
    }

    public static <T> T unmarshall(String str, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        T obj = null;
        try {
            obj = mapper.readValue(str, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }


}
