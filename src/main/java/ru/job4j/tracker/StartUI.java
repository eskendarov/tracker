package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            int select = Integer.valueOf(input.askStr(showMenu()));
            switch (select) {
                case 0: {
                    System.out.println("=== Create a new Item ====");
                    String name = input.askStr("Enter name: ");
                    Item item = new Item(name);
                    tracker.add(item);
                    System.out.println(name + " - added!");
                    break;
                }
                case 1: {
                    for (Item item : tracker.findAll()) {
                        System.out.println(item);
                    }
                    break;
                }
                case 2: {
                    String id = input.askStr("Enter ID:");
                    String name = input.askStr("Enter name:");
                    Item item = new Item(name);
                    System.out.println(tracker.replace(id, item) ? "Item edited" : "Item not found");
                    break;
                }
                case 3: {
                    String id = input.askStr("Enter ID:");
                    System.out.println("Deleted " + tracker.delete(id));
                    break;
                }
                case 4: {
                    String id = input.askStr("Enter ID:");
                    Item item = tracker.findById(id);
                    if (null != item) {
                        System.out.println(item);
                    } else {
                        System.out.println("Item not found ");
                    }
                    break;
                }
                case 5: {
                    String name = input.askStr("Enter name: ");
                    Item[] items = tracker.findByName(name);
                    if (items.length > 0) {
                        for (Item item : items) {
                            System.out.println(item);
                        }
                    } else {
                        System.out.println("No items with name: " + name);
                    }
                    break;
                }
                case 6: {
                    run = false;
                    break;
                }
                default: {
                    System.out.println("Select an existing menu item!");
                }
            }
        }
    }

    private String showMenu() {
        return "Menu:\n" +
                "0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program\n" +
                "Select: ";
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}