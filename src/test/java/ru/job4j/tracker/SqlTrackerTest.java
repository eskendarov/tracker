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
    public void createItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(
                ConnectionRollback.create(this.init()))
        ) {
            tracker.add(new Item("name", "desc"));
            assertThat(tracker.findByName("desc").size(), is(1));
        }
    }
}
