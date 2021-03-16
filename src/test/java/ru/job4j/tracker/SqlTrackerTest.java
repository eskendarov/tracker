package ru.job4j.tracker;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    public Connection init() throws ClassNotFoundException, SQLException {
        final ResourceBundle res = ResourceBundle.getBundle("application");
        Class.forName(res.getString("psql.driver"));
        return DriverManager.getConnection(
                res.getString("psql.url"),
                res.getString("psql.username"),
                res.getString("psql.password")
        );
    }

    @Test
    public void add() throws Exception {
        try (SqlTracker tracker = new SqlTracker(
                ConnectionRollback.create(this.init()))
        ) {
            tracker.add(new Item("desc"));
            assertThat(tracker.findByName("desc").size(), is(1));
        }
    }

    @Test
    public void replace() throws Exception {
        try (SqlTracker tracker = new SqlTracker(
                ConnectionRollback.create(this.init()))
        ) {
            final Item item = tracker.add(new Item("desc"));
            tracker.replace(item.getId(), new Item("newItem"));
            assertThat(tracker.findById(item.getId()).getName(),
                    is("newItem"));
        }
    }

    @Test
    public void delete() throws Exception {
        try (SqlTracker tracker = new SqlTracker(
                ConnectionRollback.create(this.init()))
        ) {
            final Item item = tracker.add(new Item("desc"));
            tracker.delete(item.getId());
            assertThat(tracker.findByName("desc").size(), is(0));
        }
    }

    @Test
    public void findById() throws Exception {
        try (SqlTracker tracker = new SqlTracker(
                ConnectionRollback.create(this.init()))
        ) {
            final Item item = tracker.add(new Item("byId"));
            assertThat(tracker.findById(item.getId()).getName(),
                    is(item.getName()));
        }
    }

    @Test
    public void findByName() throws Exception {
        try (SqlTracker tracker = new SqlTracker(
                ConnectionRollback.create(this.init()))
        ) {
            final Item item = tracker.add(new Item("byName"));
            assertThat(tracker.findByName("byName").get(0).getId(),
                    is(item.getId()));
        }
    }
}
