package ru.job4j.tracker.menuitemactions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.storage.Store;

public class ReplaceAction implements UserAction {

    private final Output out;

    public ReplaceAction(Output output) {
        this.out = output;
    }

    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Enter ID: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        out.println(tracker.replace(id, item) ? "Item replaced" : "Item not found");
        return true;
    }
}
