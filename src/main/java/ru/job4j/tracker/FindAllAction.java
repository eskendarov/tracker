package ru.job4j.tracker;

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
