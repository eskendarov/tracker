package ru.job4j.stream.exam;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJob4j {

    static Stream<Integer> integerStream;

    public StreamJob4j(Stream<Integer> integerStream) {
        this.integerStream = integerStream;
    }

    static StreamJob4j of(Integer... args) {
        return new StreamJob4j(Stream.of(args));
    }

    static StreamJob4j map(Function<Integer, Integer> mapper) {
        return new StreamJob4j(integerStream.map(mapper));
    }

    static StreamJob4j filter(Predicate<Integer> predicate) {
        return new StreamJob4j(integerStream.filter(predicate));
    }

    static List<Integer> collect() {
        return integerStream.collect(Collectors.toList());
    }
}
