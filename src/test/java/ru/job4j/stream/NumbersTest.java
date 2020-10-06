package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NumbersTest {

    @Test
    public void getPositiveNum() {
        Numbers numbers = new Numbers();
        List<Integer> src = Arrays.asList(6, -2, 0, -32, 4, -232, 224, 112, 1212, -76);
        assertThat(numbers.filterPositive(src), is(Arrays.asList(6, 0, 4, 224, 112, 1212)));
    }
}