package fight;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DataSourceTest {

    private static DataSourceTest dataSource;
    protected DataSourceTest() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getPersonConnection()  throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/task_4_test",
                "root",
                "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new DataSourceTest();
        }
        return dataSource.getPersonConnection();
    }
}