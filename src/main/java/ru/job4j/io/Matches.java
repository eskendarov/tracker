package ru.job4j.io;

import java.util.Scanner;

/**
 * Игра 11. Смысл игры в следующем. На столе лежат 11 спичек. Два игрока по очереди берут от 1 до 3 спичек.
 * Выигрывает тот, кто забрал последние спички.
 * @author Enver Eskendarov
 */

public class Matches {
    public static void main(String[] args) {
        int amount = 11;
        boolean gamer1 = true;
        Scanner input = new Scanner(System.in);
        while (amount > 0) {
            if (gamer1) {
                System.out.println("Игрок №1, введите количество спичек");
            } else {
                System.out.println("Игрок №2, введите количество спичек");
            }
            int took = Integer.valueOf(input.nextLine());
            if (took <= 3 && took > 0) {
                if (amount - took < 0) {
                    System.out.println("Вы не можете взять больше чем осталось!");
                } else {
                    amount = amount - took;
                    System.out.println("Отобрано " + took + ", осталось " + amount + " спичек");
                    gamer1 = !gamer1;
                }
            } else {
                System.out.println("Допустимое количество спичек 1-3");
            }
        }
        System.out.println("Вы выиграли, отобрав последние спички, игра завершена!");
    }
}
