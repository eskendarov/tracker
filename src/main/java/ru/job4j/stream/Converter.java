package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class
Converter {

    public Map<String, Student> toMap(List<Student> list) {
        return list.stream().distinct().collect(Collectors.toMap(key -> key.getSurname(), value -> value));
    }
}
