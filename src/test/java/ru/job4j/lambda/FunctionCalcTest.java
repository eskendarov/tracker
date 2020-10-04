package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FunctionCalcTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionCalc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FunctionCalc.diapason(1, 4, x -> 2 * Math.pow(x, 2) + 1 * x + 2);
        List<Double> expected = Arrays.asList(5D, 12D, 23D, 38D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = FunctionCalc.diapason(1, 4, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(3D, 9D, 27D, 81D);
        assertThat(result, is(expected));
    }
}