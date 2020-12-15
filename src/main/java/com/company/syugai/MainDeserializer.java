package com.company.syugai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class MainDeserializer {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"birthday\":\"11-июл.-2002\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Student.class, new StudentDeserializer());
        objectMapper.registerModule(module);
        Student student = objectMapper.readValue(json, Student.class);
        System.out.println(student);
    }
}
