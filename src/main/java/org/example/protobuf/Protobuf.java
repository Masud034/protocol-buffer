package org.example.protobuf;

import com.masudulalam.models.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Protobuf {
    public static void main(String[] args) throws IOException {
        Person person = Person
                .newBuilder()
                .setName("Masudul Alam")
                .setAge(10)
                .build();
        System.out.println(person);

        Path path = Paths.get("file.ser");
        //serialization
        Files.write(path, person.toByteArray());
        //deserialization
        byte[] bytes = Files.readAllBytes(path);
        Person desPerson = Person.parseFrom(bytes);
        System.out.println(desPerson);
    }
}
