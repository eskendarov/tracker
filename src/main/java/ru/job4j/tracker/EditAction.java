package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID:");
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        System.out.println(tracker.replace(id, item) ? "Item edited" : "Item not found");
        return true;
    }
}
