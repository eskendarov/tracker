package ru.job4j.poly;

/**
 * VehicleUsage Class description goes here.
 *
 * @author Enver Eskendarov
 * @version 1.0 06/06/2021
 */
public class VehicleUsage {

    public static void main(String[] args) {
        final Vehicle[] vehicles = {
                new Car(), new Airplane(), new Train(),
                new Airplane(), new Train(), new Car()
        };
        for (Vehicle vehicle : vehicles) {
            System.out.print(vehicle.getClass().getSimpleName());
            vehicle.move();
            vehicle.coolConditioner();
            System.out.println();
        }
    }
}
