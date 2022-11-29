package org.example.protobuf;

import com.masudulalam.models.Car;
import com.masudulalam.models.Dealer;

public class MapDemo {
    public static void main(String[] args) {
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
                .setYear(2019)
                .build();

        Dealer dealer = Dealer
                .newBuilder()
                .putModel(2021, v8)
                .putModel(2022, accord)
                .build();

        System.out.println(dealer.getModelOrThrow(2021));
        System.out.println(dealer.getModelOrDefault(2001, accord));
        System.out.println(dealer.getModelOrThrow(2001));
    }
}
