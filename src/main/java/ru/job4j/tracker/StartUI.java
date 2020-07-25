package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println(name + " - added!");
    }

    public static void findAllItems(Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID:");
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        System.out.println(tracker.replace(id, item) ? "Item edited" : "Item not found");
    }

    public static void deleteItem(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID:");
        System.out.println("Deleted " + tracker.delete(id));
    }

    public static void findItemById(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID:");
        Item item = tracker.findById(id);
        if (null != item) {
            System.out.println(item);
        } else {
            System.out.println("Item not found ");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("No items with name: " + name);
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            switch (select) {
                case 0 -> StartUI.createItem(input, tracker);
                case 1 -> StartUI.findAllItems(tracker);
                case 2 -> StartUI.editItem(input, tracker);
                case 3 -> StartUI.deleteItem(input, tracker);
                case 4 -> StartUI.findItemById(input, tracker);
                case 5 -> StartUI.findItemByName(input, tracker);
                case 6 -> run = false;
                default -> System.out.println("Select an existing menu item!");
            }
        }
    }

    private void showMenu() {
        System.out.print("Menu:\n" +
                "0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program\n");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}