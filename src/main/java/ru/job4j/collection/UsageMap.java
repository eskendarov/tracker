package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UsageMap {

    public static void main(String[] args) {
        Map<String, String> students = new HashMap<>();
        students.put("envereskendarov@gmail.com", "Enver Eskendarov");
        students.put("oleg.iv@gmail.com", "Oleg Ivanov");
        students.put("pechkin@gmail.com", "Pochtalyon Pechkin");
        for (String key : students.keySet()) {
            System.out.println("KEY: " + key + "  VALUE: " + students.get(key));
        }
    }
}
