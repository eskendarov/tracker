package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    Output out = new StubOutput();
    Store memTracker = new MemTracker();

    @Test
    public void whenInvalidInput() {
        Input in = new StubInput(
                new String[]{"1", "one", "0"}
        );
        ValidateInput input = new ValidateInput(in, out);
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(input, memTracker, actions);
        String exp = String.format("Menu:%n"
                + "0. Exit%n"
                + "Wrong input, you can select: 0 .. 0%n"
                + "Menu:%n"
                + "0. Exit%n"
                + "Please enter validate data again.%n");
        assertThat(out.toString(), is(exp));
    }

    @Test
    public void whenValidInput() {
        Input in = new StubInput(
                new String[]{"0"}
        );
        ValidateInput input = new ValidateInput(in, out);
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(input, memTracker, actions);
        String exp = String.format("Menu:%n0. Exit%n");
        assertThat(out.toString(), is(exp));
    }
}