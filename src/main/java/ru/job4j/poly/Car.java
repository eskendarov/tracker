package ru.job4j.poly;

/**
 * Car Class description goes here.
 *
 * @author Enver Eskendarov
 * @version 1.0 06/06/2021
 */
public class Car implements Vehicle {

    @Override
    public void move() {
        System.out.print(" Едет по трассе.");
    }

    @Override
    public void coolConditioner() {
        System.out.print(" Включен кондиционер.");
    }
}
