package ru.job4j.tracker;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void addItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Java");
        Item item2 = new Item("Android");
        tracker.add(item1);
        tracker.add(item2);
        Item result = tracker.findById(item1.getId());
        assertThat(result.getName(), is(item1.getName()));
    }

    @Test
    public void findById() {
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> rsl = tracker.findByName("Item1");
        assertThat(expected, is(rsl));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}