package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class
Converter {

    public Map<String, Student> toMap(List<Student> list) {
        return list.stream().collect(Collectors.toMap(
                Student::getSurname, // key
                student -> student, // value
                (value, equalKeyValue) -> equalKeyValue) // if the key exists, the value is overwritten
        );
    }

    public List<Integer> toIntegerList(Integer[][] sourceInt) {
        return Stream.of(sourceInt)
                .flatMap(Arrays::stream) // converting an element from a stream to a stream
                .collect(Collectors.toList());
    }
}
