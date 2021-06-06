package ru.job4j.ooa;

/**
 * Airbus Class description goes here.
 *
 * @author Enver Eskendarov
 * @version 1.0 06/06/2021
 */
public final class Airbus extends AirCraft {

    private static final int COUNT_ENGINE = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        System.out.println("Количество двигателей равно: "
                + (name.equals("A380") ? 4 : COUNT_ENGINE));
    }

    @Override
    public String toString() {
        return "Airbus{name=" + name + '}';
    }
}
