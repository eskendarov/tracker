package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrixTest {

    @Test
    public void when2on2ArrayThenList4() {
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> result = ConvertMatrix.toList(input);
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        assertThat(result, is(expect));
    }
}