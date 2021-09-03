package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.menuitemactions.CreateAction;
import ru.job4j.tracker.menuitemactions.Exit;
import ru.job4j.tracker.menuitemactions.UserAction;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.storage.MemTracker;
import ru.job4j.tracker.storage.Store;

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

    @Test
    public void whenMultiValidInput() {
        Input in = new StubInput(
                new String[]{"0", "0"}
        );
        ValidateInput input = new ValidateInput(in, out);
        UserAction[] actions = {
                new Exit(out),
                new CreateAction(out)
        };
        new StartUI(out).init(input, memTracker, actions);
        String exp = String.format("Menu:%n0. Exit%n1. Create%n");
        assertThat(out.toString(), is(exp));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenNegativeInputInvalid() {
        Input in = new StubInput(
                new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(in, out);
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(input, memTracker, actions);
    }
}
