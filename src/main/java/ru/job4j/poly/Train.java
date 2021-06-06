package ru.job4j.poly;

/**
 * Train Class description goes here.
 *
 * @author Enver Eskendarov
 * @version 1.0 06/06/2021
 */
public class Train implements Vehicle{

    @Override
    public void move() {
        System.out.print(" Едет по рельсам.");
    }

    @Override
    public void coolConditioner() {
        System.out.print(" Кондиционер неисправен.");
    }
}
