package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortItemTest {

    @Test
    public void sort() {
        List<Item> names = Arrays.asList(new Item("Ivan"),
                new Item("Emilia"), new Item("Patrick"));
        Collections.sort(names, new SortItem.ByOrder());
        assertThat(names.get(0).getName(), is("Emilia"));
        Collections.sort(names, new SortItem.ReversOrder());
        assertThat(names.get(0).getName(), is("Patrick"));
    }
}