package ru.job4j.tracker.storage;

import ru.job4j.tracker.models.Item;

import java.util.List;

/**
 * Store - интерфейс хранилища.
 *
 * @author Enver Eskendarov
 * @version 1.0 12/03/2021
 */

public interface Store extends AutoCloseable {

    void init();

    Item add(Item item);

    boolean replace(String id, Item item);

    boolean delete(String id);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(String id);
}
