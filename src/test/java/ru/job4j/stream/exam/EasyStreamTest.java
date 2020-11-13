package ru.job4j.stream.exam;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EasyStreamTest {

    @Test
    public void whenEmptySource() {
        var result = EasyStream.of(List.of()).collect();
        assertThat(result, is(List.of()));
    }

    @Test
    public void whenFilledSource() {
        var result = EasyStream.of(List.of(1, 2, 3))
                .collect();
        assertThat(result, is(List.of(1, 2, 3)));
    }

    @Test
    public void whenFilteredSource() {
        var result = EasyStream.of(List.of(1, 2, 3))
                .filter(e -> e == 2)
                .collect();
        assertThat(result, is(List.of(2)));
    }

    @Test
    public void whenMappedSource() {
        var result = EasyStream.of(List.of(1, 2, 3))
                .map(e -> e * 2)
                .collect();
        assertThat(result, is(List.of(2, 4, 6)));
    }

    @Test
    public void whenFilteredMappedSource() {
        var result = EasyStream.of(List.of(1, 2, 3))
                .filter(e -> e == 2)
                .map(e -> e * 2)
                .collect();
        assertThat(result, is(List.of(4)));
    }

    @Test
    public void whenMappedFilteredSource() {
        var result = EasyStream.of(List.of(1, 2, 3))
                .map(e -> e * 2)
                .filter(e -> e == 4)
                .collect();
        assertThat(result, is(List.of(4)));
    }

    @Test
    public void whenMultiFilterSource() {
        var result = EasyStream.of(List.of(1, 2, 3, 4, 5))
                .filter(e -> e >= 2)
                .filter(e -> e <= 4)
                .collect();
        assertThat(result, is(List.of(2, 3, 4)));
    }
}
