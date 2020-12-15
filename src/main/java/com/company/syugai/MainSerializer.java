package com.company.syugai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.time.LocalDate;

public class MainSerializer {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = new Student("John", "Doe", LocalDate.of(2002, 07, 11));
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Student.class, new StudentSerializer());
        objectMapper.registerModule(simpleModule);
        System.out.println(objectMapper.writeValueAsString(student));
    }
}
