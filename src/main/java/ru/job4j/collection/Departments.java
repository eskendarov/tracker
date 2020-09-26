package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String s : value.split("/")) {
                start = start + s;
                tmp.add(start);
                start = start + "/";
            }
        }
        return sortAsc(new ArrayList<>(tmp));
    }

    public static List<String> sortAsc(List<String> orgs) {
        Collections.sort(orgs);
        return orgs;
    }

    public static List<String> sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
        return orgs;
    }
}