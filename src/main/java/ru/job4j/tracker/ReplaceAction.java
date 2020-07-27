package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID:");
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        System.out.println(tracker.replace(id, item) ? "Item replaced" : "Item not found");
        return true;
    }
}
