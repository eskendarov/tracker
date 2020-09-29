package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String s : value.split("/")) {
                start = start + s;
                tmp.add(start); // Операция добавления HashSet (O(1)) быстрее чем в TreeSet (O(log n))
                start = start + "/";
            }
        }
        return new ArrayList<>(new TreeSet<>(tmp));
    }

    public static List<String> sortAsc(List<String> orgs) {
        Collections.sort(orgs);
        return orgs;
    }

    public static List<String> sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
        return orgs;
    }
}