package ru.job4j.stream;

/**
 * UsageCarBuilder Class.
 *
 * @author Enver Eskendarov
 * @version 1.0 06/06/2021
 */
public class UsageCarBuilder {

    public static void main(String[] args) {
        final Car bmw = new Car.Builder()
                .vinCode("12WY872")
                .volume("V12")
                .color("Red")
                .model("BMW M6")
                .weight("1500")
                .build();
        final Car ford = new Car.Builder()
                .color("Black")
                .model("Ford Mustang")
                .build();
        final Car lada = new Car.Builder(
                "V6",
                "Lada S",
                "White",
                "12Y1",
                "1300"
        ).build();
        System.out.println(bmw);
        System.out.println(ford);
        System.out.println(lada);
    }
}
