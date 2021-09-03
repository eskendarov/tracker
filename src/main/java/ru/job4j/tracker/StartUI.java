package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.menuitemactions.CreateAction;
import ru.job4j.tracker.menuitemactions.DeleteAction;
import ru.job4j.tracker.menuitemactions.Exit;
import ru.job4j.tracker.menuitemactions.FindAllAction;
import ru.job4j.tracker.menuitemactions.FindByIdAction;
import ru.job4j.tracker.menuitemactions.FindByNameAction;
import ru.job4j.tracker.menuitemactions.ReplaceAction;
import ru.job4j.tracker.menuitemactions.UserAction;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.storage.SqlTracker;
import ru.job4j.tracker.storage.Store;

/**
 * StartUI - Запускает приложение, интерфейс пользователя..
 *
 * @author Enver Eskendarov
 * @version 1.0 03.09.2021
 */

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

    public void init(Input input, Store tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println(
                        "Wrong input, you can select: 0 .. "
                                + (actions.length - 1)
                );
                continue;
            }
            final UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    public static void main(String[] args) {
        final Output output = new ConsoleOutput();
        final Input input = new ValidateInput(new ConsoleInput(), output);
        try (Store tracker = new SqlTracker()) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
