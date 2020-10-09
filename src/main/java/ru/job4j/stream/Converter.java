package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class
Converter {

    public Map<String, Student> toMap(List<Student> list) {
        return list.stream().collect(Collectors.toMap(
                Student::getSurname, // key
                student -> student, // value
                (value, equalKeyValue) -> equalKeyValue) // if the key exists, the value is overwritten
        );
    }
}
