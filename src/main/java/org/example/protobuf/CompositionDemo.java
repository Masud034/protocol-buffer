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
        Car car = Car
                .newBuilder()
                .setMake("Toyota")
                .setModel("V8")
                .setYear(2020)
                .build();

        Person person = Person
                .newBuilder()
                .setName("Masudul Alam")
                .setAge(10)
                .setAddress(address)
                .setCar(car)
                .build();

        System.out.println(person);
    }
}
