package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {

    @Test
    public void convert() {
        List<Student> students = Arrays.asList(
                new Student(23, "Krakovskaya"),
                new Student(11, "Sharikov"),
                new Student(33, "Poligraph"),
                new Student(11, "Sharikov"),
                new Student(44, "Bormental")
        );
        Map<String, Student> studentMap = new Converter().toMap(students);
        Map<String, Student> expeted = new HashMap<>();
        expeted.put("Poligraph", new Student(33, "Poligraph"));
        expeted.put("Sharikov", new Student(11, "Sharikov"));
        expeted.put("Bormental", new Student(44, "Bormental"));
        expeted.put("Krakovskaya", new Student(23, "Krakovskaya"));
        assertThat(studentMap, is(expeted));
    }
}