package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void createItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"0", "Item_1", "0", "Item_2", "1"});
        UserAction[] actions = {
                new CreateAction(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().length, is(2));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"0", "Item_1", "0", "Item_2", "0", "Item_1", "1"});
        UserAction[] actions = {
                new CreateAction(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findByName("Item_1").length, is(2));
    }

    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item = new Item("Item_1");
        tracker.add(item);
        Input input = new StubInput(new String[]{"0", "Item_2", "0", "Item_3", "1"});
        UserAction[] actions = {
                new CreateAction(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("Item_1"));
    }
}