package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item findById(String id) {
        Item rsl = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    public Item[] findByName(String key) {
        int size = 0;
        Item[] withKey = new Item[items.length];
        for (int i = 0; i < position; i++) {
            if (key.equals(items[i].getName())) {
                withKey[size++] = items[i];
            }
        }
        return Arrays.copyOf(withKey, size);
    }
}