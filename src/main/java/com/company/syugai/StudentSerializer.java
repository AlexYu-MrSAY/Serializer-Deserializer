package com.company.syugai;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class StudentSerializer extends StdSerializer<Student> {
    public StudentSerializer(){
        super(Student.class);
    }
    public void serialize(Student student, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("firstName", student.getFirstName());
        jsonGenerator.writeStringField("lastName", student.getLastName());
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        jsonGenerator.writeStringField("birthday", student.getBirthday().format(f));
        jsonGenerator.writeEndObject();
    }

}
