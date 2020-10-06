package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    public List<Integer> filterPositive(List<Integer> list) {
        return list.stream()
                .filter(integer -> integer >= 0)
                .collect(Collectors.toList());
    }
}
