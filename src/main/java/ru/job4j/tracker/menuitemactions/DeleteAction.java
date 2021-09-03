package ru.job4j.tracker.menuitemactions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.storage.Store;

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
    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Enter ID:");
        out.println(tracker.delete(id) ? "Item deleted " : "Item not found");
        return true;
    }
}
