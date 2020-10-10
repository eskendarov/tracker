package ru.job4j.collection;

import java.util.Set;

public class UniqueText {

    public static boolean isEquals(String originText, String duplicateText) {
        return Set.of(originText.split(" "))
                .containsAll(Set.of(duplicateText.split(" ")));
    }
}