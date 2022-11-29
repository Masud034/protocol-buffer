package org.example.protobuf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.masudulalam.models.Person;
import org.example.json.JPerson;
import java.io.IOException;

public class PerformanceTest {
    public static void main(String[] args) {
        //json
        JPerson jPerson = new JPerson();
        jPerson.setName("Masudul Alam");
        jPerson.setAge(10);
        ObjectMapper mapper = new ObjectMapper();

        Runnable json = ()-> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(jPerson);
                JPerson desJPerson = mapper.readValue(bytes, JPerson.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        //protobuff
        Person protoPerson = Person
                .newBuilder()
                .setName("Masudul Alam")
                .setAge(10)
                .build();

        Runnable protobuf = ()-> {
            try {
                byte[] bytes = protoPerson.toByteArray();
                Person desProtoPerson = Person.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        };

        //run performance test
        runPerformanceTest(json, "json");
        runPerformanceTest(protobuf, "protobuff");
    }

    private static void runPerformanceTest(Runnable runnable, String method) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1_000_000; i++) {
            runnable.run();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(method + " took " + (endTime-startTime) + " ms");
    }
}
