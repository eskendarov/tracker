[![Build Status](https://travis-ci.org/eskendarov/job4j_tracker.svg?branch=master)](https://travis-ci.org/eskendarov/job4j_tracker)
[![codecov](https://codecov.io/gh/eskendarov/job4j_tracker/branch/master/graph/badge.svg)](https://codecov.io/gh/eskendarov/job4j_tracker)

## "Система заявок - Tracker" - консольное приложение с пользовательским меню и использованием _DB PostgreSQL_.

#### Программа может:
- Добавлять заявку.
- Заменять заявку на новую заявку по ID.
- Удалять заявку по ID.
- Отображать список всех заявок.
- Производить поиск по имени заявки.

#### Особенности структуры приложения:
- В проекте имеется возможность хранить данные в памяти или в базе данных.
- Интерфейс `ru.job4j.tracker.storage.Store` описывает объекты использующие хранилище: `ru.job4j.tracker.storage.MemTracker`, `ru.job4j.tracker.storage.SqlTracker`. Эти объекты умеют: добавлять, заменять, искать по имени, читать все сохраненные данные.
- Объект `ru.job4j.tracker.models.Item` - описывает модель данных.
- Отображение меню - `ru.job4j.tracker.StartUI`. Этот объект управляет меню. Он основан на цикле, который опрашивает пользователя о выбранном пункте меню. Если пользователь выбрал пункт "Выйти", то цикл завершается и программа закрывается.
- Действия меню описаны группой классов, основанных на сущности `ru.job4j.tracker.menuitemactions.UserAction`. Если от заказчика придет требование добавить новое действие, благодаря ООП мы можем добавить еще один элемент на основе этого элемента и добавить его в систему без изменений.
- Система ввода-вывода, объекты `ru.job4j.tracker.input.Input` и `ru.job4j.tracker.output.Output`, позволяют использовать данные для консольного ввода-вывода, а также отдельно для тестов.