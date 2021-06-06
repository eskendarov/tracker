package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

/**
 * StartUIItem Class description goes here.
 *
 * @author Enver Eskendarov
 * @version 1.0 06/06/2021
 */
public class DateTimeItem {

    public static void main(String[] args) {
        final Item item = new Item("Item");
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getCreated().format(formatter));
    }
}
