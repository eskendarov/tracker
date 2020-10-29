package ru.job4j.stream.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamJob4j {

    private static Function<Integer, Integer> map;
    private static Predicate<Integer> filter;
    private static final ArrayList<Integer> source = new ArrayList<>();
    private static final ArrayList<Integer> dest = new ArrayList<>();
    private static StreamJob4j streamJob4j;

    private StreamJob4j() {
    }

    public static StreamJob4j getInstance() {
        if (streamJob4j == null) {
            streamJob4j = new StreamJob4j();
        }
        return streamJob4j;
    }

    static StreamJob4j of(Integer... args) {
        source.addAll(List.of(args));
        return getInstance();
    }

    public StreamJob4j map(Function<Integer, Integer> mapper) {
        map = mapper;
        return getInstance();
    }

    public StreamJob4j filter(Predicate<Integer> predicate) {
        filter = predicate;
        return getInstance();
    }

    public ArrayList<Integer> collect() {
        source.forEach(integer -> {
            int el = map.apply(integer);
            if (filter.test(el)) {
                dest.add(el);
            }
        });
        return dest;
    }
}
