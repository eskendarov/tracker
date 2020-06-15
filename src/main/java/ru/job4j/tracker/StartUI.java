package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            switch (select) {
                case 0: {
                    System.out.println("=== Create a new Item ====");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item item = new Item(name);
                    tracker.add(item);
                    System.out.println(name + " - added!");
                    break;
                }
                case 1: {
                    for (Item item : tracker.findAll()) {
                        System.out.println("Name: " + item.getName() + ", ID: " + item.getId());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter ID:");
                    String id = scanner.nextLine();
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    Item item = new Item(name);
                    System.out.println("Edited: " + tracker.replace(id, item));
                    break;
                }
                case 3: {
                    System.out.println("Enter ID:");
                    String id = scanner.nextLine();
                    System.out.println("Deleted" + tracker.delete(id));
                    break;
                }
                case 4: {
                    System.out.println("Enter ID:");
                    String id = scanner.nextLine();
                    Item item = tracker.findById(id);
                    System.out.println("Name: " + item.getName() + ", ID: " + item.getId());
                    break;
                }
                case 5: {
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    for (Item item: tracker.findByName(name)){
                        System.out.println("Name: " + item.getName() + ", ID: " + item.getId());
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

    private void showMenu() {
        System.out.println("Menu:\n" +
                "0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program\n" +
                "Select:");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}