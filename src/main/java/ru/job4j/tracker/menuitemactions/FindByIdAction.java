package ru.job4j.tracker.menuitemactions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.storage.Store;

public class FindByIdAction implements UserAction {

    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Enter ID:");
        Item item = tracker.findById(id);
        out.println(null != item ? item : "Item not found");
        return true;
    }
}
