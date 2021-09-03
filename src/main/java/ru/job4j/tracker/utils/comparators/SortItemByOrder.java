package ru.job4j.tracker.utils.comparators;

import ru.job4j.tracker.models.Item;

import java.util.Comparator;

public class SortItemByOrder implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
