package ru.job4j.poly;

/**
 * Airplane Class description goes here.
 *
 * @author Enver Eskendarov
 * @version 1.0 06/06/2021
 */
public class Airplane implements Vehicle {

    @Override
    public void move() {
        System.out.print(" Взлетает с полосы.");
    }

    @Override
    public void coolConditioner() {
    }
}
