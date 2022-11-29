package org.example.protobuf;

import com.masudulalam.models.Address;
import com.masudulalam.models.Car;
import com.masudulalam.models.Person;

public class CompositionDemo {
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
                .build();

        Car accord = Car
                .newBuilder()
                .setMake("Honda")
                .setModel("accord")
                .setYear(2020)
                .build();

        Person person = Person
                .newBuilder()
                .setName("Masudul Alam")
                .setAge(10)
                .setAddress(address)
                .addCar(v8)
                .addCar(accord)
                .build();

        System.out.println(person);
    }
}
