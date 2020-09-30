package ru.job4j.collection.exam;

import java.util.Arrays;
import java.util.HashSet;

public class Article {

    public static boolean generateBy(String origin, String line) {
        return new HashSet<>(Arrays.asList(origin.split("\\b")))
                .containsAll(Arrays.asList(line.split(" ")));
    }
}