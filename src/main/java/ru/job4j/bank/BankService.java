package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

/**
 * В классе BankService можно производить следующие действия:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет (один или несколько).
 * 4. Переводить деньги с одного банковского счета на другой счет.
 *
 * @author Enver Eskendarov
 * @version 1.0
 */
public class BankService {

    /**
     * Пользователи {@link User} и их аккаунты {@link Account}
     * хранятся в карте Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя в хранилище USERS
     *
     * @param user - пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Находит пользователя в хранилище и присваивает аккаунт
     *
     * @param passport - паспорт пользователя
     * @param account  - аккаунт пользователя
     */
    public void addAccount(String passport, Account account) {
        var user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Ищет пользователя в хранилище по паспорту
     *
     * @param passport - паспорт пользователя
     * @return - возвращает пользователя по паспорту
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * По реквизиту ищет аккаунт пользователя
     *
     * @param passport  - паспорт пользователя
     * @param requisite - реквизит пользователя
     * @return - возвращает аккаунт пользователя
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        var user = findByPassport(passport);
        return Stream.of(users)
                .filter(users -> user.isPresent())
                .flatMap(account -> account.get(user.get()).stream())
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst();
    }

    /**
     * Переводит деньги с одного банковского счета на другой счет.
     *
     * @param srcPassport   - паспорт пользователя отправителя
     * @param srcRequisite  - реквизит пользователя отправителя
     * @param destPassport  - паспорт пользователя получателя
     * @param destRequisite - реквизит пользователя получателя
     * @param amount        - сумма переводимых денежных средств
     * @return - возвращает статус банковского перевода true или false
     */
    public boolean transferMoney(String srcPassport,
                                 String srcRequisite,
                                 String destPassport,
                                 String destRequisite,
                                 double amount
    ) {
        var src = findByRequisite(srcPassport, srcRequisite);
        var dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent() && src.get().getBalance() >= amount) {
            dest.get().setBalance(dest.get().getBalance() + amount);
            src.get().setBalance(src.get().getBalance() - amount);
            return true;
        }
        return false;
    }
}
