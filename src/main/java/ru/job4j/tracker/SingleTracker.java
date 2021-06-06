package ru.job4j.tracker;

import java.util.List;

/**
 * SingleTracker Class description goes here.
 *
 * @author Enver Eskendarov
 * @version 1.0 06/06/2021
 */
public class SingleTracker {

    private final MemTracker tracker = new MemTracker();
    private static SingleTracker instance = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public boolean delete(String id) {
        return tracker.delete(id);
    }

    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }

    public Item findById(int id) {
        return null;
    }

    public List<Item> findByName(String name) {
        return tracker.findByName(name);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }
}
