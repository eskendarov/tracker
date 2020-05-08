package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
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
        Item[] expected = {item1, item2};
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        Item[] rsl = tracker.findAll();
        assertThat(expected, is(rsl));
    }

    @Test
    public void findByName() {
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        Item item3 = new Item("Item1");
        Item[] expected = {item1, item3};
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] rsl = tracker.findByName("Item1");
        assertThat(expected, is(rsl));
    }
}