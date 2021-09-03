package ru.job4j.tracker.menuitemactions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.storage.Store;

public class Exit implements UserAction {

    private final Output out;

    public Exit(Output output) {
        this.out = output;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}
