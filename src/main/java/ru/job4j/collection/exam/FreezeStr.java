package ru.job4j.collection.exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FreezeStr {

    public static boolean eq(String left, String right) {
        List<String> leftList = new LinkedList<>(Arrays.asList(left.split("")));
        List<String> rightList = new LinkedList<>(Arrays.asList(right.split("")));
        Collections.sort(leftList);
        Collections.sort(rightList);
        return leftList.equals(rightList);
    }
}