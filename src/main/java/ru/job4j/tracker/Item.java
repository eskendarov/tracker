package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {

    private String id;
    private String name;
    private final LocalDateTime created = LocalDateTime.now(); //not used

    public Item(String name) {
        this.name = name;
    }

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return String.format("Item{ID=%s, Name=%s}", id, name);
    }
}
