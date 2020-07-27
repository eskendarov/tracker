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
        if (null != item) {
            System.out.println(item);
        } else {
            System.out.println("Item not found ");
        }
        return true;
    }
}
