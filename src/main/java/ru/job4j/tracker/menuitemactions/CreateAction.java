package ru.job4j.tracker.menuitemactions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.storage.Store;

public class CreateAction implements UserAction {

    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        out.println("Added: " + tracker.add(item));
        return true;
    }
}
