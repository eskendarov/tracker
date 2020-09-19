package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortItemTest {

    List<Item> names;

    {
        names = Arrays.asList(new Item("Ivan"),
                new Item("Emilia"), new Item("Patrick"));
    }

    @Test
    public void sortByOrder() {
        Collections.sort(names, new SortItemByOrder());
        assertThat(names.get(0).getName(), is("Emilia"));
    }

    @Test
    public void sortReversOrder() {
        Collections.sort(names, new SortItemReversOrder());
        assertThat(names.get(0).getName(), is("Patrick"));
    }
}