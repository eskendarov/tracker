package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {

    private final List<Item> items = new ArrayList<>();

    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
        return item;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item findById(String id) {
        for (Item item : items) {
            if (id.equals(item.getId())) {
                return item;
            }
        }
        return null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (Item item : items) {
            if (id.equals(item.getId())) {
                return items.indexOf(item);
            }
        }
        return rsl;
    }

    public boolean replace(String id, Item item) {
        if (indexOf(id) != -1) {
            item.setId(id);
            items.set(indexOf(id), item);
            return true;
        }
        return false;
    }

    public boolean delete(String id) {
        for (Item item : items) {
            if (id.equals(item.getId())) {
                items.remove(item);
                return true;
            }
        }
        return false;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> withKey = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                withKey.add(item);
            }
        }
        return withKey;
    }
}