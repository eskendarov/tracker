package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {

    public static HashSet<Account> sent(List<Account> accounts) {
        // Преобразование из List в Set, удалит дубликаты клиентов банка,
        // оставляя уникальные по hashCode (тут это серия и номер паспорта).
        return new HashSet<>(accounts); // Конструктор HashSet реализовывает метод adAll, который добавляет элементы через foreach
    }
}