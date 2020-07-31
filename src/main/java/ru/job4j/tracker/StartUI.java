package ru.job4j.tracker;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu:");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            try {
                UserAction action = actions[select];
                run = action.execute(input, tracker);
            } catch (ArrayIndexOutOfBoundsException e) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
            }
        }
    }

    public static void main(String[] args) {
        Input input = new ValidateInput();
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}