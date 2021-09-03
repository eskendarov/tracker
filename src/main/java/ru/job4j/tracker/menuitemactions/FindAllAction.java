package ru.job4j.tracker.menuitemactions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.storage.Store;

public class FindAllAction implements UserAction {

    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        for (Item item : tracker.findAll()) {
            out.println(item);
        }
        return true;
    }
}
