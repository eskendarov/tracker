package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] arr1 = o1.split("/", 2);
        String[] arr2 = o2.split("/", 2);
        // 1-ую часть сортируем по убыванию
        int rsl = arr2[0].compareTo(arr1[0]);
        // Если элементы 1-ой части равны, сортируем по возрастанию
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}