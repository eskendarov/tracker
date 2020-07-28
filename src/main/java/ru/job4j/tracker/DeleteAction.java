package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output output) {
        this.out = output;
    }


    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID:");
        out.println(tracker.delete(id) ? "Item deleted " : "Item not found");
        return true;
    }
}
