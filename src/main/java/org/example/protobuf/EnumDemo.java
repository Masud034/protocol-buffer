package org.example.protobuf;

import com.masudulalam.models.Address;
import com.masudulalam.models.BodyType;
import com.masudulalam.models.Car;
import com.masudulalam.models.Person;

public class EnumDemo {
    public static void main(String[] args) {
        Address address = Address
                .newBuilder()
                .setStreet("Ceramic Road")
                .setCity("Dhaka")
                .setPostCode(1216)
                .build();

        Car v8 = Car
                .newBuilder()
                .setMake("Toyota")
                .setModel("V8")
                .setYear(2020)
                .setBodyType(BodyType.SUV)
                .build();

        Car accord = Car
                .newBuilder()
                .setMake("Honda")
                .setModel("accord")
                .setYear(2020)
                .setBodyType(BodyType.SEDAN)
                .build();

        Car civic = Car
                .newBuilder()
                .setMake("Honda")
                .setModel("civic")
                .setYear(2019)
                .build();

        Person person = Person
                .newBuilder()
                .setName("Masudul Alam")
                .setAge(10)
                .setAddress(address)
                .addCar(accord)
                .addCar(v8)
                .addCar(civic)
                .build();

        System.out.println(person);
        System.out.println(person.getCar(2).getBodyType());
    }
}
