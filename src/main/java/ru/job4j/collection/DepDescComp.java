package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        // Делим строки на две части по выражению - "/"
        // если строка не содержит выражение "/", объявим вторую часть пустой строкой
        String[] arr1 = o1.contains("/") ? o1.split("/", 2) : new String[]{o1, ""};
        String[] arr2 = o2.contains("/") ? o2.split("/", 2) : new String[]{o2, ""};
        // 1-ую часть сортируем по убыванию
        int rsl = arr2[0].compareTo(arr1[0]);
        // Если элементы 1-ой части равны, сортируем по возрастанию
        return rsl == 0 ? arr1[1].compareTo(arr2[1]) : rsl;
    }
}