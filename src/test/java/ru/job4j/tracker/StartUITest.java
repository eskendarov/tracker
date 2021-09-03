package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.menuitemactions.CreateAction;
import ru.job4j.tracker.menuitemactions.DeleteAction;
import ru.job4j.tracker.menuitemactions.Exit;
import ru.job4j.tracker.menuitemactions.FindAllAction;
import ru.job4j.tracker.menuitemactions.FindByIdAction;
import ru.job4j.tracker.menuitemactions.FindByNameAction;
import ru.job4j.tracker.menuitemactions.ReplaceAction;
import ru.job4j.tracker.menuitemactions.UserAction;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.storage.MemTracker;
import ru.job4j.tracker.storage.Store;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final String ln = System.lineSeparator();

    @Test
    public void createItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Store tracker = new MemTracker();
        UserAction[] actions = {
                new CreateAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", item.getId(), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", item.getId(), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Store tracker = new MemTracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit" + ln
        ));
    }

    @Test
    public void whenFindAll() {
        Store tracker = new MemTracker();
        Output output = new StubOutput();
        Item item = new Item("Item_1");
        tracker.add(item);
        Input input = new StubInput(new String[]{"0", "1"});
        UserAction[] actions = {
                new FindAllAction(output),
                new Exit(output)
        };
        String expected = "Menu:" + ln
                + "0. Show all Items" + ln
                + "1. Exit" + ln
                + item.toString() + ln
                + "Menu:" + ln
                + "0. Show all Items" + ln
                + "1. Exit" + ln;
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(expected));
    }

    @Test
    public void findByName() {
        Store tracker = new MemTracker();
        Output output = new StubOutput();
        Item item = new Item("Idea");
        tracker.add(item);
        Input input = new StubInput(new String[]{"0", "Idea", "1"});
        UserAction[] actions = {
                new FindByNameAction(output),
                new Exit(output)
        };
        String expected = "Menu:" + ln
                + "0. Find items by Name" + ln
                + "1. Exit" + ln
                + item.toString() + ln
                + "Menu:" + ln
                + "0. Find items by Name" + ln
                + "1. Exit" + ln;
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(expected));
    }

    @Test
    public void findById() {
        Store tracker = new MemTracker();
        Output output = new StubOutput();
        Item item = new Item("Item_1");
        tracker.add(item);
        Input input = new StubInput(new String[]{"0", item.getId(), "1"});
        UserAction[] actions = {
                new FindByIdAction(output),
                new Exit(output)
        };
        String expected = "Menu:" + ln
                + "0. Find item by Id" + ln
                + "1. Exit" + ln
                + item.toString() + ln
                + "Menu:" + ln
                + "0. Find item by Id" + ln
                + "1. Exit" + ln;
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(expected));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "0"}
        );
        Store tracker = new MemTracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu:%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu:%n"
                                + "0. Exit%n"
                )
        ));
    }
}