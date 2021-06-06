package ru.job4j.stream;

/**
 * Card Class description goes here.
 *
 * @author Enver Eskendarov
 * @version 1.0 06/06/2021
 */
public class Card {

    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", suit, value);
    }
}
