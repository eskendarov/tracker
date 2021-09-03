package ru.job4j.tracker.storage;

import ru.job4j.tracker.models.Item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * SqlTracker - подключается к базе данных, создаёт в ней записи,
 * редактирует, читает и удаляет.
 *
 * @author Enver Eskendarov
 * @version 1.0 12/03/2021
 */
public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    public void init() {
        try {
            final ResourceBundle res = ResourceBundle.getBundle("application");
            Class.forName(res.getString("psql.driver"));
            connection = DriverManager.getConnection(
                    res.getString("psql.url"),
                    res.getString("psql.username"),
                    res.getString("psql.password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = connection.prepareStatement(
                "insert into items(name) values (?)",
                Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, item.getName());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getString(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean res = false;
        try (PreparedStatement statement = connection.prepareStatement(
                "update items set name = ? where id = ?")
        ) {
            statement.setString(1, item.getName());
            statement.setInt(2, Integer.parseInt(id));
            res = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(
                "delete from items where id = ?")
        ) {
            statement.setInt(1, Integer.parseInt(id));
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        final List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "select * from items")
        ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    final Item item = new Item(resultSet.getString("name"));
                    item.setId(resultSet.getString("id"));
                    items.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        final List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "select * from items where name = ?")
        ) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    final Item item = new Item(resultSet.getString("name"));
                    item.setId(resultSet.getString("id"));
                    items.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        try (PreparedStatement statement = connection.prepareStatement(
                "select * from items where id = ?")
        ) {
            statement.setInt(1, Integer.parseInt(id));
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                item = new Item(resultSet.getString("name"));
                item.setId(resultSet.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
