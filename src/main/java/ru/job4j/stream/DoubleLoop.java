package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DoubleLoop -  генерирует колоду карт.
 *
 * @author Enver Eskendarov
 * @version 1.0 06/06/2021
 */
public class DoubleLoop {

    public static void main(String[] args) {
        final List<Card> cards = Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(
                        Value.values()).map(value -> new Card(suit, value))
                ).collect(Collectors.toList());
        cards.forEach(System.out::println);
    }
}
