package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID:");
        Item item = tracker.findById(id);
        System.out.println(null != item ? item : "Item not found");
        return true;
    }
}
