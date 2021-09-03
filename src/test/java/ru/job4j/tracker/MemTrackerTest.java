package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.storage.MemTracker;
import ru.job4j.tracker.storage.Store;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class MemTrackerTest {

    @Test
    public void addItems() {
        Store tracker = new MemTracker();
        Item item1 = new Item("Java");
        Item item2 = new Item("Android");
        tracker.add(item1);
        tracker.add(item2);
        Item result = tracker.findById(item1.getId());
        assertThat(result.getName(), is(item1.getName()));
    }

    @Test
    public void findById() {
        Store tracker = new MemTracker();
        Item item1 = new Item("Java");
        Item item2 = new Item("Android");
        tracker.add(item1);
        tracker.add(item2);
        Item result = tracker.findById(item1.getId());
        assertThat(result.getName(), is("Java"));
    }

    @Test
    public void findAll() {
        Item item1 = new Item("Java");
        Item item2 = new Item("Android");
        List<Item> expected = List.of(item1, item2);
        Store tracker = new MemTracker();
        tracker.add(item1);
        tracker.add(item2);
        List<Item> rsl = tracker.findAll();
        assertThat(expected, is(rsl));
    }

    @Test
    public void findByName() {
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        Item item3 = new Item("Item1");
        List<Item> expected = List.of(item1, item3);
        Store tracker = new MemTracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> rsl = tracker.findByName("Item1");
        assertThat(expected, is(rsl));
    }

    @Test
    public void whenReplace() {
        Store tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Store tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}