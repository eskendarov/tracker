package ru.job4j.stream.exam;

public class StreamJob4jUsage {

    public static void main(String[] args) {
        StreamJob4j.of(1, 2, 4, 4, 6, 7, 8, 8, 9, 6, 4, 3)
                .map(integer -> integer + 1)
                .filter(integer -> integer > 3)
                .collect();
    }
}
