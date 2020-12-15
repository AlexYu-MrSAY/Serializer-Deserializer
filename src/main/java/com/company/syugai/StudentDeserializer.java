package com.company.syugai;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentDeserializer extends StdDeserializer<Student> {
    public StudentDeserializer(){
        super(Student.class);
    }

    public Student deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        JsonNode firstNameNode = root.get("firstName");
        String firstName = firstNameNode.asText();
        String lastName = root.get("lastName").asText();
        String birthdayString = root.get("birthday").asText();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDate birthday = LocalDate.parse(birthdayString, f);
        return new Student(firstName, lastName, birthday);
    }
}
