package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LambdaBlock {

    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println(String.format("compare - %s : %s", right, left));
            return right.compareTo(left);
        };
        ArrayList<String> list = new ArrayList<>(Arrays.asList("aaaa", "ddddd","bbbbb","wwwww"));
        list.sort(cmpDescSize);
    }
}
